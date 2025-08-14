pipeline {
    agent any
    stages {
        stage('RA_ApiDefault') {
            steps {
                script {
                    bat "mvn clean test -Dproject.build.sourceEncoding=UTF-8"
                }
            }
        }
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
        unsuccessful {
            echo 'INSTÁVEL'
        }
        fixed {
            echo 'CORRIGIDO'
        }
    }
}
