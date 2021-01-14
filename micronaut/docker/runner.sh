#!/bin/bash

DB_HOST=${DB_HOST:-'localhost'}
DB_NAME=${DB_NAME:-'fosdem'}
DB_USERNAME=${DB_USERNAME:-'fosdem'}
DB_PASSWORD=${DB_PASSWORD:-'fosdem'}

DD_ENABLE=${DD_ENABLE:-'FALSE'}
DD_SERVICE_NAME="fosdem21-demo-micronaut"
DD_AGENT_HOST=${DD_AGENT_HOST:-'172.17.0.1'}
DD_AGENT_PORT=${DD_AGENT_PORT:-'8126'}

cd /fosdem-demo

sed -i "s/__DB_HOST__/${DB_HOST}/" application.properties
sed -i "s/__DB_NAME__/${DB_NAME}/" application.properties
sed -i "s/__DB_USERNAME__/${DB_USERNAME}/" application.properties
sed -i "s/__DB_PASSWORD__/${DB_PASSWORD}/" application.properties

if [ "${DD_ENABLE}" = "FALSE" ]; then
  java -server -XX:+UnlockExperimentalVMOptions -XX:+UseStringDeduplication -jar app.jar
else
  wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
  java -javaagent:dd-java-agent.jar \
       -Ddd.agent.host=$DD_AGENT_HOST \
       -Ddd.agent.port=$DD_AGENT_PORT \
       -Ddd.profiling.enabled=true \
       -Ddd.logs.injection=true \
       -Ddd.trace.sample.rate=1 \
       -Ddd.service=$DD_SERVICE_NAME \
       -Ddd.env=app-linode \
       -XX:+UnlockExperimentalVMOptions \
       -XX:+UseStringDeduplication
       -jar app.jar
fi
