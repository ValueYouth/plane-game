package com.valueyouth.planeGame;

import java.awt.Image;
import java.awt.Rectangle;

import com.valueyouth.util.GameUtil;


public class GameObject
{
	Image image ; // �����ͼƬ
	double x, y ; // ���������
	int speed ;   // ������ٶ�
	int width, height ;
	
	
	public GameObject()
	{
		// �յĹ��췽��
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

	// �õ���Ϸ������ľ��ο�
	
	public Rectangle getRect()
	{
		return new Rectangle((int)x, (int)y, width, height) ;
	}
	
	
}
