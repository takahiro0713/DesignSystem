import javax.swing.ImageIcon;

//装柱クラス
public class Soutyu {
	private String soutyuNo;
	private int poleNo;
	private int zahyoX;
	private int zahyoY;
	private ImageIcon icon;
	
	Soutyu(){
	}

	Soutyu(int inputPoleNo) {
		this.poleNo = inputPoleNo;
	}
	
	public ImageIcon makeSoutyu() {
		icon = new ImageIcon("C:/pleiades202206/pictures/DesignProgect/装柱.jpg");
		return icon;
	}

	public int getPoleNo() {
		return poleNo;
	}

	public void setPoleNo(int poleNo) {
		this.poleNo = poleNo;
	}

	public String getSoutyuNo() {
		return soutyuNo;
	}

	public void setSoutyuNo(String soutyuNo) {
		this.soutyuNo = soutyuNo;
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
