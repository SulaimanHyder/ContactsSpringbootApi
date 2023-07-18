#This is a docker file for the docker image contactsspringbootapi application
#Base image is openjdk with version 17
#Copy jar from target folder to docker image
#Expose port 9000

FROM openjdk:17
COPY target/contactsrestapi-1.0.0.jar contactsspringbootapi-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","contactsspringbootapi-0.0.1-SNAPSHOT.jar"]