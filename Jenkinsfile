pipeline {
    agent any
    stages {
               // 1. Checkout del código fuente
        stage('Checkout') {
            steps {
                git branch: 'main', 
                     url: 'https://github.com/sxbres/javaJenkins.git'
            }
        }

        // 2. Compilación del código principal
        stage('Compile') {
            steps {
                bat '''
                    if exist target rmdir /s /q target
                    mkdir target
                    javac -d target src/app/*.java
                '''
            }
        }
    }
}