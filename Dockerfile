FROM maven:3.8.6-amazoncorretto-17 AS builder

WORKDIR /app

COPY pom.xml    .
COPY src ./src
RUN mvn -DskipTests clean install

FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
COPY --from=builder app/target/library-system-1.0.0.jar ./library-system-1.0.0.jar

EXPOSE 8080

CMD ["java", "-jar", "library-system-1.0.0.jar"]

