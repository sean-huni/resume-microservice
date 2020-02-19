#!/usr/bin/env bash

redeploy(){
gradle clean
gradle build
docker build -f Dockerfile -t resume-img .
docker run --name='resume' -d -it -p 8080:8080 resume-img && docker logs resume -f
}

if [[ ! -z "$(docker container ps | grep resume)" ]]; then
    echo "Resume Docker Container Found"
    docker stop resume && docker rm resume && docker rmi resume-img
    redeploy
else
    echo "Resume Docker Container NOT Found"
    redeploy
fi

