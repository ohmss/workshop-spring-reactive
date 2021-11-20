<!--- STARTEXCLUDE --->
# Reactive Implementation of 🐈 Spring PetClinic 🐕


[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-streaming-game)
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)


*50 minutes, Intermediate, [Start Building](https://github.com/DataStax-Examples/spring-petclinic-reactive#prerequisites)*

![banner](doc/img/banner.png?raw=true)

This sample is a fully reactive version of the Spring PetClinic application using Spring WebFlux.
<!--- ENDEXCLUDE --->

![image](doc/img/ui-top.png?raw=true)

## :clipboard: Table of content

1. [Objectives](#1-objectives)
2. [Frequently asked questions](#1-objectives)
3. [Materials for the Session](#1-objectives)
4. [Hands-on - Create your Database](#1-objectives)
5. [Hands-on - Work with Drivers](#1-objectives)
6. [Hands-on - Work with Spring](#1-objectives)
7. [Hands-on - User Interface](#1-objectives)
8. [Homeworks](#1-objectives)


## 1. Objectives

* *Learn how Apache Cassandra **data modelling** is different from relational*
* *Understand how **Java Applications** connect to Apache Cassandra™*
* *Learn about **Spring and Spring Boot** Microservices*
* *Understand what are the benefit a **Reactive Programming*** 
* ***Get a working full stack application Spring Boot-Data-Reactive***


## 2. Frequently asked questions
<p/>
<details>
<summary><b>1. Can I run the workshop on my computer?</b></summary>
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
<summary><b>2. What other prerequisites are there?</b></summary>
<ul>
<li>You will need a GitHub account
<li>You will also need an Astra account: don't worry, we'll work through that in the following
</ul>
</p>
</details>
<p/>
<details>
<summary><b>3. Do I need to pay for anything for this workshop?</b></summary>
<b>No.</b> All tools and services we provide here are FREE.
</details>
<p/>
<details>
<summary><b>4. Will I get a certificate if I attend this workshop?</b></summary>
Attending the session is not enough. You need to complete the homeworks detailed below and you will get a nice badge.
</details>
<p/>

## 3. Materials for the Session

It doesn't matter if you join our workshop live or you prefer to work at your own pace,
we have you covered. In this repository, you'll find everything you need for this workshop:

- [Slide deck](slides/DataStaxDevs-workshop-Build_a_Multiplayer_Game_with_Streaming.pdf)
- [Discord chat](https://bit.ly/cassandra-workshop)
- [Questions and Answers](https://community.datastax.com/)


## Run the application

### 1. Start the database

**✅ Create a free-forever Cassandra database with DataStax Astra**: [click here to get started](https://astra.datastax.com/register?utm_source=github&utm_medium=referral&utm_campaign=spring-petclinic-reactive) 🚀


![Astra Registration Screen](doc/img/db-auth.png?raw=true)


**✅ Use the form to create a new database**

On the Astra home page locate the **Add Database** button

![Astra Database Creation Form](doc/img/db-creation-1.png?raw=true)

Select the **free tier** plan, this is a true free tier, free forever and no payment method asked 🎉 🎉

![Astra Database Creation Form](doc/img/db-creation-2.png?raw=true)

Select the proper region and click the `configure` button. The number of regions and cloud providers are limited in the free tier but please notice you can run the DB on any cloud with any VPC Peering.

![Astra Database Creation Form](doc/img/db-creation-3.png?raw=true)

Fill in the `database name`, `keyspace name`, `username` and `password`. *Please remember your password as you will be asked to provide it when the application starts the first time.*

![Astra Database Creation Form](doc/img/db-creation-4.png?raw=true)

**✅ View your Database and connect**

View your database. It may take 2-3 minutes for your database to spin up. You will receive an email at that point.

**👁️ Expected output**

*Initializing*

![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/dashboard-pending-1000.png?raw=true)

Once the database is ready, notice how the status changes from `Pending` to `Active` and Astra enables the **CONNECT** button.

![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/dashboard-withdb-1000.png?raw=true)

### 2. Copy credentials to connect

**✅ Navigate to your credentials**

Locate the combo `Organization: <Your email>` on the top navigation. On the right side of your organization, click the ellipsis (...) then click your `<Your email>`.

![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/organization-combo-1000.png?raw=true)

You should land on the following screen. Scroll down to the bottom of the page to locate the `Service Account` in `Security Settings`

![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/organization-home-1000.png?raw=true)

**✅ Create Service Account**


Create a service account by clicking `Add Service Account` button above the section as shown below
![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/security-settings-annotated.png?raw=true)
When panel open on the right, click `Add` 

![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/security-add-org-annotated.png?raw=true)

**✅ Copy credentials to your clipboard**


Click the ellipsis at end of Service Account row to open menu as select `Copy Credentials`

![my-pic](https://github.com/datastaxdevs/shared-assets/blob/master/astra/organization-copycredentials-1000.png?raw=true)

The credentials you copied to the clipboard look like the following JSON, we will use it in gitpod to enable connectivity.
```json
{
  "clientId":"149de2c7-9b07-41b3-91ad-9453dee4dc54",
  "clientName":"cedrick.lunven@datastax.com",
  "clientSecret":"aaaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa"
}
```

### 3. Start in Gitpod

**✅ Open Gitpod (with creds copied to clipboard)**

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-spring-reactive)

When you first launch gitpod, it builds the image.
![image](doc/img/building-workspace.png?raw=true)

Git pod pulls the image.
![image](doc/img/pulling-image.png?raw=true)

**✅ Paste credentials in Gitpod terminal**

Once Gitpod loads the workspace, you'll be asked to paste your service account credentials in the Gitpod terminal at the bottom of the screen. The [setup.sh](setup.sh) script at the root of the repository is what asks this question.

![image](doc/img/script-copy-creds.png?raw=true)

**✅ Open Swagger UI in browser**

When gitpod finishes building the app, a new tab will open in your browser showing the following.

![image](doc/img/exec-start.png?raw=true)

**🎉 Celebrate!**

You've successfully built the Spring Petclinic Reactive backend application!

![image](doc/img/exec-api-page.png?raw=true)

**✅ Start the Web UI** :

You may have noticed another terminal named `spring-petclinic-angular`. This is where the UI should start.

![image](doc/img/start-ui.png?raw=true)

After answering the question about analytics usage, you should be able to access the UI on a new tab.

![Pet Clinic Welcome Screen](doc/img/ui-top.png?raw=true)

**NOTE** If you want to run everything locally, reference the [LOCAL_README.md](doc/LOCAL_README.md)

## Understand the architecture

### Internal Architecture our of component

Let's have a look inside the main component `spring-petclinic-reactive` to see which libraries and frameworks have been used.

![Pet Clinic Welcome Screen](doc/img/internal-architecture.png?raw=true)

- `Spring-boot`: Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.

- `Spring-Security`: Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications. Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements.

- `Spring-WebFlux`: Spring sub framework allowing to create Reactive Rest Endpoint.

- `Spring-Actuator`: Expose Endpoints to expose metrics to third party system: health, infos, jmx,prometheus,...

- `Spring-Test`: Enabled unit testing and mocking with Spring configuration and beans.

- `Spring-Cloud`: Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns. They will work well in any distributed environment, including the developer’s own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.

- `SpringFox` *(Swagger)*: Annotation based rest documentation generation and test client generation (swagger-ui).

![Pet Clinic Welcome Screen](doc/img/swagger.png?raw=true)


### Logical Architecture

![Pet Clinic Welcome Screen](doc/img/logical-architecture.png?raw=true)

Here, you can find a description of the logical architecture components:

- `spring-parclinic-angular`: This is the existing project that provides a user interface implementation using Angular. It has been used as well for other backend projects like the
**spring-petclinic-rest**

- `prometheus`: Our component exposes some metrics through the actuator endpoint. A registry will push this information into the Prometheus database (docker-based).

![Pet Clinic Welcome Screen](doc/img/prometheus.png?raw=true)

- `Grafana`: Allows to create dashboards based on data stored in prometheus.

![Pet Clinic Welcome Screen](doc/img/grafana.png?raw=true)

- `zipkin`: Our component includes the `spring-cloud-sleuth` dependency allowing Brave to push metrics usage of the API to the distributed tracing component Zipkin. To enable this tracing
set the property `zipkin.enabled` to true in `application.yaml`.
To start zipkin use `docker-compose up -d`

```
  zipkin:
    enabled: true
    baseUrl: http://localhost:9411
    sender:
      type: web
```

![Pet Clinic Welcome Screen](doc/img/zipkin.png?raw=true)

- `Apache Cassandra`: A NoSQL database

- `DataStax Astra` : Apache Cassandra available in the Cloud for free as a managed service (DBaas)


### Data Model diagram

The underlying data model implemented in Apache Cassandra is different from the one you would have defined with a relational database.

![Pet Clinic Welcome Screen](doc/img/data-model.png?raw=true)

To enable scalability, Apache Cassandra does not support joins or integrity constraints. Therefore we used some denormalization.
We also created some `secondary indices` to queries columns that are not the PARTITION KEY. These secondary indices work well in this case because the cardinality is low (e.g, few pets for an owner).

The application generates the objects related to the data model (e.g., tables, indices, udts) at startup.

## Homework

<img src="images/streaming-workshop.png?raw=true" width="200" align="right" />

Don't forget to complete your assignment and get your verified skill badge! Finish and submit your homework!

1. Complete the practice steps as described below until you have your own app running in Gitpod.
2. Now roll up your sleeves and modify the code in two ways: (1) we want the API to send a greeting to each new player in the chat box, and (2) we want the player names in the game area to match the icon color. _Please read the detailed guidance found [below](#6-homework-instructions)_.
3. Take a SCREENSHOT of the running app modified this way. _Note: you will have to restart the API and reload the client to see all changes!_
4. Submit your homework [here](https://dtsx.io/streaming-game-homework).

That's it, you are done! Expect an email in a few days!

