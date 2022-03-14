# codingChallenge
It is a backend application where a customer can create new product, view all products, modify and delete their own products.
### Strategy
#### The client registers first and then logs in. After login, a jwt token is returned based on the email address.
#### The token that comes out after login is sent from the header(Authorization) in every endpoint so that the client can update or delete only its own products.
### Technologies used in this project:
#### BackEnd Framework: SpringBoot
#### ORM: Hibernate
#### Database: PostgreSql
