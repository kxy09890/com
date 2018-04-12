package com.mud;

import java.util.Scanner;

public class Testmain {

	public static void main(String[] args) {
		// TODO 人物配置
		System.out.println("*欢迎来到乡村大战*");
		System.out.println("*请给你的人物设置一个动听的名字");
		Scanner sc = new Scanner(System.in);
		String uName = sc.nextLine();
		Player p1 = new Player();
		Player p2 = new Player(p1);
		p1.target = p2;

		p1.setName(uName);
		p1.setMaxHP(1000);
		p1.setNowHP(1000);
		p1.setMaxAP(80);
		p1.setMinAP(50);
		p1.setPercent(0.15);
		p1.setSpeed(1000);

		p2.setName("乡村野牛");
		p2.setMaxHP(2000);
		p2.setNowHP(2000);
		p2.setMaxAP(50);
		p2.setMinAP(15);
		p2.setPercent(0.25);
		p2.setSpeed(410);
				
		
		System.err
				.print(p1.getName() + "的初始属性： 最大血量[" + p1.getMaxHP() + "]|攻击力[" + p1.getMinAP() + "-" + p1.getMaxAP());
		System.err.println("]|暴击率[" + p1.getPercent() + "]|攻速[" + p1.getSpeed() + "]");
		Section_ALL sa = new Section_ALL();

		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		sa.partOne(sc, p1, p2);// 第一章内容
		t1.start();
		t2.start();
	}

}
