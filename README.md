
```
./mvnw clean spring-boot:run -f demo-receiver -Dspring-boot.run.arguments="--spring.docker.compose.file=$(pwd)/compose.yaml --spring.docker.compose.enabled=true"
./mvnw clean spring-boot:run -f demo-sender -Dspring-boot.run.arguments="--spring.docker.compose.file=$(pwd)/compose.yaml --spring.docker.compose.enabled=true"
```

http://localhost:15672 `guest`/`guest`

<img width="1024" alt="image" src="https://github.com/user-attachments/assets/fc27a162-d0cb-4a98-a692-ec3731341c62">
