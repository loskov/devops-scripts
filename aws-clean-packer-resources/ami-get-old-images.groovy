#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import java.text.SimpleDateFormat

def awsCliShowAmiInfoFor = "aws ec2 describe-images --owners self --filters 'Name=name,Values="
def awsJsonParser = "jq '[.Images[] | {ImageId, CreationDate}]'"
def services = ["bash", "-c", "./ami-get-names.groovy"].execute().text.readLines()
def cutoffDate = new Date()-30
def allAmisToClean = []

services.each { serviceName ->
  def proc = ["bash", "-c", "$awsCliShowAmiInfoFor $serviceName*' | $awsJsonParser"].execute()
  proc.waitFor()
  def allAmis = new JsonSlurper().parseText(proc.text)

  def amisWithDates = allAmis.collect { kv ->
      [ImageId: kv.ImageId, CreationDate: new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(kv.CreationDate)]
  }

  def amisToClean = amisWithDates.findAll { kv ->
    kv.CreationDate.before(cutoffDate)
  }

  if (amisToClean.size() < allAmis.size()) {
    allAmisToClean += amisToClean.ImageId
    amisToClean.ImageId.each { println "$it" }
  }
}
