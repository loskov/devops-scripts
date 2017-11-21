#!/usr/bin/env groovy

import groovy.json.JsonSlurper

def awsShowKeyPairs = "aws ec2 describe-key-pairs --filters \"Name=key-name,Values=packer *\""
def awsJsonParser = "jq '[.KeyPairs[] | { KeyName,KeyFingerprint }]'"

def proc = ["bash", "-c", "$awsShowKeyPairs | $awsJsonParser"].execute()
def keys = new JsonSlurper().parseText(proc.text)
def keyNames = keys.KeyName

keyNames.each { println it }
