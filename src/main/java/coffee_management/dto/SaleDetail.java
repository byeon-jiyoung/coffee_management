package coffee_management.dto;

public class SaleDetail {
	private long supplyTax;//공급가액
	private long addTax;//부가세액
	private long salePrice;//판매금액
	private long marginPrice;//마진액
	private long rank;//순위
	
	public SaleDetail() {
	}

	public SaleDetail(long supplyTax, long addTax, long salePrice, long marginPrice) {
		this.supplyTax = supplyTax;
		this.addTax = addTax;
		this.salePrice = salePrice;
		this.marginPrice = marginPrice;
	}
	
	public SaleDetail(long supplyTax, long addTax, long salePrice, long marginPrice, long rank) {
		this.supplyTax = supplyTax;
		this.addTax = addTax;
		this.salePrice = salePrice;
		this.marginPrice = marginPrice;
		this.rank = rank;
	}

	public long getSupplyTax() {
		return supplyTax;
	}

	public void setSupplyTax(long supplyTax) {
		this.supplyTax = supplyTax;
	}

	public long getAddTax() {
		return addTax;
	}

	public void setAddTax(long addTax) {
		this.addTax = addTax;
	}

	public long getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(long salePrice) {
		this.salePrice = salePrice;
	}

	public long getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(long marginPrice) {
		this.marginPrice = marginPrice;
	}
	
	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("SaleDetail [supplyTax=%s, addTax=%s, salePrice=%s, marginPrice=%s, rank=%s]", supplyTax,
				addTax, salePrice, marginPrice, rank);
	}
	
	
}
