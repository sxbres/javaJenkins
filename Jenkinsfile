pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://gitlab.com/sxbres/javaJenkins'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
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
