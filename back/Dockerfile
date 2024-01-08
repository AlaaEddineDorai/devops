# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/back.jar /app/app.jar

# Specify the default command to run on container startup
CMD ["java", "-jar", "app.jar"]

