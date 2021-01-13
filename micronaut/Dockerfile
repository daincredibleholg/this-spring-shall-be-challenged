FROM openjdk:11-jdk-slim
WORKDIR /fosdem-demo
COPY build/libs/app-1.0.0-all.jar app.jar
COPY docker/application.properties /fosdem-demo/application.properties
COPY docker/runner.sh /

RUN chmod +x /runner.sh

EXPOSE 8080
CMD ["/runner.sh"]