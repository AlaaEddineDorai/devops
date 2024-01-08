echo 'building'
pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Init') {
            steps {
                sh 'echo Init Step'
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('Build and Push Image') {
            steps {
                dir('front') {
                    sh 'docker build -t alaaeddinedorai/devops:latest .'
                    sh 'docker push alaaeddinedorai/devops:latest'
                }
            }
        }

        stage('Logout') {
            steps {
                sh 'docker logout'
            }
        }
    }
}

