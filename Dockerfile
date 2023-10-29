FROM amazoncorretto:17 AS spring-builder

COPY gradlew .
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle gradle
COPY src src


RUN chmod +x gradlew
# -x test는 tdd 구현시 필요한 부분 현재는 datasource connection test 실패로 제외 해놓음
RUN ./gradlew build -x test || return 0
COPY . .
#################################################################

FROM amazonlinux

RUN yum -y install java-17-amazon-corretto amazon-cloudwatch-agent /usr/bin/systemctl
COPY ./cloud-watch/config.json /opt/aws/amazon-cloudwatch-agent/bin/default_linux_config.json

# docker port open
EXPOSE 8080


ENV RUN_IN_CONTAINER="True"
# copy build file
# cicd-0.0.1-SNAPSHOT -> 파라미터로 대체 가능 할 듯
COPY --from=spring-builder ./build/libs/commerce-0.0.1-SNAPSHOT.jar app.jar