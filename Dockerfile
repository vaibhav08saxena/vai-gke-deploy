FROM openjdk:24-jdk
COPY demo-employee/target/*.jar demo-employee/app.jar
EXPOSE 8101
ENTRYPOINT ["java", "-jar", "demo-employee/app.jar"]