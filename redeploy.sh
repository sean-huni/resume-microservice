#!/usr/bin/env bash

redeploy(){
gradle clean
gradle build
docker build -f Dockerfile -t resume-ms-img .
docker run --name='resume-ms' -d -it -p 8080:8080 resume-ms-img && docker logs resume-ms -f
}

if [[ ! -z "$(docker container ps | grep resume-ms)" ]]; then
    echo "Resume Microservice Docker Container Found"
    docker stop resume-ms && docker rm resume-ms && docker rmi resume-ms-img
    redeploy
else
    echo "Resume Microservice Docker Container NOT Found"
    redeploy
fi

