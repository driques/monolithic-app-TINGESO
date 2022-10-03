pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages {
        stage('Build jar file') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/driques/monolithic-app-TINGESO']]])
                sh 'mvn package -DskipTests'
            }
        }
        stage('Build docker image'){
            steps {
                sh 'docker build -t driques/monolithic-app.jar .'
            }
        }
        stage('Push docker image'){
            steps {
                script{
                    withCredentials([string(credentialsId: 'dockerhubpass', variable: 'dckrpass')]) {
                        sh 'docker login -u driques -p ${dckrpass}'
                    }
        
                    sh 'docker push driques/monolithic-app.jar'
                }
            }
        }
    }
    post {
		always {
			sh 'docker logout'
		}
	}
}