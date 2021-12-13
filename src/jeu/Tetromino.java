package jeu;

public class Tetromino {
	
	protected ObjetGraphique[][][] tab;
	protected int position;
	protected int type;
	
	public Tetromino() {
		// TODO Auto-generated constructor stub
		ObjetGraphique[][][] tab = new ObjetGraphique[4][4][4];
	}

	public Tetromino(int type, int position) {
		super();
		this.type = type;
		this.position = position;
		ObjetGraphique[][][] tab = new ObjetGraphique[4][4][4];
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
