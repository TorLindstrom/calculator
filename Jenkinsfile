pipeline {
    environment {
        PATH = "C:\\WINDOWS\\SYSTEM32"
    }
    agent {
        label 'windows'
    }
    tools{
        maven 'Maven Computer'
    }
    options{
        timestamps ()
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application...'
                bat "mvn -version"
                bat "mvn clean compile"
                //stash includes: '**/target/*.class', name: 'class'
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
                //unstash 'class'
                bat "mvn test"
            }
        }
        
        stage("deploy") {
            steps{
                echo 'deploying the application...'
                bat "mvn package"
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
