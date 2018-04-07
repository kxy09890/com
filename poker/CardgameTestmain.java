package com.poker;

public class CardgameTestmain { 

	public static void main(String[] args) {
		System.out.println("----------欢迎进入纸牌对决----------");
		GameStart gs = new GameStart();// 加载游戏流程方法集
		gs.initialize();// 来复扑克
		gs.shuffle();// 洗下牌
		gs.playerSet();// 玩家登场
		gs.deal();// 发牌
		gs.sort();// 理牌
		gs.compareToPonint();// 比较
		gs.print();// 结果
		System.out.println("-------------游戏结束-------------");
	}

}
