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
                    
                    echo Mostrando estructura de target\\test-classes...
                    dir /s /b target\\test-classes
                    
                    echo Ejecutando tests...
                    java -cp "target;target\\test-classes;lib/*" org.junit.runner.JUnitCore tests.AraleTest tests.SenbeiTest > target\\test-output.txt 2>&1 || echo "Tests completed with some failures"
                    
                    type target\\test-output.txt
                '''
            }
            post {
                always {
                    junit 'target/test-output.txt'
                    archiveArtifacts 'target/test-output.txt'
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