# Assignment 4

### Content

将``Spring Batch``例子中的``xmlWriter``替换为自己实现的一个``writer``（例如写成一个json文件），通过修改``context``定义改造已有系统。

### Usage

- 首先打开terminal，命令行下进入``sprintbatch``文件夹，然后执行``mvn clean``清理原有的生成文件

- 再执行``mvn compile``，进行编译，编译完成后会提示**BUILD SUCCESS**

- 最后执行``mvn exec:java -Dexec:"cn.edu.nju.sa2017.pipefilter.App"``，执行完成后通过``cat xml/outputs/report.json``查看执行结果