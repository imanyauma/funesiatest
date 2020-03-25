FROM maven:3.6.1-jdk-8
RUN mkdir /opt/app
RUN mvn clean
COPY target/*.jar /opt/app/mwopt.jar
WORKDIR /opt/app
CMD ["java", "-jar", "/opt/app/mwopt.jar"]