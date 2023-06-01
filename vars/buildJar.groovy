#!/usr/bin/env groovy
def call() {
    echo "Building the images"
    sh "mvn package"
}