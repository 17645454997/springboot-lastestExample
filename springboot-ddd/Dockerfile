FROM java:8
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]



