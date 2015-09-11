package com.valueyouth.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


/**
 * 游戏开发中常用的工具类（比如：加载图片等的方法）
 * @author WangChi
 *
 */
public class GameUtil
{
	public static Image getImage(String path)
	{
		URL url = GameUtil.class.getClassLoader().getResource(path) ;
		BufferedImage img = null ;
		
		try
		{
			img = ImageIO.read(url) ;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return img ;
	}
}
