FROM java:8

RUN mkdir /keywizard
WORKDIR /keywizard
ADD target/artifacts /keywizard

EXPOSE 9080
EXPOSE 9081

CMD java $JAVA_OPTS -Xmx128m -jar keywizard-1.0-SNAPSHOT.jar server keywizard.yml