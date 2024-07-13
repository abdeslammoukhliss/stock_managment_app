pipeline {
    agent {
        label 'alpine-jdk-2'
        // or
        // node 'your_existing_agent_name'
    }

    stages {


        stage('Build') {
                    steps {
                        // Build the project
                        sh 'mvn clean install'
                    }
                }
                stage('Test') {
                    steps {
                        // Run the tests
                        sh 'mvn test'
                    }
                }


    }

    post {
        success {
            echo 'Pipeline completed successfully. Application deployed.'
            // Additional post-success actions if needed
        }
        failure {
            echo 'Pipeline failed. Deployment aborted.'
            // Additional actions to handle failure
        }
    }
}
