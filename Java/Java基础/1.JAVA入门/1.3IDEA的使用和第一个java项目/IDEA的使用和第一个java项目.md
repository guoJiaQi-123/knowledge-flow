## IDEA的使用（开发神器）

![image-20220209185144451](https://www.itbaizhan.com/wiki/imgs/image-20220209185144451.png)

IDEA 全称 IntelliJ IDEA，是java编程语言开发的集成环境，被公认为最好的java开发工具之一。IDEA目前市场占有率越来越高，流行度也越来越高。

三大神器：

- IDEA 官方网址： http://www.jetbrains.com/idea/
- VS Code 官方网址：https://code.visualstudio.com/
- eclipse 官方网址：[http://www.eclipse.org](http://www.eclipse.org/)



### **IDEA使用10分钟入门**

在开发工具匮乏的年代，第一代Java程序员都是从文本编辑器开始训练自己的代码，从而一步步成为高手，这是一种无奈，而不是一种必须。

我们认为，现在横在入门初学者最大的障碍在于“是否能激发兴趣，解决问题，体验到编程的快乐”，而不是讨论是该用记事本还是eclipse、还是IDEA。

是否使用或坚持记事本编程不是成为高手的必要条件，而“激发兴趣，保持兴趣”确是成为高手的必要条件。也基于我们的理念“快速入门，快速实战”，我们一开始就引入IDEA，让初学者更容易的激发兴趣，体验学习的快乐。

### **下载和安装IDEA**

下载地址：

[https://www.jetbrains.com/idea/download/#section=windows](https://www.itbaizhan.com/wiki/12047.html?status=iframe#section=windows) ，出现图1-25所示下载界面。下载完成后，安装即可。

![image-20220209185555378](https://www.itbaizhan.com/wiki/imgs/image-20220209185555378.png)

![image-20220209185640849](https://www.itbaizhan.com/wiki/imgs/image-20220209185640849.png)

![image-20220209185734627](https://www.itbaizhan.com/wiki/imgs/image-20220209185734627.png)

![image-20220209185801144](https://www.itbaizhan.com/wiki/imgs/image-20220209185801144.png)

![image-20220209185834667](https://www.itbaizhan.com/wiki/imgs/image-20220209185834667.png)

## **IDEA的配置和使用**

![image-20220210093744724](https://www.itbaizhan.com/wiki/imgs/image-20220210093744724.png)

### **初始配置IDEA**

1. 导入以前的IDEA设置，或者没有导入的设置，选择第二个。

![image-20220210093851671](https://www.itbaizhan.com/wiki/imgs/image-20220210093851671.png)

## **在IDEA中创建Java项目**

点击欢迎界面“Create New Project”，创建新的项目。

也可以进入主界面后，在快捷菜单中依次选择file-->new-->project，开始新建Java项目。

1. 选择JDK

   ![image-20220210093956751](https://www.itbaizhan.com/wiki/imgs/image-20220210093956751.png)

2. 根据项目模板创建项目

   ![image-20220210094208968](https://www.itbaizhan.com/wiki/imgs/image-20220210094208968.png)

3. 填写项目名称和包名

   ![image-20220210094251457](https://www.itbaizhan.com/wiki/imgs/image-20220210094251457.png)

4. 开始编写代码

![image-20220210094351976](https://www.itbaizhan.com/wiki/imgs/image-20220210094351976.png)

### **使用IDEA开发和运行Java程序**

**新建一个java类**

我们在上一节建好的Java项目中，开始开发Java程序。首先，新建一个Java类。在src下面的包：com.bjsxt上右键单击，建立一个Java类。如图1-32所示。

![image-20220210094550680](https://www.itbaizhan.com/wiki/imgs/image-20220210094550680.png)

出现新建类的开始界面，如图1-33所示。我们只需输入类名即可，其他不需做任何设置：

![image-20220210094647248](https://www.itbaizhan.com/wiki/imgs/image-20220210094647248.png)

新建Java类成功，出现如图1-34所示。

![image-20220210094722913](https://www.itbaizhan.com/wiki/imgs/image-20220210094722913.png)

在src下面出现了Welcome.java文件。点击该文件后，出现该文件代码编辑区。

【示例1-2】使用IDEA开发Java程序

```java
public class Welcome {
    public static void main(String[ ] args) {
        System.out.println("hello");
    }
}
```

运行该程序：在代码上单击右键后，选择“Run 类名.main()”。或者直接点击右上角工具栏的运行按钮

![image-20220210095009606](https://www.itbaizhan.com/wiki/imgs/image-20220210095009606.png)

![image-20220210095127634](https://www.itbaizhan.com/wiki/imgs/image-20220210095127634.png)

界面下方的控制台（console）出现运行结果，如图1-36所示。

![image-20220210095525745](https://www.itbaizhan.com/wiki/imgs/image-20220210095525745.png)

至此，我们成功在IDEA中开发了我们的第一个Java程序！



**IDEA自动编译**

IDEA会自动执行javac进行编译，并且会将编译错误直接给出提示，一目了然，非常便于我们调试。如图1-37所示，我们故意将“println”错写为“Urintln”，此时IDEA则会提示编译错误。

![image-20220210095826144](https://www.itbaizhan.com/wiki/imgs/image-20220210095826144.png)

## **30分钟完成桌球小游戏项目**

![image-20220210101112132](https://www.itbaizhan.com/wiki/imgs/image-20220210101112132.png)

我们秉承“快速入门、快速实战”的理念，开发这套系列教材；就是希望朋友们在学习过程中，尽快进入实战环节，尽快介入项目，让大家更有兴趣、更有成就感，从而带来更大的学习动力。

如下的小项目，对于第一次接触编程的朋友从理解上会有难度。但是，我们这个项目不在于让大家理解代码本身，而是让大家“重在体验敲代码的感觉”。



**注意：**

**1.为了提高兴趣，听不懂没有关系。很多知识点需要后面再讲解！**

**2.其中的数学知识，听不懂也没关系。**

**3.对于有基础的同学，可以照着敲完。**

**4.对于零基础的同学，看一下即可，可以不敲。如果要敲，也就当做是一个打字练习。**

**5.** **千万不要沉迷在此！敲一敲就可以了，作为兴趣！**



**【项目】桌球游戏小项目**

练习目标：

1. 找到敲代码的感觉
2. 收获敲代码的兴趣
3. 作出效果，找到自信
4. 从一开始就学会调试错误
5. 掌握Java代码基本结构



**项目需求：**

桌球在球桌中按照一定线路和角度移动，遇到边框会自动弹回。

![image-20220210102006873](https://www.itbaizhan.com/wiki/imgs/image-20220210102006873.png)

**要求：**

即使看不太懂，也要照着敲如下游戏代码，至少5遍。要求所有字符和源文件一致。如果报异常，请细心看所在行和老师代码有何区别。现阶段不需要理解代码的语法功能，只要按照代码结构输入代码，能够经过调试实现代码的正常运行即可。



下面我们将分以下四个步骤来实现桌球游戏：

第一步：创建项目和窗口。

第二步：加载两个图片。

第三步：实现动画，小球沿着水平方向移动并做边界检测。

第四步：实现小球沿着任意角度飞行（会用到初中学习的三角函数，如果忘记了就想想你们的体育老师吧）。



【注】：源码和图片资源下载地址： [www.itbaizhan.cn](http://www.itbaizhan.cn/)

### **第一步：**绘制窗口

创建项目并拷贝图片：在项目名MyPro01上单击右键，在菜单中依次选择new---Folder，创建一个名称是images的文件夹，并复制两张图片到该目录下。并在src下创建类BallGame.java。

【示例1-3】桌球游戏代码—绘制窗口

```java
import javax.swing.JFrame;


public class BallGame extends JFrame {
    // 窗口加载
    void launchFrame() {
        setSize(300, 300);
        setLocation(400, 400);
        setVisible(true);
    }
    // main方法是程序执行的入口
    public static void main(String[ ] args) {
        System.out.println(" 我是尚学堂高淇，这个游戏项目让大家体验编程的快感，"
                + "寓教于乐！");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}

```

执行结果如图1-41所示：

![image-20220210103708601](https://www.itbaizhan.com/wiki/imgs/image-20220210103708601.png)

### **第二步：加载图片**

加载两个图片：我们要在BallGame类中添加小球和桌面的路径，并指定小球出现在窗口的的初始位置。然后添加paint方法，加载小球和桌面。代码如示例1-4所示。

先在项目下建立images文件夹，然后将两个图片拷贝到images目录下。

![image-20220210104147741](https://www.itbaizhan.com/wiki/imgs/image-20220210104147741.png)

【示例1-4】桌球游戏代码—加载图片

```java
import java.awt.*;
import javax.swing.JFrame;


public class BallGame extends JFrame {
  //添加小球和桌面图片的路径
  Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
  Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");
  //指定小球的初始位置
  double x=100; //小球的横坐标
  double y=100; //小球的纵坐标
  
  //画窗口的方法：加载小球与桌面
  public void paint(Graphics g){
    System.out.println("窗口被画了一次！");
    g.drawImage(desk, 0, 0, null);
    g.drawImage(ball, (int)x, (int)y, null);
   }
   
  //窗口加载
  void launchFrame(){
    setSize(856,500);
    setLocation(50,50);
    setVisible(true);
   }
   
  //main方法是程序执行的入口
  public static void main(String[ ] args){
    System.out.println(" 我是尚学堂高淇，这个游戏项目让大家体验编程的快感，"
             + "寓教于乐！");
    BallGame game = new BallGame();
    game.launchFrame();
   }
}

```

执行结果如图1-42所示：

![image-20220210104755078](https://www.itbaizhan.com/wiki/imgs/image-20220210104755078.png)

> **注意：**
>
> 由于懒加载问题，有可能出现第一次加载图片无效的情况；请最大化窗口再打开即可。稍后大家完成第三步后，就完全不存在这个问题了。

###  **第三步：**实现水平方向来回飞行

实现动画，小球沿着水平方向移动并做边界检测。 要实现动画的关键是改变小球的坐标，并且要不停的重画窗口来更新小球的坐标；边界检测则是判断小球的坐标是否超出桌面的范围，如果超出则要改变小球原来的运动方向。代码如示例1-5所示。

【示例1-5】桌球游戏代码—实现水平方向来回飞行

```java
import java.awt.*;
import javax.swing.JFrame;


public class BallGame extends JFrame {
  //添加小球和桌面图片的路径
  Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
  Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");
  
  //指定小球的初始位置
  double x=100; //小球的横坐标
  double y=100; //小球的纵坐标
  boolean right = true; //判断小球的方向
  
  //画窗口的方法：加载小球与桌面
  public void paint(Graphics g){
    System.out.println("窗口被画了一次！");
    g.drawImage(desk, 0, 0, null);
    g.drawImage(ball, (int)x, (int)y, null);
    
    //改变小球坐标
    if(right){
      x = x +10;      
     }else{
      x = x - 10;
     }
    //边界检测
    //856是窗口宽度，40是桌子边框的宽度，30是小球的直径
    if(x>856-40-30){  
      right = false;
     }
    if(x<40){    
      right = true;
     }
   }
   
  //窗口加载
  void launchFrame(){
    setSize(856,500);
    setLocation(50,50);
    setVisible(true);
    
    //重画窗口,每秒画25次
    while(true){
      repaint(); //调用repaint方法，窗口即可重画
      try{
        Thread.sleep(40);  //40ms, 1秒=1000毫秒.  大约一秒画25次窗口
       }catch(Exception e){
        e.printStackTrace();
       }
     }
   }
   
  //main方法是程序执行的入口
  public static void main(String[ ] args){
    System.out.println(" 我是尚学堂高淇，这个游戏项目让大家体验编程的快感，"
             + "寓教于乐！");
    BallGame game = new BallGame();
    game.launchFrame();
   }
}

```

### **第四步：**实现任意角度飞行

实现小球沿着任意角度飞行：此时小球的运动方向不能再单纯的使用right来表示，需要一个表示角度的变量degree，小球坐标的改变也要依据这个角度。代码如示例1-6所示（为了保存第三步的代码，我们新创建了一个类BallGame2）。

【示例1-6】桌球游戏代码—实现任意角度飞行

```java
import java.awt.*;
import javax.swing.JFrame;


public class BallGame2 extends JFrame {
  //添加小球和桌面图片的路径
  Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
  Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");
  
  //指定小球的初始位置
  double x=100; //小球的横坐标
  double y=100; //小球的纵坐标
  double degree = 3.14/3; //弧度：小球的运动角度，此处就是60度
  
  //画窗口的方法：加载小球与桌面
  public void paint(Graphics g){
    System.out.println("窗口被画了一次！");
    g.drawImage(desk, 0, 0, null);
    g.drawImage(ball, (int)x, (int)y, null);
    
    //根据角度degree改变小球坐标
    x = x+ 10*Math.cos(degree);
    y = y +10*Math.sin(degree);
    
    //边界检测：碰到上下边界
    //500是窗口高度；40是桌子边框，30是球直径；最后一个40是标题栏的高度
    if(y>500-40-30||y<40+40){
      degree = -degree;
     }
    //边界检测：碰到左右边界
    //856是窗口宽度，40是桌子边框的宽度，30是小球的直径
    if(x<40||x>856-40-30){
      degree = 3.14 - degree;
     }
   }
   
  //窗口加载
  void launchFrame(){
    setSize(856,500);
    setLocation(50,50);
    setVisible(true);
    
    //重画窗口,每秒画25次
    while(true){
      repaint(); //调用repaint方法，窗口即可重画
      try{
        Thread.sleep(40);  //40ms,1秒=1000毫秒.  大约一秒画25次窗口
       }catch(Exception e){
        e.printStackTrace();
       }
     }
   }
   
  //main方法是程序执行的入口
  public static void main(String[ ] args){
    System.out.println(" 我是尚学堂高淇，这个游戏项目让大家体验编程的快感，"
             + "寓教于乐！");
    BallGame2 game = new BallGame2();
    game.launchFrame();
   }
}

```

### **本节作业**

1. 使用IDEA创建java项目，并创建一个java程序。
2. 使用IDEA，完全照着课程，字母都保持一致。照着实现桌球小游戏项目。【不需要理解，这个练习，重在寓教于乐，引起兴趣】