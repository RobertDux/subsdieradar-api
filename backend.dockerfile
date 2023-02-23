FROM openjdk:17

COPY . .
RUN ./mvnw clean package spring-boot:repackage -DskipTests

WORKDIR /target
ENTRYPOINT ["java", "-jar", "SubsidieRadar-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081
