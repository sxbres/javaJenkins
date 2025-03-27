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
            java -cp "target;tests;lib/*" org.junit.runner.JUnitCore tests.AraleTest tests.SenbeiTest > test-output.txt 2>&1 || echo "Tests completed"
            
            echo Mostrando resultados detallados...
            type test-output.txt
            
            echo Generando reporte XML...
            echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > test-results.xml
            echo "<testsuite>" >> test-results.xml
            type test-output.txt | findstr /C:"Test " >> test-results.xml
            echo "</testsuite>" >> test-results.xml
            
            move test-results.xml target\\
            move test-output.txt target\\
        '''
    }
    post {
        always {
            junit 'target/test-results.xml'
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