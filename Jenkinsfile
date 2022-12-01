pipeline {
  agent any
  environment {
    DOCKER_REGISTRY = "https://registry.hub.docker.com"
    DOCKER_CREDENTIALS_ID = "dockerhub-credential"
    DOCKER_IMAGE_NAME = "limejuny/springboot-querydsl-test"
  }
  stages {
    stage("Build Docker Image") {
      steps {
        script {
          app = docker.build("${DOCKER_IMAGE_NAME}")
        }
      }
    }
    stage("Push Docker Image") {
      steps {
        script {
          docker.withRegistry("${DOCKER_REGISTRY}", "${DOCKER_CREDENTIALS_ID}") {
            app.push("latest")
          }
        }
      }
    }
  }
}
