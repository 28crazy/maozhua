# 二开推荐阅读[如何提高项目构建效率](https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/scene/build/speed.html)
# 多模块构建：在仓库根目录（maozhua/）执行 docker build。
FROM maven:3.9-eclipse-temurin-11-alpine AS build

WORKDIR /app

COPY settings.xml pom.xml ./
COPY common ./common
COPY domain ./domain
COPY api ./api
COPY infra ./infra
COPY app ./app

RUN mvn -s /app/settings.xml -B -q -f /app/pom.xml clean package -DskipTests

FROM eclipse-temurin:11-jre-alpine

RUN apk add --no-cache ca-certificates

WORKDIR /app

COPY --from=build /app/app/target/app-0.0.1-SNAPSHOT.jar /app/app.jar

ENV SERVER_PORT=80

EXPOSE 80

CMD ["java", "-jar", "/app/app.jar"]
