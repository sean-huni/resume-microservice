#!/usr/bin/env bash

redeploy() {
  gradle clean
  gradle build
  docker build -f Dockerfile -t resume-ms-img .
  docker run --name='resume-ms' -d -it -p 8080:8080 resume-ms-img && docker logs resume-ms -f
}

build() {
  docker build -f Dockerfile -t resume-ms-img .
}

# Tag-And-Push Script to tag & push the app
tagAndPush() {
  docker tag resume-ms-img:latest s34n/resume-ms-img:latest
  docker push s34n/resume-ms-img:latest
}

if [[ ! -z "$(docker container ps | grep resume-ms)" ]]; then
  echo "Resume Microservice Docker Container Found"
  docker stop resume-ms && docker rm resume-ms && docker rmi resume-ms-img
  build
  tagAndPush
else
  echo "Resume Microservice Docker Container NOT Found"
  build
  tagAndPush
fi
