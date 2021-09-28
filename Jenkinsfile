pipeline {
    agent any
	
    stages {
        stage('CompileStage') 
        {
           
            steps {
            
	            	withMaven(maven:'maven_3.8.2')
	                {
	                sh 'mvn clean compile'
	                }
            	  }
        }
        
            stage('TestStage') 
        {
           
            steps {
            
	            	withMaven(maven:'maven_3.8.2')
	                {
	                sh 'mvn test'
	                }
            	  }
        }
      }
}