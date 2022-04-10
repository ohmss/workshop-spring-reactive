<!--- STARTEXCLUDE --->

# Workshop 🐈 Spring PetClinic Reactive 🐕

<img src="doc/img/badge-petclinic.png?raw=true" width="200" align="right" />

[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-streaming-game)
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)

> ⚠️ Difficulty: **`Intermediate`, we expect you to already know Java and Spring.**

![banner](doc/img/banner.png?raw=true)

This sample is a fully reactive version of the [Spring PetClinic](https://projects.spring.io/spring-petclinic/) application using [Spring WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)

<!--- ENDEXCLUDE --->

## 📋 Table of contents

<img src="https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/doc/img/ui-veterinarians.png?raw=true" align="right" width="400px"/>

1. [Objectives](#1-objectives)
2. [Frequently asked questions](#2-frequently-asked-questions)
3. [Materials for the Session](#3-materials-for-the-session)
4. [Create your Database](#4-create-astra-db-instance)
5. [Create your Token](#5-create-astra-token)
6. [Start and setup Gitpod](#6-start-and-setup-gitpod)
7. [Create your Schema](#7-create-your-schema-with-cql-console)
8. [Working with Cassandra Drivers](#8-working-with-cassandra-drivers)
9. [Working with Spring Data](#9-working-with-spring-data)
10. [Working with Spring WebFlux](#10-working-with-spring-webflux)
11. [Working with Angular UI](#11-angular-user-interface)
12. [Homeworks](#12-homeworks)

## 1. Objectives

✅ Learn how Apache Cassandra **data modelling** is different from relational

✅ Understand how **Java Applications** connect to Apache Cassandra™

✅ Learn about **Spring and Spring Boot** Microservices

✅ Understand what are the benefits of **Reactive Programming**

✅ **Get a working full stack application Spring Boot-Data-Reactive including a Node.js application for populating data**

## 2. Frequently asked questions

<p/>
<details>
<summary><b> 1️⃣ Can I run this workshop on my computer?</b></summary>
<hr>
<p>There is nothing preventing you from running the workshop on your own machine, If you do so, you will need the following
<ol>
<li><b>git</b> installed on your local system
<li><b>JDK 8+</b> installed on your local system
<li><b>Maven 3.6+</b> installed on your local system
<li><a href="https://www.whitesourcesoftware.com/free-developer-tools/blog/update-node-js/" >Node 15 and npm 7 or later</a>
</ol>
</p>
In this readme, we try to provide instructions for local development as well - but keep in mind that the main focus is development on Gitpod, hence <strong>We can't guarantee live support</strong> about local development in order to keep on track with the schedule. However, we will do our best to give you the info you need to succeed.
</details>
<p/>
<details>
<summary><b> 2️⃣ What other prerequisites are required?</b></summary>
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

## 3. Materials for the Session

It doesn't matter if you join our workshop live or you prefer to work at your own pace,
we have you covered. In this repository, you'll find everything you need for this workshop:

- [Slide deck](doc/slides/slides.pdf)
- [Datastax Developers Discord chat](https://bit.ly/cassandra-workshop)
- [Questions and Answers](https://community.datastax.com/)

## 4. Create Astra DB Instance

#### ✅ 4a.Register or Sign to Astra

> 📖 DOCUMENTATION: [How to create an Astra Account](https://awesome-astra.github.io/docs/pages/astra/create-account/)

[![](https://dabuttonfactory.com/button.png?t=+Connect+to+Astra&f=Open+Sans-Bold&ts=12&tc=fff&hp=23&vp=16&c=11&bgt=gradient&bgc=0b5394&ebgc=073763)](https://astra.dev/4-6)

#### ✅ 4c.Create a Database (or resume your database)

> 📖 DOCUMENTATION: [How create a Database](https://awesome-astra.github.io/docs/pages/astra/create-instance/)

Use the following values:

| Parameter     | Value                           |
| ------------- | ------------------------------- |
| Database name | `workshops`                     |
| Keyspace name | `spring_petclinic`              |
| Region name   | The one you like, no difference |

**Walkthrough:** _The Walkthrough mentions the wrong keyspace, make sure to use `spring_petclinic`_

![image](doc/img/astra-create-db.gif?raw=true)

## 5. Create Astra Token

To connect to the database from Java code we need some credentials, this is what we are going to do here.

> 📖 DOCUMENTATION: [How to create an Astra Token](https://awesome-astra.github.io/docs/pages/astra/create-token/#c-procedure)

| Parameter | Value                    |
| --------- | ------------------------ |
| Role      | `Database Administrator` |

**👁️ Walkthrough**

![image](doc/img/astra-create-token.gif?raw=true)

> ⚠️ We will use the third argument called `TOKEN` that looks like `AstraCS:...` make sure you copy it in the clipboard.

### 6. Start and Setup Gitpod

#### ✅ 6a. Open Gitpod

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/ohmss/workshop-spring-reactive)

When you first launch gitpod, it builds the image.
![image](doc/img/building-workspace.png?raw=true)

This is the home Screen. It is a VSCode instance in the cloud. As you can see, notice multiple panels are open with 2 terminals, the readme and the explorer.

#### ✅ 6b. Setup Cqlsh

#### ⚠️ COPY-PASTE IN GITPOD

> _Some browsers might block the CTRL+C and CRTL+V if that happen you can paste with right-click and paste._

> _The first time you paste something in Gitpod your might have a pop-up telling you to accept the command_

- There 3 terminal panel on the bottom right hand corner. The last `setup-cqlsh:bash` got the focus.

![cqlsh](doc/img/setup-cqlsh.png?raw=true)

- If you look at the terminal windows it is asking for your Astra TOKEN. Please enter the value of your Token it should look like `AstraCS....` then press enter.

![image](doc/img/gitpod-home.png?raw=true)

- The initialization will go on for you to get access to `CQLSH` directly.

```
------------------------------------------------------------
--            Installation of Cqlsh                      ---
------------------------------------------------------------

[OK] - Tools folder has been created
[OK] - Package has been downloaded
[OK] - We will now as you about your ASTRA TOKEN (AstraCS....)
Checking your credentials...

Login to Astra at https://dstx.io/workshops
After login, you can create a database.
Click on your name in the left-hand column
In the dropdown, select "Organization Settings"
    Select "Token Management" from the left-hand column
    Select "Database Administrator" in the Role dropdown
    Click "Generate Token"
    Save to CSV if you want to access it later
✔ Please paste the Database Admin Token here
***********
Credentials set up, checking database
Looking for workshops
     workshops: Current status is ACTIVE
         ... status is ACTIVE
    existing workshops database found.
Looking for spring_petclinic keyspace
    keyspace spring_petclinic already exists
Setting up secure bundle

Deleted file: cqlshrc
[OK] - Database ID is 3ed83de7-d97f-4fb6-bf9f-82e9f7eafa23
[OK] - Database REGION is eu-west-1
[OK] - Database TOKEN is ************
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
[OK] - Secure Connect Bundle downloaded
[OK] - Launching CQLSH....
Connected to cndb at 127.0.0.1:9042.
[cqlsh 6.8.0 | Cassandra 4.0.0.6816 | CQL spec 3.4.5 | Native protocol v4]
Use HELP for help.
token@cqlsh>
```

#### ✅ 6c. Validate CqlSH

- You can now list the keyspaces (like oracle schemas) available.

```sql
describe keyspaces;
```

Output:

```
system_virtual_schema  system_auth   data_endpoint_auth  system_traces
temporal_visibility    system_views  better_reads        ecommerce
netflix                system        spring_petclinic    todos
system_schema          datastax_sla  native_java         feeds_reader
```

- Select the keyspace we will work with today `spring_petclinic`

```sql
use spring_petclinic;
```

- You can quit wit

```sql
quit
```

- You can now open the console any time with

```
/workspace/workshop-spring-reactive/cqlsh
```

The other Terminal are dedicated for the frontend and the backend.

#### ✅ 6d. Know your gitpod

- **📘 All tools are installed**

Gitpod provides everything you need to work with JAVA, Node.JS (but also python, docker and many more). Open a new **TERMINAL** and enter the following command.

- Check Java Version

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

- Check Maven version

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

- Check Node version

```bash
node -v
```

> 🖥️ Expected output

```
v14.17.0
```

- Check NPM version

```bash
npm -v
```

> 🖥️ Expected output

```
6.14.13
```

- **📘 Remote explorer**

In the tutorial we will also work with the preview and the remote explorer. To switch from source explorer to remote explorer click on dekstop icon on the menu bar in the left (6th item from top).

![image](doc/img/gitpod-remote-explorer.png?raw=true)

- **📘 Simple Browser preview**

As of now **nothing IS running** but if you want to open a preview or a new browser use the icons as shown below.

![image](doc/img/gitpod-preview.png?raw=true)

#### ✅ 6e. Validate your setup

- All variables you will need are in file called `.env `. We will source this file to define the env variables when needed.

```bash
cat /workspace/workshop-spring-reactive/.env
```

- Take a look at the code of [`Test01_Connectivity`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/test/java/com/datastax/workshop/petclinic/Test01_Connectivity.java) here we use the `CqlSession` and `AstraClient` to show some infromation regarding your Astra DB.

```
gp open gp open /workspace/workshop-spring-reactive/src/test/java/com/datastax/workshop/petclinic/Test01_Connectivity.java
```

Execute the test with:

```bash
cd /workspace/workshop-spring-reactive
set -a
source /workspace/workshop-spring-reactive/.env
set +a
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

You are all set.

## 7. Create your schema with CQL Console

#### ✅ 7a. Open cqlSH Console

```
set -a
source /workspace/workshop-spring-reactive/.env
set +a
/workspace/workshop-spring-reactive/cqlsh
```

#### ✅ 7b. Use the proper keyspace

```sql
use spring_petclinic;
```

#### ✅ 7c. Create your objects

```sql
use spring_petclinic;

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

#### ✅ 7d. Check our 6 tables

```sql
describe tables;
```

#### ✅ 7e. Insert Reference Data

```sql
INSERT INTO petclinic_reference_lists(list_name, values)
VALUES ('pet_type ', {'bird', 'cat', 'dog', 'lizard','hamster','snake'});

INSERT INTO petclinic_reference_lists(list_name, values)
VALUES ('vet_specialty', {'radiology', 'dentistry', 'surgery'});
```

## 8. Working with Cassandra Drivers

#### ✅ 8a. The CqlSession

- Exist the CqlSH or open a new terminal to take a look on configuration file `application.yml`.

```bash
gp open /workspace/workshop-spring-reactive/src/main/resources/application.yml
```

- The spring Configuration will use load keys coming from `astra.*` and initialize the object `CqlSession`. A first way to implement a DAO is to use this object explicitly. Check the code at [`Test02_DaoWithCqlSession`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/test/java/com/datastax/workshop/petclinic/Test02_DaoWithCqlSession.java)

- Take a look at the `DAO` with `CqlSession`

```bash
 gp open /workspace/workshop-spring-reactive/src/main/java/com/datastax/workshop/petclinic/reflist/ReferenceListReactiveDao.java
```

- Test source code (invoking the dao)

```bash
gp open gp open /workspace/workshop-spring-reactive/src/test/java/com/datastax/workshop/petclinic/Test02_DaoWithCqlSession.java
```

- Execute the test with the following:

```bash
set -a
source /workspace/workshop-spring-reactive/.env
set +a
mvn test -Dtest=com.datastax.workshop.petclinic.Test02_DaoWithCqlSession
```

1. Notice how you needed to put a terminal call `block()` on line 21 or the program is not started.

Project [Reactor](https://projectreactor.io/) is a fourth-generation reactive library, based on the Reactive Streams specification, for building non-blocking applications on the JVM. We are using the library reactor-test introducing `StepVerifier` to ease the coding of unit tests:

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

> 🖥️ Expected output

```
15:34:33.926 INFO  com.datastax.workshop.petclinic.Test02_DaoWithCqlSession : Started Test02_DaoWithCqlSession in 14.782 seconds (JVM running for 16.99)
[dentistry, radiology, surgery]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.42 s - in com.datastax.workshop.petclinic.Test02_DaoWithCqlSession
```

#### ✅ 8b. The Driver Object Mapping Layer

We will illustrate this with the `Vet` in this [package](https://github.com/datastaxdevs/workshop-spring-reactive/tree/master/src/main/java/com/datastax/workshop/petclinic/vet/db)

1.  Define an `@Entity` where object attributes matches the table columns [`VetEntity`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/main/java/com/datastax/workshop/petclinic/vet/db/VetEntity.java)

2.  Define an `@Dao` interface with only the method you want to implements [`VetReactiveDao`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/main/java/com/datastax/workshop/petclinic/vet/db/VetReactiveDao.java)

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
set -a
source /workspace/workshop-spring-reactive/.env
set +a
mvn test -Dtest=com.datastax.workshop.petclinic.Test03_DaoWithDriverObjectMapping
```

## 9. Working with Spring Data

[Spring Data](https://spring.io/projects/spring-data) provides a common abstraction on top of multiple databases leveraging JPA. The quantity of code is greatly reduced by working with interfaces `CrudRepository` and entities.

- Define an entity [`VetEntitySpring`]() where object attributes matches the table columns. You can notice that the set of annotations is not the same as with java driver mapper.

- Define an interface extending the `ReactiveCassandraRepository` named `VetRepositorySpring`

```java
@Repository
public interface VetRepositorySpring
   extends ReactiveCassandraRepository<VetEntitySpring, UUID> {
}
```

#### ✅ 9a. Execute the unit test

Execute the test to work with the DAO `Test04_DaoWithSpringData`

```bash
set -a
source /workspace/workshop-spring-reactive/.env
set +a
mvn test -Dtest=com.datastax.workshop.petclinic.Test04_DaoWithSpringData
```

Execute the test to work with the DAO `Test05_DaoWithSpringDataSimple`

```bash
set -a
source /workspace/workshop-spring-reactive/.env
set +a
mvn test -Dtest=com.datastax.workshop.petclinic.Test05_DaoWithSpringDataSimple
```


## 10. Working with Spring WebFlux

> [Reference Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)

_The original web framework included in the Spring Framework, Spring Web MVC, was purpose-built for the Servlet API and Servlet containers. The reactive-stack web framework, Spring WebFlux, was added later in version 5.0. It is fully non-blocking, supports Reactive Streams back pressure, and runs on such servers as Netty, Undertow, and Servlet 3.1+ containers._

_Both web frameworks mirror the names of their source modules (spring-webmvc and spring-webflux) and co-exist side by side in the Spring Framework. Each module is optional. Applications can use one or the other module or, in some cases, both — for example, Spring MVC controllers with the reactive WebClient._

The different DAO we created is injected into a Rest controller. (same as Spring WEB)

```java
@RestController
@RequestMapping("/petclinic/api/specialties")
public class VetSpecialtyController {

 @Autowired
 ReferenceListReactiveDao dao;

 @GetMapping(produces = APPLICATION_JSON_VALUE)
 public Mono<ResponseEntity<Set<VetSpecialty>>> getAllVetsSpecialties() {
   return refDao.findReferenceList("vet_specialty")
    .map(Set::stream)
    .map(s -> s.map(VetSpecialty::new)
    .collect(Collectors.toSet()))
    .map(ResponseEntity::ok);
 }
}
```

#### ✅ 10a. Execute the unit test

```bash
set -a
source /workspace/workshop-spring-reactive/.env
set +a
mvn test -Dtest=com.datastax.workshop.petclinic.Test06_ApiController
```

#### ✅ 10b. Start the application with Swagger UI

We also used SpringDOC to generate a Swagger UI interface. For more information check the class [`ApiDocumentationConfig`](https://github.com/datastaxdevs/workshop-spring-reactive/blob/master/src/main/java/com/datastax/workshop/petclinic/conf/ApiDocumentationConfig.java)

```java
@RestController
@RequestMapping("/petclinic/api/specialties")
@Api(value="/petclinic/api/specialties", tags = {"Veterinarian Specialties Api"})
public class VetSpecialtyController {
  //...
}
```

You can now go ahead and start the application. The application is listening on port `9966` as defined in `application.yaml` _(Please do not change this, this is what the user interface is looking for)_

Start the application;

```bash
set -a
source /workspace/workshop-spring-reactive/.env
set +a
mvn spring-boot:run
```

Open your browser on port `9966` using the the remote explorer or entering in a new terminal.

```bash
gp preview "$(gp url 9966)"
```

You should find the Nice user interface:

![Pet Clinic Welcome Screen](doc/img/swagger.png?raw=true)

#### ✅ 10c. Use API

Locate the resource `Veterinarian Specialties Api` and method the specialities endpoint below to test the service.

```bash
GET ​/petclinic​/api​/specialties
```

To execute the service expand the method, locate the button `[TRY IT OUT]`

![Pet Clinic Welcome Screen](doc/img/tryit-1.png?raw=true)

Click `[Execute]`, this particular method does not take any argument.

![Pet Clinic Welcome Screen](doc/img/tryit-2.png?raw=true)

You should see a response something like below.

![Pet Clinic Welcome Screen](doc/img/tryit-3.png?raw=true)
[🏠 Back to Table of Contents](#-table-of-content)

## 11. Angular User Interface

> [Reference Documentation](https://spring-petclinic.github.io/spring-petclinic-angular/)

> [Source Code](https://github.com/spring-petclinic/spring-petclinic-angular/tree/4f58177e29476a4866723a7edc6dab614e96eec0)

Keep the application running on the first terminal. We need our backend. Let'us start the user interface.

#### ✅ 11a. Start the front end

On the terminal `spring-petclinic-angular:npm` navigate to the Angular application.

```bash
chunk {main} main.js, main.js.map (main) 331 kB [initial] [rendered]
chunk {polyfills} polyfills.js, polyfills.js.map (polyfills) 293 kB [initial] [rendered]
chunk {polyfills-es5} polyfills-es5.js, polyfills-es5.js.map (polyfills-es5) 463 kB [initial] [rendered]
chunk {runtime} runtime.js, runtime.js.map (runtime) 6.08 kB [entry] [rendered]
chunk {scripts} scripts.js, scripts.js.map (scripts) 411 kB [entry] [rendered]
chunk {styles} styles.js, styles.js.map (styles) 1.16 MB [initial] [rendered]
chunk {vendor} vendor.js, vendor.js.map (vendor) 6.87 MB [initial] [rendered]
** Angular Live Development Server is listening on localhost:4200, open your browser on http://localhost:4200/ **
ℹ ｢wdm｣: Compiled successfully.
```

- Kill the running application (the frontend must start after the backend here)

```
CTRL+C
```

- Start the application again

```
 cd /workspace/workshop-spring-reactive/spring-petclinic-angular
 npm run start
```

#### ✅ 11b. Open the user interface

Open your browser on port `4200` using the the remote explorer or entering in a new terminal.

```bash
gp preview "$(gp url 4200)"
```

![Pet Clinic Welcome Screen](doc/img/ui-top.png?raw=true)

This is it for the Hands-on TODAY. The angular project is a separate project on its own and we simply reuse it as a submodule but did not code anything there.

[🏠 Back to Table of Contents](#-table-of-content)

## 12. Homeworks

<img src="doc/img/badge-petclinic.png?raw=true" width="200" align="right" />

Don't forget to complete your assignment and get your verified skill badge! Finish and submit your homework!

1. Complete the practice steps as described below until you have your own app running in Gitpod.
2. Answer the technical questions in the form (We promise, it is NOT difficult if you follow the workshop).
3. Add a funny PET TYPE in the DATABASE and take a SCREENSHOT of the running app with your data.
4. Submit your homework [here](https://dtsx.io/homework-spring-reactive)

5. _(totally optional)_ Challenge for 🌶️🌶️🌶️ EXTRA SPICE 🌶️🌶️🌶️. Fork the project, change the code for more repositories to use Spring Data (replacing the Java drivers) and do a pull request. 👕 If the submission has a good quality we will ship a SWAG BOX for free.

Congratulations you made it to the END !!
