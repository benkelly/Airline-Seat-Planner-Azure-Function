# Airline Seat Planner Azure Function
 An example of my aws Lambda [Airline Seat Planner](https://github.com/benkelly/Airline-Seat-Planner-Aws-Lambda) project, made this with the great [Azure-Samples/hello-spring-function-azure](https://github.com/Azure-Samples/hello-spring-function-azure) in about 30 mins :^)

## Live Sample 

```shell script
curl https://airline-seat-planner.azurewebsites.net/api/AirlineSeatPlanner -d '{"rowSize":4,"rowHeight":4,"groupList":[{"passengerList":[{"windowPref":true,"name":"1"},{"windowPref":false,"name":"2"},{"windowPref":false,"name":"3"}]},{"passengerList":[{"windowPref":false,"name":"4"},{"windowPref":false,"name":"5"},{"windowPref":false,"name":"6"},{"windowPref":false,"name":"7"}]},{"passengerList":[{"windowPref":false,"name":"8"}]},{"passengerList":[{"windowPref":false,"name":"9"},{"windowPref":false,"name":"10"},{"windowPref":true,"name":"11"}]},{"passengerList":[{"windowPref":true,"name":"12"}]},{"passengerList":[{"windowPref":false,"name":"13"},{"windowPref":false,"name":"14"}]},{"passengerList":[{"windowPref":false,"name":"15"},{"windowPref":false,"name":"16"}]}]}'
```

## Getting Started

### Prerequisites

This project uses the Maven Wrapper, so all you need is Java installed.

### Installation

- Clone the project: `git clone https://github.com/benkelly/Airline-Seat-Planner-Azure-Function.git`
- Configure the project to use your own resource group and your own application name (it should be unique across Azure)
  - Open the `pom.xml` file
  - Customize the `resourceGroup` and `appName` properties
- Build the project: `./mvnw clean package`

### Quickstart

Once the application is built, you can run it locally using the Azure Function Maven plug-in:

`./mvnw azure-functions:run`

And you can test it using a cURL command:

```shell script
curl http://localhost:7071/api/AirlineSeatPlanner -d '{"rowSize":4,"rowHeight":4,"groupList":[{"passengerList":[{"windowPref":true,"name":"1"},{"windowPref":false,"name":"2"},{"windowPref":false,"name":"3"}]},{"passengerList":[{"windowPref":false,"name":"4"},{"windowPref":false,"name":"5"},{"windowPref":false,"name":"6"},{"windowPref":false,"name":"7"}]},{"passengerList":[{"windowPref":false,"name":"8"}]},{"passengerList":[{"windowPref":false,"name":"9"},{"windowPref":false,"name":"10"},{"windowPref":true,"name":"11"}]},{"passengerList":[{"windowPref":true,"name":"12"}]},{"passengerList":[{"windowPref":false,"name":"13"},{"windowPref":false,"name":"14"}]},{"passengerList":[{"windowPref":false,"name":"15"},{"windowPref":false,"name":"16"}]}]}'
```

## Deploying to Azure Functions

Deploy the application on Azure Functions with the Azure Function Maven plug-in:

`./mvnw azure-functions:deploy`

You can then test the running application:

```shell script
curl https://<YOUR_SPRING_FUNCTION_NAME>.azurewebsites.net/api/AirlineSeatPlanner -d '{"rowSize":4,"rowHeight":4,"groupList":[{"passengerList":[{"windowPref":true,"name":"1"},{"windowPref":false,"name":"2"},{"windowPref":false,"name":"3"}]},{"passengerList":[{"windowPref":false,"name":"4"},{"windowPref":false,"name":"5"},{"windowPref":false,"name":"6"},{"windowPref":false,"name":"7"}]},{"passengerList":[{"windowPref":false,"name":"8"}]},{"passengerList":[{"windowPref":false,"name":"9"},{"windowPref":false,"name":"10"},{"windowPref":true,"name":"11"}]},{"passengerList":[{"windowPref":true,"name":"12"}]},{"passengerList":[{"windowPref":false,"name":"13"},{"windowPref":false,"name":"14"}]},{"passengerList":[{"windowPref":false,"name":"15"},{"windowPref":false,"name":"16"}]}]}'
```

Replace the `<YOUR_SPRING_FUNCTION_NAME>` part by the name of your Spring Function.
