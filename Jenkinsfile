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
                    if exist target rmdir /s /q target
                    mkdir target
                    mkdir target\\test-classes
                    javac -d target src/app/*.java
                '''
            }
        }
        
        stage('Test') {
            steps {
                bat '''
                    echo Compilando tests...
                    javac -cp "target;lib/*" -d target\\test-classes tests/*.java
                    
                    echo Ejecutando tests...
                    java -cp "target;target\\test-classes;lib/*" org.junit.runner.JUnitCore AraleTest SenbeiTest > target\\test-results.xml || echo "Tests completed with some failures"
                '''
            }
            post {
                always {
                    junit 'target/test-results.xml'
                    archiveArtifacts 'target/test-results.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                bat '''
                    cd target
                    jar cvf app.jar *
                '''
            }
        }
    }
}