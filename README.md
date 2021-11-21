<!--- STARTEXCLUDE --->
# Reactive Implementation of 🐈 Spring PetClinic 🐕


[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-streaming-game)
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)


*50 minutes, Intermediate, [Start Building](https://github.com/DataStax-Examples/spring-petclinic-reactive#prerequisites)*

![banner](doc/img/banner.png?raw=true)

This sample is a fully reactive version of the Spring PetClinic application using Spring WebFlux.
<!--- ENDEXCLUDE --->

## 📋 Table of content

<img src="https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/doc/img/ui-top.png?raw=true" align="right" width="400px"/>


1. [Objectives](#1-objectives)
2. [Frequently asked questions](#2-frequently-asked-questions)
3. [Materials for the Session](#3-materials-for-the-session)
4. [Create your Database](#4-create-astra-db-instance)
5. [Create your Schema](#5-create-your-schema-with-cql-console)
6. [Create your Token](#6-create-your-token)
7. [Start Gitpod and Setup your application](#7-start-gitpod)
8. [Setup and work with Drivers](#1-objectives)
9. [Working with Spring](#1-objectives)
10. [Working with user interface](#1-objectives)
11. [Homeworks](#1-objectives)


## 1. Objectives

* *Learn how Apache Cassandra **data modelling** is different from relational*
* *Understand how **Java Applications** connect to Apache Cassandra™*
* *Learn about **Spring and Spring Boot** Microservices*
* *Understand what are the benefit a **Reactive Programming*** 
* ***Get a working full stack application Spring Boot-Data-Reactive***

[🏠 Back to Table of Contents](#clipboard-table-of-content)

## 2. Frequently asked questions
<p/>
<details>
<summary><b> 1️⃣ Can I run the workshop on my computer?</b></summary>
<hr>
<p>There is nothing preventing you from running the workshop on your own machine, If you do so, you will need the following
<ol>
<li><b>git</b> installed on your local system
<li><b>JDK 8+</b> installed on your local system
<li><b>Maven 3.6+</b> installed on your local system
<li><a href="https://www.whitesourcesoftware.com/free-developer-tools/blog/update-node-js/" >Node 15 and npm 7 or later</a>
</ol>
</p>
In this readme, we try to provide instructions for local development as well - but keep in mind that the main focus is development on Gitpod, hence **We can't guarantee live support** about local development in order to keep on track with the schedule. However, we will do our best to give you the info you need to succeed.
</details>
<p/>
<details>
<summary><b> 2️⃣ What other prerequisites are there?</b></summary>
<hr>
<ul>
<li>You will need a GitHub account
<li>You will also need an Astra account: don't worry, we'll work through that in the following
</ul>
</p>
</details>
<p/>
<details>
<summary><b> 3️⃣ Do I need to pay for anything for this workshop?</b></summary>
<hr>
<b>No.</b> All tools and services we provide here are FREE.
</details>
<p/>
<details>
<summary><b> 4️⃣ Will I get a certificate if I attend this workshop?</b></summary>
<hr>
Attending the session is not enough. You need to complete the homeworks detailed below and you will get a nice badge.
</details>
<p/>

[🏠 Back to Table of Contents](#clipboard-table-of-content)

## 3. Materials for the Session

It doesn't matter if you join our workshop live or you prefer to work at your own pace,
we have you covered. In this repository, you'll find everything you need for this workshop:

- [Slide deck](doc/slides.pdf)
- [Datastax Developers Discord chat](https://bit.ly/cassandra-workshop)
- [Questions and Answers](https://community.datastax.com/)

[🏠 Back to Table of Contents](#clipboard-table-of-content)

## 4. Create Astra DB Instance

**`ASTRA DB`** is the simplest way to run Cassandra with zero operations at all - just push the button and get your cluster. No credit card required, $25.00 USD credit every month, roughly 5M writes, 30M reads, 40GB storage monthly - sufficient to run small production workloads.

#### ✅ 4a. Register 

If you do have an account yet register and sign In to Astra DB this is FREE and NO CREDIT CARD asked** [https://astra.datastax.com](https://astra.dev/11-22): You can use your `Github`, `Google` accounts or register with an `email`.

_Make sure to chose a password with minimum 8 characters, containing upper and lowercase letters, at least one number and special character_

#### ✅ 4b. Create a "FREE" plan

Follow this [guide](https://docs.datastax.com/en/astra/docs/creating-your-astra-database.html), to set up a pay as you go database with a free $25 monthly credit. You will find below recommended values to enter:

- **For the database name** - `workshops`

- **For the keyspace name** - `spring_petclinic`

_You can technically use whatever you want and update the code to reflect the keyspace. This is really to get you on a happy path for the first run._

- **For provider and region**: Choose a provider (GCP, Azure or AWS) and then the related region is where your database will reside physically (choose one close to you or your users).

- **Create the database**. Review all the fields to make sure they are as shown, and click the `Create Database` button.

You will see your new database `pending` in the Dashboard.

![my-pic](doc/img//db-pending.png?raw=true)

The status will change to `Active` when the database is ready, this will only take 2-3 minutes. You will also receive an email when it is ready.

**👁️ Walkthrough**

*The Walkthrough mentionned the wrong keyspace, make sure to use `spring_petclinic`*

![image](doc/img/astra-create-db.gif?raw=true)

[🏠 Back to Table of Contents](#clipboard-table-of-content)

## 5. Create your schema with CQL Console

#### ✅ 5a. Select keyspace in CQL Console

As seen in the slides on the contrary of relational you start with the request and data model BEFORE CODING.

![image](doc/img/db-cqlconsole-1.png?raw=true)

 Let's create the tables. In the console use the command:

```sql
use spring_petclinic;
```

![image](doc/img/db-cqlconsole-2.png?raw=true)

#### ✅ 5b. Create tables

This is the data model we are looking for with 6 tables.

![Pet Clinic Welcome Screen](doc/img/data-model.png?raw=true)

Execute the following in the cql console

```sql
DROP INDEX IF EXISTS petclinic_idx_vetname;
DROP INDEX IF EXISTS petclinic_idx_ownername;
DROP TABLE IF EXISTS petclinic_vet;
DROP TABLE IF EXISTS petclinic_vet_by_specialty;
DROP TABLE IF EXISTS petclinic_reference_lists;
DROP TABLE IF EXISTS petclinic_owner;
DROP TABLE IF EXISTS petclinic_pet_by_owner;
DROP TABLE IF EXISTS petclinic_visit_by_pet;

CREATE TABLE IF NOT EXISTS petclinic_vet (
  id          uuid,
  first_name  text,
  last_name   text,
  specialties set<text>,
  PRIMARY KEY ((id))
);


CREATE TABLE IF NOT EXISTS petclinic_vet_by_specialty (
 specialty   text,
 vet_id      uuid,
 first_name  text,
 last_name   text,
 PRIMARY KEY ((specialty), vet_id)
);


CREATE TABLE IF NOT EXISTS petclinic_owner (
  id         uuid,
  first_name text,
  last_name  text,
  address    text,
  city       text,
  telephone  text,
  PRIMARY KEY ((id))
);

CREATE TABLE IF NOT EXISTS petclinic_pet_by_owner (
  owner_id   uuid,
  pet_id     uuid,
  pet_type   text,
  name       text,
  birth_date date,
  PRIMARY KEY ((owner_id), pet_id)
);

CREATE TABLE IF NOT EXISTS petclinic_visit_by_pet (
   pet_id      uuid,
   visit_id    uuid,
   visit_date  date,
   description text,
   PRIMARY KEY ((pet_id), visit_id)
);

CREATE TABLE IF NOT EXISTS petclinic_reference_lists (
  list_name text,
  values set<text>,
  PRIMARY KEY ((list_name))
);

/** We could search veterinarians by their names. */
CREATE INDEX IF NOT EXISTS petclinic_idx_ownername ON petclinic_owner(last_name);
/** We could search vet by their names. */
CREATE INDEX IF NOT EXISTS petclinic_idx_vetname ON petclinic_vet(last_name);
```

#### ✅ 5c. Check our 6 tables

```sql
describe tables;
```

#### ✅ 5d. Insert Reference Data

```sql
INSERT INTO petclinic_reference_lists(list_name, values) 
VALUES ('pet_type ', {'bird', 'cat', 'dog', 'lizard','hamster','snake'});

INSERT INTO petclinic_reference_lists(list_name, values) 
VALUES ('vet_specialty', {'radiology', 'dentistry', 'surgery'});
```

[🏠 Back to Table of Contents](#clipboard-table-of-content)

## 6. Create Astra Token

To connect to the database from Java code we need some credentials, this is what we are doing here.

#### ✅ 6a. Generate Token

Following the [Manage Application Tokens docs](https://docs.datastax.com/en/astra/docs/manage-application-tokens.html) create a token with `Database Admnistrator` roles.

- Go the `Organization Settings`

- Go to `Token Management`

- Pick the role `Database Admnistrator` on the select box

- Click Generate token

**👁️ Walkthrough**

![image](doc/img/astra-create-token.gif?raw=true)

This is what the token page looks like. You can now download the values as a CSV. We will need those values but you can also keep this window open for use later.

![image](doc/img/astra-token.png?raw=true)

Notice the clipboard icon at the end of each value.

- `clientId:` We will use it as a _username_ to contact Cassandra

- `clientSecret:` We will use it as a _password_ to contact Cassandra

- `appToken:` We will use it as a api token Key to interact with APIs.

#### ✅ 6b. Copy your token in your clipboard

To know more about roles of each token you can have a look to [this video.](https://www.youtube.com/watch?v=nRqu44W-bMU)

**Note: Make sure you don't close the window accidentally or otherwise - if you close this window before you copy the values, the application token is lost forever. They won't be available later for security reasons.**

We are now set with the database and credentials. Let's start coding with Spring !

[🏠 Back to Table of Contents](#clipboard-table-of-content)

### 7. Start Gitpod and Setup your application

#### ✅ 7a. Open Gitpod

Click the button below it should route you to your workspace:
[https://gitpod.io/#https://github.com/datastaxdevs/workshop-spring-reactive](https://gitpod.io/#https://github.com/datastaxdevs/workshop-spring-reactive).

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-spring-reactive)

When you first launch gitpod, it builds the image.
![image](doc/img/building-workspace.png?raw=true)

Git pod pulls the image.
![image](doc/img/pulling-image.png?raw=true)


#### 📘 Home Screen

This is the home Screen. It is a VSCode instance in the cloud. As you can seeNotice multiple panels are opens with 2 terminals, the readme and the explorer. 
![image](doc/img/start-ui.png?raw=true)

#### 📘 How to open a new terminal

You can open a new terminal from the menu in the ellipsis in the top left hand corner. Then use the Switch termina panel to move from another.
![image](doc/img/gitpod-new-terminal.png?raw=true)


#### ✅ 7b. Know your gitpod


- **📘 All tools are installed**

Gitpod provide everything you need to work with JAVA, NODEJS (but also python, docker and many more). Open a new **TERMINAL** and enter the following command.

```bash
java --version
```

> 🖥️ Expected output
```
Picked up JAVA_TOOL_OPTIONS: -Xmx2576m
openjdk 11.0.11 2021-04-20 LTS
OpenJDK Runtime Environment Zulu11.48+21-CA (build 11.0.11+9-LTS)
OpenJDK 64-Bit Server VM Zulu11.48+21-CA (build 11.0.11+9-LTS, mixed mode)
```

```bash
mvn -v
```

> 🖥️ Expected output
```
Picked up JAVA_TOOL_OPTIONS: -Xmx2576m
Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /home/gitpod/.sdkman/candidates/maven/current
Java version: 11.0.11, vendor: Azul Systems, Inc., runtime: /home/gitpod/.sdkman/candidates/java/11.0.11.fx-zulu
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-1051-gke", arch: "amd64", family: "unix"
```

```bash
node -v
```

> 🖥️ Expected output
```
v14.17.0
```

- **📘 Remote explorer**

In the tutorial we will also work with the preview and the remote explorer. To switch from source explorer to remove explorer local the dekstop icon on the menu bar in the left (6th item).

![image](doc/img/gitpod-remote-explorer.png?raw=true)

- **📘 Simple Browser preview**

As of now **nothing IS running** but if you want to open a preview or a new browser use the icons as show below.

![image](doc/img/gitpod-preview.png?raw=true)


#### ✅ 7c. Setup your application

Locate the File `application.yaml` in the folder `src/main/resources`, there your 3 properties to update marked with `CHANGE_ME`.

```yaml
server:
  port: 9966

logging:
  pattern:
    console: "%d{HH:mm:ss.SSS} %magenta(%-5level) %cyan(%-45logger) : %msg%n"
  level:
    root: WARN
    com.datastax.workshop: INFO
    com.datastax.astra: INFO
    com.datastax.stargate: INFO
    com.datastax.oss.driver: ERROR
    com.sprinframework.test: ERROR
    ch.qos.logback.classic: ERROR
    
# Setup your application
astra:
  application-token: <CHANGE_ME>
  database-id: <CHANGE_ME>
  database-region: <CHANGE_ME>
  keyspace: spring_petclinic
  metrics:
    enabled: false
```

- *The DatabaseID is located on the home page*
![Pet Clinic Welcome Screen](doc/img/astra-config-1.png?raw=true)

- *The Database region (adn keyspace) are located in the details page*
![Pet Clinic Welcome Screen](doc/img/astra-config-2.png?raw=true)

- *Make sure the Token local like `AstraCS:xxxxxxxxxxx:yyyyyyyyyyy*

#### ✅ 7d. Validate your setup

Have a look to the code of [`Test01_Connectivity`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/test/java/com/datastax/workshop/petclinic/Test01_Connectivity.java) here we use the `CqlSession` and `AstraClient` to show some infromations regarding your Astra DB. Execute the test with:

```bash
mvn test -Dtest=com.datastax.workshop.petclinic.Test01_Connectivity
```

> 🖥️ Expected output
```bash
== CQL_SESSION ==
+ Your Keyspace: spring_petclinic
+ Vet Specialty: 
[dentistry, radiology, surgery]
== ASTRA ==
+ Your OrganizationID: f9460f14-9879-4ebe-83f2-48d3f3dce13c
+ Your Databases: 
workshops : id=3ed83de7-d97f-4fb6-bf9f-82e9f7eafa23, region=eu-west-1
```

## 8. Working with DAO

#### ✅ 8a. The CqlSession

The integration to Cassandra is always implemented through the `CqlSession`. A first way to implement a DAO is to just use this object explicitely. Check the code of [`Test02_DaoWithCqlSession`]https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/test/java/com/datastax/workshop/petclinic/Test02_WorkingWithDao.java) and run the following test:

```bash
mvn test -Dtest=com.datastax.workshop.petclinic.Test02_DaoWithCqlSession
```

Notice how you need to put a terminal call `block()` or use the `StepVerifier` included in Spring Reactive.

```java
@Test
public void should_list_vet_specialies() {
 System.out.println(referenceListDao
   .findReferenceList("vet_specialty").block());
        
 StepVerifier
  .create(referenceListDao.findReferenceList("vet_specialty"))
  .expectNext(Set.of("dentistry", "radiology", "surgery"))
  .expectComplete()
  .verify();
}
```

#### ✅ 8b. The Driver Object Mapping Layer

We will illustrate this with the `Vet` in this [package](https://github.com/datastaxdevs/workshop-spring-reactive/tree/master/src/main/java/com/datastax/workshop/petclinic/vet/db)

1.  Define an `@Entity` where object attributes matches the table columns [`VetEntity`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/main/java/com/datastax/workshop/petclinic/vet/db/VetEntity.java)

2. Define an `@Dao` interface with only the method you want to implements [`VetReactiveDao`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/main/java/com/datastax/workshop/petclinic/vet/db/VetReactiveDao.java)

```java
@Dao
public interface VetReactiveDao {

 @Select
 MappedReactiveResultSet<VetEntity> findById(@NotNull UUID vetId);

 // More methods....
}
```

3. Define the `@Mapper` to explain how to create the `Dao` from the the Cqlsession. [`VetReactiveDaoMapper`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/main/java/com/datastax/workshop/petclinic/vet/db/VetReactiveDaoMapper.java)

```java
@Mapper
public interface VetReactiveDaoMapper {
  @DaoFactory
  VetReactiveDao vetDao(@DaoKeyspace CqlIdentifier keyspace);
}
```

Now execute the test to work with the DAO `Test03_DaoWithDriverObjectMapping`

```bash
mvn test -Dtest=com.datastax.workshop.petclinic.Test03_DaoWithDriverObjectMapping
```

## 9. Working with Spring Data

[Spring Data](https://spring.io/projects/spring-data) provides a common astraction on top of multiple databases leveraging JPA. The quantity of code is greatly reduce by working with interfaces `CrudRepository` and entities.

- Define an entity [`VetEntitySpring`]() where object attributes matches the table columns. You can notice that the set of annotations is not the same as with java driver mapper.






## 10. Working with Apis

## 11. Working with user interface


```
 cd /workspace/workshop-spring-reactive/spring-petclinic-angular
 npm run start
```


![Pet Clinic Welcome Screen](doc/img/swagger.png?raw=true)



## Homework

<img src="images/streaming-workshop.png?raw=true" width="200" align="right" />

Don't forget to complete your assignment and get your verified skill badge! Finish and submit your homework!

1. Complete the practice steps as described below until you have your own app running in Gitpod.
2. Now roll up your sleeves and modify the code in two ways: (1) we want the API to send a greeting to each new player in the chat box, and (2) we want the player names in the game area to match the icon color. _Please read the detailed guidance found [below](#6-homework-instructions)_.
3. Take a SCREENSHOT of the running app modified this way. _Note: you will have to restart the API and reload the client to see all changes!_
4. Submit your homework [here](https://dtsx.io/streaming-game-homework).

That's it, you are done! Expect an email in a few days!

