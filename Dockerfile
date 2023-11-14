FROM openjdk:8
EXPOSE 9089
ADD target/KaddemProject-0.0.1-SNAPSHOT.jar kaddem.jar
ENTRYPOINT ["java","-jar","kaddem.jar"]
