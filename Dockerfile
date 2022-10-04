FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/monolithic-pep-v1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]