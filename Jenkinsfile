//Jenkins script to build and deploy the contactsspringbootapi application
//Must have maven to compile, test and package the application
//Must have docker to build the docker image and push it to docker hub
//define environment variables mavenHome and dockerHome for tools in jenkins
//use script to build docker image and env.BUILD_NUMBER.
//use script to deploy docker image to docker hub.

pipeline {
    agent any
    
    environment {
        mavenHome = tool 'maven'
        dockerHome = tool 'docker'
        PATH = "$PATH:$mavenHome/bin:$dockerHome/bin"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests=true'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("mohyder/contactsbootapi:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockercred') {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
post {
    always {
        sh 'docker logout dockerhub'
    }
    success {
        echo 'Yay! Success!'
    }
    unstable {
        echo 'The pipeline has passed but some criteria is unstable'
    }
    failure {
        echo 'We failed :('
    }
    changed {
        echo 'Things were different before...'
    }
}
   
