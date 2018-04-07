package com.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public int id;
	public String name;
	public List<Poker> handCards = new ArrayList<Poker>();
	// 玩家的手牌集合↑
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
