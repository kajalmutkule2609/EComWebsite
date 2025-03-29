package org.techhub.eComWebsite.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.eComWebsite.Model.ProductModel;

@Repository("prodRepo")
public class ProductRepositoryImp implements ProductRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	List<ProductModel> list;

	@Override
	public boolean addNewProduct(ProductModel product) {
		int result=jdbcTemplate.update("Insert into Product Values('0',?,?,?,?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, product.getProdName());
				ps.setInt(2, product.getPrice());
				ps.setInt(3, product.getQuantity());
				ps.setString(4, product.getDescription());
			}
			
		});
		return result>0;
	}

	@Override
	public List<ProductModel> getAllProducts() {
		list=jdbcTemplate.query("select * from Product",new RowMapper<ProductModel>() {

			@Override
			public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductModel model=new ProductModel();
				model.setProdName(rs.getString(1));
				model.setPrice(rs.getInt(2));
				model.setQuantity(rs.getInt(3));
				model.setDescription(rs.getString(4));
				return model;
			}
			
		});
		return list;
	}

	@Override
	public List<ProductModel> searchProduct(String category) {
		return null;
	}

	@Override
	public boolean updateProduct(String category) {
		return false;
	}

	@Override
	public boolean deleteProduct(String category) {
		return false;
	}

	@Override
	public List<ProductModel> sortProductsByPriceLowToHigh() {
		return null;
	}

	@Override
	public List<ProductModel> sortProductsByPriceHighToLow() {
		return null;
	}
}
