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

       

        stage('Build proj') {
           
            steps {
                dir('front') {
			sh 'docker push alaaeddinedorai/devops:latest'
                }
            }
        }

        stage('logout') {
            steps {
                sh 'docker logout'
            }
        }
    }
}
