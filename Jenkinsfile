pipeline {
    agent any

    tools {
        jdk 'jdk-21'  // Nombre que configuraste en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sxbres/javaJenkins.git'
            }
        }

        stage('Compile') {
            steps {
                bat """
                    if exist target rmdir /s /q target
                    mkdir target
                    mkdir target\\test-classes
                    javac -d target src/app/*.java
                """
            }
        }

        stage('Test') {
            steps {
                bat """
                    echo Compilando tests...
                    javac -cp "target;lib/*" -d target\\test-classes tests/*.java
                    echo Ejecutando tests...
                    java -cp "target;target\\test-classes;lib/*" org.junit.runner.JUnitCore tests.AraleTest tests.SenbeiTest
                """
            }
            post {
                always {
                    junit 'target/test-output.txt'  // Asegúrate de que JUnit genere un XML válido
                }
            }
        }
    }
}