pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                sh '''
                docker run --rm \
                -v $WORKSPACE:/app \
                -w /app \
                maven:3.9.9-eclipse-temurin-17 \
                mvn clean test
                '''
            }
        }

        stage('Build') {
            steps {
                sh '''
                docker run --rm \
                -v $WORKSPACE:/app \
                -w /app \
                maven:3.9.9-eclipse-temurin-17 \
                mvn package -DskipTests
                '''
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
         success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}