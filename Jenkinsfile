pipeline {
    agent {
        label 'docker-agent-alpine'
        // or
        // node 'your_existing_agent_name'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from your version control system
                sh 'echo "no Checking out the code..."'
            }
        }

        stage('Build') {
            steps {
                // Example: Build your application (replace with your build commands)
                sh 'echo "Building the application..."'
                //sh './gradlew build' // Replace with your actual build commands
            }
        }

        stage('Test') {
            steps {
                // Example: Run tests (replace with your test commands)
                sh 'echo "Running tests..."'
               // sh './gradlew test' // Replace with your actual test commands
            }
        }

        stage('Deploy') {
            steps {
                // Example: Deploy your application (replace with your deployment commands)
                sh 'echo "Deploying the application..."'
                //sh './deploy.sh' // Replace with your actual deployment commands
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
