package com.poker;

import java.util.Comparator;

public class CompareToPoker implements Comparator<Poker> {// ←自定義創建比較器，比較兩個類

	@Override
	public int compare(Poker o1, Poker o2) {// ←自定义的比较规则方法
		// TODO 给出牌组以备比较时计分之用↓
		String[] color = { "方片", "梅花", "红桃", "黑桃" };
		String[] point = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		int temp1 = 0;// 第一张牌面的分值
		int temp2 = 0;// 第二张牌面的分值
		for (int i = 0; i < point.length; i++) {// 遍歷每一種點數
			if (o1.points.equals(point[i]))// 確定玩家的第一張牌，以集合下標為記錄單位
				temp1 += i * 10;// ←製作牌的分数单元
			if (o2.points.equals(point[i]))// 確定玩家的第二張牌，以集合下標為記錄單位
				temp2 += i * 10;
		}
		
		for (int i = 0; i < color.length; i++) {
			if (o1.color.equals(color[i]))
				temp1 += i;
			if (o2.color.equals(color[i]))
				temp2 += i;// 记录牌花色的分值
		}
		//三种比较结果，1大2，2大1，平局
		if (temp1 > temp2)
			return -1;
		if (temp1 < temp2)
			return 1;

		return 0;
	}

}
