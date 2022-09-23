
public class DesinDocument {
	
	private UtilityPole poleInfo;
	
	public DesinDocument() {
		poleInfo = new UtilityPole();
		
		poleInfo.setPoleNo(0);
		poleInfo.setZahyoX(0);
		poleInfo.setZahyoY(0);
		
	}
	
	public void makePole(int zahyoX,int zahyoY,int poleNo) {
		poleInfo = new UtilityPole();
		
		poleInfo.setPoleNo(zahyoX);
		poleInfo.setZahyoX(zahyoY);
		poleInfo.setZahyoY(poleNo);
		
		//電柱画面表示
	}
	
}
