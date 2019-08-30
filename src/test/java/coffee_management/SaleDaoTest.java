package coffee_management;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import coffee_management.dao.SaleDao;
import coffee_management.dao.impl.SaleDaoImpl;
import coffee_management.dto.Product;
import coffee_management.dto.Sale;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest extends AbstractTest {
	private SaleDao dao = SaleDaoImpl.getInstance();
	
	@Test
	public void test01SelectSaleByAll() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Sale> list = dao.selectSaleByAll();
		
		for(Sale s : list) {
			System.out.println(s);
		}
		Assert.assertNotNull(list);
	}
	
	
	@Test
	public void test02InsertSale() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Sale sale = new Sale(new Product("B003"), 3000, 175, 12);
		
		int res = dao.insertSale(sale);
		Assert.assertEquals(1, res);
		
		test01SelectSaleByAll();
	}
	
	
	//판매금액 순위
	@Test
	public void test03SelectSaleRankTrue() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Sale> list = dao.selectSaleRank(true);
			
		for(Sale s : list) {
			System.out.println(s);
		}
		Assert.assertNotNull(list);
	}
	
	//마진액 순위
	@Test
	public void test04SelectSaleRankFalse() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Sale> list = dao.selectSaleRank(false);
			
		for(Sale s : list) {
			System.out.println(s);
		}
		Assert.assertNotNull(list);
	}

}
