#!/bin/sh

DB_HOST=${DB_HOST:-'localhost'}
DB_NAME=${DB_NAME:-'fosdem'}
DB_USERNAME=${DB_USERNAME:-'fosdem'}
DB_PASSWORD=${DB_PASSWORD:-'fosdem'}

cd /fosdem-demo

sed -i "s/__DB_HOST__/${DB_HOST}/" application.properties
sed -i "s/__DB_NAME__/${DB_NAME}/" application.properties
sed -i "s/__DB_USERNAME__/${DB_USERNAME}/" application.properties
sed -i "s/__DB_PASSWORD__/${DB_PASSWORD}/" application.properties

java -server -XX:+UnlockExperimentalVMOptions -XX:+UseStringDeduplication -jar app.jar