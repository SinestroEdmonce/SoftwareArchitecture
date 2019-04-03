# Assignment 4

### Content

将``Spring Batch``例子中的``xmlWriter``替换为自己实现的一个``writer``（例如写成一个json文件），通过修改``context``定义改造已有系统。

### Usage

- 首先打开terminal，命令行下进入``sprintbatch``文件夹，然后执行``mvn clean``清理原有的生成文件

- 再执行``mvn compile``，进行编译，编译完成后会提示**BUILD SUCCESS**

- 最后一步执行有两种方式，第一种是命令行执行，第二种是首先在``pom.xml``上配置然后再命令行运行，第二种好处是无须命令行输入复杂参数：
    
    - 直接执行命令``mvn exec:java -Dexec:"cn.edu.nju.sa2017.pipefilter.App"``

    - 首先配置``pom.xml``，使用``exec-maven-plugin``插件。然后执行命令``mvn exec:java``。针对``pom.xml``的配置如下：

        ```xml
        <build>
        <finalName>spring-batch</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.0</version>
                <configuration>
                    <source>${jdk.version}</source>
                    <target>${jdk.version}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.6.0</version>
                <configuration>
                    <mainClass>cn.edu.nju.sa2017.pipefilter.App</mainClass>
                </configuration>
            </plugin>
        </plugins>
        </build>
        ```

    最后在执行``cat ./xml/outputs/report.json``即可查看到结果文件。
