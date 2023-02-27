#!/bin/bash

sudo apt-add-repository ppa:ansible/ansible
sudo apt update -y
sudo apt install ansible -y
ansible-playbook -i inventory.ini playbook.yml