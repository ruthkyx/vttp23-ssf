FROM maven:3-eclipse-temurin-21

LABEL MAINTAINER="ruth.kyx@gmail.com"
LABEL APPLICATION="Healthcheck Application"

WORKDIR /usr/app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src
# COPY target/day18lect-0.0.1-SNAPSHOT.jar

RUN mvn package -Dmaven.test.skip=true

ENTRYPOINT ["java", "-jar", "target/day18lect-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3 \
CMD curl -s -f http://localhohst:8080/demo/health || exit 1
