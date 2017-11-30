set -x
# Remove previous Docker packages
sudo apt-get remove -y docker docker-engine docker.io
# Update and install supporting packages
sudo apt-get update
sudo apt-get install -y apt-transport-https ca-certificates curl software-properties-common
# Add Docker gpg key
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
# Add Docker repository
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt-get update
# Install Docker
sudo apt-get install -y docker-ce
# Check version
docker -v
# Add current user to docker group
sudo usermod -aG docker $(whoami)
echo "To use docker without sudo you need to re-log"
# Run Docker daemon at startup
sudo systemctl enable docker
