package coffee_management.dao;

import java.sql.SQLException;
import java.util.List;

import coffee_management.dto.Product;

public interface ProductDao {
	
	public abstract List<Product> selectProductByAll() throws SQLException;
	public Product selectProductByCode(Product product) throws SQLException;

}
