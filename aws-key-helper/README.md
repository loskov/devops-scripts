# AWS key helper
## General info
[Ansible AWS modules](http://docs.ansible.com/ansible/latest/ec2_module.html) and [boto library](https://github.com/boto/boto) use environment variables to authenticate to your AWS account.

Instead of putting your `aws_access_key` and `aws_secret_key` with plaintext inside your scripts or playbooks you can set two env variables:
- AWS_ACCESS_KEY_ID or AWS_ACCESS_KEY or EC2_ACCESS_KEY
- AWS_SECRET_ACCESS_KEY or  AWS_SECRET_KEY or EC2_SECRET_KEY

and authentication will use proper values.

## Usage:
1. Paste your access and secret keys into `aws-enable-token` file.
2. (optional) If you have more than one set of key change AWS_CURRENT variable to better reflect the name of your current AWS environment.
3. Run script `./aws-token-helper.sh`
4. Run `source ~/.bashrc` to enable functions in your shell
5. You can now run `aws-enable-token` and `aws-disable-token` to add/delete your keys as env variables.
