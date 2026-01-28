FROM eclipse-temurin:25
WORKDIR /app
COPY target/*.jar /app/app.jar
LABEL authors="guilh"
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
EXPOSE 8080