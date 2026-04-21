
FROM eclipse-temurin:17-jdk-alpine

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Instalamos curl
RUN apk add --no-cache curl

# jar
COPY target/*.jar app.jar

# Puerto de Eureka
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]