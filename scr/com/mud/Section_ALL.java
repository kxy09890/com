package com.mud;

import java.util.Scanner;

public class Section_ALL {
	
	void partOne(Scanner sc, Player p1, Player p2) {// 第一章
		System.out.println("输入数字1-回车，开始游戏吧");
		int t = sc.nextInt();
		if(t==1) {
			System.out.println("****第一章-小试牛刀****");	
		}else if(t==2){
			System.out.println(p1.getName()+"回家取了把杀猪刀！！看起来更暴躁了，攻击力大增");
			p1.setMaxAP(450);
			p1.setSpeed(800);
			System.err.println("攻击力增加到450！攻速也有小幅提升！");
		}else {
			System.out.println("输入错误，游戏已退出");
			System.exit(0);
		}
	}
}
