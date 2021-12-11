package jeu;

public class ObjetGraphique {
	protected int x;
	protected int y;
	protected int tailleCase;
	
	public ObjetGraphique(int x, int y, int tailleCase) {
		super();
		this.x = x;
		this.y = y;
		this.tailleCase = tailleCase;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTailleCase() {
		return tailleCase;
	}

	public void setTailleCase(int tailleCase) {
		this.tailleCase = tailleCase;
	};
	
	/*Je teste des trucs */
}
