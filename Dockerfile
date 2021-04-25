FROM java:8
FROM maven:alpine
WORKDIR /app
COPY . /app
EXPOSE 8080
ADD ./target/data-warehouse-0.0.1-SNAPSHOT.jar data-warehouse-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","data-warehouse-0.0.1-SNAPSHOT.jar"]
