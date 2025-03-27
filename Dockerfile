FROM gradle:8-jdk21-corretto as builder

WORKDIR /app

COPY . .

RUN gradle build --no-daemon

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/guess-the-pass.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
