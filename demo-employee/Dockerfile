FROM openjdk:24-jdk
#RUN mvn clean package -DskipTests
RUN ls -l 
RUN ls -l target
COPY target/*.jar app.jar
EXPOSE 8101
ENTRYPOINT ["java", "-jar", "app.jar"]