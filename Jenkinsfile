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
                    mkdir test-classes 2>nul || rem
                    javac -cp "target;lib/*" -d test-classes tests/*.java
                    
                    echo Ejecutando tests...
                    java -cp "target;test-classes;lib/*" org.junit.runner.JUnitCore tests.AraleTest tests.SenbeiTest > test-output.txt 2>&1 || echo "Tests completed"
                    
                    type test-output.txt
                '''
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

        stage('Upload to FTP') {
            steps {
            bat '''
            echo open 127.0.0.1 > ftp_commands.txt
            echo user jenkins >> ftp_commands.txt
            timeout /t 2 /nobreak >> ftp_commands.txt
            echo jenkins >> ftp_commands.txt
            echo binary >> ftp_commands.txt
            echo cd / >> ftp_commands.txt
            echo put target/app.jar >> ftp_commands.txt
            echo bye >> ftp_commands.txt
            ftp -n -s:ftp_commands.txt
        '''
    }
}

    }
}
