FROM maven:3.6.1-jdk-8
RUN mkdir /opt/app
COPY target/*.jar /opt/app/funesiatest.jar
WORKDIR /opt/app
CMD ["java", "-jar", "/opt/app/funesiatest.jar"]