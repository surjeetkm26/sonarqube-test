node{

	def project = 'my-project'
  	def appName = 'my-first-microservice'
  	def serviceName = "${appName}-backend"  
  	def imageVersion = 'development'
  	def namespace = 'development'
  	def imageTag = "gcr.io/${project}/${appName}:${imageVersion}.${env.BUILD_NUMBER}"
  	def branchName = "master"
  
	stage("Git clone"){
		git credentialsId: 'GITHUB_CREDENTIALS', url: 'https://github.com/surjeetkm26/sonarqube-test.git'
	}
	stage("Maven clean build artifact"){
		def mavenHome= tool name: "Maven", type: "maven"
		def command= "${mavenHome}/bin/mvn"
		bat "${command} clean package -DskipTests"
	}
	
	stage("CheckMarx-security Scan"){
		
	}
	stage("Build Docker Image"){
		bat "docker build -t dockerrock123/sonarqube:1.0 ."		
	}
	stage("Build Push Image"){
		withCredentials([string(credentialsId: 'dockerlogin', variable: 'dockerlogin')]) {
 			   		bat "docker login -u dockerrock123 -p ${dockerlogin}"
		}
		bat "docker push dockerrock123/sonarqube:1.0"	
	}
	stage("deploy to GKE"){
			kubernetesDeploy(configs: 'deployment.yml',
							 kubeconfigId: 'k8configid',
							 enableConfigSubstitution: true)	
	}
}