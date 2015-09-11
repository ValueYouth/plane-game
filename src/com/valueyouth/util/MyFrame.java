package com.valueyouth.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame
{
	private static final long	serialVersionUID	= 1L;
	
	// ˫����
	private Image iBuffer ; 
	private Graphics gBuffer ;
	TimeThread time = new TimeThread() ;

	/**
	 * ������Ϸ
	 */
	public void launchFrame()
	{
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT) ;
		setLocation(280, 70) ;
		setVisible(true);
		setResizable(false) ;

		time.start(); // ������ʱ�߳�
		new PaintThread().start(); // �����ػ��߳�
		
		// �˳�����
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{			
				System.exit(0);
			}			
		});
	}
	
	// ˫���弼����������˸
	
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
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @param args
	 */
	class PaintThread extends Thread
	{
		public void run()
		{
			while (true)
			{
				if ( !Constant.PAUSE ) // ���¿ո������ͣ
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
	
	// ��ʾ��Ϸ��ʱ��
	
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
		
	// ֹͣ��ʱ
	
	public void stop()
	{
		time.stop();
	}	
}
