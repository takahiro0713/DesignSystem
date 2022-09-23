
public abstract class Material {
	private String product;
	private int instCost;
	private int removeCost;
	private int zaikouKubun;
	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getInstCost() {
		return instCost;
	}

	public void setInstCost(int instCost) {
		this.instCost = instCost;
	}

	public int getRemoveCost() {
		return removeCost;
	}

	public void setRemoveCost(int removeCost) {
		this.removeCost = removeCost;
	}

	public int getZaikouKubun() {
		return zaikouKubun;
	}

	public void setZaikouKubun(int zaikouKubun) {
		this.zaikouKubun = zaikouKubun;
	}
	
	
}
