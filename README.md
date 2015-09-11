>#飞机大战

##一. 游戏部分截图

1.  开始游戏界面（游戏暂停通过`空格`控制）<br><br>
	![start](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/start.jpg "游戏开始") 
2.  游戏结束界面（按`Enter`键重新开始游戏）<br><br>
	![over](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/over.jpg "游戏结束")

##二. 开发中的关键点

1. 	如何在使用java中的awt进行界面的创建<br>
2.	如何设计飞机类和子弹类，并实现在`区域边缘`的逻辑。<br>
3.	如何进行碰撞检测。<br>
4.	如何使用`键盘控制`整个游戏。

##三. 设计思想

* 游戏整体应用Java封装特性，创建两个包：com.valueyouth.gameFrame和com.vlaueyouth.util。
* 前一个包中，分别创建游戏框架类，飞机类和子弹类。在后一个包中，创建常量类，游戏工具类和游戏父框架类。
* 在飞机类中，主要是对飞机一些动作的方法。比如，使用键位控制飞机的飞行，飞机的速度，飞机的初始化等。
* 在子弹类中，主要是对子弹的一些方法。比如，子弹的初始化，子弹的飞行速度，子弹碰壁后的反弹等。

##四. 项目结构图

1. 游戏主题结构<br><br>
   ![plane-game](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/one.png "主体结构")
2. util包<br><br>
   ![plane-game](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/two.png "util包")
3. gameFrame包<br><br>
   ![plane-game](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/two.png "gameFrame包")

##五. 设计技巧
1.  Plane类和Bullet类都继承GameObject类。减少代码量，增强了结构之间的连贯性。向高内聚与低耦合的方向靠近。
2.	使用双缓冲技术，来消除游戏画面的闪烁。
3.	应用封装的思想，将属于Plane类中的属性与方法，统一放到Plane类。其中包括：初始化飞机，重绘飞机，按键控制飞机的飞行，飞机边缘逻辑。
4.	游戏暂停的实现。定义信号变量PAUSE。当PAUSE为false时，执行线程中的repaint()方法，否则，什么也不执行。确定PAUSE的值：<br>
在Constant类中设置变量count，用来统计按下空格键的次数。用count % 2 的结果与0进行比较，若为真，就将PAUSE置为false。否则<br>
否则，置为true。


