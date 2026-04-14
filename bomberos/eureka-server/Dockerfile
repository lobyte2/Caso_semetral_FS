
FROM eclipse-temurin:17-jdk

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Instalamos curl
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# jar
COPY target/*.jar app.jar

# Puerto de Eureka
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]