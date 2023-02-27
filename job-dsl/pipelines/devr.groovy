def project = "Devr"
def repos = [
  "pastebin"
]

folder("${project}") {
  description("Folder contains all pipelines of project ${project}")
}

repos.each { repo ->
  multibranchPipelineJob("${project}/${project}-multibranch-${repo}") {
    branchSources {
      displayName("${project}-multibranch-${repo}")
      branchSource {
        source {

        }
      }
    }
  }
}