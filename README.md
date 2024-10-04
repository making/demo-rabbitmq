
```
./mvnw clean spring-boot:run -f demo-receiver -Dspring-boot.run.arguments="--spring.docker.compose.file=$(pwd)/compose.yaml --spring.docker.compose.enabled=true"
./mvnw clean spring-boot:run -f demo-sender -Dspring-boot.run.arguments="--spring.docker.compose.file=$(pwd)/compose.yaml --spring.docker.compose.enabled=true"
```

http://localhost:15672 `guest`/`guest`

<img width="1024" alt="image" src="https://github.com/user-attachments/assets/88e50dbf-3326-4e30-b6d8-4259e033243f">

```
./mvnw -V --no-transfer-progress clean spring-boot:build-image -f demo-receiver -DskipTests -Dspring-boot.build-image.imageName=ghcr.io/making/demo-rabbitmq-receiver
./mvnw -V --no-transfer-progress clean spring-boot:build-image -f demo-sender -DskipTests -Dspring-boot.build-image.imageName=ghcr.io/making/demo-rabbitmq-sender
```