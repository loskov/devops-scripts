
cat >> ~/.bashrc <<EOF
## AWS token activation
aws-enable-token() {
  export AWS_CURRENT=xxxx
  export AWS_ACCESS_KEY=xxxxxxxxxxxxx
  export AWS_SECRET_KEY=xxxxxxxxxxxxxxxxxxxxxxxxxx
}

aws-disable-token() {
  unset AWS_CURRENT
  unset AWS_ACCESS_KEY
  unset AWS_SECRET_KEY
}
## End of AWS token activation
EOF
echo 'Added helper functions to .bashrc'
echo 'Run: source ~/.bashrc to apply'
