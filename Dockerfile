#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
#
# Package stage
#
FROM openjdk:20
COPY --from=build /target/chat-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]