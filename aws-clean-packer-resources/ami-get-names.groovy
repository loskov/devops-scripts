#!/usr/bin/env groovy
// (optional) Use regexp in Values to narrow your search
def awsGetAllAmis = "aws ec2 describe-images --owners self --filters 'Name=name,Values=*'"
def awsJsonParser = "jq -r '.Images[].Name'"
def sortAndDistinct = "awk '{\$NF=\"\"; print \$0}' | sort | uniq"

def proc = ["bash", "-c", "$awsGetAllAmis | $awsJsonParser | $sortAndDistinct"].execute()
proc.waitFor()

def amis = proc.text.readLines()
amis.findAll().each { println it.trim() }
