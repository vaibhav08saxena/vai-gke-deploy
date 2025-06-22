FROM container-registry.oracle.com/java/openjdk:24

# Install Maven
ENV MAVEN_VERSION=3.9.10
RUN curl -fsSL https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven

ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Verify Maven installation
RUN mvn -v

WORKDIR /app
COPY pom.xml .
COPY src ./src

#rum maven to build jar
RUN mvn clean package -DskipTests
RUN pwd
RUN ls -l /app/target/

COPY /app/target/demo-employee-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]