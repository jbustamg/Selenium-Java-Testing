pipeline
{
    agent any

    parameters
    {
        string(name: 'TAGS', defaultValue: 'regression', description: 'Use regression to execute all tests')
        string(name: 'EMAIL', defaultValue: 'rtroncosogajardo.external@epo.org', description: 'Users to notify after build')
    }
    stages {
        stage('Checkout') {
            steps
            {
                cleanWs()
                withCredentials([
                    usernamePassword(
                        credentialsId: 'github-legal-client',
                        usernameVariable: 'GITHUB_APP',
                        passwordVariable: 'GITHUB_ACCESS_TOKEN')
                ])
                {
                    git branch: "feature/report-update", url: "https://${GITHUB_APP}:${GITHUB_ACCESS_TOKEN}@git.epo.org/legal-client/lc-automated-testing.git"
                }
            }
        }
        stage('Test') {
            steps {
                   script {
                      sh """
                          mvn clean verify serenity:aggregate -Dtags=${TAGS}
                      """
                   }
            }
        }
    }
   post {
        always {
            script {
                summary = junit testResults: 'target/failsafe-reports/TEST-*.xml'
            }
            emailext body: "Failed: ${summary.failCount}/${summary.totalCount}, took ${currentBuild.durationString} \n Report: ${BUILD_URL}", subject: "Legal-client: $BUILD_URL", to: '${EMAIL}'
            publishHTML(target: [
                reportName : "Test results for legal client",
                reportDir:   'target/site/serenity',
                reportFiles: 'index.html',
                keepAll:     true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])
            archiveArtifacts 'target/site/serenity/**, target/failsafe-reports/**, logs/**'
        }
    }
}