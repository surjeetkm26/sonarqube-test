node{
	stage("Git clone"){
		git credentialsId: 'GITHUB_CREDENTIALS', url: 'https://github.com/surjeetkm26/sonarqube-test.git'
	}
	stage("Maven clean build artifact"){
		def mavenHome= tool name: "Maven", type: "maven"
		def command= "${mavenHome}/bin/mvn"
		bat "${command} clean package -DskipTests"
	}
	stage("Code Quality Check SonarQube"){
		
			withSonarQubeEnv("sonarkube-server") {
				def mavenHome= tool name: "Maven", type: "maven"
				def command= "${mavenHome}/bin/mvn"
				bat "${command} sonar:sonar"
			}
		}
	stage("Build Docker Image"){
		withDockerRegistry(credentialsId: 'dockerhub-credential', url: 'https://hub.docker.com/') {
			app=docker.build(dockerrock123/sonarqubetest)
		}
	}
	
}