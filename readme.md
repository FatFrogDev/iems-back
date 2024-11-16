# IEMS Backend

This is a REST-API backend for the IEMS project. It is made for ......

## Table of Contents

- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Technologies

- Java
- Spring Boot
- Gradle
- PostgreSQL

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/FatFrogDev/iems-back.git
    cd iems-back
    ```

   2. Configure the database connection in `application.yml`:
       ```properties
      spring:
         datasource:
            url: jdbc:postgresql://localhost:5432/iems
            username: postgres
            password:SecretPassw0rd12390
       ```

3. Build the project:
    ```sh
    ./gradlew build
    ```

4. Run the application:
    ```sh
    ./gradlew bootRun
    ```

## Usage

To use the API, you can send HTTP requests to the endpoints defined below.

### API Endpoints

Check docs at: http://{{app-url}}/swagger-ui/index.html#/

## Contributing

Contributions are welcome! Please fork the repository and create a pull request.

## License

This project is licensed under the MIT License.

---

Made with ♥ by [Deyby](https://github.com/FatFrogDev/)