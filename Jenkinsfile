pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
        steps {
            bat 'if exist target rmdir /s /q target'
        }
}

        stage('Test') {
            steps {
                bat '''
                docker run --rm ^
                -v %WORKSPACE%:/workspace  ^
                -w /workspace  ^
                maven:3.9.9-eclipse-temurin-17 ^
                mvn clean test 
                '''
            }
        }

        stage('Build') {
            steps {
                bat '''
                docker run --rm ^
                -v %WORKSPACE%:/workspace  ^
                -w /workspace  ^
                maven:3.9.9-eclipse-temurin-17 ^
                mvn package -DskipTests
                '''
            }
        }
    }

    post {
        always {
            junit '**/surefire-reports/*.xml'
        }
         success {
            archiveArtifacts artifacts: '**/*.jar', fingerprint: true
        }
    }
}