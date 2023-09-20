package kr.co.kmarket.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.ProductDTO;

/*
 	작업자 : 강윤수
 	작업날짜 : 2023/09/14
 	작업내용 : insert Product
*/

public class ProductDAO extends DBHelper{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO product) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT);
			psmt.setInt(1, product.getProdCate1());
			psmt.setInt(2, product.getProdCate2());
			psmt.setString(3, product.getProdName());
			psmt.setString(4, product.getDescript());
			psmt.setString(5, product.getCompany());
			psmt.setString(6, product.getSeller());
			psmt.setInt(7, product.getPrice());
			psmt.setInt(8, product.getDiscount());
			psmt.setInt(9, product.getPoint());
			psmt.setInt(10, product.getStock());
			psmt.setInt(11, product.getDelivery());
			psmt.setString(12, product.getThumb1());
			psmt.setString(13, product.getThumb2());
			psmt.setString(14, product.getThumb3());
			psmt.setString(15, product.getDetail());
			psmt.setString(16, product.getStatus());
			psmt.setString(17, product.getDuty());
			psmt.setString(18, product.getReceipt());
			psmt.setString(19, product.getBizType());
			psmt.setString(20, product.getOrigin());
			psmt.setString(21, product.getIp());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error("insertProduct() error : "+e.getMessage());
		}
	}
	public ProductDTO selectProduct(String cate1, String cate2, String prodNo) {
		
		ProductDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCT);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setString(3, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setProdNo(rs.getString("prodNo"));
				dto.setProdCate1(rs.getString("prodCate1"));
				dto.setProdCate2(rs.getString("prodCate2"));
				dto.setProdName(rs.getString("prodName"));
				dto.setDescript(rs.getString("descript"));
				dto.setProdCompany(rs.getString("prodCompany"));
				dto.setSeller(rs.getString("seller"));
				dto.setPrice(rs.getString("price"));
				dto.setDiscount(rs.getString("discount"));
				dto.setPoint(rs.getString("point"));
				dto.setStock(rs.getString("stock"));
				dto.setSold(rs.getString("sold"));
				dto.setDelivery(rs.getString("delivery"));
				dto.setHit(rs.getString("hit"));
				dto.setScore(rs.getString("score"));
				dto.setReview(rs.getString("review"));
				dto.setThumb1(rs.getString("thumb1"));
				dto.setThumb2(rs.getString("thumb2"));
				dto.setThumb3(rs.getString("thumb3"));
				dto.setDetail(rs.getString("detail"));
				dto.setStatus(rs.getString("status"));
				dto.setDuty(rs.getString("duty"));
				dto.setReceipt(rs.getString("receipt"));
				dto.setBizType(rs.getString("bizType"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getString("rdate"));
				dto.setLevel(rs.getString("level"));
				dto.setCompany(rs.getString("company"));
			}
			close();
		} catch (Exception e) {
			logger.error("selectProduct() error :"+e.getMessage());
		}
		return dto;
	}

	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(String uid, String no) {
		
		try {
			conn= getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_PRODUCT);
			psmt.setString(1, uid);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public List<ProductDTO> selectProductsAll(int start, String seller) {
		
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_ALL);
			psmt.setString(1, seller);
			psmt.setInt(2, start);		
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getString("prodNo"));
				dto.setProdCate1(rs.getString("prodCate1"));
				dto.setProdCate2(rs.getString("prodCate2"));
				dto.setProdName(rs.getString("prodName"));
				dto.setDescript(rs.getString("descript"));
				dto.setProdCompany(rs.getString("prodCompany"));
				dto.setSeller(rs.getString("seller"));
				dto.setPrice(rs.getString("price"));
				dto.setDiscount(rs.getString("discount"));
				dto.setPoint(rs.getString("point"));
				dto.setStock(rs.getString("stock"));
				dto.setSold(rs.getString("sold"));
				dto.setDelivery(rs.getString("delivery"));
				dto.setHit(rs.getString("hit"));
				dto.setScore(rs.getString("score"));
				dto.setReview(rs.getString("review"));
				dto.setThumb1(rs.getString("thumb1"));
				dto.setThumb2(rs.getString("thumb2"));
				dto.setThumb3(rs.getString("thumb3"));
				dto.setDetail(rs.getString("detail"));
				dto.setStatus(rs.getString("status"));
				dto.setDuty(rs.getString("duty"));
				dto.setReceipt(rs.getString("receipt"));
				dto.setBizType(rs.getString("bizType"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getString("rdate"));
				dto.setLevel(rs.getString("level"));
				dto.setCompany(rs.getString("company"));
				
				products.add(dto);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectProductsAll() error :"+e.getMessage());
		}
		
		return products;
	}
	
	/************************* 대분류 상품 불러오기 *************************/
	public List<ProductDTO> selectProductsByCate1(String cate1, int start) {
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE1);
			psmt.setString(1, cate1);
			psmt.setInt(2, start);
			
			rs = psmt.executeQuery();

			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getString("prodNo"));
				dto.setProdCate1(rs.getString("prodCate1"));
				dto.setProdCate2(rs.getString("prodCate2"));
				dto.setProdName(rs.getString("prodName"));
				dto.setDescript(rs.getString("descript"));
				dto.setProdCompany(rs.getString("prodCompany"));
				dto.setSeller(rs.getString("seller"));
				dto.setPrice(rs.getString("price"));
				dto.setDiscount(rs.getString("discount"));
				dto.setPoint(rs.getString("point"));
				dto.setStock(rs.getString("stock"));
				dto.setSold(rs.getString("sold"));
				dto.setDelivery(rs.getString("delivery"));
				dto.setHit(rs.getString("hit"));
				dto.setScore(rs.getString("score"));
				dto.setReview(rs.getString("review"));
				dto.setThumb1(rs.getString("thumb1"));
				dto.setThumb2(rs.getString("thumb2"));
				dto.setThumb3(rs.getString("thumb3"));
				dto.setDetail(rs.getString("detail"));
				dto.setStatus(rs.getString("status"));
				dto.setDuty(rs.getString("duty"));
				dto.setReceipt(rs.getString("receipt"));
				dto.setBizType(rs.getString("bizType"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getString("rdate"));
				dto.setLevel(rs.getString("level"));
				dto.setCompany(rs.getString("company"));
				
				products.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductsByCate1() error :"+e.getMessage());
		}
		return products;
	}
	
	/************************* 소분류 상품 불러오기 *************************/
	public List<ProductDTO> selectProductsByCate2(String cate1, String cate2, int start, String type) {
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			if(type == null) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2);
				logger.debug("selectProductsByCate2... ALL");
				
			}else if(type.equals("1")) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2_SOLD_DESC);
				logger.debug("selectProductsByCate2... SOLD DESC");
				
			}else if(type.equals("2")) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2_PRICE_ASC);
				logger.debug("selectProductsByCate2... PRICE ASC");
				
			}else if(type.equals("3")) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2_PRICE_DESC);
				logger.debug("selectProductsByCate2... PRICE DESC");
				
			}else if(type.equals("4")) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2_SCORE_DESC);
				logger.debug("selectProductsByCate2... SCORE DESC");
				
			}else if(type.equals("5")) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2_REVIEW_DESC);
				logger.debug("selectProductsByCate2... REVIEW DESC");
				
			}else if(type.equals("6")) {
				psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_CATE2_LATELY);
				logger.debug("selectProductsByCate2... LATELY");
			}
			
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setInt(3, start);
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getString("prodNo"));
				dto.setProdCate1(rs.getString("prodCate1"));
				dto.setProdCate2(rs.getString("prodCate2"));
				dto.setProdName(rs.getString("prodName"));
				dto.setDescript(rs.getString("descript"));
				dto.setProdCompany(rs.getString("prodCompany"));
				dto.setSeller(rs.getString("seller"));
				dto.setPrice(rs.getString("price"));
				dto.setDiscount(rs.getString("discount"));
				dto.setPoint(rs.getString("point"));
				dto.setStock(rs.getString("stock"));
				dto.setSold(rs.getString("sold"));
				dto.setDelivery(rs.getString("delivery"));
				dto.setHit(rs.getString("hit"));
				dto.setScore(rs.getString("score"));
				dto.setReview(rs.getString("review"));
				dto.setThumb1(rs.getString("thumb1"));
				dto.setThumb2(rs.getString("thumb2"));
				dto.setThumb3(rs.getString("thumb3"));
				dto.setDetail(rs.getString("detail"));
				dto.setStatus(rs.getString("status"));
				dto.setDuty(rs.getString("duty"));
				dto.setReceipt(rs.getString("receipt"));
				dto.setBizType(rs.getString("bizType"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getString("rdate"));
				dto.setLevel(rs.getString("level"));
				dto.setCompany(rs.getString("company"));
				
				products.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductsByCate2() error :"+e.getMessage());
		}
		return products;
	}
	/************************* 상품 전체 불러오기 *************************/

	public int selectCountProductsAll(String seller) {
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_PRODUCTS_ALL);
			psmt.setString(1, seller);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectCountProductsAll() error : "+e.getMessage());
		}
		return total;
	}
	public int selectCountProductsByCate1(String cate1) {
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_PRODUCTS_BY_CATE1);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectCountProductsByCate1() error : "+e.getMessage());
		}
		return total;
	}
	public int selectCountProductsByCate2(String cate1, String cate2) {
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_PRODUCTS_BY_CATE2);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectCountProductsByCate1() error : "+e.getMessage());
		}
		return total;
	}
	
	
	/************************* 베스트/히트/추천 상품 불러오기 *************************/
	public List<ProductDTO> selectPopularProducts(String type) {
		List<ProductDTO> popItem = new ArrayList<ProductDTO>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			if(type.equals("best")) {
				rs = stmt.executeQuery(SQL.SELECT_BEST_PRODUCT);
				logger.debug("selectPopularProducts... BEST");
				
			}else if(type.equals("hit")) {
				rs = stmt.executeQuery(SQL.SELECT_HIT_PRODUCT);
				logger.debug("selectPopularProducts... HIT");
				
			}else if(type.equals("recommend")) {
				rs = stmt.executeQuery(SQL.SELECT_RECOMMEND_PRODUCT);
				logger.debug("selectPopularProducts... RECOMMEND");
				
			}else if(type.equals("current")) {
				rs = stmt.executeQuery(SQL.SELECT_CURRENT_PRODUCT);
				logger.debug("selectPopularProducts... CURRENT");
				
			}else if(type.equals("discount")) {
				rs = stmt.executeQuery(SQL.SELECT_DISCOUNT_PRODUCT);
				logger.debug("selectPopularProducts... DISCOUNT");
			}
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getString(1));
				dto.setProdCate1(rs.getString(2));
				dto.setProdCate2(rs.getString(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setProdCompany(rs.getString(6));
				dto.setSeller(rs.getString(7));
				dto.setPrice(rs.getString(8));
				dto.setDiscount(rs.getString(9));
				dto.setPoint(rs.getString(10));
				dto.setStock(rs.getString(11));
				dto.setSold(rs.getString(12));
				dto.setDelivery(rs.getString(13));
				dto.setHit(rs.getString(14));
				dto.setScore(rs.getString(15));
				dto.setReview(rs.getString(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				popItem.add(dto);
			}
			close();
			
		} catch (Exception e) {
			logger.error("selectPopularProducts : " + e.getMessage());
		}
		return popItem;
	}
}
