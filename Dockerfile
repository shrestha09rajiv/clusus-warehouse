FROM openjdk:8-jre-alpine
EXPOSE 8080
RUN mkdir /app
COPY target/*.jar /app/warehouse-application.jar
ENTRYPOINT [ "java", "-jar", "warehouse-application.jar" ]