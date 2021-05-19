pipeline {
     agent {
            label 'Slave_Induccion'
     }

     options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
     }

     tools {
       jdk 'JDK11_Centos'
       gradle 'Gradle5.0_Centos'
     }

     stages{
        stage('Checkout') {
            steps{
                echo "------------>Checkout<------------"
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default',
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        credentialsId: '21962253',
                        url:'https://github.com/jihenaor/jorgehenaoadn'
                    ]]
                ])
            }
        }

        stage('Compile & Unit Tests') {
            steps{
                dir("microservicio") {
                    echo "------------>Clean Tests<------------"
                    sh 'gradle clean'
                    echo "------------>Tests<------------"
                    sh 'gradle test'
                }
            }
        }

        stage('Static Code Analysis') {
            steps{
                 echo '------------>Análisis de código estático<------------'
                 withSonarQubeEnv('Sonar') {
                 sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties -X"
                 }
            }
        }

        stage('Build') {
            steps {
               echo "------------>Build<------------"
               dir("microservicio") {
                     sh 'gradle build -x test'
               }
            }
        }
     }

     post {
          always {
              echo 'This will always run'
          }
          success {
               echo 'This will run only if successful'
               junit 'microservicio/**/build/test-results/test/*.xml'
          }
          failure {
               echo 'This will run only if failed'
               mail (to: 'jorge.henao@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
          }

          unstable {
               echo 'This will run only if the run was marked as unstable'
          }
          changed {
              echo 'This will run only if the state of the Pipeline has changed'
              echo 'For example, if the Pipeline was previously failing but is now successful'
          }
     }
}