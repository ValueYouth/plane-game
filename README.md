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
1. Plane类和Bullet类都继承GameObject类。减少代码量，增强了结构之间的连贯性。向高内聚与低耦合的方向靠近。
2. 使用双缓冲技术，来消除游戏画面的闪烁。
3. 应用封装的思想，将属于Plane类中的属性与方法，统一放到Plane类。其中包括：初始化飞机，重绘飞机，按键控制飞机的飞行，飞机边缘逻辑。
4. 游戏暂停的实现。
   * 定义信号变量PAUSE。当PAUSE为false时，执行线程中的repaint()方法，否则，什么也不执行。
   * 确定PAUSE的值：在Constant类中设置变量count，用来统计按下空格键的次数。
     用count % 2 的结果与0进行比较，若为真  ，就将PAUSE置为false。否则，置为true。

##六. 开发后记
   开发这个小游戏的初衷，是为了加深自己对java语言一些特性的理解。
   众所周知，在现在这个阶段，awt显然基本已经被时代淘汰，断然没有了它初始时的风光。:sob:虽然它已风光不再，但对于我来说，这就已经足够了。自己也曾经问过老师，MFC现在学还有用么？老师说了一句很有用的话：MFC是过时了，但是其中包含的一些思想，却永远不会过时的。现在想来，确实如此。大二时我可是疯狂买进了好几本重量级的关于Windows桌面开发的书籍，比如：《深入浅出MFC》，《Windows程序设计 第五版》等。MFC只看了其几章与C++有关的部分，真正认真阅读的是后一本书。由于整本书太厚，被我无情的使用武力劈成了2半。从窗口的注册到创建，再到第一个窗口界面，再到最后子窗口和菜单栏。一点一点，日积月累。由于时间有限，下半本还处于崭新状态。虽然这都是过时，老掉牙的东西，但其中真的有很多思想值得学习。比如，windows消息传递机制，编码问题，回调机制等等。而且，我认为，在这些前沿的技术中，这些旧的还有自己的身影。没有旧技术的牢靠基石，哪会有新技术的风光？难道新技术会凭空出现？
   在开发的过程中，可谓是困难重重。从刚开始的创建一个游戏界面（awt算是临时了解，所以创建游戏界面算是从头开始:feet:），到子弹“碰壁”后的处理，也就是边缘处理，再到最后的时间加入，每一次都充斥这痛苦与激动。还记得最后要加入一个功能————对空格键的映射：通过按下空格键控制游戏的暂停和继续。由于自己对awt中的重绘机制不是很了解，因此只能到网上进行“海搜”。诸如“向游戏进程中加入信号量”，“通过同步，向游戏中加入锁”等，自己依然无法理解，当然也就无法向程序中加入。就这样在这个问题上困惑了半天。当天下午，也许是上帝眷顾自己吧。自己无心地在paint线程中，屏蔽了repaint()方法，继续运行游戏，发现游戏画面静止了。我突然间就有了灵感：设置一个信号量（boolean），通过空格键控制这个通过一个信号量的值，进而控制repaint()方法的执行。这不就实现空格的控制逻辑了么？:sunglasses:而完成这几句代码的实现，不过花了几分钟而已。
   所有的问题都迎刃而解了，自己心情格外开朗啊。看着对面那个欧美宾馆，
   我：哎，小5啊。奇怪，为什么这么早对面欧美宾馆标志怎么就亮了呢？
   小5：你tm眼花了吧。看清楚了，那反射的是太阳光啊！
   然后，我就小跳着去卫生间洗脸了。:joy:

