package com.kfc;

public class M {

	public static void main(String[] args) {
		KFC kfc= new KFC();//新建一个kfc店
		
		FuWuYuan fwy1 = new FuWuYuan();//新建一个服务员
		fwy1.setKfc(kfc);//把服务员放入kfc
		
		GuKe gk1 = new GuKe();//新建一个顾客
		gk1.setKfc(kfc);//把顾客放入kfc
		
		fwy1.start();//服务员开始生产食物
		
		gk1.start();//顾客开始消费食物

	}

}
