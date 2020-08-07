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
                withMaven(maven: 'maven_3.6.3') {
                    bat 'mvn clean test -Dtest=AllureTest#${TAG} allure:report -Dmaven.test.failure.ignore=true install'
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