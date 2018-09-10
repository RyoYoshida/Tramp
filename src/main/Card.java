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
		int compare;
		if(this.mark == Mark.JOKER) {
			if(card.mark == Mark.JOKER) {
				compare = 0;
			}else {
				compare = -1;
			}
		}else if(card.mark == Mark.JOKER) {
			compare = 1;
		}else {
			// Aceを14として扱う
			int n1 = this.number;
			int n2 = card.number;
			if(n1 == 1) n1 += 13;
			if(n2 == 1) n2 += 13;
			
			if(n1 > n2) {
				compare = -1;
			}else if(n1 < n2) {
				compare = 1;
			}else {
				// 同値の場合マークで判定
				if(this.mark.priority > card.mark.priority) {
					compare = -1;
				}else if(this.mark.priority < card.mark.priority) {
					compare = 1;
				}else {
					compare = 0;
				}
			}
		}
		return compare;
	}
}
