FROM openjdk:11
LABEL maintainer="chat-application"
ADD target/chat-0.0.1-SNAPSHOT.jar chat-application.jar
ENTRYPOINT ["java", "-jar", "chat-application.jar"]