#!/usr/bin/env bash

redeploy() {
  gradle clean
  gradle build
  docker build -f Dockerfile -t resume-ms-img .
  docker run --name='resume-ms' -d -it -p 8080:8080 resume-ms-img && docker logs resume-ms -f
}

ver="5.0.0"

build() {
  ./gradlew clean
  ./gradlew assemble
  #Remember to update the version
  rm version.txt && touch version.txt && echo $ver | tee -a version.txt
  docker build -f Dockerfile -t resume-ms-img:$ver .
}

# Tag-And-Push Script to tag & push the app
tagAndPush() {
  docker tag resume-ms-img:$ver s34n/resume-ms-img:$ver
  docker push s34n/resume-ms-img:$ver
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
