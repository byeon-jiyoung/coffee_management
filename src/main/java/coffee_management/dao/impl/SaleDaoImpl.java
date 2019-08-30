package coffee_management.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import coffee_management.dao.SaleDao;
import coffee_management.dto.Sale;
import coffee_management.jdbc.MyBatisSqlSessionFactory;

public class SaleDaoImpl implements SaleDao {
	private static final String namespace = "coffee_management.dao.SaleMapper";
	
	private static final SaleDao instance = new SaleDaoImpl();
	
	public static SaleDao getInstance() {
		return instance;
	}
	
	public SaleDaoImpl() {}


	@Override
	public List<Sale> selectSaleByAll() throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectSaleByAll");
		}
	}

	@Override
	public int insertSale(Sale sale) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertSale", sale);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public List<Sale> selectSaleRank(boolean isSale) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectSaleRank", isSale);
		}
	}

}
