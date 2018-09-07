package main;

public class Card {
	private Mark mark;
	private int number;

	public enum Mark {
		JOKER("ジョーカー"),
		SPADE("スペード"),
		DIA("ダイヤ"),
		HEART("ハート"),
		CLOVER("クローバー");

		private final String name;
		Mark(String name) {
	        this.name = name;
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
}
