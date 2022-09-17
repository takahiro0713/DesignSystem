import javax.swing.ImageIcon;

public class UtilityPole {
	
	private int poleNo;
	private int zahyoX;
	private int zahyoY;
	private ImageIcon icon;
	
	UtilityPole(){
		poleNo = 0;
	}
	
	public UtilityPole(int poleNo) {
		//電柱画面を表示
	}
	
	public ImageIcon makePole() {
		icon = new ImageIcon("○");
		return icon;
	}
	
	public int getPoleNo() {
		return poleNo;
	}

	public void setPoleNo(int poleNo) {
		this.poleNo = poleNo;
	}

	public int getZahyoX() {
		return zahyoX;
	}

	public void setZahyoX(int zahyoX) {
		this.zahyoX = zahyoX;
	}

	public int getZahyoY() {
		return zahyoY;
	}

	public void setZahyoY(int zahyoY) {
		this.zahyoY = zahyoY;
	}
}
