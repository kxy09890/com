package com.kfc;

public class GuKe extends Thread{

	private KFC kfc;//保证所有服务员都在一个KFC里

	public void setKfc(KFC kfc) {
		this.kfc = kfc;
	}
	
	public void run() {
		synchronized (kfc) {//保证大家在一个kfc里
			while(true) {//不停的去取食物
				//顾客去餐盘取食物
				//如果餐盘没有食物
				if(kfc.canpan.size()==0) {
					kfc.notifyAll();//叫醒服务员
					try {
						kfc.wait();//顾客自己等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {//餐盘有食物
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					String quzoudeshiwu=(String)kfc.canpan.remove(0);
					System.out.println("代佳兴取走一个："+quzoudeshiwu+",当前餐盘剩余"+kfc.canpan.size()+"个食物");
				}
			}
		}
		
		
	}
	
}
