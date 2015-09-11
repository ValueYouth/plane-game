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
			
			// �����ɻ�����ײ
			
			boolean collide = b.getRect().intersects(plane.getRect()) ;
			
			if (collide)
			{
				plane.setLive(false) ;
			}
			
		}
		
		// ��Ϸ��������ʾ��Ϣ
		if (!plane.isLive())
		{
			GameInfo(g, "GAME OVER", Color.RED, Constant.GAME_WIDTH / 2 - 150,
					Constant.GAME_HEIGHT / 2 - 120, 50) ;
			GameInfo(g, "���ʱ�䣺" + Constant.seconds + "s",
					Color.GRAY, 160, 300, 20) ;
			level(g) ;
			g.drawImage(restart, 120, 420, null) ;
			stop() ;
		}
		else
		{
			GameInfo(g, "ʱ�䣺" + Constant.seconds, Color.GRAY, 380, 50, 15) ; 			
		}
		
	}
	
	// ��Ϸ��������ʾ��Ϣ
	
	public void GameInfo(Graphics g, String info, Color color, int x, int y, int size)
	{
		Font font = new Font(null, Font.BOLD, size) ;
		
		g.setFont(font);
		Color oldColor = g.getColor() ;
		g.setColor(color);
		g.drawString(info, x, y);
		g.setColor(oldColor);
	}
	
	// ��ʾ��ĵȼ�
	
	public void level(Graphics g)
	{
		GameInfo(g, "��óƺţ�", Color.GRAY, 160, 340, 20) ;
		
		switch(Constant.seconds / 10)
		{
		case 0:
			GameInfo(g, "С����", Color.DARK_GRAY, 260, 340, 20) ;
			break ;
			
		case 1:
			GameInfo(g, "����", Color.BLUE, 260, 340, 20) ;
			break;
			
		case 2:
			GameInfo(g, "���", Color.CYAN, 260, 340, 20) ;
			break;
			
		case 3:
			GameInfo(g, "����", Color.GREEN, 260, 340, 20) ;
			break;
			
		case 4:
			GameInfo(g, "״Ԫ", Color.YELLOW, 260, 340, 20) ;
			break;
			
		default:
			GameInfo(g, "�޵�", Color.WHITE, 260, 340, 20) ;
			break ;
				
		}
	}
	
	
	// ��д�����launchFrame()����
	
	public void launchFrame()
	{
		super.launchFrame();
	
		addKeyListener(new KeyMonitor()) ; // ���Ӽ��̵ļ�����
		
		// ����һ���ӵ�
		
		for (int i = 0; i < 20; i++)
		{
			Bullet b = new Bullet() ;
			bulletList.add(b) ;
		}
	}
	
	// �����ڲ��࣬���Է����ʹ���ⲿ�����ͨ����
	
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
	 * ����������Ϸ
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
