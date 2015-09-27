KeyWizard
=======
A dockerized dropwizard application that generates new bitcoin addresses and associated information. The application leverages docker, dropwizard, bitcoinj, and the freemarker template engine. It can be ran as a standalone jar (or) as a docker image.

Prerequisites:
-------------------------

* JDK 1.8 or higher
* Maven
* Docker (optional)
* For additional dependency information refer to pom.xml

Build Instructions:
-------------------------

Building an executable jar:
> mvn package

The standalone executable jar can be found at: ./target/artifacts/keywizard-1.0-SNAPSHOT.jar

Building a docker image (optional):
> docker build -t keywizard .


Usage:
-------------------------

Running as a DropWizard application:

> java -jar target/artifacts/keywizard-1.0-SNAPSHOT.jar server keywizard.yml

Running as a docker container:


Example Output:
-------------------------

http://localhost:9080/
![View](/screenshots/view.jpeg?raw=true "View")

http://localhost:9080/api
![API](/screenshots/api.jpeg?raw=true "API")

DropWizard Health Check:
-------------------------

Execute health check:
http://localhost:9081/healthcheck?pretty=true

Limitations:
-------------------------

* The example is http only. If you host this service you must provide your own keys to enable https.

License
-------------------------

The MIT License (MIT)

Copyright (c) 2015 com.gmail.lifeofreilly

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

