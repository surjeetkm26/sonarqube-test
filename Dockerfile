FROM openjdk:11
RUN mkdir -p /opt/store/
COPY ./target/sonarqube-test.jar /opt/store/
WORKDIR /opt/store/
EXPOSE 8080
CMD ["java", "-jar", "sonarqube-test.jar"]