package com.valueyouth.planeGame;

import java.awt.Image;
import java.awt.Rectangle;

import com.valueyouth.util.GameUtil;


public class GameObject
{
	Image image ; // 物体的图片
	double x, y ; // 物体的坐标
	int speed ;   // 物体的速度
	int width, height ;
	
	
	public GameObject()
	{
		// 空的构造方法
	}
	
	public GameObject(Image image)
	{
		this.image = image;
		height = image.getHeight(null) ;
		width  = image.getWidth(null) ;
	}
	
	public GameObject(Image image, double x, double y, int speed)
	{
		this(image) ;
		
		this.x = x ;
		this.y = y ;
		this.speed  = speed ;
	}
	
	public GameObject (String path, double x ,double y, int speed)
	{
		this(GameUtil.getImage(path), x, y, speed) ;
	}

	// 得到游戏中物体的矩形框
	
	public Rectangle getRect()
	{
		return new Rectangle((int)x, (int)y, width, height) ;
	}
	
	
}
