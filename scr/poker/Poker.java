package com.poker;

public class Poker {

	public String color;
	public String points;

	public Poker(String color, String points) {
		this.color = color;
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// 如果属性不为空就生成一个hashCode散列值累加到结果集中
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {// 自定义什么情况下算是两张扑克类相等↓
		if (this == obj)// 非扑克类不等
			return true;
		if (obj == null)// 空为不等
			return false;
		if (getClass() != obj.getClass())// 传入类不等于比较类
			return false;
		Poker other = (Poker) obj;// 规范传入扑克类型中必要的属性
		if (points == null) {// 点数不空且不等
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (color == null) {// 花色不空且不等
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;// 能通过以上条件说明两张牌相等
	}

}
