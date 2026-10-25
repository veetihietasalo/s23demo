# s23demo

First Spring Boot demo from the autumn 2023 back-end programming course. Three endpoints that return plain text, in Finnish.

Endpoints:
- `/main` returns "Tämä on autokaupan pääsivu" (this is the car shop's main page)
- `/moi?nimesi=Anna` returns "Hei Anna". The name defaults to Veeti
- `/moi2?nimesi=Anna&ika=30` returns "Hei Anna, 30 vuotta". Defaults: Veeti, 22

Stack: Java 17, Spring Boot 3.1.3 (web starter), Maven wrapper. The code is in `demo/`.

Run:

```
cd demo
sh mvnw spring-boot:run      # macOS / Linux
mvnw.cmd spring-boot:run     # Windows
```

Then open http://localhost:8080/main

The `main` branch has a separate version, the week 1 submission from 30 August 2023, with `/index`, `/contact` and `/hello?location=...&name=...`.

Status: course demo, 1 commit on 24 August 2023.
