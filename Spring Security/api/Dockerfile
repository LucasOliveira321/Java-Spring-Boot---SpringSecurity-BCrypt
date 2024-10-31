FROM openjdk:17-slim
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080

CMD ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]