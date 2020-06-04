# Resume-z
Creative Resume Website

Gone are the days of handing out a copy of the paper CV. This project aims to explore the creativity in developing a CV website.

# Tech-Stack
   - Java SpringBoot Microservice.
   - Angular 9 [UI-Single Page Application](https://github.com/sean-huni/resume-user-interface)
   - JPA-Hibernate
   - MariaDB

Launching the App with Gradle
 - On Unix/MacOS
 
    `./gradlew bootRun`
    
 - On Windows:

    `gradlew.bat run`
 
    
# Swagger-Docs
Swagger Url: http://localhost:8080/swagger-ui.html

# Deployment via Docker

## From the Dev Machine
 - Updated `s34n/resume-ms-img:<version>` of the app in run.sh
 - sh run.sh
 - `docker login --username s34n`
 - Generate New Access Token >> for that machine on DockerHub
   
## From the Cloud-Env
 - `sudo docker stop resume-ms && sudo docker rm resume-ms`
 - `sudo docker pull s34n/resume-ms-img:<version>`
 - `sudo docker run --name='resume-ms' -it --restart unless-stopped -p 8080:8080 s34n/resume-ms-img:<version>`
 