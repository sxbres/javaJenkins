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
        bat '''
            javac -cp target;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar -d target tests/*.java
            
            echo === EJECUTANDO TESTS ===
            java -cp target;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore AraleTest SenbeiTest | tee target/test-results.txt
            echo === FIN DE TESTS ===
            
            # Convertir output a formato JUnit XML
            echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > target/test-results.xml
            echo "<testsuite>" >> target/test-results.xml
            type target/test-results.txt | findstr /C:"Test " >> target/test-results.xml
            echo "</testsuite>" >> target/test-results.xml
        '''
    }
    post {
        always {
            junit 'target/test-results.xml'
            archiveArtifacts 'target/test-results.txt'
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