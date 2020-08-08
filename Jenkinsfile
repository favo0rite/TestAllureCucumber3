pipeline {
    agent any

    stages {
        stage('Print message') {
            steps {
                echo "${PARAMS}"
            }
        }
        stage('Run test') {
            steps {
                withMaven(maven: 'maven-3.3.9') {
                    bat 'mvn clean test -Dtags=${tags} allure:report'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
}