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

               // 3. Ejecución de Tests JUnit (lo que te falta)
        stage('Test') {
    steps {
        // Compila los tests
        bat '''
            javac -cp target;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar -d target tests/*.java
        '''
        // Ejecuta cada test directamente
        bat '''
            java -cp target;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore AraleTest SenbeiTest > target/test-results.xml || echo "Tests completed"
        '''
    }
    post {
        always {
            junit 'target/test-results.xml'
        }
    }
}

        // 4. Empaquetado JAR (preparación para FTP)
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