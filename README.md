# ps-web

ps-web 是基于Maven+Spring+SpringMVC+Mybatis的轻量级后台管理系统，适用于中小型项目的管理后台，支持按钮级别的权限控制，系统具有最基本的用户管理、角色管理、资源管理、系统日志、代码生成器等通用性功能，企业或个人可直接在此基础上进行开发，扩展，添加各自的需求和业务功能！


## 需求分析

关于权限系统的文章网上多如牛毛，很多都是基于角色的访问控制（RBAC）设计。但是发现完全实现RBAC的理论其实不一定好用,我想做一款适合自己的。所以首先我们必要明确我们要去实现哪些东西。

1、权限资源

a.菜单权限  经理和业务员登陆系统拥有的功能菜单是不一样的

b.按钮权限  经理能够审批，而业务员不可以

c.数据权限  A业务员看不到B业务员的单据

d.字段权限  某些人查询客户信息时看不到客户的手机号或其它字段

2、用户

应用系统的具体操作者，我这里设计用户是不能直接分配权限的，必须要分配一个角色，角色中再分配权限，如果某个用户权限比较特殊，可以为他专门建一个角色来应用解决，因为如果用户也可以分配权限系统就会复杂很多。

3、角色

为了对许多拥有相似权限的用户进行分类管理，定义了角色的概念，以上所有的权限资源都可以分配给角色，角色和用户N:N的关系。

5、菜单

6、按钮


### 后端技术

技术 | 名称 | 版本 | 官网
----|------|----|----
Spring Framework | 容器 | 4.2.5.RELEASE | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)
SpringMVC | MVC框架 | 4.2.5.RELEASE |  [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)
MyBatis | ORM框架 | 3.2.1 |  [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
Maven | 项目构建管理 | 4.0.0 |  [http://maven.apache.org](http://maven.apache.org/)
Logback | 日志组件 | 1.7.7 |  [https://logback.qos.ch](https://logback.qos.ch/)
Druid | 数据库连接池 | 1.0.11 |  [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
Hibernate Validator | 后端校验框架 | 5.2.3.Final | [http://hibernate.org/validator/](http://hibernate.org/validator/)
swagger2 | springfox-swagger2 | 2.6.0 | [https://www.cnblogs.com/exmyth/p/7183753.html](https://www.cnblogs.com/exmyth/p/7183753.html)
JWT | 登录认证 | 2.4.0 | [https://blog.csdn.net/weixin_37162010/article/details/80210993](https://blog.csdn.net/weixin_37162010/article/details/80210993)

### 前端技术

技术 | 名称 | 版本 |  官网
----|------|----|----
vue.js | 渐进式框架 | 2.x |  [https://cn.vuejs.org/v2/guide](https://cn.vuejs.org/v2/guide)
element | 基于 Vue 2.0 的桌面端组件库 | 1.12.1 |  [http://element.eleme.io/#/zh-CN](http://element.eleme.io/#/zh-CN)


## 软件需求

- JDK1.8+
- MySQL5.6+
- Tomcat8.0+
- Maven3.0+


## 许可证

ps-web 使用 MIT 许可证发布，用户可以自由使用、复制、修改、合并、出版发行、散布、再授权及贩售ps-web 及其副本。

[查看许可证](LICENSE "LICENSE")

## 获取源码

 [https://github.com/zhaododo2008/permission](https://github.com/zhaododo2008/permission "github")


