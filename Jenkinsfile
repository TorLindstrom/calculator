pipeline {
    agent any 
    tools{
        maven 'M3'
    }
    options{
        timestamps ()
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application...'
                sh "mvn -B -version"
                sh "mvn -B compile"
                stash includes: '**/target/*.class', name: 'class'
            }
        }

        stage("test") {
            agent {
                label 'CICD'
            }
            steps {
                echo 'testing the application...'
                unstash 'class'
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
