def project = "Devr"
def repos = [
  [name: "pastebin", job_path: "Jenkinsfile", job_branch: "master", git_url: "https://github.com/thongngo3301/pastebin"]
]

folder("${project}") {
  description("Folder contains all pipelines of project ${project}")
}

repos.each { repo ->
  pipelineJob("${project}/${project}-${repo['name']}") {
    properties {
      pipelineTriggers {
        triggers {
          githubPush()
        }
      }
    }
    definition {
      cpsScm {
        lightweight(true)
        scriptPath("${repo['job_path']}")
        scm {
          git {
            branch("${repo['job_branch']}")
            remote {
              url("${repo['git_url']}")
            }
          }
        }
      }
    }
  }
}