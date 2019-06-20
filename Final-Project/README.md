# Final Project

## 项目地址

为避免仓库过于庞杂，最终的大作业存放在``Github``上的另一个仓库中，项目链接如下：

``Microservices-DFS``: [https://github.com/SinestroEdmonce/Microservices-DFS](https://github.com/SinestroEdmonce/Microservices-DFS)

## 项目描述：微服务架构的分布式文件系统设计与实现

**总体要求**：基于微服务架构，设计一个分布式文件系统。

**具体要求**：

1. 基于Spring Boot实现NameNode和DataNode两个服务，在Spring Cloud微服务平台上运行一个NameNode实例和多个DataNode实例（无需考虑NameNode单点失效问题）  

2. NameNode提供REST风格接口与用户交互，实现用户文件上传、下载、删除，DataNode不与用户直接交互（无需考虑NameNode的IO瓶颈问题）  

3. NameNode将用户上传文件文件拆为固定大小的存储块，分散存储在各个DataNode上，每个块保存若干副本。块大小和副本数可通过系统参数配置。

**接口示例**：

- ``GET / `` - 列出文件系统``/``目录内容
- ``GET /user1/a.docx`` - 下载``/user1/a.docx``文件
- ``PUT /user2/b.zip`` - 上传``b.zip``文件到``/user2``目录
- ``DEL /user2/b.zip`` - 删除``/user2``目录下``b.zip``文件

**非功能性要求**：

1. DataNode服务可弹性扩展，每次启动一个DataNode服务NameNode可发现并将其纳入整个系统

2. NameNode负责检查各DataNode健康状态，需模拟某个DataNode下线时NameNode自动在其他DataNode上复制（迁移）该下线服务原本保存的数据块（可选，加5分）

3. NameNode在管理数据块存储和迁移过程中应实现一定策略尽量保持各DataNode的负载均衡（可选，+5分）

4. 提供一个NameNode上的前端页面（可选，+5分）