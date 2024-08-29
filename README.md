# spring-boot-test
- Environment
    - Project: Gradle-Kotlin
    - Language: Java
    - Spring Boot: 3.3.3
    - Packaging: Jar
    - Java: 22

- Command
    ```sh
    $ ./gradlew bootRun
    
    $ ./gradlew test

    $ ./gradlew build
    ```

- Spring의 import static 구문은 자동으로 생성되지 않는다
    ```java
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    ```