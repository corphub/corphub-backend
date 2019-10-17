# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8082 available to the world outside this container
EXPOSE 8082:8082

# The application's jar file
ARG POM_VERSION=target/tophub-backend-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD "target/tophub-backend-${POM_VERSION}.jar" "tophub-backend.jar"

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "tophub-backend.jar"]