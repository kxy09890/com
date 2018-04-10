package com.kfc;

public class FuWuYuan extends Thread {

	private KFC kfc;//保证所有服务员都在一个KFC里

	public void setKfc(KFC kfc) {
		this.kfc = kfc;
	}


	public void run() {
		
		synchronized (kfc) {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				//生成食物
				String shiwu=suiJiShengChengYiGeShiWu();
				//放入餐盘
				kfc.canpan.add(shiwu);
				System.out.println("服务员把'"+shiwu+"'放入餐盘,当前餐盘里有"+kfc.canpan.size()+"个食物");
				//如果餐盘达到容量的最大值
				if(kfc.canpan.size()==KFC.MAX) {
					//叫顾客
					kfc.notifyAll();
					//自己停止工作
					try {
						kfc.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		

		
		
	}
	
	public String suiJiShengChengYiGeShiWu() {
		int xuhao = (int)(Math.random()*5);
		return kfc.shiwuzhonglei[xuhao];
	}
}
