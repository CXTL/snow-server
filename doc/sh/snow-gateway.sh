#!/usr/bin/env bash
app_name='snow-gateway'
docker stop ${app_name}
echo '----stop container----'
docker rm ${app_name}
echo '----rm container----'
docker rmi `docker images | grep none | awk '{print $3}'`
echo '----rm none images----'
docker run -p 18080:18080 --name ${app_name} \
-e TZ="Asia/Shanghai" \
-v /etc/localtime:/etc/localtime \
-d snow/${app_name}:0.0.1-SNAPSHOT
echo '----start container----'