FROM openjdk:24-jdk
WORKDIR /demo-employee
RUN mvn clean package -DskipTests
COPY target/*.jar app.jar
EXPOSE 8101
ENTRYPOINT ["java", "-jar", "app.jar"]