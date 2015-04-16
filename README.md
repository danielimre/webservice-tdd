webservice-tdd
==============

An example JSON webservice with its Java client built using TDD with functional and unit tests. The steps being taken are in individual commits.

Technologies
------------
* maven
* spring
* jackson
* tomcat7

Build
-----
Uses cargo to deploy the application. Build any stage with jacoco turned off with `-Djacoco.skip=true`

Build project, run unit and functional tests:
```
   mvn verify
```

Start up application:
```
   mvn verify -P runapp
```
Example:
```
   mvn verify -P runapp -Dskip.jacoco=true
```
