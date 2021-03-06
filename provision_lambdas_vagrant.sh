#!/bin/bash

#first add java8 repo and update
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get -y update

#next check/install maven
if [ "$(command -v mvn)" = "" ]; then sudo apt-get -y install maven; fi

#debconf-set-selections used below to accept java8 lic
if [ "$(command -v debconf-set-selections)" = "" ]; then sudo apt-get -y install debconf-utils; fi

#install java8
sudo /bin/echo -e oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
sudo apt-get -y install oracle-java8-installer
sudo apt-get -y install oracle-java8-set-default

#install git
if [ "$(command -v git)" = "" ]; then sudo apt-get -y install git 1.7.1; fi

#for viewing .md files using markdown and lynx at the prompt
if [ "$(command -v markdown)" = "" ]; then sudo apt-get -y install markdown; fi
if [ "$(command -v lynx)" = "" ]; then sudo apt-get -y install lynx; fi

#finally clone and build the maven project from git
sudo su vagrant

#make a random 'projects' folder in the user home folder 
mkdir -p /home/vagrant/projects
cd /home/vagrant/projects

mkdir -p /home/vagrant/bin

#clone the repo
git clone https://github.com/newhavengill/lambdas.git

#build it
cd lambdas
mvn clean

#copy to user bin folder
cp src/bash/* /home/vagrant/bin/.

#add src/bash to path is user bin is not in path
if [ "$(command -v nashorn)" = "" ]; then export PATH="/home/vagrant/projects/lambdas/src/bash:$PATH"; fi 

#run it
# nashorn src/js/test.js

echo 'run:'
echo 'markdown README.md | lynx -stdin'
