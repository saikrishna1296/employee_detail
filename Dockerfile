# Use a base image with Java installed
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/employye_details-0.0.1-SNAPSHOT.jar employye_details-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/employye_details-0.0.1-SNAPSHOT.jar"]