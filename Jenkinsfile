pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sxbres/javaJenkins.git'
            }
        }
        stage('Compile') {
            steps {
                bat '''
                    mkdir target
                    javac -d target src/app/*.java
                '''
            }
        }
        stage('Package') {
            steps {
                bat '''
                    cd target
                    jar cvf app.jar *.class
                '''
            }
        }
    }
}