FROM openjdk:8-jdk-alpine
ADD target/challenge-0.0.1-SNAPSHOT.jar challenge-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["sh","-c","java -jar /challenge-0.0.1-SNAPSHOT.jar"]