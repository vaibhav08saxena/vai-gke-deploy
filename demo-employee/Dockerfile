FROM openjdk:24-jdk
WORKDIR demo-employee
#RUN mvn clean package -DskipTests
RUN ls -l demo-employee
RUN ls -l demo-employee/target
COPY target/*.jar app.jar
EXPOSE 8101
ENTRYPOINT ["java", "-jar", "app.jar"]