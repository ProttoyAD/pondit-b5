FROM ubuntu:latest

COPY ./amazon-corretto-20 /home/jdk20

WORKDIR /home/jdk20/bin

COPY ./labforward-backend-1.0.0.jar /home/labforward.jar

CMD ["./java", "-jar", "/home/labforward.jar"]