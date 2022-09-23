import javax.swing.ImageIcon;

//電柱クラス
public class Pole {
	
	private int poleNo;
	private int zahyoX;
	private int zahyoY;
	private ImageIcon icon;
	
	Pole(){
	}
	
	Pole(int input_poleNo) {
		this.poleNo = input_poleNo;
	}
	
	public ImageIcon makePole() {
		icon = new ImageIcon("C:/pleiades202206/pictures/DesignProgect/電柱.jpeg");
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
