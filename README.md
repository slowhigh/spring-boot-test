# spring-boot-test
- Environment
    - Project: Gradle-Kotlin
    - Language: Java
    - Spring Boot: 3.3.3
    - Packaging: Jar
    - Java: 22

- Command
    ```sh
    > ./gradlew bootRun
    
    > ./gradlew test

    > ./gradlew build
    ```
- Hot Reload
    - terminal 1
        ```sh
        > ./gradlew build --continuous
        ```
    - terminal 2
        ```sh
        > ./gradlew bootRun
        ```

- Spring의 import static 구문은 자동으로 생성되지 않는다
    ```java
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    ```

- build.gradle.kts에 dependency 추가 후 build.gradle.kts 클릭 후 "Reload Projects" Click or Shift+Alt+U

- build 시 생성되는 jar의 파일 이름 설정 (./build/libs/cloudnote-0.0.1.jar)
    - `./settings.gradle.kts` 파일 내 `rootProject.name` 항목 수정 (rootProject.name = "cloudnote")
    - `./build.gradle.kts` 파일 내 `version` 항목 수정 (version = "0.0.1")

- docker 파일 생성
    ```sh
    $ docker build --build-arg JAR_FILE=build/libs/\*.jar -t slowhigh/cloudnote .

    $ docker run -d --name rest-service -p 8080:8080 slowhigh/cloudnote
    ```