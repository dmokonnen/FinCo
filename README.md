# FinCo
A Financial Company framework for our Advanced Software Development course at Maharishi International University.

# Design
## Class Diagram
<img src="./docs/fwUML.png"/>

## @todo add sequence diagrams
All Diagrams can be found under the docs directory

# Patterns Used
### 1. Party Pattern
The Party Patter is a design pattern used to structure Organizational Hierarchies within a design.

In FinCo framework we use it to define hierarchies between a Person and Organization(Company) units.

### 2. Account Pattern
The Account Pattern is a design pattern used to keep information about an account and all the entries
related to a given account.

In FinCo framework we use it to keep track of an account information along with transactional information.

### 3. Command Pattern
The Command Pattern is a behavioural design pattern used to encapsulate actions and store and trigger them
at a later time.

In FinCo framework we use it to perform actions related to accounts.

### 4. Factory Pattern
The Factory Pattern is a creational design pattern used to create objects.

In FinCo framework we use it to create Account and Customer instances.

# Build
to build use the terminal script `build.sh`
```shell script
chmod +x build.sh # use it only once to give executable permission to the file
./build.sh [bank|ccard]
```
and run with: `java -jar target/bank.jar` or `java -jar target/ccard.jar`

if using windows write the following commands
```shell script
mvn -Pbank clean package
mvn -Pccard clean package
```
