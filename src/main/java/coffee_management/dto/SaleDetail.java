package coffee_management.dto;

public class SaleDetail {
	private int supplyTax;//공급가액
	private int addTax;//부가세액
	private int salePrice;//판매금액
	private int marginPrice;//마진액
	private int rank;//순위
	
	public SaleDetail() {
	}

	public SaleDetail(int supplyTax, int addTax, int salePrice, int marginPrice) {
		this.supplyTax = supplyTax;
		this.addTax = addTax;
		this.salePrice = salePrice;
		this.marginPrice = marginPrice;
	}
	
	public SaleDetail(int supplyTax, int addTax, int salePrice, int marginPrice, int rank) {
		this.supplyTax = supplyTax;
		this.addTax = addTax;
		this.salePrice = salePrice;
		this.marginPrice = marginPrice;
		this.rank = rank;
	}

	public int getSupplyTax() {
		return supplyTax;
	}

	public void setSupplyTax(int supplyTax) {
		this.supplyTax = supplyTax;
	}

	public int getAddTax() {
		return addTax;
	}

	public void setAddTax(int addTax) {
		this.addTax = addTax;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("SaleDetail [supplyTax=%s, addTax=%s, salePrice=%s, marginPrice=%s, rank=%s]", supplyTax,
				addTax, salePrice, marginPrice, rank);
	}
	
	
}
