package coffee_management;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import coffee_management.dao.ProductDao;
import coffee_management.dao.impl.ProductDaoImpl;
import coffee_management.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends AbstractTest {
	private ProductDao dao = ProductDaoImpl.getInstance();

	@Test
	public void test01SelectProductByAll() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Product> list = dao.selectProductByAll();
		for(Product p : list) {
			System.out.println(p);
		}
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test02SelectProductByCode() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Product product = new Product("A001");
		Product p = dao.selectProductByCode(product);
		
		System.out.println(p);
	}

}
