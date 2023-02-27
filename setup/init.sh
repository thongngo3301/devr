#!/bin/bash

sudo apt-add-repository ppa:ansible/ansible
sudo apt update
sudo apt install ansible
ansible-playbook -i inventory.ini playbook.yml