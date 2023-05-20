FROM alpine

#install java command
RUN apk add openjdk11

COPY ./target/*.jar app.jar

COPY ./src/main/resources/application.properties application.properties

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar