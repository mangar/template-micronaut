FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim

COPY build/libs/template-micronaut-*-all.jar template-micronaut.jar

EXPOSE 8080

# CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar template-micronaut.jar
CMD ["java", "-server", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:InitialRAMFraction=2", "-XX:MinRAMFraction=2", "-XX:MaxRAMFraction=2", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "template-micronaut.jar"]
