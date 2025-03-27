FROM gradle:8-jdk21-corretto as builder

WORKDIR /app

COPY . .

RUN gradle clean build -x check -x test

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/ /app

CMD ["sh", "-c", "java $JAVA_OPTS -jar $(ls -1 *jar | grep -v plain)"]
