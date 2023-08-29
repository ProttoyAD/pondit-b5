FROM openjdk:17-alpine

EXPOSE 8080

COPY ./target/simple-app-*.jar ROOT.jar

ENTRYPOINT ["java", "-jar", "ROOT.jar"]