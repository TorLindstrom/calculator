pipeline {
    agent any 
    tools{
        maven 'M3'
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application...'
                sh "mvn -B verify clean"
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
                sh "mvn integration-test"
            }
        }
        
        stage("deploy") {
            steps{
                echo 'deploying the application...'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/TEST-*.xml'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was unstable'
        }
        changed {
            echo 'This will run only if the state of the pipeline has changed'
        }
    }
}
