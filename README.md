# 说明

## 0. 配置

### application.yml

```yaml
spring:
  application:
    name: ${artifactId}
```

可用的占位符

```yaml
_rootArtifactId_ ：做文件夹名替换用，例如_rootArtifactId_-dao, 占位符来动态获取父工程的ArtifactId
 ${rootArtifactId} ： 它保存用户输入的值作为项目名（maven在用户运行原型时在提示符中询问为artifactid:的值）
 ${artifactId}  ：如果您的项目由一个模块组成，则此变量的值将与${rootArtifactId}相同，但如果项目包含多个模块，则此变量将由每个模块文件夹中的模块名替
 ${package} ： 用户为项目提供的包，也在用户运行原型时由maven提示
 ${packageInPathFormat} ： 与${package}变量的值相同，但将“.”替换为字符“/”，例如：，对于包com.aurora.demo，此变量为com/aurora/demo
 ${groupId}  ：用户为项目提供的groupid，在用户运行原型时由maven提示
 ${version}  ：版本号
```

## 1. 构建脚手架

```
mvn clean archetype:create-from-project 
```

## 2. 将脚手架复制到本地仓库

cd E:\temp\my-demo\target\generated-sources\archetype

pom坐标修改后直接安装到本地仓库

```yaml
  mvn clean install -DskipTests
```

未修改pom文件，或想自定maven坐标，可以加入以下参数


```yaml
mvn clean install -DskipTests ^
-DgroupId=com.kalpa  ^
-DartifactId=my-demo-archetype  ^
-Dversion=1.0.0 ^
-Dpackaging=jar
```

## 使用
>
> -B 非交互模式运行
> -e 错误详细输出
> -X 调试输出，打印详细的过程日志
> -DarchetypeCatalog 置顶使用本地仓库的archetype目录来查找模板
> -DinteractiveMode=false 关闭交互模式

需要将{mydemo}替换为你的项目名

```
mvn archetype:generate ^
-B -e -X ^
-DgroupId=com.kalpa ^
-DartifactId={mydemo} ^
-Dversion=1.0.0 ^
-Dpackage=com.kalpa.{mydemo} ^
-DarchetypeGroupId=com.kalpa ^
-DarchetypeArtifactId=kalpa-archetype ^
-DarchetypeVersion=1.0-SNAPSHOT ^
-DarchetypeCatalog=local ^
-DinteractiveMode=false
```

### windows使用例子

```
mvn archetype:generate ^
-B -e -X ^
-DgroupId=com.kalpa ^
-DartifactId=video ^
-Dversion=1.0.0 ^
-Dpackage=com.kalpa.video ^
-DarchetypeGroupId=com.kalpa ^
-DarchetypeArtifactId=kalpa-archetype ^
-DarchetypeVersion=1.0-SNAPSHOT ^
-DarchetypeCatalog=local ^
-DinteractiveMode=false
```
