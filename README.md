#飞机大战

##一. 游戏部分截图

1.  开始游戏界面（游戏暂停通过`空格`控制）<br><br>
	![start](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/start.jpg "游戏开始")  
	![over](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/over.jpg "游戏结束")
##一. 开发中的关键点

1. 	如何在使用java中的awt进行界面的创建<br>
2.	如何设计飞机类和子弹类，并实现在区域边缘的逻辑。<br>
3.	如何进行碰撞检测<br>
4.	如何使用键盘控制整个游戏。

##二. 设计思想

* 游戏整体应用Java封装特性，创建两个包：com.valueyouth.gameFrame和com.vlaueyouth.util。
* 前一个包中，分别创建游戏框架类，飞机类和子弹类。在后一个包中，创建常量类，游戏工具类和游戏父框架类。
* 在飞机类中，主要是对飞机一些动作的方法。比如，使用键位控制飞机的飞行，飞机的速度，飞机的初始化等。
* 在子弹类中，主要是对子弹的一些方法。比如，子弹的初始化，子弹的飞行速度，子弹碰壁后的反弹等。

##三. 项目结构图

1. 游戏主题结构<br><br>
   ![plane-game](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/one.png "主体结构")
2. util包<br><br>
   ![plane-game](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/two.png "util包")
3. gameFrame包<br><br>
   ![plane-game](https://raw.githubusercontent.com/ValueYouth/plane-game/master/src/images/two.png "gameFrame包")

