FROM openjdk:17-jdk
MAINTAINER naziasultan
COPY target/service-0.0.1-SNAPSHOT.jar service-0.0.1.jar
ENTRYPOINT ["java","-jar","/service-0.0.1.jar"]