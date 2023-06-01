package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def build(String imageName) {
        script.sh "docker build -t $imageName ."
    }

    def login(){
        script.withCredentials([script.usernamePassword(credentialsId: "Docker", passwordVariable: "PASS", usernameVariable: "USR")]) {
            script.sh "echo $script.PASS | docker login -u $script.USR --password-stdin"
        }
    }

    def push(String imageName) {
        script.sh "docker push $imageName"
    }
}