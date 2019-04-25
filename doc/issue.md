# 问题

## 配置 Ueditor 上传文件

使用 Ueditor 上传的图片提示 后台配置错误

解决：使用官方提供的json配置文件，从classpath下面读取

上传图片成功，显示不出来

解决：上传路径 “/”替换

## 插入数据报错

数据太多，超出字段限制

解决：将字段类型修改成text

## 标签下面博客数量出现负数

解决：减少数量的时候加判断，最低为0

## 上传文件找不到路径

springboot 内置tomcat，request得到请求路径不对

解决：使用spring提供的工具类得到实际路径

# 技术

springBoot

https://spring.io/projects/spring-boot/

mybatis

http://www.mybatis.org/mybatis-3/zh/index.html

mapper

https://github.com/abel533/Mapper

pageHelper

https://github.com/pagehelper/Mybatis-PageHelper

freemarker

https://freemarker.apache.org/

bootstrap

http://www.bootcss.com

Ueditor 

https://ueditor.baidu.com/website/

Semantic-UI

https://semantic-ui.com/

