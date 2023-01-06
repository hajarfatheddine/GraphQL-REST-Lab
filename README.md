# Development of a microservice following best practices
This microservice allows the management of bank accounts.

### I- Application Architecture : 

The architecture of this microservice is as follows:

![image](https://user-images.githubusercontent.com/84817425/211089841-f6644b98-7501-4158-9dc8-9d9259b277c1.png)

### II- Application Structure :

The app is organized in packages :
```
com.microservice1.microservice1 
│
└───config
└─── dtos
│   │   BankAccountRequestDTO
│   │   BankAccountResponseDTO
└─── entities
│    │   AccountProjection
│    │   BankAccount
│    │   Customer
└─── enums
│    │   BankAccountType
└─── exceptions
│    │   CustomerDataFetcherExceptionResolver
└─── mappers
│    │   AccountMapper
└─── repositories
│    │   BankAccountRepository
│    │   CustomerRepository
└─── security
└─── services
│    │   AccountService
│    │   AccountServiceImpl
└─── web
│    │   AccountRestController
│    │   BankAccountGrapchQLController
└─── Microservice1Application
```

- **`config`**: is for configuration files.
- **`dtos`**: DTO (Data Transfer Object) is a design pattern that is used to transfer data between layers of an application. 
DTOs are often used to decouple the presentation layer of an application from the business logic, allowing the two layers to evolve independently of each other.
- **`entities`**: contains the app classes.
- **`enums`**: for enumration.
- **`exceptions`**: for personalized exceptions.
- **`mappers`**: the mappers are used to map objects of one type to another. 
Mappers can be used to convert data between different representations, such as converting data from a database entity to a DTO (Data Transfer Object) or vice versa.
- **`repositories`**: for the app's repositories.
- **`security`**.
- **`services`**.
- **`web`**: for the app's controllers.
The controllers that we have are:
- **`AccountRestController`**: This controller is a REST controller.
- **`BankAccountGrapchQLController`**: a GraphQL controller.

> Note: The difference between GraphQL & REST is that REST retrieves and returns ALL DATA, on the other hand, GraphQL returns the data wanted & specified in the file **`schema.graphqls`**.

### III- GraphQL :

1. First and for most, we need to add the following dependency in **`pom.xml`** file:
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-graphql</artifactId>
</dependency>
```
2. we need to create **`schema.graphqls`** that'll contain the description of the graphQL service (the different queries). 

The file look something like this:
```
type Query{

    accountList: [BankAccount],
    bankAccountById (id:String): BankAccount
    customers : [Customer]
}
type Mutation{
    addAccount(bankAccount: BankAccountDTO): BankAccount,
    updateAccount(id: String, bankAccount: BankAccountDTO) : BankAccount,
    deleteAccount(id: String):Boolean
}
```
---
### Testing the microservice functionalities :

#### Using Postman :

<http://localhost:8085/bankAccounts>

![Capture d’écran (341)](https://user-images.githubusercontent.com/84817425/211101854-3753c5aa-a0c8-404e-8f77-2fab29c88149.png)

<http://localhost:8085/bankAccounts/{id}>

![image](https://user-images.githubusercontent.com/84817425/211102367-151ee1f4-8d8d-4eff-a042-ccf26c3c6876.png)

#### Using GraphQL :

To be able to execute the graphQL queries we must open the following URL:

<http://localhost:8085/graphiql?path=/graphql>

The following screenshot shows the id & the balance of all bankAccounts:

![image](https://user-images.githubusercontent.com/84817425/211102536-368bb68e-74b5-4e39-862a-33b00125bebf.png)

The following screenshot shows the id, the balance, the customer's name and bankAccount of all bankAccounts that exists:

![image](https://user-images.githubusercontent.com/84817425/211102968-637c514b-f91c-4871-ab9a-39abeefc019a.png)



