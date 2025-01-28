FROM openjdk:11-jdk

COPY /target/katlhula-1.0-SNAPSHOT.jar /app/katlhula.jar

CMD ["java", "-jar", "/app/katlhula.jar"]
