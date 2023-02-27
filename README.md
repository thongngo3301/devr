Setup environment:
- This installation is executed on Ubuntu Server 22.04 environment
- We will have a "setup" directory, which contains Ansible code to install packages and Jenkins
- Go to the "setup" directory, run command: "bash init.sh" to start the installation
- It will firstly install Ansible core, then execute the Ansible playbook
- The playbook includes 3 tasks: os.yml, docker.yml, jenkins.yml; corresponding to: "Setup main OS", "Setup Docker package, group and user" and "Setup Jenkins"