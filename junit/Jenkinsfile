pipeline {
    agent any 
    tools{
        maven 'M3'
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application...'
                //sh "mvn -B verify"
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
                //sh "mvn integration-test"
            }
        }
        
        stage("deploy") {
            steps{
                echo 'deploying the application...'
            }
        }
    }
}
