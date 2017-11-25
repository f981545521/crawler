## WebMagic

> **WebMagic** 是一个简单灵活的Java爬虫框架。基于WebMagic，你可以快速开发出一个高效、易维护的爬虫。[官网地址](http://webmagic.io)
### WebMagic的四个组件
- Downloader

Downloader负责从互联网上下载页面，以便后续处理。WebMagic默认使用了Apache HttpClient作为下载工具。

- PageProcessor

PageProcessor负责解析页面，抽取有用信息，以及发现新的链接。WebMagic使用Jsoup作为HTML解析工具，并基于其开发了解析XPath的工具Xsoup。在这四个组件中，PageProcessor对于每个站点每个页面都不一样，是需要使用者定制的部分。

- Scheduler

Scheduler负责管理待抓取的URL，以及一些去重的工作。WebMagic默认提供了JDK的内存队列来管理URL，并用集合来进行去重。也支持使用Redis进行分布式管理。除非项目有一些特殊的分布式需求，否则无需自己定制Scheduler。

- Pipeline

Pipeline负责抽取结果的处理，包括计算、持久化到文件、数据库等。WebMagic默认提供了“输出到控制台”和“保存到文件”两种结果处理方案。Pipeline定义了结果保存的方式，如果你要保存到指定数据库，则需要编写对应的Pipeline。对于一类需求一般只需编写一个Pipeline。

### 用于数据流转的对象
- Request

Request是对URL地址的一层封装，一个Request对应一个URL地址。它是PageProcessor与Downloader交互的载体，也是PageProcessor控制Downloader唯一方式。

- Page

Page代表了从Downloader下载到的一个页面——可能是HTML，也可能是JSON或者其他文本格式的内容。Page是WebMagic抽取过程的核心对象，它提供一些方法可供抽取、结果保存等。

- ReusltItems

ReusltItems相当于一个Map，它保存PageProcessor处理的结果，供Pipeline使用。它的API与Map很类似，值得注意的是它有一个字段skip，若设置为true，则不应被Pipeline处理。

###  控制爬虫运转的引擎—Spider

> `Spider`是WebMagic内部流程的核心。Downloader、PageProcessor、Scheduler、Pipeline都是Spider的一个属性，这些属性是可以自由设置的，通过设置这个属性可以实现不同的功能。Spider也是WebMagic操作的入口，它封装了爬虫的创建、启动、停止、多线程等功能。
> 
> 对于编写一个爬虫，PageProcessor是需要编写的部分，而Spider则是创建和控制爬虫的入口。

### 使用webMagic

- maven中引入依赖jar包
```
	<dependency>
	    <groupId>us.codecraft</groupId>
	    <artifactId>webmagic-core</artifactId>
	    <version>0.5.3</version>
	</dependency>
	<dependency>
	    <groupId>us.codecraft</groupId>
	    <artifactId>webmagic-extension</artifactId>
	    <version>0.5.3</version>
	</dependency>
```

- 详细教程请移步：[官网地址](http://webmagic.io)

---

### 参考案例

1. [Java爬虫案例（webmagic）](http://blog.csdn.net/u012385190/article/details/53393805)
2. [Java爬虫（webmagic）](http://blog.csdn.net/u012385190/article/details/51517466)


