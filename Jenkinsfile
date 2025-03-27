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
                    javac -d target src/app/*.java
                '''
            }
        }
        
        stage('Test') {
            steps {
                bat '''
                    echo Compilando tests desde directorio original...
                    javac -cp "target;lib/*" tests/*.java
                    
                    echo Ejecutando tests in-place...
                    java -cp "target;tests;lib/*" org.junit.runner.JUnitCore tests.AraleTest tests.SenbeiTest > test-results.xml || echo "Tests completed"
                    
                    echo Moviendo resultados a target...
                    move test-results.xml target\\
                '''
            }
            post {
                always {
                    junit 'target/test-results.xml'
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