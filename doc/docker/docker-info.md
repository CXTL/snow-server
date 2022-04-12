### seata
冒号前为挂载目录
```
docker run -d -e SEATA_CONFIG_NAME=file:/root/seata-config/registry -v /Users/chenxiaotian/Desktop/data/seata/seata-config:/root/seata-config -v /Users/chenxiaotian/Desktop/data/seata/nacos:/root/nacos -v /Users/chenxiaotian/Desktop/data/seata/logs:/root/logs -p 8091:8091 --name seata-server --restart=always seataio/seata-server:1.4.2
```