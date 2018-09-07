package main;

public class Card {
	private Mark mark;
	private int number;

	public enum Mark {
		JOKER("�W���[�J�["),
		SPADE("�X�y�[�h"),
		DIA("�_�C��"),
		HEART("�n�[�g"),
		CLOVER("�N���[�o�[");

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
}
