 URL Shortener

This Assessment is about URL Shortener using Spring Boot and exposing endpoint which takes input as the URL and returns shortenend URL

Endpoint

POST : http://localhost:8080/rest/url

Commands to build project

Maven build tool is build the project. Below command is to build the jar

		mvn clean package

Docker Commands

To Build Docker Image
	
	docker build -t assessment/url-shortener .

To Run the Docker Image

	docker run -p 8080:8080 assessment/url-shortener

Tag the Image before pushing to the Docker Hub Repository
	
	docker tag assessment/url-shortener stanraj/assessments:url-shortener

Push the image to the Docker hub repository using the dockerid
	
	docker push stanraj/assessments:url-shortener

Pulling the image from docker repository to local

	docker pull stanraj/assessments:url-shortener

Docker Repository URL
https://hub.docker.com/r/stanraj/assessments/tags?page=1&ordering=last_updated
