# Step 1: Use an official OpenJDK runtime as the base image.
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container.
WORKDIR /app

# Step 3: Copy the packaged JAR file into the container.
COPY target/*.jar /app/application.jar

# Step 4: Expose the port on which the Spring Boot application will run.
EXPOSE 8080

# Set the active Spring profile
ENV SPRING_PROFILES_ACTIVE=h2

# Step 5: Run the Spring Boot application.
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
