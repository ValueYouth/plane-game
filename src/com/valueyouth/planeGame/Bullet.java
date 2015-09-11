package com.valueyouth.planeGame;

import java.awt.Color;
import java.awt.Graphics;

import com.valueyouth.util.Constant;


public class Bullet extends GameObject
{
	double degree ;

	
	public Bullet()
	{
		degree = 2 * Math.PI * Math.random() ; // 生成随机角度

		x = Constant.GAME_WIDTH / 2 ;
		y = Constant.GAME_HEIGHT / 2 ;
		
		this.speed  = 4 ;
		this.width  = 7 ;
		this.height = 7 ;
	}
	
	public void draw(Graphics g)
	{
		Color color = g.getColor();
		g.setColor(Color.GRAY);
		g.fillOval((int)x, (int)y, width, height); 
		
		if (y >= Constant.GAME_HEIGHT - 15 || y <= 30)
		{
			degree = -degree ;
		}
		if (x >= 500 - 70 || x <= 0)
		{
			degree = Math.PI - degree ;
		}
		
		x += speed * Math.cos(degree) ;
		y += speed * Math.sin(degree) ;
		
		g.setColor(color);
	}
}
