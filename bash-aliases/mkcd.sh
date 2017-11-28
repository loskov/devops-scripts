cat >> ~/.bashrc <<EOF
## mkdir + cd into it
mkcd() {
  mkdir -p \$1
  cd \$1
}
## End of mkdir + cd into it
EOF
