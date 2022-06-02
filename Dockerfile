FROM openjdk:8-jdk-alpine

RUN mkdir app

ARG JAR_FILE

ADD /target/${JAR_FILE} /app/Teste.jar

WORKDIR /app

ENTRYPOINT java -jar Teste.jar