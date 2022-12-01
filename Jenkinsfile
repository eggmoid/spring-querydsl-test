pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        script {
          checkout scm
        }
      }
    }
    stage('Build') {
      steps {
        script {
          app = docker.build('limejuny/springboot-querydsl-test')
        }
      }
    }
    stage('Push') {
      steps {
        script {
          docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credential') {
            app.push("latest")
          }
        }
      }
    }
  }
}
