#!/usr/bin/env groovy
def call() {
    withCredentials([usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")]) {
        sh "docker build -t hari851995/java:v1.5 ."
        sh "echo $PASS | docker login -u $USR --password-stdin"
        sh "docker push hari851995/java:v1.5"
    }
}