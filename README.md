lambdas
============

prereqs - maven, jdk8, on ubuntu or osx.  

If you're on windows you will need to run ubuntu in a virtual machine.

<https://jdk8.java.net/download.html>

if replacing your system jdk/jvm with 1.8 isn't your thing, try vagrant!

<http://www.vagrantup.com/>

I've included a sample Vagrant file and provisioning script that downloads an ubuntu 13.10 vm from <http://cloud-images.ubuntu.com> and installs maven, jdk1.8, builds this project and runs src/js/test.js

If you prefer to manually setup your ubuntu vm/box feel free to hack the provision_lambdas_vagrant.sh script and make it work. I've included the basics here if don't like figuring out shell scripts. Oh, and osx fans - you're on your own.

first(!) install maven if it is not installed, 

    if [ -z $(which mvn) ]; then sudo apt-get install maven; fi

get and install jdk8

    sudo add-apt-repository ppa:webupd8team/java
    sudo apt-get update
    sudo apt-get install oracle-java8-installer
    sudo apt-get install oracle-java8-set-default

add a user bin folder to hold your scripts

    mkdir ~/bin

and add the folder to your path by editing your ~/.profile like so - 

    if [ -d "$HOME/bin" ] ; then
        PATH="$HOME/bin:$PATH"
    fi

reload the .profile if changed

    source ~/.profile

copy the source code from this project into ~/bin/

    chmod +x ./src/bash/*
    cp ./src/bash/* ~/bin/.
