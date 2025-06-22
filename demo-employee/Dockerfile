FROM openjdk:24-jdk
ENV MAVEN_VERSION=3.9.10 \
    MAVEN_HOME=/opt/maven \
    PATH=$MAVEN_HOME/bin:$PATH
RUN curl -fsSL https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} $MAVEN_HOME
RUN mvn clean package -DskipTests
RUN ls -l 
RUN ls -l target
COPY target/*.jar app.jar
EXPOSE 8101
ENTRYPOINT ["java", "-jar", "app.jar"]