## **面向对象编程(Object Oriented Programing)**

![image-20220210105749003](https://www.itbaizhan.com/wiki/imgs/image-20220210105749003.png)

## **神速熟悉面向对象**

![image-20220210105845926](https://www.itbaizhan.com/wiki/imgs/image-20220210105845926.png)

学完本节，如果还有点糊涂，很正常，本节仅是你的“初恋对象”。本节仅仅是为了方便大家入门，更快的了解面向对象。后面，才是真正开始“面向对象”，真正为了“结婚”、为了“开发”的“真对象”。

**表格结构和类结构**

我们在现实生活中，思考问题、发现问题、处理问题，往往都会用“表格”作为工具。实际上，“表格思维”就是一种典型的面向对象思维。

实际上，互联网上所有的数据本质上都是“表格”。我们在这里通过从表格表示数据开始，引入对象和类。大家就会神奇的发现，原来“表格就是对象”。

以公司雇员表为例：

| ID   | 姓名   | 岗位   | 基本工资 | 绩效工资 | 入职日期 |
| ---- | ------ | ------ | -------- | -------- | -------- |
| 1001 | 高小一 | 程序员 | 20000    | 0        | 9月1日   |
| 1002 | 高小二 | 前台   | 5000     | 0        | 9月2日   |
| 1003 | 高小三 | 销售员 | 3000     | 15000    | 9月1日   |
| 1004 | 高小四 | 财务   | 5000     | 0        | 9月3日   |

上面这个雇员表，可以将公司所有员工信息“结构化”、“标准化”，让管理者可以方便的进行统计和管理。



我们也经常将表中的“列”，叫做“字段”，英文中统一叫做“field”。显然，field定义了表的结构。我们可以通过增加新的field(列)，让表中所有的行增加数据：

| ID   | 姓名   | 岗位   | 基本工资 | 绩效工资 | 入职日期 | 工作地点 |
| ---- | ------ | ------ | -------- | -------- | -------- | -------- |
| 1001 | 高小一 | 程序员 | 20000    | 0        | 9月1日   | 北京     |
| 1002 | 高小二 | 前台   | 5000     | 0        | 9月2日   | 北京     |
| 1003 | 高小三 | 销售员 | 3000     | 15000    | 9月1日   | 郑州     |
| 1004 | 高小四 | 财务   | 5000     | 0        | 9月3日   | 上海     |

面向对象编程中，类对应表的结构（表的field），我们可以定义出“雇员类”：

![image-20220210114335720](https://www.itbaizhan.com/wiki/imgs/image-20220210114335720.png)

通过上图，可以看到，雇员类和雇员表的结构完全一样。只不过，雇员类增加了数据的类型而已。

**1.表格的动作和类的方法**

每个公司的雇员都要有相关的动作。比如：所有雇员每天的工作标准动作有：

1. 参加晨会，领取当天任务
2. 午休
3. 提交工作日志



我们可以在雇员表中将动作信息也包含进去：

| ID   | 姓名   | 岗位   | 基本工资 | 绩效工资 | 入职日期 | 工作地点 | 晨会动作说明     |
| ---- | ------ | ------ | -------- | -------- | -------- | -------- | ---------------- |
| 1001 | 高小一 | 程序员 | 20000    | 0        | 9月1日   | 北京     | 1. 8:30打卡      |
| 1002 | 高小二 | 前台   | 5000     | 0        | 9月2日   | 北京     | 2. 开晨会        |
| 1003 | 高小三 | 销售员 | 3000     | 15000    | 9月1日   | 郑州     | 3. 9:00结束      |
| 1004 | 高小四 | 财务   | 5000     | 0        | 9月3日   | 上海     | 4. 喊口号:”加油” |

新增的列“雇员动作说明”，显然是对所有的雇员都有用，每个雇员都有这个动作。 在类中就是定义成方法：

![image-20220210135251474](https://www.itbaizhan.com/wiki/imgs/image-20220210135251474.png)

当然，我们也可以根据需求，为雇员定义多个动作。比如：午休、提交工作日志、领取工资等等。

**3.对象对应“表中的行数据”**

前面两节，我们主要讲解的是“表结构和类的对应关系”。那么，表中的数据和什么对应呢？

表中的一行一行的数据，都在表结构的约束范围内，大家的结构都是相同的。如下表：

| ID   | 姓名   | 岗位   | 基本工资 | 绩效工资 | 入职日期 | 工作地点 | 晨会动作说明                                    |
| ---- | ------ | ------ | -------- | -------- | -------- | -------- | ----------------------------------------------- |
| 1001 | 高小一 | 程序员 | 20000    | 0        | 9月1日   | 北京     | 1. 8:30打卡2. 开晨会3. 9:00结束4. 喊口号:”加油” |
| 1002 | 高小二 | 前台   | 5000     | 0        | 9月2日   | 北京     |                                                 |
| 1003 | 高小三 | 销售员 | 3000     | 15000    | 9月1日   | 郑州     |                                                 |
| 1004 | 高小四 | 财务   | 5000     | 0        | 9月3日   | 上海     |                                                 |

显然，每一行数据都有“姓名”、“基本工资”等“列”，也都有标准的“晨会动作”。在面向对象编程中，下面三句话大家记住：

1. 表结构对应：类结构
2. 一行数据对应：一个对象
3. 表中所有数据对应：这个类的所有对象



因此，上面的四行数据，我们使用四个对象就需要这样表示（假设有对应的构造方法，如下代码是示意，非真实代码）：

> emp1 = new Employee(ID:1001, name:"高小一", job:"程序员", baseSalary:20000, salary2:0, hiredate:"9月1日", address:"北京");
>
> emp2 = new Employee(ID:1002, name:"高小二", job:"前台", baseSalary:5000, salary2:0, hiredate:"9月2日", address:"北京");
>
> emp3 = new Employee(ID:1003, name:"高小三", job:"销售员", baseSalary:3000, salary2:15000, hiredate:"9月1日", address:"郑州");
>
> emp4 = new Employee(ID:1004, name:"高小四", job:"财务", baseSalary:5000, salary2:0, hiredate:"9月2日", address:"上海");

有的人可能注意到了，创建对象的时候没有传入“晨会动作”这个列，是因为“晨会动作”是一个所有数据都有的标准动作，没必要再重复为每个对象创建“标准晨会动作”。



【注意】：

1. 本节课中的代码仅是“示意型”，你可以在文档笔记中写，没有必要再开发环境中写并运行。

 **面向过程和面向对象思想**

![image-20220210135652822](https://www.itbaizhan.com/wiki/imgs/image-20220210135652822.png)

![image-20220210135809455](https://www.itbaizhan.com/wiki/imgs/image-20220210135809455.png)

### **面向过程和面向对象的区别**

面向过程和面向对象都是对软件分析、设计和开发的一种思想,它指导着人们以不同的方式去分析、设计和开发软件。C语言是一种典型的面向过程语言，Java是一种典型的面向对象语言。



**面向过程适合简单、不需要协作的事务，重点关注如何执行。** 面向过程时，我们首先思考“怎么按步骤实现？”并将步骤对应成方法，一步一步，最终完成。 这个适合简单任务，不需要过多协作的情况下。比如，如何开车？我们很容易就列出实现步骤：

![image-20220210135942380](https://www.itbaizhan.com/wiki/imgs/image-20220210135942380.png)

比如：把大象装冰箱分几步？

![image-20220210135958054](https://www.itbaizhan.com/wiki/imgs/image-20220210135958054.png)

但是当我们思考比较复杂的设计任务时，比如“如何造车？”，就会发现列出1234这样的步骤，是不可能的。那是因为，造车太复杂，需要很多协作才能完成。此时面向对象思想就应运而生了。



**面向对象(Oriented-Object)思想**更契合人的思维模式。我们首先思考的是“**怎么设计这个事物？”** 比如思考造车，我们就会先思考“车怎么设计？”，而不是“怎么按步骤造车的问题”。这就是思维方式的转变。



**比如，我们用面向对象思想思考“如何设计车”：**

![image-20220210140217120](https://www.itbaizhan.com/wiki/imgs/image-20220210140217120.png)

**天然的，我们就会从“车由什么组成”开始思考。发现，车由如下对象组成：**

![image-20220210140318789](https://www.itbaizhan.com/wiki/imgs/image-20220210140318789.png)

为了协作，我们找轮胎厂完成制造轮胎的步骤，发动机厂完成制造发动机的步骤；这样，发现大家可以同时进行车的制造，最终进行组装，大大提高了效率。但是，具体到轮胎厂的一个流水线操作，仍然是有步骤的，还是离不开执行者、离不开面向过程思维！



因此，**面向对象可以帮助我们从宏观上把握、从整体上分析整个系统。** 但是，具体到实现部分的微观操作（就是一个个方法），仍然需要面向过程的思路去处理。



我们千万不要把面向过程和面向对象对立起来。他们是相辅相成的。面向对象离不开面向过程！



**·面向对象和面向过程思想的总结**

- 都是解决问题的思维方式，都是代码组织的方式。
- **面向过程是一种“执行者思维”**，解决简单问题可以使用面向过程。
- **面向对象是一种“设计者思维”**，解决复杂、需要协作的问题可以使用面向对象。
- 面向对象离不开面向过程：
  1. 宏观上：通过面向对象进行整体设计
  2. 微观上：执行和处理数据，仍然是面向过程。

### **面向对象是“设计者思维”**

![image-20220210140610529](https://www.itbaizhan.com/wiki/imgs/image-20220210140610529.png)

**面向对象是一种“设计者思维”。**设计时，先从问题中找名词，然后确立这些名词哪些可以作为类，再根据问题需求确定的类的属性和方法，确定类之间的关系。



设计一款企业管理软件，我们需要进行面向对象分析。写一首诗、一篇文章、一篇小说也需要进行面向对象分析。



因此，面向对象这种思维是任何人都需要学习、任何人都需要掌握的。



**·面向对象和面向过程思想的总结**

- 都是解决问题的思维方式，都是代码组织的方式。
- **面向过程是一种“执行者思维”**，解决简单问题可以使用面向过程。
- **面向对象是一种“设计者思维”**，解决复杂、需要协作的问题可以使用面向对象。
- 面向对象离不开面向过程：
  1. 宏观上：通过面向对象进行整体设计
  2. 微观上：执行和处理数据，仍然是面向过程

**实时效果反馈**

**1. 如下关于面向对象和面向过程的说法，错误的是:**

A 面向过程是一种“执行者思维”，解决简单问题可以使用面向过程

B 面向对象是一种“设计者思维”，解决复杂、需要协作的问题可以使用面向对象

C 面向对象离不开面向过程。宏观上，面向对象做整体设计；微观上，面向过程进行执行

D 面向对象和面向过程是对立，二者势不两立！

**答案**

1=>D

**1.面向对象分析：写诗(仅做娱乐，可不学)**

“面向对象思维”不止适合工科、理科，也适合文科。比如：我要写一首诗，就是一种设计的过程，怎么样用简单的、有意境的词汇来描述一个场景。



《登鹳雀楼》是一首名诗，我们使用面向对象的思维方式分析一下。

![image-20220210140734060](https://www.itbaizhan.com/wiki/imgs/image-20220210140734060.png)

我们先从场景中找出名词。里面有：



外在场景：1. 太阳 2. 天空 3. 黄河 4. 河流交汇处 5. 鹳雀楼 6. 草

诗人情怀：1. 登高望远 2. 进取 3. 努力

描述过程：由远及近，再到自身情怀。



我们也可以使用表格来表示上面的信息：

| 物体（Object）   | 类型 | 别称、雅称                                                   |
| ---------------- | ---- | ------------------------------------------------------------ |
| 太阳             | 实物 | 金虎 赤乌 阳乌 金乌 金轮 火轮赤轮 晷景 奔晷 朱曦 曦和 阳景 大明明光 光朱 曙雀 红日 |
| 天空             | 实物 | 皇天，天宇，玉宇，空际，上苍，苍天 旻天，天幕，天穹，苍穹，穹苍，苍旻，苍昊，太清 太虚 |
| 黄河             | 实物 | 大河、母亲河，上河，长河                                     |
| 河流交汇处的沙洲 | 实物 | 沙洲、交汇处                                                 |
| 鹳雀楼           | 实物 | 楼                                                           |
| 草               | 实物 | 芦苇                                                         |
| 登高望远         | 虚物 |                                                              |
| 进取心           | 虚物 |                                                              |
| 努力             | 虚物 | 天天向上                                                     |

分析完上面这些Object后，我们需要进行组合。把这些Object融合到一个场景。王之涣大诗人设计的场景就是：

实：在高楼上看着太阳和黄河，真好看。

虚：寄托一下登高望远、人生积极进取的精神。



好了。程序员“王之涣”开始琢磨他的程序了。

![image-20220210140913997](https://www.itbaizhan.com/wiki/imgs/image-20220210140913997.png)

**0.1版《登鹳雀楼》**

王之涣诗人爬上了登鹳雀楼，心情大好。把看到的场景和旁边的小甜甜说（0.1版诗歌）：

啊，太阳快下山了

啊，黄河往海的方向流。

啊，我还想看的远一点

啊，咱们再向上爬一层楼吧。



**0.2版《登鹳雀楼》**

这么说完，哄小甜甜都有点费劲, 这和我们村的二牛说的差不多啊。需要加工一下，太阳太俗，换成“红日”。“远一点”太没志气“诗人得夸张点，远一点怎么也得千里吧，估计李白那家伙就要写万里了，我就千里吧”。于是，诞生了0.2版诗歌：



红日要下山，

黄河往海（的方向）流。

要想看千里，

向上爬一楼。



**0.3版《登鹳雀楼》**

至少都是5个字了，但是用语太俗，哄小甜甜还是费劲，但比村里面的二牛强一点，不光词汇要雅，句子也要再雅一点（0.3版诗歌）：



红日依山尽，

黄河往海流。

欲看千里远，

向上爬一楼。



**0.4版《登鹳雀楼》**

红日大家都知道，还是俗，我得变变样。咦，红的有点泛白（也可能是看久了，眼睛疲劳），那就白日吧，别人都没用过，“微创新一下”。

欲看千里远，里面的动词换成名词更有场景感，欲目千里远。不错不错，再倒装一下变成“欲远千里目”。

向上爬一楼，这个爬字看着就恶心，而且和“上”是一个意思，去掉它。“向上爬一楼”-->“向上一层楼”。于是（0.4版诗歌出来了）：



白日依山尽，

黄河往海流。

欲远千里目，

向上一层楼。



**1.0版《登鹳雀楼》**

这个0.4版已经哄的小甜甜花枝乱颤了。大诗人觉得这诗有流传的潜力，晚上回去再好好“精加工一下”。于是，字斟句酌，让读起来更加朗朗上口，最终成就了流传千年的诗歌（1.0版诗歌）：

白日依山尽，

黄河入海流。

欲穷千里目，

更上一层楼。



兄弟，会写诗了吗？多用“面向对象的设计思维”模拟“原创者的思考过程”，你离“封神”会越来越近，你的学习也会越来越有意思。

![image-20220210141049812](https://www.itbaizhan.com/wiki/imgs/image-20220210141049812.png)

**2.面向对象分析：写小说**(仅做娱乐，可不学)

写小说本质上和设计软件是一样的，根据想要表达的内容，设计不同的场景、设计不同的任务。



设计完成后，作者再按照一章一章的完成写作（执行阶段）。



所以，只要是“设计工作”都是相通的。程序员副业写写小说也不是不可能，《哈利波特》的作者J.K.罗琳（J.K. Rowling），也是利用业余时间写出了传世之作，并且获得了数亿英镑的收入。2004年，罗琳荣登《[福布斯](https://baike.baidu.com/item/福布斯/301065)》富人排行榜，她的身价达到10亿美元。

![image-20220210141413335](https://www.itbaizhan.com/wiki/imgs/image-20220210141413335.png)

《哈利波特》太长了，关键是我也没看过。 在这里，以短篇小说《茶馆》为例，简单分析“面向对象设计方式写小说”的过程。



1.明确小说主要内容和目标

《茶馆》是现代文学家老舍所著，《茶馆》这本文章主要展现戊戌变法，揭示了近半个世纪中国社会的黑暗，腐败的社会现象。



以大茶馆的兴衰变迁，展示了清末到北洋军阀再到抗战胜利后，北京的各个阶层和社会风貌不同人物的变迁，像是亲身在当时的环境中，感受近50年的北京的变化！

![image-20220210141616061](https://www.itbaizhan.com/wiki/imgs/image-20220210141616061.png)

2.人物设计分析

一个茶馆就是一个小社会，各类人物开始出现，他们不同的命运也被体现，侧面反映出当时黑反腐朽的时代。

![image-20220210141908122](https://www.itbaizhan.com/wiki/imgs/image-20220210141908122.png)

3.整体事件设计

![image-20220210142041424](https://www.itbaizhan.com/wiki/imgs/image-20220210142041424.png)

**3.对象的进化史(数据管理和企业管理共通之处)**

**(仅做娱乐，可不学)**

本节课从另一个角度出发，帮助大家理解对象。从数据管理的角度出发，看待对象是如何诞生的。



事物的发展总是遵循“量变引起质变”的哲学原则；企业管理和数据管理、甚至社会管理也有很多共通的地方。本节课类比企业管理的发展，让大家更容易理解为什么会产生“对象”这个概念。



**·数据无管理时代**

最初的计算机语言只有基本变量(类似我们学习的基本数据类型)，用来保存数据。那时候面对的数据非常简单，只需要几个变量即可搞定；这个时候不涉及“数据管理”的问题。同理，就像在企业最初发展阶段只有几个人，不涉及管理问题，大家闷头做事就OK了。



**·数组管理和企业部门制**

企业发展中，员工多了怎么办？我们很自然的想法就是归类，将类型一致的人放到一起；企业中，会将都做销售工作的放到销售部管理；会将研发软件的放到开发部管理。同理在编程中，变量多了，我们很容易的想法就是“将同类型数据放到一起”， 于是就形成了“数组”的概念，单词对应“array”。 这种“归类”的思想，便于管理数据、管理人。



**·对象和企业项目制**

企业继续发展，面对的场景更加复杂。一个项目可能需要经常协同多个部门才能完成工作；一个项目从谈判接触可能需要销售部介入；谈判完成后，需求调研开始，研发部和销售部一起介入；开发阶段需要开发部和测试部互相配合敏捷开发，同时整个过程财务部也需要跟进。在企业中，为了便于协作和管理，很自然就兴起了“项目制”，以项目组的形式组织，一个项目组可能包含各种类型的人员。 一个完整的项目组，麻雀虽小五脏俱全，就是个创业公司甚至小型公司的编制，包含行政后勤人员、财务核算人员、开发人员、售前人员、售后人员、测试人员、设计人员等等。事实上，华为、腾讯、阿里巴巴等大型公司内部都是采用这种“项目制”的方式进行管理。



同理，计算机编程继续发展，各种类型的变量更加多了，而且对数据的操作(指的就是方法，方法可以看做是对数据操作的管理)也复杂了，怎么办?



为了便于协作和管理，我们**“将相关数据和相关方法封装到一个独立的实体”，于是“对象”产生了。** 比如，我们的一个学生对象：

有属性（静态特征）：年龄：18，姓名：高淇，学号：1234

也可以有方法（动态行为）：学习，吃饭，考试

请大家举一反三，根据上表理解一下企业的进化史，会发现大道至简。原来，数据管理、企业管理、社会发展也是有很多共通的地方。“量变引起质变，不同的数量级必然采用不同的管理模式”。

![image-20220210142539379](https://www.itbaizhan.com/wiki/imgs/image-20220210142539379.png)

> **总结**
>
> - 对象说白了也是一种数据结构(对数据的管理模式)，将数据和数据的行为放到了一起。
> - 在内存上，对象就是一个内存块，存放了相关的数据集合！
> - 对象的本质就一种数据的组织方式！

**本节作业**

1. 说出面向过程和面向对象的相同点、不同点。

2. 面向对象是设计者思维，面向过程是执行者思维。如何理解？.

3. 使用面向对象分析和设计方法，按照如下场景写一首诗（或者自己设计一个场景）：

   > 抖音刷到半夜，脖子都TM酸了，手指都TM麻木了，仍然不眠不休的想看，真是上瘾了。躺下就后悔，想抽自己，这样累死了自己，还没学到东西，这和坐路边嗑瓜子扯淡有什么区别？
   >
   > 想以后过上好日子，还得学习啊。还不如看会尚学堂的课程，好好学习，拿个百万年薪。

**《抖音不如尚学堂》**

**高淇**

抖音手指麻，

半夜不眠刷。

明日尚学堂，

月薪九万八。 

## **对象和类的详解**

![image-20220210143256553](https://www.itbaizhan.com/wiki/imgs/image-20220210143256553.png)

类可以看做是一个模版，或者图纸，系统根据类的定义来造出对象。我们要造一个汽车，怎么样造？类就是这个图纸，规定了汽车的详细信息，然后根据图纸将汽车造出来。



类：我们叫做`class`。 对象：我们叫做`Object`,`instance`(实例)。以后我们说某个类的对象，某个类的实例。是一样的意思。

> **总结**
>
> - 类可以看成一类对象的模板，对象可以看成该类的一个具体实例。
> - 类是用于描述同一类型的对象的一个抽象概念，类中定义了这一类对象所应具有的共同的属性、方法。

### **类的定义**

做了关于对象的很多介绍，终于进入代码编写阶段。

本节中重点介绍类和对象的基本定义，属性和方法的基本使用方式。

【示例】类的定义方式

```java
// 每一个源文件必须有且只有一个public class，并且类名和文件名保持一致！
public class Car { 
}
class Tyre { // 一个Java文件可以同时定义多个class
}
class Engine {
}
class Seat {
}
```

对于一个类来说，**有三种成员：属性field、方法method、构造器constructor**。

![image-20220210143938057](https://www.itbaizhan.com/wiki/imgs/image-20220210143938057.png)

**属性（field 成员变量）**

**属性用于定义该类或该类对象包含的数据或者说静态特征**。属性作用范围是整个类体。

在定义成员变量时可以对其初始化，如果不对其初始化，**Java使用默认的值对其初始化**。

![image-20220210144153765](https://www.itbaizhan.com/wiki/imgs/image-20220210144153765.png)

**属性定义格式**

```java
[修饰符] 属性类型 属性名 = [默认值] ;
```

**方法**

**方法用于定义该类或该类实例的行为特征和功能实现。**方法是类和对象行为特征的抽象。面向对象中，整个程序的基本单位是类，方法是从属于类和对象的。

```java
[修饰符] 方法返回值类型 方法名(形参列表) {
    // n条语句
}
```

【示例】编写简单的学生类

![image-20220210144359471](https://www.itbaizhan.com/wiki/imgs/image-20220210144359471.png)

```java
public class SxtStu {
  //属性（成员变量）
    int id;
    String sname;
    int age;    
    //方法
        System.out.println("我正在学习！");
    }   
    //构造方法
    SxtStu(){
    }
}
```

**实时效果反馈**

**1. 关于类中，定义属性的说法，错误的是:**

A 属性，也称之为：成员变量

B 属性用于定义该类或该类对象包含的数据或者说静态特征

C 属性作用范围是整个类体

D 无论我们是否手动初始化， Java都使用默认的值对属性做其初始化

**答案**

1=>D

 **简单内存分析(帮助理解面向对象)**

![image-20220210144518495](https://www.itbaizhan.com/wiki/imgs/image-20220210144518495.png)

```java
public class SxtStu {
	int id;
	int age;
	String sname;


	public void study(){
	System.out.println("学习");
	}


	public void kickball(){
	System.out.println("踢球");
	}


	public static void main(String[] args) {
	SxtStu s1=new SxtStu();
	System.out.println(s1.id);
	System.out.println(s1.sname);
	s1.id = 1001;
	s1.sname = "高淇";
	System.out.println(s1.id);
	}
}

```

## **构造方法(构造器 constructor)**

构造器用于对象的初始化，而不是创建对象！

![image-20220210144630190](https://www.itbaizhan.com/wiki/imgs/image-20220210144630190.png)

构造方法是负责初始化（装修），不是建房子

![image-20220210144719296](https://www.itbaizhan.com/wiki/imgs/image-20220210144719296.png)

**声明格式：**

```java
[修饰符] 类名(形参列表){ //n条语句}
```



**构造器4个要点：**

- 构造器通过new关键字调用！！
- 构造器虽然有返回值，但是不能定义返回值类型(返回值的类型肯定是本类)，不能在构造器里使用return返回某个值。
- 如果我们没有定义构造器，则编译器会自动定义一个无参的构造方法。如果已定义则编译器不会自动添加！
- 构造器的方法名必须和类名一致！



**课堂练习**

> - **定义一个“点”（Point）类用来表示二维空间中的点（有两个坐标）。要求如下：**
>
> 1. 可以生成具有特定坐标的点对象。
> 2. 提供可以计算该“点”距另外一点距离的方法。

**参考答案**

```java
class Point {
  double x, y;
  public Point(double _x, double _y) {
     x = _x;
y = _y;
  }
  public double getDistance(Point p) {
return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
}


public static void main(String[ ] args) {
Point p1 = new Point(3.0, 4.0);
Point origin = new Point(0.0, 0.0);
System.out.println(p1.getDistance(origin));
}
}
```

**实时效果反馈**

**1. 如下关于构造器的说法，错误的是:**

A 构造器用于对象的初始化，而不是创建对象！

B 构造器用于创建对象，以及初始化

C 构造器通过new关键字调用

D 构造器的方法名必须和类名一致

**答案**

1=>B

### **构造方法的重载**

![image-20220210145143829](https://www.itbaizhan.com/wiki/imgs/image-20220210145143829.png)

构造方法也是方法。与普通方法一样，构造方法也可以重载。

【示例4-6】构造方法重载(创建不同用户对象)

```java
public class User {
    int id; // id
    String name; // 账户名
    String pwd; // 密码
    public User() {


    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
   }
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
    public static void main(String[ ] args) {
        User u1 = new User();
        User u2 = new User(101, "高小七");
        User u3 = new User(100, "高淇", "123456");        
    }
}
```

> **新手雷区**
>
> 如果方法构造中形参名与属性名相同时，需要使用this关键字区分属性与形参。
>
> this.id 表示属性id；id表示形参id

## **面向对象的内存分析**

为了让大家对于面向对象编程有更深入的了解，我们要对程序的执行过程中，内存到底发生了什么变化进行剖析，让大家做到“心中有数”，通过更加形象方式理解程序的执行方式。

> **老鸟建议**
>
> - 本节课是为了让初学者更深入了解程序底层执行情况，为了完整的体现内存分析流程，会有些新的名词，比如：线程、Class对象。大家暂时可以不求甚解的了解，后期学了这两个概念再回头来看我们这篇内存分析，肯定收获会更大。
> - 学习本节，一定要结合视频学习！
> - **明确目标，我们是通过“分析内存”帮助理解，而不是为分析而分析，把问题搞复杂。**

 

### **JAVA虚拟机内存模型概念**

![image-20220210145628540](https://www.itbaizhan.com/wiki/imgs/image-20220210145628540.png)

学习内存模型是为了更好理解面向对象

我们前面做过的内存分析过程：

![image-20220210145731441](https://www.itbaizhan.com/wiki/imgs/image-20220210145731441.png)

Java虚拟机的内存可以分为三个区域：栈stack、堆heap、方法区method area。



**虚拟机栈（简称：栈）的特点如下：**

1. 栈描述的是方法执行的内存模型。每个方法被调用都会创建一个栈帧（存储局部变量、操作数、方法出口等）
2. JVM为每个线程创建一个栈，用于存放该线程执行方法的信息（实际参数、局部变量等）
3. 栈属于线程私有，不能实现线程间的共享！
4. 栈的存储特性是“先进后出，后进先出”
5. 栈是由系统自动分配，速度快！栈是一个连续的内存空间！



**堆的特点如下：**

1. 堆用于存储创建好的对象和数组(数组也是对象)
2. JVM只有一个堆，被所有线程共享
3. 堆是一个不连续的内存空间，分配灵活，速度慢！
4. 堆被所有的线程所共享，在堆上的区域，会被垃圾回收器做进一步划分，例如新生代、老年代的划分。

![image-20220210145909173](https://www.itbaizhan.com/wiki/imgs/image-20220210145909173.png)

**方法区（也是堆）特点如下：**

1. 方法区是JAVA虚拟机规范，可以有不同的实现。

   i. JDK7以前是“永久代”

   ii. JDK7部分去除“永久代”，静态变量、字符串常量池都挪到了堆内存中

   iii. JDK8是“元数据空间”和堆结合起来。

2. JVM只有一个方法区，被所有线程共享！

3. 方法区实际也是堆，只是用于存储类、常量相关的信息！

4. 用来存放程序中永远是不变或唯一的内容。（类信息【Class对象，反射机制中会重点讲授】、静态变量、字符串常量等）

5. 常量池主要存放常量：如文本字符串、final常量值。

**实时效果反馈**

**1. 如下关于java的内存模型，错误的是:**

A 栈描述的是方法执行的内存模型。每个方法被调用都会创建一个栈帧

B 栈是一个不连续的内存空间！

C 堆用于存储创建好的对象

D 方法区实际也是堆，只是用于存储类、常量相关的信息！

**答案**

1=>B

 

### 程序执行过程内存分析

【示例】编写Person类并分析内存

```java
public class Person {
    String name;
    int age;
    public void show(){
        System.out.println(name);
    }
public static void main(String[ ] args) {
        // 创建p1对象
        Person p1 = new Person();
        p1.age = 24;
        p1.name = "张三";
        p1.show();
        // 创建p2对象
        Person p2 = new Person();
        p2.age = 35;
        p2.name = "李四";
        p2.show();
    Person p3 = p1;
    Person p4 = p1;
    p4.age = 80;
    System.out.println(p1.age);
    }
}
```

![image-20220210150350901](https://www.itbaizhan.com/wiki/imgs/image-20220210150350901.png)

### **参数传值机制**

![image-20220210150509267](https://www.itbaizhan.com/wiki/imgs/image-20220210150509267.png)

Java中，方法中所有参数都是“值传递”，也就是“传递的是值的副本”。 也就是说，我们得到的是“原参数的复印件，而不是原件”。

**· 基本数据类型参数的传值**

传递的是值的副本。 副本改变不会影响原件。

**· 引用类型参数的传值**

传递的是值的副本。但是引用类型指的是“对象的地址”。因此，副本和原参数都指向了同一个“地址”，改变“副本指向地址对象的值，也意味着原参数指向对象的值也发生了改变”。

【示例】多个变量指向同一个对象

```java
public class User {
    int id;     //id
    String name;    //账户名
    String pwd;     //密码
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public static void main(String[ ] args) {
        User u1 = new User(100, "高小七");
        User u3 = u1;
        System.out.println(u1.name);
        u3.name="张三";
        System.out.println(u1.name);
    }
}
```

执行结果如图4-12所示：

![image-20220210151954850](https://www.itbaizhan.com/wiki/imgs/image-20220210151954850.png)

## **垃圾回收机制(Garbage Collection)**

Java引入了垃圾回收机制，令C++程序员最头疼的内存管理问题迎刃而解。Java程序员可以将更多的精力放到业务逻辑上而不是内存管理工作上，大大的提高了开发效率。

![image-20220210152039854](https://www.itbaizhan.com/wiki/imgs/image-20220210152039854.png)

### **垃圾回收原理和算法**

**· 内存管理**

**Java的内存管理很大程度就是：堆中对象的管理**，其中包括对象空间的分配和释放。

- **对象空间的分配：**使用new关键字创建对象即可
- **对象空间的释放：**将对象赋值null即可。



**· 垃圾回收过程**

任何一种垃圾回收算法一般要做两件基本事情：

1. 发现无用的对象
2. 回收无用对象占用的内存空间。

垃圾回收机制保证可以将“无用的对象”进行回收。

无用的对象指的就是没有任何变量引用该对象。Java的垃圾回收器通过相关算法发现无用对象，并进行清除和整理。



**实时效果反馈**

**1. 关于垃圾回收的说法，错误的是:**

A Java的内存管理很大程度就是：堆中对象的管理

B 垃圾回收机制保证可以将“无用的对象”进行回收。

C 无用的对象指的就是没有任何变量引用该对象。

D 无用的对象指的就是长时间没有调用的对象。

**答案**

1=>D

 **· 垃圾回收相关算法**

1. 引用计数法

   堆中的每个对象都对应一个引用计数器，当有引用指向这个对象时，引用计数器加1，而当指向该对象的引用失效时（引用变为null），引用计数器减1，最后如果该对象的引用计算器的值为0时，则Java垃圾回收器会认为该对象是无用对象并对其进行回收。优点是算法简单，缺点是“循环引用的无用对象”无法别识别。

   ![image-20220210152158532](https://www.itbaizhan.com/wiki/imgs/image-20220210152158532.png)

   **【示例】循环引用演示**

   代码中，s1和s2互相引用对方，导致他们引用计数不为0，但是实际已经无用，但无法被识别。

   ```java
   public class Student {
       String name;
       Student friend;
       
     public static void main(String[ ] args) {
       Student s1 = new Student();
       Student s2 = new Student();
       
       s1.friend = s2;
       s2.friend = s1;    
       s1 = null;
       s2 = null;
      }
   }
   ```

2. 引用可达法（根搜索算法）

**程序把所有的引用关系看作一张图**，从一个节点GC ROOT开始，寻找对应的引用节点，找到这个节点以后，继续寻找这个节点的引用节点，当所有的引用节点寻找完毕之后，剩余的节点则被认为是没有被引用到的节点，即无用的节点。

 

### **通用的分代垃圾回收机制(先了解，学到高级可以再看)**

![image-20220210152848561](https://www.itbaizhan.com/wiki/imgs/image-20220210152848561.png)

分代垃圾回收机制，是基于这样一个事实：不同的对象的生命周期是不一样的。因此，不同生命周期的对象可以采取不同的回收算法，以便提高回收效率。我们将对象分为三种状态：年轻代、年老代、永久代。同时，将处于不同状态的对象放到堆中不同的区域。

**1. 年轻代**

所有新生成的对象首先都是放在Eden区。年轻代的目标就是尽可能快速的收集掉那些生命周期短的对象，对应的是Minor GC，每次 Minor GC 会清理年轻代的内存，算法采用效率较高的复制算法，频繁的操作，但是会浪费内存空间。当“年轻代”区域存放满对象后，就将对象存放到年老代区域。

**2. 年老代**

在年轻代中经历了N(默认15)次垃圾回收后仍然存活的对象，就会被放到年老代中。因此，可以认为年老代中存放的都是一些生命周期较长的对象。年老代对象越来越多，我们就需要启动Major GC和Full GC(全量回收)，来一次大扫除，全面清理年轻代区域和年老代区域。

**3. 永久代**

用于存放静态文件，如Java类、方法等。持久代对垃圾回收没有显著影响。JDK7以前就是“方法区”的一种实现。JDK8以后已经没有“永久代”了，使用metaspace元数据空间和堆替代。

![image-20220210153247735](https://www.itbaizhan.com/wiki/imgs/image-20220210153247735.png)

**·Minor GC:**

用于清理年轻代区域。Eden区满了就会触发一次Minor GC。清理无用对象，将有用对象复制到“Survivor1”、“Survivor2”区中。

**·Major GC：**

用于清理年老代区域。

**·Full GC：**

用于清理年轻代、年老代区域。 成本较高，会对系统性能产生影响。



### **JVM调优和Full GC**

在对JVM调优的过程中，很大一部分工作就是对于Full GC的调节。有如下原因可能导致Full GC：

1. 年老代（Tenured）被写满
2. 永久代（Perm）被写满
3. System.gc()被显式调用
4. 上一次GC之后Heap的各域分配策略动态变化

**实时效果反馈**

**1. 如下关于分代垃圾回收机制，错误的说法是:**

A 分代垃圾回收，是基于这样一个事实：不同的对象的生命周期是不一样的。

B 将对象分为三种状态：年轻代、年老代、永久代

C Full GC用于清理年轻代、年老代区域。JVM调优中，很大的工作就是Full GC的调节。

D Minor GC：用于清理年老代区域。Major GC：用于清理年青代区域

**答案**

1=>D

 **开发中容易造成内存泄露的操作**

**内存泄漏：**

指堆内存由于某种原因程序未释放，造成内存浪费，导致运行速度减慢甚至系统崩溃等。

![image-20220210153527394](https://www.itbaizhan.com/wiki/imgs/image-20220210153527394.png)

> **老鸟建议**
>
> - 在实际开发中，经常会造成系统的崩溃。如下这些操作我们应该注意这些使用场景。 请大家学完相关内容后，回头过来温习下面的内容。不要求此处掌握相关细节。

如下四种情况时最容易造成内存泄露的场景，请大家开发时一定注意：

**1.创建大量无用对象**

比如：大量拼接字符串时，使用了String而不是StringBuilder。

```java
String str = "";
for (int i = 0; i < 10000; i++) {  
    str += i;   //相当于产生了10000个String对象
}
```

**2. 静态集合类的使用**

像HashMap、Vector、List等的使用最容易出现内存泄露，这些静态变量的生命周期 和应用程序一致，所有的对象也不能被释放。

**3. 各种连接对象（IO流对象、数据库连接对象、网络连接对象）未关闭**

IO流对象、数据库连接对象、网络连接对象等连接对象属于物理连接，和硬盘或者网 络连接，不使用的时候一定要关闭。

**4. 监听器的使用不当**

释放对象时，没有删除相应的监听器



**其他要点**

1. 程序员无权调用垃圾回收器。
2. 程序员可以调用System.gc()，该方法只是通知JVM，并不是运行垃圾回收器。尽量少用，会申请启动Full GC，成本高，影响系统性能。
3. Object对象的finalize方法，是Java提供给程序员用来释放对象或资源的方法，但是尽量少用



### **本节作业**

1. 垃圾回收过程一般分为两步，是哪两步？
2. 垃圾回收常见的两种算法是什么？
3. 堆内存划分成：年轻代、年老代、永久代。垃圾回收器划分成：Minor GC、Major GC、Full GC。这三种垃圾收回器都对应哪些区域？
4. 对JVM调优的过程中，很大一部分工作就是对于Full GC的调节。这句话对吗？
5. System.gc()的作用是什么？

**实时效果反馈**

**1. for循环时，创建了多少个字符串对象:**

```java
String str = "";
for (int i = 0; i < 10000; i++) {  
    str += i;
}
```

A 0

B 1

C 10000

D 100

**答案**

1=>C

 **this关键字**

![image-20220210164223611](https://www.itbaizhan.com/wiki/imgs/image-20220210164223611.png)

#### **this的用法：**

- 普通方法中，this总是指向调用该方法的对象。
- 构造方法中，this总是指向正要初始化的对象。

> **创建对象的四步：**
>
> ![image-20220210164322090](https://www.itbaizhan.com/wiki/imgs/image-20220210164322090.png)

> this的其他要点：
>
> - this()调用重载的构造方法，避免相同的初始化代码。但只能在构造方法中用，并且必须位于构造方法的第一句。
> - this不能用于static方法中。
> - this是作为普通方法的“隐式参数”，由系统传入到方法中。

**【示例】this的用法详解**

```java
public class TestThis {
    int a, b, c;

   TestThis() {
        System.out.println("正要初始化一个Hello对象");
    }
    TestThis(int a, int b) {
        // TestThis(); //这样是无法调用构造方法的！
        this(); // 调用无参的构造方法，并且必须位于第一行！
        a = a;// 这里都是指的局部变量而不是成员变量
// 这样就区分了成员变量和局部变量. 这种情况占了this使用情况大多数！
        this.a = a;
        this.b = b;
    }
    TestThis(int a, int b, int c) {
        this(a, b); // 调用带参的构造方法，并且必须位于第一行！
        this.c = c;
    }

    
    void sing() {
    }
    void eat() {
        this.sing(); // 调用本类中的sing();
        System.out.println("你妈妈喊你回家吃饭！");
    }


    public static void main(String[ ] args) {
        TestThis hi = new TestThis(2, 3);
        hi.eat();
    }
}
```

**实时效果反馈**

**1. 关于this关键字的说法，错误的是:**

A 普通方法中，this总是指向调用该方法的对象

B 构造方法中，this总是指向正要初始化的对象

C this可以用于static方法中

D this()调用重载的构造方法，避免相同的初始化代码。

**答案**

1=>C

### **static 关键字**

<img src="https://www.itbaizhan.com/wiki/imgs/image-20220210164818477.png" alt="image-20220210164818477" style="zoom:50%;" />

静态变量(类变量)、静态方法(类方法)：static声明的属性或方法。



> 静态变量/静态方法生命周期和类相同，在整个程序执行期间都有效。它有如下特点：
>
> 1. 为该类的公用变量，属于类，被该类的所有实例共享，在类载入时被初始化。
> 2. static变量只有一份。
> 3. 一般用“类名.类变量/方法”来调用。
> 4. 在static方法中不可直接访问非static的成员。

【示例】static关键字的使用

```java
public class TestStatic {
    int id; // id
    String name; // 账户名
    String pwd; // 密码
    static String company = "北京尚学堂"; // 公司名称
    public TestStatic (int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void login() {
        System.out.println(name);
    }
    public static void printCompany() {
        // login();//调用非静态成员，编译就会报错
  System.out.println(company);
    }
    public static void main(String[ ] args) {
        TestStatic u = new TestStatic (101, "高小七");
        TestStatic .printCompany();
        TestStatic .company = "北京阿里爷爷";
        TestStatic .printCompany();
    }}
```

执行结果如图所示：

![image-20220210165146330](https://www.itbaizhan.com/wiki/imgs/image-20220210165146330.png)

示例运行时的内存分配图。

![image-20220210165259021](https://www.itbaizhan.com/wiki/imgs/image-20220210165259021.png)

**实时效果反馈**

**1. 如下关于static关键字的说法，错误的是:**

A 静态变量/静态方法生命周期和类相同，在整个程序执行期间都有效

B static变量只有一份

C 在static方法中不可直接访问非static的成员

D static变量从属于对象，不是从属于类

**答案**

1=>D

 

### **静态初始化块**

构造方法用于对象的普通属性初始化。

静态初始化块，用于类的初始化操作，初始化静态属性。

在静态初始化块中不能直接访问非static成员。

> **注意事项**
>
> **静态初始化块执行顺序(学完继承再看这里)：**
>
> - 上溯到Object类，先执行Object的静态初始化块，再向下执行子类的静态初始化块，直到类的静态初始化块为止。
> - 构造方法执行顺序和上面顺序一样！！

【示例】static静态初始化块

```java
public class TestStatic2 {
    static String company; //公司名称
    static {
        System.out.println("执行类的初始化工作");
        company = "北京尚学堂";
        printCompany();
    }   
    public static void printCompany(){
        System.out.println(company);
    }   
    public static void main(String[ ] args) {
    }
}

```

执行结果如图所示：

![image-20220210170118090](https://www.itbaizhan.com/wiki/imgs/image-20220210170118090.png)

 

### **变量的分类和作用域**

![image-20220210171356219](https://www.itbaizhan.com/wiki/imgs/image-20220210171356219.png)

变量有三种类型：局部变量、成员变量(也称为实例变量)和静态变量。

**局部变量、成员变量、静态变量的核心区别**

| 类型               | 声明位置           | 从属于      | 生命周期（作用域）                                           |
| ------------------ | ------------------ | ----------- | ------------------------------------------------------------ |
| 局部变量           | 方法或语句块内部   | 方法/语句块 | 从声明处开始，到方法或语句块结束                             |
| 成员变量(实例变量) | 类内部，方法外部   | 对象        | 对象创建，成员变量也跟着创建。对象消失，成员变量也跟着消失； |
| 静态变量(类变量)   | 类内部，static修饰 | 类          | 类被加载，静态变量就有效；                                   |

**实时效果反馈**

**1. 关于变量的类型，错误的说法是:**

A 局部变量，从属于方法

B 成员变量，从属于类

C 成员变量，从属于对象

D 静态变量，从属于类

**答案**

1=>B

## **包机制(package、import)**

包（package）相当于文件夹对于文件的作用。用于管理类、用于解决类的重名问题。

![image-20220210172445863](https://www.itbaizhan.com/wiki/imgs/image-20220210172445863.png)

### **package**

**package的使用有两个要点：**

1. 通常是类的第一句非注释性语句。
2. 包名：域名倒着写即可，便于内部管理类。

【示例】package的命名演示

```java
com.oracle.test;
com.itbaizhan.gao.test;
com.itbaizhan.gao.view;
com.itbaizhan.view.model;
```

> **注意事项**
>
> - 写项目时都要加包，不要使用默认包。
> - com.gao和com.gao.car，这是两个完全独立的包。只是逻辑上看,后者是前者的一部分。

【示例】package的使用

```java
package com.itbaizhan;
public class Test {
    public static void main(String[ ] args) {
        System.out.println("helloworld");
    }
}
```

**在IDEA项目中新建包**

在src目录上单击右键，选择new->package

![image-20220210172918421](https://www.itbaizhan.com/wiki/imgs/image-20220210172918421.png)

在package窗口上输入包名即可

![image-20220210173240019](https://www.itbaizhan.com/wiki/imgs/image-20220210173240019.png)

即可在src下面看到包：

![image-20220210173418521](https://www.itbaizhan.com/wiki/imgs/image-20220210173418521.png)

接下来，我们就可以在包上单击右键，新建类啦

### **JDK中的主要包**

**表 JDK中的主要包**

| **Java中的常用包** | **说明**                                                     |
| ------------------ | ------------------------------------------------------------ |
| java.lang          | 包含一些Java语言的核心类，如String、Math、Integer、System和Thread。 |
| java.awt           | 包含了构成抽象窗口工具集（abstract window toolkits）的多个类，这些类被用来构建和管理应用程序的图形用户界面(GUI)。 |
| java.net           | 包含执行与网络相关的操作的类。                               |
| java.io            | 包含能提供多种输入/输出功能的类。                            |
| java.util          | 包含一些实用工具类，如定义系统特性、使用与日期日历相关的函数。 |

 **导入类import**

如果要使用其他包的类，需使用import，从而在本类中直接通过类名来调用，否则就需要书写类的完整包名和类名。

![image-20220210173846351](https://www.itbaizhan.com/wiki/imgs/image-20220210173846351.png)

> **注意要点**
>
> - Java会默认导入java.lang包下所有的类，因此这些类我们可以直接使用。
> - 如果导入两个同名的类，只能用包名+类名来显示调用相关类：java.util.Date date = new java.util.Date();

### **静态导入**

静态导入(static import): 其作用是用于导入指定类的静态属性和静态方法，这样我们可以直接使用静态属性和静态方法。

【示例】静态导入的使用

```java
package com.itbaizhan;
import static java.lang.Math.*;//导入Math类的所有静态属性
import static java.lang.Math.PI;//导入Math类的PI属性


public class Test2{
    public static void main(String [ ] args){
        System.out.println(PI);
        System.out.println(random());
    }
}
```

执行结果如图所示：

![image-20220210174316694](https://www.itbaizhan.com/wiki/imgs/image-20220210174316694.png)

**实时效果反馈**

**1. 关于package和import，说法错误的是:**

A 使用import导入类后，可以直接使用该类

B java.lang包，也需要手动导入，不会被自动导入

C cn.gao和cn.gao.car，这是两个完全独立的包。只是逻辑上看, 后者是前者的一部分。

D 包名：一般是域名倒着写即可，便于内部管理类。

**答案**

1=>B

 **面向对象三大特征**

本章重点针对面向对象编程的三大特征：继承、封装、多态进行详细的讲解。不要期望，通过本章学习就“搞透面向对象编程”。本章只是面向对象编程的起点，后面所有的章节说白了都是对面向对象这一章的应用。



> **老鸟建议**
>
> 建议大家，学习本章，莫停留！学完以后，迅速开展后面的章节。可以这么说，后续章节所有的编程都是“面向对象思想”的应用而已！

## **继承**

![image-20220210174815485](https://www.itbaizhan.com/wiki/imgs/image-20220210174815485.png)

继承是面向对象编程的三大特征之一。继承让我们更加容易实现类的扩展。实现代码的重用，不用再重新发明轮子(don’t reinvent wheels)。



继承有两个主要作用：

1. 代码复用，更加容易实现类的扩展
2. 方便建模

### **继承的实现**

从英文字面意思理解，extends的意思是“扩展”。子类是父类的扩展。现实世界中的继承无处不在。比如：

![image-20220210175051614](https://www.itbaizhan.com/wiki/imgs/image-20220210175051614.png)

上图中，哺乳动物继承了动物。意味着，动物的特性，哺乳动物都有；在我们编程中，如果新定义一个Student类，发现已经有Person类包含了我们需要的属性和方法，那么Student类只需要继承Person类即可拥有Person类的属性和方法。

【示例】使用extends实现继承

```java
public class Test{
    public static void main(String[ ] args) {
        Student s = new Student("高淇",176,"Java");
        s.rest();
        s.study();
    }
}
class Person {
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会！");
    }   
}
class Student extends Person {
    String major; //专业
    public void study(){
        System.out.println("在尚学堂，学习Java");
    }   
    public Student(String name,int height,String major) {
        //天然拥有父类的属性
        this.name = name;
        this.height = height;
        this.major = major;
    }
}
```

执行结果如图所示：

![image-20220210180149793](https://www.itbaizhan.com/wiki/imgs/image-20220210180149793.png)

### **instanceof 运算符**

`instanceof`是二元运算符，左边是对象，右边是类；当对象是右面类或子类所创建对象时，返回`true`；否则，返回`false`。比如：

【示例】使用`instanceof`运算符进行类型判断

```java
public class Test{
    public static void main(String[ ] args) {
        Student s = new Student("高淇",172,"Java");
        System.out.println(s instanceof Person);
        System.out.println(s instanceof Student);
    }
}
```

两条语句的输出结果都是`true`

### **继承使用要点**

1. 父类也称作超类、基类。 子类：派生类等。
2. Java中只有单继承，没有像C++那样的多继承。多继承会引起混乱，使得继承链过于复杂，系统难于维护。
3. Java中类没有多继承，接口有多继承。
4. 子类继承父类，可以得到父类的全部属性和方法 (除了父类的构造方法)，但不见得可以直接访问(比如，父类私有的属性和方法)。
5. 如果定义一个类时，没有调用extends，则它的父类是：java.lang.Object。

**实时效果反馈**

**1. 如下哪个不是面向对象的三大特征**

A 继承

B 封装

C 组合

D 多态

**2. 如下关于继承的说法，错误的是:**

A 子类继承父类，可以得到父类的全部属性和方法 (除了父类的构造方法)，但不见得可以直接访问(比如，父类私有的属性和方法)

B 如果定义一个类时，没有调用extends，则它没有父类

C 继承使用extends关键字来实现

D Java中类没有多继承，接口有多继承

**答案**

1=>C 2=>B

 **方法重写override**

![image-20220210180541587](https://www.itbaizhan.com/wiki/imgs/image-20220210180541587.png)

子类重写父类的方法，可以用自身行为替换父类行为。重写是实现多态的必要条件。

**方法重写需要符合下面的三个要点：**

1. `= =`：方法名、形参列表相同。
2. `≤`：返回值类型和声明异常类型，子类小于等于父类。
3. `≥`：访问权限，子类大于等于父类。

【示例】方法重写

```java
package com.itbaizhan.oop;


/**
 * 测试方法的重写
 */
public class TestOverride {
    public static void main(String[ ] args) {
        Horse h = new Horse();
        Plane p = new Plane();
        h.run();
        h.getVehicle();
        p.run();
    }
}


class Vehicle {     //交通工具类
    public void run() {
        System.out.println("跑....");
    }


    public Vehicle getVehicle(){
        System.out.println("给你一个交通工具！");
        return null;
    }


}
class Horse extends Vehicle { // 马也是交通工具


    @Override
    public void run() {
        System.out.println("得得得....");
    }


    @Override
   public Horse getVehicle() {
        return new Horse();
    }
}


class Plane extends Vehicle {
    @Override
    public void run() {
        System.out.println("天上飞....");
    }
}
```

**实时效果反馈**

**1. 方法的重写，指的是:**

A 重写指的是：一个类内部，多个相同方法名的方法，也称为：重载。

B 子类重写父类的方法，可以用自身行为替换父类行为。

C 重写的单词是：override

D 重写是实现多态的必要条件

**答案**

1=>A

 **final关键字**

**final关键字的作用：**

- **修饰变量:** 被他修饰的变量不可改变。一旦赋了初值，就不能被重新赋值。

  **`final int MAX_SPEED = 120;`**

- **修饰方法：**该方法不可被子类重写。但是可以被重载！

  **`final void study(){}`**

- **修饰类:** 修饰的类不能被继承。比如：`Math`、`String`等。

  **`final class A {}`**

![image-20220210180925181](https://www.itbaizhan.com/wiki/imgs/image-20220210180925181.png)

final修饰类如图所示。

![image-20220210181017370](https://www.itbaizhan.com/wiki/imgs/image-20220210181017370.png)

**实时效果反馈**

**1. 关于final的说法，错误的是:**

A final修饰变量: 被他修饰的变量不可改变

B final修饰方法：该方法不可被子类重写

C final修饰类: 修饰的类不能被继承

D final修饰方法：该方法不可被重载

**答案**

1=>D

 

### **继承和组合**

![image-20220210181051823](https://www.itbaizhan.com/wiki/imgs/image-20220210181051823.png)

结婚就是一种组合。两人组合后，可以复用对方的属性和方法！

除了继承，“组合”也能实现代码的复用！“组合”核心是“将父类对象作为子类的属性”。



【示例】之前继承的代码用组合重新实现

```java
public class Test{
  public static void main(String[ ] args) {
   Student s = new Student("高淇",172,"Java");
   s.person.rest();   //s.rest();
   s.study();
  }
}


class Person {
  String name;
  int height;
  public void rest(){
   System.out.println("休息一会！");
  } 
}


class Student /*extends Person*/ {
  Person person = new Person();
  String major; //专业


  public Student(String name,int height,String major) {
   //拥有父类的对象，通过这个对象间接拥有它的属性和方法
    this.person.name = name;   //this.name = name;
   	this.person.height = height;   //this.height = height;
    this.person.rest();

    this.major = major;}
    public void study(){
 System.out.println("学习:");
 person.rest();
 System.out.println(this.person2.name);
}
  }

```

组合比较灵活。继承只能有一个父类，但是组合可以有多个属性。所以，有人声称“组合优于继承，开发中可以不用继承”，但是，不建议大家走极端。

对于`is -a`关系建议使用继承，`has-a`关系建议使用组合。

比如：上面的例子，Student is a Person这个逻辑没问题，但是：Student has a Person就有问题了。这时候，显然继承关系比较合适。

再比如：笔记本和芯片的关系显然是`has-a`关系，使用组合更好。



**本节作业**

1. 面向对象的三大特征是什么？
2. 继承的两个主要作用是什么？
3. JAVA中实现继承是哪个关键词？
4. JAVA中的类继承，是单继承还是多继承？JAVA中其他地方有多继承吗？
5. 子类继承父类可以获得除父类构造方法之外的所有，但不见得都能使用。找现实中的例子打比喻描述这个现象。
6. 定义类时，没有使用extends，他的父类是什么？
7. 完成课堂中，Person、Student继承关系的代码测试。
8. 完成课堂中，Person、Student组合关系的代码测试。
9. 组合和继承的关系如何理解？
10. 完成课堂中，方法重写的测试。
11. 方法重写和方法重载什么区别？
12. final关键字修饰变量、方法、类，都分别代表什么含义？

**实时效果反馈**

**1. 继承和组合的说法，错误的是:**

A 继承和组合，都可以实现代码的复用

B “组合”核心是“将父类对象作为子类的属性”。

C 组合任何时候都好于继承，完全可以替换继承！

D 对于`is -a`关系建议使用继承，`has-a`关系建议使用组合。

**答案**

1=>C

 **Object类详解**

![image-20220210181625859](https://www.itbaizhan.com/wiki/imgs/image-20220210181625859.png)

所有类都是Object类的子类，也都具备Object类的所有特性。

### **Object类基本特性**

1. Object类是所有类的父类，所有的Java对象都拥有Object类的属性和方法。
2. 如果在类的声明中未使用extends，则默认继承Object类。

![image-20220210182336575](https://www.itbaizhan.com/wiki/imgs/image-20220210182336575.png)

【示例】Object类

```java
public class Person {
    ...
}
//等价于：
public class Person extends Object {
    ...
}
```

#### **toString方法**

Object类中定义有`public String toString()`方法，其返回值是 String 类型。Object类中`toString`方法的源码为：

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

根据如上源码得知，默认会返回“类名+@+16进制的hashcode”。在打印输出或者用字符串连接对象时，会自动调用该对象的`toString()`方法。

**【示例】重写toString()方法**

```java
class Person {
    String name;
    int age;
    @Override
    public String toString() {
        return name+",年龄："+age;
    }
}
public class Test {
    public static void main(String[ ] args) {
        Person p=new Person();
        p.age=20;
        p.name="李东";
        System.out.println("info:"+p);
        
        Test t = new Test();
        System.out.println(t);
    }
}
```

执行结果如图所示：

![image-20220210183153778](https://www.itbaizhan.com/wiki/imgs/image-20220210183153778.png)

1. 

**实时效果反馈**

**1. 关于Object类的说法，错误的是:**

A 所有类都是Object类的子类，也都具备Object类的所有特性

B 所有的Java对象都拥有Object类的属性和方法

C 如果在类的声明中未使用extends，则默认继承Object类

D 如果在类的声明中未使用extends，则该类没有父类

**答案**

1=>D

####  **==和equals方法**

![image-20220210183531639](https://www.itbaizhan.com/wiki/imgs/image-20220210183531639.png)

`==`代表比较双方是否相同。如果是==基本类型则表示值相等，如果是引用类型则表示地址相等即是同一个对象。==

`equals()`提供定义**“对象内容相等”**的逻辑。比如，我们在公安系统中认为id相同的人就是同一个人、学籍系统中认为学号相同的人就是同一个人。

`equals()`默认是比较两个对象的hashcode。但，可以根据自己的要求重写`equals`方法。

【示例】自定义类重写equals()方法

```java
public class TestEquals { 
    public static void main(String[ ] args) {
        Person p1 = new Person(123,"高淇");
        Person p2 = new Person(123,"高小七");      
        System.out.println(p1==p2);   //false，不是同一个对象
        System.out.println(p1.equals(p2)); //true，id相同则认为两个对象内容相同
        String s1 = new String("尚学堂");
        String s2 = new String("尚学堂");
        System.out.println(s1==s2);         //false, 两个字符串不是同一个对象
        System.out.println(s1.equals(s2)); //true,  两个字符串内容相同
    }
}
class Person {
    int id;
    String name;
    public Person(int id,String name) {
        this.id=id;
        this.name=name;
    }




    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else {
            if(obj instanceof Person) {
                Person c = (Person)obj;
                if(c.id==this.id) {
                    return true;
                }
            }
        }
        return false;
    }
}

```

### **补:IDEA部分快捷键**

**IDEA快捷键和相关操作：**

1. 类的结构视图：alt+7

2. 看类的源码：ctrl+左键

3. 自动生成构造器、get、set方法、equals等：alt+insert

4. 查看错误：alt+enter

5. 快捷输出常见字符串：

   a) main public static void main(String[] args){}

   b) sout System.out.println();

   c) soutm System.out.println(“描述：所在类中的，所在方法”);

### **super关键字**

![image-20220210183911147](https://www.itbaizhan.com/wiki/imgs/image-20220210183911147.png)

1. super“可以看做”是直接父类对象的引用。可通过super来访问父类中被子类覆盖的方法或属性。
2. 使用super调用普通方法，语句没有位置限制，可以在子类中随便调用。
3. 在一个类中，若是构造方法的第一行没有调用super(...)或者this(...); 那么Java默认都会调用super(),含义是调用父类的无参数构造方法。

【示例】super关键字的使用

```java
public class TestSuper01 { 
    public static void main(String[ ] args) {
        new ChildClass().f();
    }
}
class FatherClass {
  public int value;
  public void f(){
    value = 100;
    System.out.println ("FatherClass.value="+value);
   }
}
class ChildClass extends FatherClass {
  public int value;
public int age;
  public void f() {
    super.f(); //调用父类的普通方法
    value = 200;
    System.out.println("ChildClass.value="+value);
    System.out.println(value);
    System.out.println(super.value); //调用父类的成员变量
   }
public void f2() {
    System.out.println(age);   }


}

```

执行结果如图所示：

![image-20220210184041051](https://www.itbaizhan.com/wiki/imgs/image-20220210184041051.png)

#### **继承树追溯**

![image-20220210184115205](https://www.itbaizhan.com/wiki/imgs/image-20220210184115205.png)

**属性/方法查找顺序：(比如：查找变量h)**

- 查找当前类中有没有属性h
- 依次上溯每个父类，查看每个父类中是否有h，直到Object
- 如果没找到，则出现编译错误。
- 上面步骤，只要找到h变量，则这个过程终止。



**构造方法调用顺序：**

构造方法第一句总是：super(…)来调用父类对应的构造方法。所以，流程就是：先向上追溯到Object，然后再依次向下执行类的初始化块和构造方法，直到当前子类为止。

**注：**静态初始化块调用顺序，与构造方法调用顺序一样，不再重复。

【示例】继承条件下构造方法的执行过程

```java
public class TestSuper02 { 
    public static void main(String[ ] args) {
        System.out.println("开始创建一个ChildClass对象......");
        new ChildClass();
    }
}
class FatherClass {
    public FatherClass() {
        System.out.println("创建FatherClass");
    }
}
class ChildClass extends FatherClass {
    public ChildClass() {
        System.out.println("创建ChildClass");
    }
}

```

执行结果如图所示：

![image-20220210184724325](https://www.itbaizhan.com/wiki/imgs/image-20220210184724325.png)

 

## **封装(encapsulation)**

封装是面向对象三大特征之一。

![image-20220210184858886](https://www.itbaizhan.com/wiki/imgs/image-20220210184858886.png)

### **封装的作用和含义**

> 我要看电视，只需要按一下开关和换台就可以了。有必要了解电视机内部的结构吗？有必要碰碰显像管吗？制造厂家为了方便我们使用电视，把复杂的内部细节全部封装起来，只给我们暴露简单的接口。

我们程序设计要追求“高内聚，低耦合”。高内聚就是类的内部数据操作细节自己完成，不允许外部干涉；低耦合是仅暴露少量的方法给外部使用，尽量方便外部调用。



**编程中封装的具体优点：**

- 提高代码的安全性。
- 提高代码的复用性。
- “高内聚”：封装细节，便于修改内部代码，提高可维护性。
- “低耦合”：简化外部调用，便于调用者使用，便于扩展和协作。



### **封装的实现—使用访问控制符**

Java是使用`访问控制符`来控制哪些细节需要封装，哪些细节需要暴露的。

Java中4种`访问控制符`分别为private、default、protected、public。

**访问权限修饰符**

| **修饰符** | **同一个类\**** | **同一个包中** | **子类** | **所有类** |
| ---------- | :-------------: | :------------: | :------: | :--------: |
| private    |      **☆**      |                |          |            |
| default    |      **☆**      |     **☆**      |          |            |
| protected  |      **☆**      |     **☆**      |  **☆**   |            |
| public     |      **☆**      |     **☆**      |  **☆**   |   **☆**    |

![image-20220210185217979](https://www.itbaizhan.com/wiki/imgs/image-20220210185217979.png)

> **【注】关于protected的两个细节：**
>
> 1. 若父类和子类在同一个包中，子类**可访问**父类的protected成员,**也可访问**父类对象的protected成员。
> 2. 若子类和父类不在同一个包中，子类**可访问**父类的protected成员，**不能访问**父类对象的protected成员。

### **封装的使用细节**

### ![image-20220210185555208](https://www.itbaizhan.com/wiki/imgs/image-20220210185555208.png)

**开发中封装的简单规则:**

- 属性一般使用private访问权限。

  属性私有后， 提供相应的get/set方法来访问相关属性，这些方法通常是public修饰的，以提供对属性的赋值与读取操作（注意：boolean变量的get方法是is开头!）。

- 方法：一些只用于本类的辅助性方法可以用private修饰，希望其他类调用的方法用public修饰。



**实时效果反馈**

**1. 开发中常见的封装规则，错误的说法是:**

A 属性一般使用private访问权限。

B 属性私有后， 提供相应的get/set方法来访问相关属性，这些方法通常是public修饰的

C 方法：一些只用于本类的辅助性方法可以用private修饰，希望其他类调用的方法用public修饰

D 属性一般使用public，方便外部调用

**答案**

1=>D

 【示例】JavaBean的封装演示

```java
public class Person {
    // 属性一般使用private修饰
    private String name;
    private int age;
    private boolean flag;
    // 为属性提供public修饰的set/get方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isFlag() {// 注意：boolean类型的属性get方法是is开头的
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

```

【示例】封装的使用

```java
class Person {
    private String name;
    private int age;
    public Person() {


    }
    public Person(String name, int age) {
        this.name = name;
        // this.age = age;//构造方法中不能直接赋值，应该调用setAge方法
        setAge(age);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        //在赋值之前先判断年龄是否合法
        if (age > 130 || age < 0) {
            this.age = 18;//不合法赋默认值18
        } else {
            this.age = age;//合法才能赋值给属性age
        }
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}


public class Test2 {
    public static void main(String[ ] args) {
        Person p1 = new Person();
        //p1.name = "小红"; //编译错误
        //p1.age = -45;  //编译错误
        p1.setName("小红");
        p1.setAge(-45);
        System.out.println(p1);
        
        Person p2 = new Person("小白", 300);
        System.out.println(p2);
    }
}

```

执行结果：

![image-20220210185753537](https://www.itbaizhan.com/wiki/imgs/image-20220210185753537.png)

##  **多态(polymorphism)**

![image-20220211105518126](https://www.itbaizhan.com/wiki/imgs/image-20220211105518126.png)

**多态指的是同一个方法调用，由于对象不同可能会有不同的行为。**现实生活中，同一个方法，具体实现会完全不同。 比如：同样是调用人“吃饭”的方法，中国人用筷子吃饭，英国人用刀叉吃饭，印度人用手吃饭。



### **多态的要点：**

1. 多态是方法的多态，不是属性的多态（多态与属性无关）。
2. 多态的存在要有3个必要条件：==继承，方法重写，父类引用指向子类对象。==
3. 父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了。



【示例】多态和类型转换

```java
class Animal {
    public void shout() {
        System.out.println("叫了一声！");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("旺旺旺！");
    }
    public void seeDoor() {
        System.out.println("看门中....");
    }
}
class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵喵！");
    }
}
public class TestPolym {
    public static void main(String[ ] args) {
        Animal a1 = new Cat(); // 向上可以自动转型
        //传的具体是哪一个类就调用哪一个类的方法。大大提高了程序的可扩展性。
        animalCry(a1);
        Animal a2 = new Dog();
        animalCry(a2);//a2为编译类型，Dog对象才是运行时类型。
        
        /*编写程序时，如果想调用运行时类型的方法，只能进行强制类型转换。
         * 否则通不过编译器的检查。*/
        Dog dog = (Dog)a2;//向下需要强制类型转换
        dog.seeDoor();
    }


    // 有了多态，只需要让增加的这个类继承Animal类就可以了。
    static void animalCry(Animal a) {
        a.shout();
    }


    /* 如果没有多态，我们这里需要写很多重载的方法。
     * 每增加一种动物，就需要重载一种动物的喊叫方法。非常麻烦。
    static void animalCry(Dog d) {
        d.shout();
    }
    static void animalCry(Cat c) {
        c.shout();
    }*/
}



```

执行结果所示：

![image-20220211105708568](https://www.itbaizhan.com/wiki/imgs/image-20220211105708568.png)

如上示例，给大家展示了多态最为多见的一种用法，即==父类引用做方法的形参==，实参可以是任意的子类对象，可以通过不同的子类对象实现不同的行为方式。

**==由此，我们可以看出多态的主要优势是提高了代码的可扩展性。==**但是多态也有弊端，就是无法调用子类特有的功能，比如，我不能使用父类的引用变量调用Dog类特有的seeDoor()方法。

那如果我们就想使用子类特有的功能行不行呢？行！这就是我们下一章节所讲的内容：对象的转型。

**多态指的是同一个方法调用，由于对象不同可能会有不同的行为。**现实生活中，同一个方法，具体实现会完全不同。 比如：同样是调用人“吃饭”的方法，中国人用筷子吃饭，英国人用刀叉吃饭，印度人用手吃饭。



**多态的要点：**

1. 多态是方法的多态，不是属性的多态（多态与属性无关）。
2. 多态的存在要有3个必要条件：继承，方法重写，父类引用指向子类对象。
3. 父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了。

**实时效果反馈**

**1. 关于多态的说法，错误的是:**

A 多态指的是同一个方法调用，由于对象不同可能会有不同的行为。

B 多态是方法的多态，不是属性的多态

C 多态的存在要有3个必要条件：继承，方法重写，父类引用指向子类对象

D 属性也有多态

**答案**

1=>D

 

## **对象的转型(casting)**

![image-20220211105814325](https://www.itbaizhan.com/wiki/imgs/image-20220211105814325.png)

1. 父类引用指向子类对象，我们称这个过程为**向上转型**，属于自动类型转换。
2. 向上转型后的父类引用变量只能调用它编译类型的方法，不能调用它运行时类型的方法。这时，我们就需要进行类型的强制转换，我们称之为**向下转型。**

【示例】对象的转型\

```java
public class TestCasting {
    public static void main(String[ ] args) {
        Object obj = new String("北京尚学堂"); // 向上可以自动转型
        // obj.charAt(0) 无法调用。编译器认为obj是Object类型而不是String类型
        /* 编写程序时，如果想调用运行时类型的方法，只能进行强制类型转换。
         * 不然通不过编译器的检查。 */
        String str = (String) obj; // 向下转型
        System.out.println(str.charAt(0)); // 位于0索引位置的字符
        System.out.println(obj == str); // true.他们俩运行时是同一个对象
    }
}
```

执行结果如果所示：

![image-20220211110047271](https://www.itbaizhan.com/wiki/imgs/image-20220211110047271.png)

在向下转型过程中，必须将引用变量转成真实的子类类型(运行时类型）否则会出现类型转换异常ClassCastException。如示例5-14所示。

【示例】类型转换异常

```java
public class TestCasting2 {
    public static void main(String[ ] args) {
    Object obj = new String("北京尚学堂");
       //真实的子类类型是String，但是此处向下转型为StringBuffer
        StringBuffer str = (StringBuffer) obj;
        System.out.println(str.charAt(0));
    }
}
```

执行结果：

![image-20220211110416318](https://www.itbaizhan.com/wiki/imgs/image-20220211110416318.png)

为了避免出现这种异常，我们可以使用instanceof运算符进行判断。



【示例】向下转型中使用instanceof

```java
public class TestCasting3 {
    public static void main(String[ ] args) {
        Object obj = new String("北京尚学堂");
        if(obj instanceof String){
            String str = (String)obj;
            System.out.println(str.charAt(0));
        }else if(obj instanceof StringBuffer){
            StringBuffer str = (StringBuffer) obj;
            System.out.println(str.charAt(0));
        }
    }
}
```

 

## **抽象类**

### **抽象方法和抽象类**

![image-20220211110633133](https://www.itbaizhan.com/wiki/imgs/image-20220211110633133.png)

**· 抽象方法**

1. ==使用`abstract`修饰的方法，没有方法体，只有声明。==
2. 定义的是一种“规范”，就是告诉子类必须要给抽象方法提供具体的实现。



**· 抽象类**

1. 包含抽象方法的类就是抽象类。
2. 通过抽象类，我们就可以做到严格限制子类的设计，使子类之间更加通用。

【示例】抽象类和抽象方法的基本用法

```java
//抽象类
abstract class Animal {
    abstract public void shout(); //抽象方法
}
class Dog extends Animal {  
    //子类必须实现父类的抽象方法，否则编译错误
    public void shout() {
        System.out.println("汪汪汪！");
    }
    public void seeDoor(){
        System.out.println("看门中....");
    }
}
//测试抽象类
public class TestAbstractClass {
    public static void main(String[ ] args) {
        Dog a = new Dog();
        a.shout();
        a.seeDoor();
    }
}
```

**抽象类的使用要点:**

1. 有抽象方法的类只能定义成抽象类
2. ==**抽象类不能实例化，即不能用new来实例化抽象类。**==
3. 抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用。
4. ==**抽象类只能用来被继承。**==
5. ==**抽象方法必须被子类实现。**==

**实时效果反馈**

**1. 关于抽象类和抽象方法，说法错误的是:**

A 有抽象方法的类只能定义成抽象类

B 抽象类能实例化，也能用new来实例化抽象类

C 抽象类可以包含属性、方法、构造方法。

D 抽象方法必须被子类实现

**答案**

1=>B

##  **接口interface**

接口就是一组规范（就像我们人间的法律一样），所有实现类都要遵守。

![image-20220211112827602](https://www.itbaizhan.com/wiki/imgs/image-20220211112827602.png)

面向对象的精髓，最能体现这一点的就是接口。为什么我们讨论设计模式都只针对具备了抽象能力的语言（比如C++、Java、C#等），就是因为设计模式所研究的，实际上就是如何合理的去抽象。

### **接口的作用**

**· 为什么需要接口?接口和抽象类的区别?**

> 接口就是比“抽象类”还“抽象”的“抽象类”，可以更加规范的对子类进行约束。全面地专业地实现了：**规范和具体实现的分离**。



> 接口是两个模块之间通信的标准，通信的规范。如果能把你要设计的模块之间的接口定义好，就相当于完成了系统的设计大纲，剩下的就是添砖加瓦的具体实现了。大家在工作以后，做系统时往往就是使用“面向接口”的思想来设计系统。



**接口和实现类不是父子关系，是实现规则的关系。**比如：我定义一个接口Runnable，Car实现它就能在地上跑，Train实现它也能在地上跑，飞机实现它也能在地上跑。就是说，如果它是交通工具，就一定能跑，但是一定要实现Runnable接口。



### **如何定义和使用接口**

**声明格式：**

```java
[访问修饰符] interface 接口名  [extends 父接口1，父接口2…]  {
常量定义；   
方法定义；
}
```

**定义接口的详细说明：**

- **访问修饰符：**==只能是public或默认。==
- **接口名：**和类名采用相同命名机制。
- **extends：**==接口可以多继承。==
- **常量：**==接口中的属性只能是常量，总是：public static final 修饰。不写也是。==
- **方法：**接口中的方法只能是：public abstract。 省略的话，也是public abstract。

> **要点**
>
> - 子类通过**implements**来实现接口中的规范。
> - 接口不能创建实例，==但是可用于声明引用变量类型。==
> - 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
> - JDK1.8（不含8）之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。
>
> **JDK1.8（含8）后，接口中可以包含普通的静态方法、默认方法。**

【示例】接口的使用

```java
public class TestInterface {
    public static void main(String[ ] args) {
        Volant volant = new Angel();
        volant.fly();
    System.out.println(Volant.FLY_HIGHT);
    
    Honest honest = new GoodMan();
    honest.helpOther();
    }
}
/**飞行接口*/
interface Volant { 
    int FLY_HIGHT = 100; // 总是：public static final类型的；
    void fly();  //总是：public abstract void fly();
}
/**善良接口*/
interface Honest { 
    void helpOther();
}
/**Angel类实现飞行接口和善良接口*/
class Angel implements Volant, Honest{
    public void fly() {
        System.out.println("我是天使，飞起来啦！");
    }
    public void helpOther() {
        System.out.println("扶老奶奶过马路！");
    }
}
class GoodMan implements Honest {
    public void helpOther() {
        System.out.println("扶老奶奶过马路！");
    } 
}
class BirdMan implements Volant {
    public void fly() {
        System.out.println("我是鸟人，正在飞！");
    }
}

```

执行结果：

![image-20220211113144108](https://www.itbaizhan.com/wiki/imgs/image-20220211113144108.png)

- 子类通过**implements**来实现接口中的规范。
- 接口不能创建实例，==但是可用于声明引用变量类型。==
- 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
- JDK1.8（不含8）之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。

**JDK1.8（含8）后，接口中可以包含普通的静态方法、默认方法。**

**实时效果反馈**

**1. 关于接口的说法，错误的是:**

A 子类通过**implements**来实现接口中的规范

B 接口能创建实例

C 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的

D JDK1.8（含8）后，接口中可以包含普通的静态方法、默认方法

**答案**

1=>B

###  **接口中定义静态方法和默认方法(JDK8)**

JAVA8之前，接口里的方法要求全部是抽象方法。

JAVA8（含8）之后，以后允许在接口里定义==默认方法==和==静态方法。==

![image-20220211113226313](https://www.itbaizhan.com/wiki/imgs/image-20220211113226313.png)

![image-20220211113248315](https://www.itbaizhan.com/wiki/imgs/image-20220211113248315.png)

### **JDK8新特性_默认方法**

Java 8及以上新版本，==**允许给接口添加一个非抽象的方法实现**，==只需要使用 `default `关键字即可，这个特征又叫做默认方法（也称为扩展方法）。



默认方法和抽象方法的区别是抽象方法必须要被实现，默认方法不是。作为替代方式，接口可以提供默认方法的实现，所有这个接口的实现类都可以得到默认方法。



**课堂代码**

```java
public class Test {
  public static void main(String[] args) {
    A a = new Test_A();
    a.moren();
   }
}


interface A {


  default void moren(){
    System.out.println("我是接口A中的默认方法！");
   }
}


class Test_A implements A {
  
  @Override
  public void moren() {
    System.out.println("Test_A.moren");
   }
}

```

 

### **JDK8新特性_静态方法**

![image-20220211113445521](https://www.itbaizhan.com/wiki/imgs/image-20220211113445521.png)

JAVA8以后，我们也可以在接口中直接定义静态方法的实现。==这个静态方法直接从属于接口==（接口也是类，一种特殊的类），==可以通过接口名调用。==

如果子类中定义了相同名字的静态方法，那就是完全不同的方法了，直接从属于子类。可以通过子类名直接调用。

```java
public class Test {
  public static void main(String[] args) {
    A.staticMethod();
    Test_A.staticMethod();
   }
}
interface A {
  public static void staticMethod(){
    System.out.println("A.staticMethod");
   }


}
class Test_A implements A {
  public static void staticMethod(){
    System.out.println("Test_A.staticMethod");
   }
}

```

**静态方法和默认方法**

==本接口的默认方法中可以调用静态方法。==

```java
public class Test {
  public static void main(String[] args) {
    A a = new Test_A();
    a.moren();
   }
}


interface A {


  public static void staticMethod(){
    System.out.println("A.staticMethod");
   }


  public default void moren(){
    staticMethod();
    System.out.println("A.moren");
   }


}


class Test_A implements A {
  public static void staticMethod(){
    System.out.println("Test_A.staticMethod");
   }
}

```

 

### **接口的多继承**

接口支持多继承。和类的继承类似，子接口extends父接口，会获得父接口中的一切。

![image-20220211113822693](https://www.itbaizhan.com/wiki/imgs/image-20220211113822693.png)

【示例】接口的多继承

```java
interface A {
    void testa();
}
interface B {
    void testb();
}
/**接口可以多继承：接口C继承接口A和B*/
interface C extends A, B {
    void testc();
}
public class Test implements C {
    public void testc() {
    }
    public void testa() {
    }
    public void testb() {
    }
}
```

> **老鸟建议**
>
> 接口语法本身非常简单，但是如何真正使用？这才是大学问。我们需要后面在项目中反复使用，大家才能体会到。 学到此处，能了解基本概念，熟悉基本语法，就是“好学生”了。 请继续努力！再请工作后，闲余时间再看看上面这段话，相信你会有更深的体会。

## **字符串String类详解**

String是最常用的类，要掌握String类常见的方法，它底层实现也需要掌握好，不然在工作开发中很容易犯错。

![image-20220211114433865](https://www.itbaizhan.com/wiki/imgs/image-20220211114433865.png)

- String类又称作不可变字符序列。
- String位于java.lang包中，Java程序默认导入java.lang包下的所有类。
- Java字符串就是**Unicode字符序列**，例如字符串“Java”就是4个Unicode字符’J’、’a’、’v’、’a’组成的。
- Java没有内置的字符串类型，而是在标准Java类库中提供了一个预定义的类String，每个用双引号括起来的字符串都是String类的一个实例。

【示例】String类的简单使用

```java
String e = ""  ; // 空字符串
String greeting = " Hello World ";
```

【示例】"+"连接符

```java
int age = 18;
String str = "age is" + age; //str赋值为"age is 18"
//这种特性通常被用在输出语句中：
System.out.println("age  is" + age);
```

### **String类和常量池**

![image-20220211141838390](https://www.itbaizhan.com/wiki/imgs/image-20220211141838390.png)

Java内存分析中，我们会经常听到关于“常量池”的描述，实际上常量池也分了以下三种：

```java
1. 全局字符串常量池
2. class文件常量池
3. 运行时常量池(Runtime Constant Pool)
```

我们只关注运行时常量池即可。



【示例】字符串相等判断（以后一般判断字符串值是否相等，使用equals()）

```java
String g1 = "北京尚学堂";
String g2 = "北京尚学堂";
String g3 = new String("北京尚学堂");


System.out.println(g1 == g2);  // true
System.out.println(g1 == g3);  // false
System.out.println(g1.equals(g3));  //true


```

**实时效果反馈**

**1. 如下代码的说法，正确的是:**

```java
String a = "百战程序员";
String b = new String("百战程序员");
```

A a和b是同一个对象

B a和b不是一个对象

C `a==b`返回的值是`true`

D `a.equals(b)`返回的值是`false`

**答案**

1=>B

 **阅读API文档**

**· 如何下载API文档**

1. 下载地址，点击进入：

https://www.oracle.com/java/technologies/javase-jdk8-doc-downloads.html

**· 查看API文档**

下载成功后，解压下载的压缩文件，点击进入docs/api下的index.html文件即可。



**· API文档如何阅读**

![image-20220211142005705](https://www.itbaizhan.com/wiki/imgs/image-20220211142005705.png)

### **String类常用的方法**

String类是我们最常使用的类。列出常用的方法，请大家熟悉。

**String类的常用方法列表**

| **方法**                                      | **解释说明**                                                 |
| --------------------------------------------- | ------------------------------------------------------------ |
| char charAt(int index)                        | 返回字符串中第index个字符                                    |
| boolean equals(String other)                  | 如果字符串与other相等，返回true；否则，返回false。           |
| boolean equalsIgnoreCase(String other)        | 如果字符串与other相等（忽略大小写），则返回true；否则，返回false。 |
| int indexOf(String str)                       | 返回从头开始查找第一个子字符串str在字符串中的索引位置。如果未找到子字符串str，则返回-1。 |
| lastIndexOf()                                 | 返回从末尾开始查找第一个子字符串str在字符串中的索引位置。如果未找到子字符串str，则返回-1。 |
| int length()                                  | 返回字符串的长度。                                           |
| String replace(char oldChar,char newChar)     | 返回一个新串，它是通过用 newChar 替换此字符串中出现的所有oldChar而生成的。 |
| boolean startsWith(String prefix)             | 如果字符串以prefix开始，则返回true。                         |
| boolean endsWith(String prefix)               | 如果字符串以prefix结尾，则返回true。                         |
| String substring(int beginIndex)              | 返回一个新字符串，该串包含从原始字符串beginIndex到串尾。     |
| String substring(int beginIndex,int endIndex) | 返回一个新字符串，该串包含从原始字符串beginIndex到串尾或endIndex-1的所有字符。 |
| String toLowerCase()                          | 返回一个新字符串，该串将原始字符串中的所有大写字母改成小写字母。 |
| String toUpperCase()                          | 返回一个新字符串，该串将原始字符串中的所有小写字母改成大写字母。 |
| String trim()                                 | 返回一个新字符串，该串删除了原始字符串头部和尾部的空格。     |

【示例】String类常用方法一\

```java
public class StringTest1 {
    public static void main(String[ ] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//提取下标为3的字符
        System.out.println(s2.length());//字符串的长度
        System.out.println(s1.equals(s2));//比较两个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//比较两个字符串（忽略大小写）
    	System.out.println(s1.indexOf("Java"));//字符串s1中是否包含Java
        System.out.println(s1.indexOf("apple"));//字符串s1中是否包含apple
        String s = s1.replace(' ', '&');//将s1中的空格替换成&
        System.out.println("result is :" + s);
    }
}
```

执行结果如图所示：

![image-20220211142248907](https://www.itbaizhan.com/wiki/imgs/image-20220211142248907.png)

【示例】String类常用方法二

```java
public class StringTest2 {
    public static void main(String[ ] args) {
        String s = "";
        String s1 = "How are you?";
        System.out.println(s1.startsWith("How"));//是否以How开头
        System.out.println(s1.endsWith("you"));//是否以you结尾
        s = s1.substring(4);//提取子字符串：从下标为4的开始到字符串结尾为止
        System.out.println(s);
        s = s1.substring(4, 7);//提取子字符串：下标[4, 7) 不包括7
        System.out.println(s);
        s = s1.toLowerCase();//转小写
        System.out.println(s);
        s = s1.toUpperCase();//转大写
        System.out.println(s);
        String s2 = "  How old are you!! ";
        s = s2.trim();//去除字符串首尾的空格。注意：中间的空格不能去除
        System.out.println(s);
        System.out.println(s2);//因为String是不可变字符串，所以s2不变
    }
}
```

执行结果如图所示：

![image-20220211142426612](https://www.itbaizhan.com/wiki/imgs/image-20220211142426612.png)

### **字符串相等的判断**

- equals方法用来检测两个字符串内容是否相等。如果字符串s和t内容相等，则s.equals(t)返回true，否则返回false。
- 要测试两个字符串除了大小写区别外是否是相等的，需要使用equalsIgnoreCase方法。
- 判断字符串是否相等不要使用`==`。



【示例】忽略大小写的字符串比较

```java
"Hello".equalsIgnoreCase("hellO");//true
```



【示例】字符串的比较：`= =`与`equals()`方法

```java
public class TestStringEquals {
    public static void main(String[ ] args) {
        String g1 = "北京尚学堂";
        String g2 = "北京尚学堂";
        String g3 = new String("北京尚学堂");
        System.out.println(g1 == g2); // true  指向同样的字符串常量对象
        System.out.println(g1 == g3); // false  g3是新创建的对象
        System.out.println(g1.equals(g3)); // true  g1和g3里面的字符串内容是一样的
    }
}
```

执行结果如图5-33所示：

![image-20220211142824723](https://www.itbaizhan.com/wiki/imgs/image-20220211142824723.png)

示例内存分析如图所示：

![image-20220211142936764](https://www.itbaizhan.com/wiki/imgs/image-20220211142936764.png)

## **内部类**

我们把一个类放在另一个类的内部定义，称为内部类(inner class)。

![image-20220211143001857](https://www.itbaizhan.com/wiki/imgs/image-20220211143001857.png)

**内部类的两个要点：**

- 内部类提供了更好的封装。只能让外部类直接访问，不允许同一个包中的其他类直接访问。
- 内部类可以直接访问外部类的私有属性，内部类被当成其外部类的成员。但外部类不能访问内部类的内部属性。

> **注意**
>
> 内部类只是一个编译时概念，一旦我们编译成功，就会成为完全不同的两个类。对于一个名为Outer的外部类和其内部定义的名为Inner的内部类。编译完成后会出现Outer.class和Outer$Inner.class两个类的字节码文件。所以内部类是相对独立的一种存在，其成员变量/方法名可以和外部类的相同。

【示例】内部类的定义和使用

```java
/**外部类Outer*/
class Outer {
    private int age = 10;
    public void show(){
        System.out.println(age);//10
    }
    /**内部类Inner*/
    public class Inner {
        //内部类中可以声明与外部类同名的属性与方法
        private int age = 20;
        public void show(){
            System.out.println(age);//20
        }
    }
}
```

编译后会产生两个不同的字节码文件，如图所示：

![image-20220211143213384](https://www.itbaizhan.com/wiki/imgs/image-20220211143213384.png)

### **内部类的分类**

![image-20220211143242793](https://www.itbaizhan.com/wiki/imgs/image-20220211143242793.png)

**非静态内部类**

**非静态内部类（外部类里使用非静态内部类和平时使用其他类没什么不同）**

1. 非静态内部类对象必须寄存在一个外部类对象里。因此，如果有一个非静态内部类对象那么一定存在对应的外部类对象。非静态内部类对象单独属于外部类的某个对象。
2. 非静态内部类可以直接访问外部类的成员，但是外部类不能直接访问非静态内部类成员。
3. 非静态内部类不能有静态方法、静态属性和静态初始化块。
4. **成员变量访问要点：**
   - 内部类属性：this.变量名。
   - 外部类属性：外部类名.this.变量名。

【示例】内部类中访问成员变量

```java
/**外部类Outer1*/
class Outer1 {
  private int age = 10;
  public void show(){
   System.out.println(age);//10
  }
  /**内部类Inner*/
  public class Inner1 {
   //内部类中可以声明与外部类同名的属性与方法
   private int age = 20;
   public void show(){
     System.out.println(age);//20
     System.out.println(Outer1.this.age); //10  访问外部类的普通属性
    }
  }
}

```

**内部类的访问：**

\1. 外部类中定义内部类：new Inner()。

\2. 外部类以外的地方使用非静态内部类：

Outer.Inner varname = new Outer().new Inner()。

【示例】内部类的访问

```java
/**
 * 测试非静态内部类
 */
public class TestInnerClass1 {
  public static void main(String[ ] args) {
   //先创建外部类实例，然后使用该外部类实例创建内部类实例
   Outer1.Inner1 inner = new Outer1().new Inner1();
   inner.show();
  }
}

```

**静态内部类**

**定义方式：**

```java
static class  ClassName {
//类体
}
```

**使用要点：**

1. 静态内部类可以访问外部类的静态成员，不能访问外部类的普通成员。
2. 静态内部类看做外部类的一个静态成员。



【示例】静态内部类的访问

```java
/*
测试静态内部类
 */
class Outer2{
  private int a = 10;
  private static int b = 20;
  //相当于外部类的一个静态成员
  static class Inner2{
   public void test(){
//    System.out.println(a);  //静态内部类不能访问外部类的普通属性
     System.out.println(b); //静态内部类可以访问外部类的静态属性
    }
  }
}
public class TestStaticInnerClass {
  public static void main(String[ ] args) {
   //通过 new 外部类名.内部类名() 来创建内部类对象
   Outer2.Inner2 inner =new Outer2.Inner2();
   inner.test();
  }
}

```

**匿名内部类**

适合那种只需要使用一次的类。比如：键盘监听操作等等。在安卓开发、awt、swing开发中常见。

**语法：**

```java
new 父类构造器(实参类表) \实现接口 () {
          //匿名内部类类体！
}
```

【示例】匿名内部类的使用

```java
/**
 * 测试匿名内部类
 */
public class TestAnonymousInnerClass {
  public void test1(A a) {
    a.run();
   }
  public static void main(String[] args) {
    TestAnonymousInnerClass tac = new TestAnonymousInnerClass();
    tac.test1(new A() {
      @Override
      public void run() {
        System.out.println("匿名内部类测试!  我是新定义的第一个匿名内部类！");
       }
     });
    tac.test1(new A() {
      @Override
      public void run() {
        System.out.println("我是新定义的第二个匿名内部类");
       }
     });
   }
}
interface A {
  void run();
}

```

> **注意**
>
> - 匿名内部类没有访问修饰符。
> - 匿名内部类没有构造方法。因为它连名字都没有那又何来构造方法呢。

**局部内部类**

定义在方法内部的，作用域只限于本方法，称为局部内部类。

局部内部类在实际开发中应用很少。

【示例】方法中的内部类

```java
/**
 * 测试局部内部类
 */
public class TestLocalInnerClass {
  public void show() {
    //作用域仅限于该方法
    class Inner3 {
      public void fun() {
        System.out.println("helloworld");
       }
     }
    new Inner3().fun();
   }
  public static void main(String[ ] args) {
    new TestLocalInnerClass().show();
   }
}

```

 