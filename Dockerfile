FROM alpine:edge
MAINTAINER swag.antispe
VOLUME /tmp
EXPOSE 8080
RUN apk add openjdk11
RUN apk add curl
RUN apk add tar
RUN apk add bash
ARG JAR_FILE=target/springboot-cassandra-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]