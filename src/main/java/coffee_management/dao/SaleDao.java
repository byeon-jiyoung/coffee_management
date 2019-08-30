package coffee_management.dao;

import java.sql.SQLException;
import java.util.List;

import coffee_management.dto.Sale;

public interface SaleDao {
	
	public List<Sale> selectSaleByAll() throws SQLException;
	public int insertSale(Sale sale) throws SQLException;
	public List<Sale> selectSaleRank(boolean isSale) throws SQLException;

}
