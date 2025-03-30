FROM maven:3.9.6-amazoncorretto-21 AS builder
WORKDIR /hw1
COPY ./../ /hw1/.
RUN mvn clean package


FROM amazoncorretto:21-alpine
ARG TARGET_JAR=hw1-1.0.0.jar
ENV TARGET_JAR=${TARGET_JAR}
ARG BUILDER_TARGET_DIR=/hw1/target
ARG MAIN_TARGET_DIR=/hw1
RUN mkdir -p ${MAIN_TARGET_DIR}
COPY --from=builder ${BUILDER_TARGET_DIR}/${TARGET_JAR} ${MAIN_TARGET_DIR}/$TARGET_JAR
WORKDIR ${MAIN_TARGET_DIR}
CMD java -jar $TARGET_JAR
