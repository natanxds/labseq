
![Logo](https://uspto.report/TM/86227240/mark)

This simple application was created using all good practices to return the labseq value according to the number passed as a parameter. 

The unit tests were created using JUnit and the SonarLint plugin was used during development to avoid code smells and vulnerabilities.
## Installation

You can ran the application using docker or your IDE

### IDE Installation
- copy the project to your local directory using the following command:
```bash
  git clone https://github.com/natanxds/labseq.git
  cd labseq
```
- then, just open the pom.xml with your IDE as a project

### Docker Installation
I have uploaded a docker image of this application, so you can just pull this image to your machine and ran the container locally. 

To get the container running, please, login to your docker account using cmd("docker login") and then, execute the following commands:
```bash
  docker pull natanxds/labseq:1.0
  docker run -p 8080:8080 natanxds/labseq:1.0
```

    
## API Reference


#### Get item

```http
  GET /labseq/${number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`      | `long` | **Required**. Number to return the labseq |




## Documentation

With the app running, you can find the docs in:

```http
  http://localhost:8080/swagger-ui/index.html
```



## Features

- **Postman collection** was added, just import the **json** file present in the repository.


## Tech Stack

**Server:** Spring Boot  
**Unit Test:** JUnit 5



## Authors

- [@natanxds](https://www.github.com/natanxds)


## License

[MIT](https://choosealicense.com/licenses/mit/)


## Running Tests

To run tests, run the following command

```bash
  npm run test
```

