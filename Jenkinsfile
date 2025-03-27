pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://gitlab.com/jaumefg/javaJenkins'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
/*
        stage('Subir a FTP') {
            steps {
                sh 'curl -T target/*.jar ftp://usuario:contraseña@servidorFTP/ruta/'
            }
        }*/
    }
}
