# starting with this linux server
FROM maven:3-eclipse-temurin-21

# create a directory call/ app
# go into the directory cd /app
WORKDIR / app

# everything after this is in /app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

COPY .mvn .mvn
COPY src src

# build the application 
RUN mvn package -Dmaven.test.skip=true

# run the application 
# Define environment variable 
ENV PORT=8080

# expose the port (reference the env variable, dont hardcode it)
EXPOSE ${PORT}  

# run the program/container
ENTRYPOINT SERVER_PORT ${PORT} java -jar target/day14/-0.0.1-SNAPSHOT.jar