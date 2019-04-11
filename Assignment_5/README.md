# Assignment 5

### Content

阅读代码``Servlet``, ``Spring MVC``，并为``Spring Batch``应用添加Web界面，通过该界面启动batch任务。

### Usage

- 首先打开terminal，命令行下进入``sprintbatch``文件夹，然后执行``mvn clean``清理原有的生成文件

- **（可选）**再执行``mvn compile``，进行编译，编译完成后会提示**BUILD SUCCESS**

- 最后执行``mvn jetty:run``启动Web服务器

- 在网页地址栏中输入``localhost:8080/batch/csv2json/a``可以执行csv文件转json文件的batch任务；输入``localhost:8080/batch/csv2xml/a``可以执行csv文件转xml文件的batch任务

     > 任务结果存放在``./xml/outputs/``中，可以进入文件夹查看结果