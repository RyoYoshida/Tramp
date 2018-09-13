package main;

public class Card {
	private Mark mark;
	private int number;

	public enum Mark {
		JOKER("ジョーカー", 5),
		SPADE("スペード", 4),
		DIA("ダイヤ", 3),
		HEART("ハート", 2),
		CLOVER("クローバー", 1);

		private final String name;
		private final int priority;
		Mark(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}
	};

	public Card(Mark mark, int number) {
		this.mark = mark;
		this.number = number;
	}

	public static Card createJoker() {
		return new Card(Mark.JOKER, 0);
	}
	
	public String getMark() {
		return mark.name;
	}

	public String getNumber() {
		String str;
		switch(number) {
			case 11:
				str = "ジャック";
				break;
			case 12:
				str = "クイーン";
				break;
			case 13:
				str = "キング";
				break;
			case 1:
				str = "エース";
				break;
			default:
				str = Integer.toString(number);
				break;
		}
		return str;
	}

	public String getMarkAndNumber() {
		String str;
		if(this.isJoker()) {
			str = getMark();
		}else {
			str = getMark() + "の" + getNumber();
		}
		return str;
	}
	
	public boolean isJoker() {
		return mark == Mark.JOKER;
	}

	public int compare(Card card) {
		return card.power() - this.power();
	}

	private int power() {
		int power = 0;

		if(mark == Mark.JOKER) {
			// ジョーカーを15として扱う。
			power = 15;
		}else if(number == 1) {
			// Aceを14として扱う。
			power += 13;
		}else {
			power = number;
		}

		//パワー値を10倍してマーク値を加点する。
		power = power*10 + mark.priority;
		
		return power;
	}
}
