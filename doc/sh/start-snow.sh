#!/bin/bash


cd /data/snow-server

git checkout -b dev origin/dev

git pull
#git pull --force origin dev:dev

mvn clean package docker:build -DskipTests

docker-compose -f /data/snow-server/doc/docker/docker-compose-app.yml up -d