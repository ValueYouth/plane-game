package com.valueyouth.planeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.valueyouth.util.Constant;
import com.valueyouth.util.GameUtil;
import com.valueyouth.util.MyFrame;


public class GameFrame extends MyFrame
{
	private static final long	serialVersionUID	= 1L;
	
	Image bg = GameUtil.getImage("images/bg.png") ;
	Plane plane = new Plane("images/plane.png", 100, 100, 10) ;
	Image restart = GameUtil.getImage("images/restart.png") ;
	ArrayList bulletList = new ArrayList() ;
	
	private static GameFrame gameFrame ;
	
	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null) ;
		plane.draw(g);

		
		for (int i = 0; i < bulletList.size(); i++)
		{
			Bullet b = (Bullet)bulletList.get(i) ;
			
			b.draw(g);
			
			// 检测与飞机的碰撞
			
			boolean collide = b.getRect().intersects(plane.getRect()) ;
			
			if (collide)
			{
				plane.setLive(false) ;
			}
			
		}
		
		// 游戏结束的提示信息
		if (!plane.isLive())
		{
			GameInfo(g, "GAME OVER", Color.RED, Constant.GAME_WIDTH / 2 - 150,
					Constant.GAME_HEIGHT / 2 - 120, 50) ;
			GameInfo(g, "存活时间：" + Constant.seconds + "s",
					Color.GRAY, 160, 300, 20) ;
			level(g) ;
			g.drawImage(restart, 120, 420, null) ;
			stop() ;
		}
		else
		{
			GameInfo(g, "时间：" + Constant.seconds, Color.GRAY, 380, 50, 15) ; 			
		}
		
	}
	
	// 游戏结束的提示信息
	
	public void GameInfo(Graphics g, String info, Color color, int x, int y, int size)
	{
		Font font = new Font(null, Font.BOLD, size) ;
		
		g.setFont(font);
		Color oldColor = g.getColor() ;
		g.setColor(color);
		g.drawString(info, x, y);
		g.setColor(oldColor);
	}
	
	// 显示你的等级
	
	public void level(Graphics g)
	{
		GameInfo(g, "获得称号：", Color.GRAY, 160, 340, 20) ;
		
		switch(Constant.seconds / 10)
		{
		case 0:
			GameInfo(g, "小菜鸟", Color.DARK_GRAY, 260, 340, 20) ;
			break ;
			
		case 1:
			GameInfo(g, "菜鸟", Color.BLUE, 260, 340, 20) ;
			break;
			
		case 2:
			GameInfo(g, "秀才", Color.CYAN, 260, 340, 20) ;
			break;
			
		case 3:
			GameInfo(g, "举人", Color.GREEN, 260, 340, 20) ;
			break;
			
		case 4:
			GameInfo(g, "状元", Color.YELLOW, 260, 340, 20) ;
			break;
			
		default:
			GameInfo(g, "无敌", Color.WHITE, 260, 340, 20) ;
			break ;
				
		}
	}
	
	
	// 重写父类的launchFrame()方法
	
	public void launchFrame()
	{
		super.launchFrame();
	
		addKeyListener(new KeyMonitor()) ; // 增加键盘的监听器
		
		// 生成一堆子弹
		
		for (int i = 0; i < 20; i++)
		{
			Bullet b = new Bullet() ;
			bulletList.add(b) ;
		}
	}
	
	// 定义内部类，可以方便地使用外部类的普通属性
	
	class KeyMonitor extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			plane.addDirection(e);
			
			if ( plane.isLive() && e.getKeyCode() == KeyEvent.VK_SPACE )
			{
				Constant.count++ ;
				if ( 0 == Constant.count % 2 )
				{
					Constant.PAUSE = false ;
				}
				else
				{
					Constant.PAUSE = true ;
				}
				
			}
			
			if ( !plane.isLive() && e.getKeyCode() == KeyEvent.VK_ENTER )
			{
				restart() ;
			}
		}
		
		public void keyReleased(KeyEvent e)
		{
			plane.deDirection(e);
		}
	}
	
	/**
	 * 重新启动游戏
	 */
	public void restart()
	{
		
		gameFrame.dispose();
		gameFrame = null ;
		Constant.seconds = 0 ;

		gameFrame = new GameFrame() ;
		gameFrame.launchFrame();
	}
	
	
	
	public static void main(String[] args)
	{
		gameFrame = new GameFrame() ;
		gameFrame.launchFrame();
	}
}
