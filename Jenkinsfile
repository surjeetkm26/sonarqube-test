node{
	stage("Git clone"){
		git credentialsId: 'GITHUB_CREDENTIALS', url: 'https://github.com/surjeetkm26/sonarqube-test.git'
	}
	stage("Maven clean build artifact"){
		def mavenHome= tool name: "Maven", type: "maven"
		def command= "${mavenHome}/bin/mvn"
		bat "${command} clean package -DskipTests"
	}
	
	stage("Build Docker Image"){
		app=docker.build('kubernetes-pro/sonarqube:v1')
	}
	stage("Push Docker image to Container Registry"){
			docker.withRegistry('https://eu.gcr.io', 'gcr:gke') {
 	 		app.push()
 	 		
		}
	}
	
}