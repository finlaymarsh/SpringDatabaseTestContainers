FROM openjdk:17-jdk

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/app.jar"]