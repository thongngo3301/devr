<h1>Jenkins job DSL</h1>

After finish running Ansible to install Jenkins, let's head to the browser at `https://localhost:8080` to login to Jenkins. Follow the instruction to finish the installation and login:
![alt First time login to Jenkins](images/first-time-login-jenkins.png "First time login to Jenkins")

Go to the `Dashboard > Manage Jenkins > Plugin Manager` page, select `Available plugins`, search for `configuration-as-code` and `job-dsl`. The result will be like this:
![alt Install Configuration as Code](images/install-casc.png "Install Configuration as Code")
![alt Install Job DSL](images/install-job-dsl.png "Install Job DSL")
Select `Install without restart`

Usually, I will use `Puppet` as my configuration management tool to control all of the YAML files in `casc_configs` folder, which will be used by `Configuration as Code` plugin. The `Job Seeder` job will also be created from CasC. However, due to the limitation of time for this assignment, I will create the `Job Seeder` job manually. But you can still have a look at my `job-seeder.yaml` file like a reference.

Go back to the dashboard, click the `New Item` link on the left of the dashboard. On the screen that follows, type in `Job Seeder`, select Freestyle project, and click OK.
![alt Create Job Seeder](images/create-job-seeder.png "Create Job Seeder")

In the screen that follows, scroll down to the `Build Steps` section and click on the `Add build step` dropdown. Next select `Process Job DSLs`.

Then, click on the radio button next to `Use the provided DSL script`, and paste the below code snippet (remember to change the Github URL):
```groovy
jobs:
  - script: >
      job('Job Seeder') {
        scm {
          git {
            remote {
              url('https://github.com/thongngo3301/devr')
              credential('ro')
            }
            branch('master')
          }
        }
        steps {
          dsl {
            external('job-dsl/pipelines/*/*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
          }
        }
        triggers {
          scm('*/15 * * * *')
        }
      }
```
Click `Save` to create the job. This will take you to the `Job Seeder` job page. Click `Build now` to force Jenkins generate our pipelines immediately.