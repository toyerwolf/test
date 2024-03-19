FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY customer-ms/build/libs/customer-ms-0.0.1-SNAPSHOT.jar /app/customer-ms.jar

CMD ["sh", "-c", "java -jar customer-ms.jar"]