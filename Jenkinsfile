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

        stage('SonarCloud') {

            steps {

                withCredentials([string(
                    credentialsId: 'sonar-token',
                    variable: 'SONAR_TOKEN'
                )]) {

                    bat '''
                    docker run --rm ^
                    -v %WORKSPACE%:/workspace ^
                    -w /workspace ^
                    maven:3.9.9-eclipse-temurin-17 ^
                    mvn sonar:sonar ^
                    -Dsonar.projectKey=Mar-Tini_tp-ci-cd ^
                    -Dsonar.organization=mar-tini ^
                    -Dsonar.host.url=https://sonarcloud.io ^
                    -Dsonar.token=%SONAR_TOKEN%
                    '''
                }
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
    

            stage('Docker Build Image') {
                steps {
                    bat '''
                    docker build -t tp_ci_cd:latest .
                    '''
                }
        }
    }

    //      stage('Deploy') {

    //         steps {

    //             bat '''
    //             docker compose down

    //             docker compose up -d app
    //             '''
    //         }
    //     }
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