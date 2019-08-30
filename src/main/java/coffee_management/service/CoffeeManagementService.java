package coffee_management.service;

import java.sql.SQLException;

import coffee_management.dao.ProductDao;
import coffee_management.dao.SaleDao;
import coffee_management.dao.impl.ProductDaoImpl;
import coffee_management.dao.impl.SaleDaoImpl;
import coffee_management.dto.Product;
import coffee_management.dto.Sale;

public class CoffeeManagementService {
	private ProductDao productDao;
	private SaleDao saleDao;
	
	public CoffeeManagementService() {
		productDao = new ProductDaoImpl();
		saleDao = new SaleDaoImpl();
	}
	
	public int registerSale(Sale sale) throws SQLException{
		return saleDao.insertSale(sale);
	}
	
	public Product searchProduct(Product product) throws SQLException{
		return productDao.selectProductByCode(product);
	}
	
}
