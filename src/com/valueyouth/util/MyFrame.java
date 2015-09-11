package com.valueyouth.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame
{
	private static final long	serialVersionUID	= 1L;
	
	// 双缓冲
	private Image iBuffer ; 
	private Graphics gBuffer ;
	TimeThread time = new TimeThread() ;

	/**
	 * 启动游戏
	 */
	public void launchFrame()
	{
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT) ;
		setLocation(280, 70) ;
		setVisible(true);
		setResizable(false) ;

		time.start(); // 启动计时线程
		new PaintThread().start(); // 启动重画线程
		
		// 退出程序
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{			
				System.exit(0);
			}			
		});
	}
	
	// 双缓冲技术，消除闪烁
	
	public void update(Graphics g)
	{
		if (iBuffer == null)
		{
			iBuffer = this.createImage(Constant.GAME_WIDTH,
					Constant.GAME_HEIGHT) ;
			gBuffer = iBuffer.getGraphics() ;
		}
		
		paint(gBuffer) ;
		g.drawImage(iBuffer, 0, 0, null) ;
	}
	
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @param args
	 */
	class PaintThread extends Thread
	{
		public void run()
		{
			while (true)
			{
				if ( !Constant.PAUSE ) // 按下空格键，暂停
				{
					repaint() ;
				}
				else
				{
					// ....
				}
				
				try
				{
					Thread.sleep(40);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	// 显示游戏的时间
	
	class TimeThread extends Thread
	{
		public void run()
		{
			while (true)
			{
				Constant.seconds++ ;
				try
				{
					TimeThread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
		
	// 停止计时
	
	public void stop()
	{
		time.stop();
	}	
}
