FROM gradle:jdk17

COPY . .
RUN gradle installDist

RUN ls ./build/install/gradle/bin

ENTRYPOINT ["./build/install/gradle/bin/gradle"]
