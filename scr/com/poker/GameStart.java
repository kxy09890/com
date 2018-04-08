package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameStart {// 游戲流程類

	String[] point = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	String[] color = new String[] { "黑桃", "红桃", "梅花", "方块" };
	Scanner input = new Scanner(System.in);
	List<Poker> pokerList = new ArrayList<>();
	List<Player> playerList = new ArrayList<>();

	public void initialize() { // 初始化方法↓
		for (int i = 0; i < 4; i++) {// ←循環四個花色
			for (int j = 0; j < 13; j++) {// ←每個花色創建12張牌
				pokerList.add(new Poker(color[i], point[j]));// ←循環創建紙牌類添加到紙牌集中
			}
		}

		System.out.println("-----------↓创建扑克牌↓------------");
		// 輸出創建好的牌組↓
		int i = 0;
		for (Poker poker : pokerList) {
			System.out.print(poker.color + poker.points + " ");
			i++;

			if (i % 13 == 0) {// ←每打完一種花色就換行
				System.out.println("");
			}
		} // for
	}

	public void shuffle() {// ↓shuffle List随机排序(進行洗牌)
		System.out.println("-------------开始洗牌-------------");
		Collections.shuffle(pokerList);
		System.out.println("-------------洗牌完成-------------");
	}

	public void playerSet() {
		System.out.println("-----------创建两名玩家------------");
		for (int i = 1; i <= 2; i++) {
			System.out.println("输入玩家" + i + "的id:");
			int id = 0;
			try {
				id = scanf();// id必须为整形，否则报错
			} catch (Exception e) {
				System.out.println(e.getMessage());
				i--;// 报错并回滚循环
				continue;
			}
			System.out.println("输入玩家" + i + "的姓名:");
			String name = input.next();
			playerList.add(new Player(id, name));// ←添加到玩家集中
		}
		input.close();// 关输入
		System.out.println("----------Game Start!-----------\n黑方玩家\t白方玩家");
		for (Player p : playerList) {// ←打印出玩家列表
			System.out.print(p.name + "\t");
		}
	}

	public int scanf() throws Exception {// ↓自定义的ID异常方法
		try {
			int in = input.nextInt();
			return in;
		} catch (Exception e) {
			input = new Scanner(System.in);
			throw new Exception("输入异常,请输入整数类型的ID!");
		}
	}

	public void deal() {// 若玩家增加，此方法需要改动↓
		System.out.println("\n-------------开始发牌-------------");
		System.out.println(playerList.get(0).name + "拿牌");
		playerList.get(0).handCards.add(pokerList.get(0));
		System.out.println(playerList.get(1).name + "拿牌");
		playerList.get(1).handCards.add(pokerList.get(1));
		System.out.println(playerList.get(0).name + "拿牌");
		playerList.get(0).handCards.add(pokerList.get(2));
		System.out.println(playerList.get(1).name + "拿牌");
		playerList.get(1).handCards.add(pokerList.get(3));
		System.out.println("------------发牌结束--------------");
	}// 两位玩家轮流拿到无序牌组里面的前四张牌↑

	public void sort() {// 第一次，自己牌的比较
		Collections.sort(playerList.get(0).handCards, new CompareToPoker());
		Collections.sort(playerList.get(1).handCards, new CompareToPoker());
		// 玩家1，2通过重写的比较类方法，整理自己的手牌，找出自己手中最大的牌↑
		System.out.println(playerList.get(0).name + "最大手牌:" + playerList.get(0).handCards.get(0).color
				+ playerList.get(0).handCards.get(0).points);
		// 默认为升序排序，所以比较后最大的牌应是手牌集中的第一张牌
		System.out.println(playerList.get(1).name + "最大手牌:" + playerList.get(1).handCards.get(0).color
				+ playerList.get(1).handCards.get(0).points);
	}

	public void compareToPonint() {
		System.out.println("--------------获胜方--------------");
		List<Poker> maxPoker = new ArrayList<Poker>();
		List<Poker> minPoker = new ArrayList<Poker>();
		maxPoker.add(playerList.get(0).handCards.get(0));
		maxPoker.add(playerList.get(1).handCards.get(0));
		// 1p的大小牌和2p的大小牌，分别放入大小牌集合中，等待比较↑↓
		minPoker.add(playerList.get(0).handCards.get(1));
		minPoker.add(playerList.get(1).handCards.get(1));
		// 第二次，对手之间的比较(大比大，小比小)
		Collections.sort(maxPoker, new CompareToPoker());
		Collections.sort(minPoker, new CompareToPoker());
			// if1大牌决胜分支,↓判断最大牌点数是否为-平局
		if (maxPoker.get(0).points.equals(maxPoker.get(1).points)) {
			// if2小牌决胜分支,↓判断最小牌点数是否为-平局
			if (minPoker.get(0).points.equals(minPoker.get(1).points)) {
			// if3大牌花色决胜分支-输/赢
				if (maxPoker.get(0).equals(playerList.get(0).handCards.get(0))) {
					System.out.println("黑方"+playerList.get(0).id+"获胜\tWinner:" + playerList.get(0).name);
				} else {
					System.out.println("白方"+playerList.get(1).id+"获胜\tWinner:" + playerList.get(1).name);
				}
			} else {// ↓if2小牌决胜分支-输/赢
				if (minPoker.get(0).equals(playerList.get(0).handCards.get(1))) {
					System.out.println("黑方"+playerList.get(0).id+"获胜\tWinner:" + playerList.get(0).name);
				} else {
					System.out.println("白方"+playerList.get(1).id+"获胜\tWinner:" + playerList.get(1).name);
				}
			}
			// ↓if1大牌决胜分支-输/赢
		} else if (maxPoker.get(0).equals(playerList.get(0).handCards.get(0))) {
			System.out.println("黑方"+playerList.get(0).id+"获胜\tWinner:" + playerList.get(0).name);
		} else {
			System.out.println("白方"+playerList.get(1).id+"获胜\tWinner:" + playerList.get(1).name);
		}
	}

	public void print() {// 亮牌
		System.out.println("----------玩家各自手牌-------------");
		for (Player player : playerList) {
			System.out.print(player.name + ":");
			for (Poker poker : player.handCards) {
				System.out.print("[" + poker.color + poker.points + "]");
			}
			System.out.println("");
		}
	}
}
