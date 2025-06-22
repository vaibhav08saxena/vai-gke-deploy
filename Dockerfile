FROM openjdk:24-jdk
COPY target/*.jar app.jar
EXPOSE 8101
ENTRYPOINT ["java", "-jar", "/app.jar"]