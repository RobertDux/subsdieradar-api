# SubsidieRadar Project
This project is part of an assignment for the
course Innovation (INNO 2022/23) at the
Hogeschool Utrecht, University of Applied Sciences.


## Starter project
This starter project contains the following:

* A Maven-based setup with several
  third-party libraries and frameworks (see: `pom.xml`)
* A preconfigured Spring project

## Prerequisites
Although it is recommended to always use the latest stable version
of Java, this project requires a version of Java 17 or higher.
You can customize this in your compilation settings and `pom.xml`.

For [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html),
you can use your IDE, install it [globally](https://maven.apache.org/download.cgi),
or use the supplied `mvnw` or `mvnw.cmd`.

You need to install node.js, vue.js and axios.js for the frontend 

Firstly make sure you have the `package.json` file in your project. If not, run the `npm init` command

For [Node.js](https://nodejs.org/en/download/) install the latest LTS `npm install`




## Booting
First, make sure the database is set up, started and reachable.
do this by runinng `docker-compose up`

Start the application via your IDE by running the `SubsidieRadarApplication`
class. Alternatively, run `mvn spring-boot:start`.

For the frontend run the following commands in terminal

`cd webapp`
`npm run serve`
