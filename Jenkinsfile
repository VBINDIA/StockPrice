pipeline {
agent any
stages {
        stage('Install') { 
            steps { 
                bat 'mvn clean install' 
            }
        }
        stage('Create Docker image'){
            steps {
                bat 'docker build -t stock/java .'
            }
        }
        stage('Run docker springboot') {
            steps {
                bat 'docker stop java-app-stock docker rm java-app-stock docker run -d -p 8500:8500 --name java-app-stock stock/java'
            }
        }

        stage('Create angular app image') {
            steps {
                bat 'docker build -t stock/angular angular-stock-price/.'
            }
        }

        stage('Run docker angular app') {
            steps {
                bat 'docker stop angular-app-stock docker rm angular-app-stock docker run -d -it -p 80:80/tcp --name angular-app-stock stock/angular:latest'
            }
        }
    }
}
