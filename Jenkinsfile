pipeline {
    agent any   

    environment {
        DOCKERHUB_CREDENTIAL_ID = '51' // Use the correct credential ID you set in Jenkins
    }

    stages {
        stage('Build and Push Image') {
    steps {
        script {
            echo 'Building and Pushing Docker Image for Frontend...'
            
            // Navigate to the 'front' directory
            dir('front') {
                // Execute Docker build command for the frontend
                sh 'docker build -t alaaeddinedorai/devops:latest .'

                // Login to DockerHub using credentials
                withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIAL_ID, usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                }

                // Push Docker image to DockerHub
                sh 'docker push alaaeddinedorai/devops:latest'
            }
        }
    }
}


        stage('Testing') {
            steps {
                script {
                    // Execute test commands (e.g., mvn test, npm test)
                    sh 'npm test' // Assuming npm is used for frontend testing
                }
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    // Remove temporary files or artifacts
                    sh 'rm -rf temporary_files'
                }
            }
        }
    }
}

