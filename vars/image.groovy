#!/usr/bin/env groovy
def call(String imageName) {
    withCredentials([usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USR --password-stdin"
        sh "docker push $imageName"
    }
}