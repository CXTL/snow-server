
> 该项目参考若依微服务搭建的基础认证授权微服务

SpringCloudAlibaba + SpringCloud + Nacos + SpringSecurity + Sentinel + Oauth2.0 + Feign + Gateway + Redis

启动参数
```
-Dnacos.host=172.17.22.14
-Dnacos.port=8848
-Dnacos.namespace=9ad275b1-74f8-4b30-b9f6-92dac3820f78
-Dmysql.host=172.17.22.14
-Dmysql.port=3306
-Dmysql.username=root
-Dmysql.password=Qazwsx!@#123
-Dredis.host=172.17.22.14
-Dredis.password=bigdata@123456
-Dredis.port=6379
-Dspring.profiles.active=dev

```

> 登录
http://localhost:18080/system/user/login
{"username":"admin","password":"123456"}

