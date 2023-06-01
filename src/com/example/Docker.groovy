package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def image(String imageName) {
        script.withCredentials([script.usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login -u $script.USR --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}