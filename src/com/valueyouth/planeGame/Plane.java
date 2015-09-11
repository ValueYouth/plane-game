package com.valueyouth.planeGame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.valueyouth.util.Constant;


public class Plane extends GameObject
{
	private boolean left, right, up, down ; 
	private boolean live = true ; // 飞机是否存活
	

	public Plane()
	{
		// 空的构造方法
	}
	
	public Plane(String path, double x, double y, int speed)
	{
		super(path, x, y, speed) ;
		
	}
	
	public boolean isLive()
	{
		return live;
	}

	
	public void setLive(boolean live)
	{
		this.live = live;
	}
	
	// 画出飞机
	
	public void draw(Graphics g)
	{
		if (live)
		{
			g.drawImage(image, (int)x, (int)y, null) ;
			move() ;
		}	
	}
	
	// 飞机的移动
	
	public void move()
	{
		if ( left && x >= 10 )
		{
			x -= speed ;
		}
		if ( right && x <= 400 )
		{
			x += speed ;
		}
		if ( up && y >= 35 )
		{
			y -= speed ;
		}
		if ( down && y <= 540 )
		{
			y += speed ;
		}
	}
	
	public void addDirection(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case 37: // 左键
				left = true ;
				break ;
			
			case 38: // 上键
				up = true ;
				break ;
				
			case 39: // 右键
				right = true ;
				break ;
				
			case 40: // 下键
				down = true ;
				break ;
	
			default:
				break ;
		}
	}
	
	public void deDirection(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case 37: // 左键
				left = false ;
				break ;
			
			case 38: // 上键
				up = false ;
				break ;
				
			case 39: // 右键
				right = false ;
				break ;
				
			case 40: // 下键
				down = false ;
				break ;
				
			default:
				break ;
		}
	}
	
	
	
	
	
	
	
}
