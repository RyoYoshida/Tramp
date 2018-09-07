package main;

public class Card {
	private Mark mark;
	private int number;

	public enum Mark {
		JOKER("�W���[�J�[", 0),
		SPADE("�X�y�[�h", 1),
		DIA("�_�C��", 2),
		HEART("�n�[�g", 3),
		CLOVER("�N���[�o�[", 4);

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
				str = "�W���b�N";
				break;
			case 12:
				str = "�N�C�[��";
				break;
			case 13:
				str = "�L���O";
				break;
			case 1:
				str = "�G�[�X";
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
			str = getMark() + "��" + getNumber();
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
			if(this.number > card.number) {
				compare = -1;
			}else if(this.number < card.number) {
				compare = 1;
			}else {
				if(this.mark.priority > card.mark.priority) {
					compare = 1;
				}else if(this.mark.priority < card.mark.priority) {
					compare = -1;
				}else {
					compare = 0;
				}
			}
		}
		return compare;
	}
}
