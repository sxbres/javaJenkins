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
            
            echo Mostrando contenido de target\\test-classes...
            dir /s /b target\\test-classes
            
            echo Ejecutando tests con output detallado...
            java -cp "target;target\\test-classes;lib/*" org.junit.runner.JUnitCore AraleTest SenbeiTest > target\\test-output.txt 2>&1 || echo "Tests completed with some failures"
            
            echo Generando reporte XML...
            echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > target\\test-results.xml
            echo "<testsuite>" >> target\\test-results.xml
            type target\\test-output.txt | findstr /C:"Test " >> target\\test-results.xml
            echo "</testsuite>" >> target\\test-results.xml
            
            echo Mostrando resultados...
            type target\\test-output.txt
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