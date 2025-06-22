# Stage 1: Build with Maven and JDK 24
FROM eclipse-temurin:24-jdk AS builder
ENV MAVEN_VERSION=3.9.10
RUN apt-get update && apt-get install -y curl tar && \
    curl -fsSL https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the app with JDK 24
FROM eclipse-temurin:24-jdk
WORKDIR /app
COPY --from=builder /app/target/demo-employee-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]