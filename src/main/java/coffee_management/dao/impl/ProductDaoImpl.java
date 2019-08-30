package coffee_management.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import coffee_management.dao.ProductDao;
import coffee_management.dto.Product;
import coffee_management.jdbc.MyBatisSqlSessionFactory;

public class ProductDaoImpl implements ProductDao {
	private static final String namespace = "coffee_management.dao.ProductMapper";
	
	private static final ProductDao instance = new ProductDaoImpl();

	public static ProductDao getInstance() {
		return instance;
	}
	
	public ProductDaoImpl() {}

	@Override
	public List<Product> selectProductByAll() throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectProductByAll");
		}
	}

	@Override
	public Product selectProductByCode(Product product) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectProductByCode", product);
		}
	}
	
}
