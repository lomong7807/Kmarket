package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.CsDTO;

public class CsDAO extends DBHelper {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 기본 CRUD 메서드
	public int insertBoard(CsDTO dto) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_BOARD);
			psmt.setInt(1, dto.getGroup());
			psmt.setInt(2, dto.getCate1());
			psmt.setInt(3, dto.getCate2());
			psmt.setString(4, dto.getUid());
			psmt.setString(5, dto.getTitle());
			psmt.setString(6, dto.getContent());
			result = psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			logger.error("insertBoard : " + e.getMessage());
		}
		return result;
	}
	
	public CsDTO selectBoard(String no) {
		CsDTO dto = null;

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_BOARD);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CsDTO();
				dto.setNo(rs.getString(1));
				dto.setParent(rs.getString(2));
				dto.setGroup(rs.getString(3));
				dto.setCate1(rs.getString(4));
				dto.setCate2(rs.getString(5));
				dto.setUid(rs.getString(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setRdate(rs.getString(9));
				dto.setGroup_name(rs.getString(10));
				dto.setCate1_name(rs.getString(11));
				dto.setCate2_name(rs.getString(12));
			}
			close();
			
		} catch (Exception e) {
			logger.error("selectBoard : " + e.getMessage());
		}
		return dto;
	}
	
	public CsDTO selectAnswer(String no) {
		CsDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ANSWER);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CsDTO();
				dto.setNo(rs.getString(1));
				dto.setParent(rs.getString(2));
				dto.setGroup(rs.getString(3));
				dto.setCate1(rs.getString(4));
				dto.setCate2(rs.getString(5));
				dto.setUid(rs.getString(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setRdate(rs.getString(9));
			}
			close();
			
		} catch (Exception e) {
			logger.error("selectAnswer : " + e.getMessage());
		}
		return dto;
	}
	

	public List<CsDTO> selectBoards(String group, String cate2, String cate3, int start) {
		
			List<CsDTO> board = new ArrayList<>();
		
		try {
				conn =getConnection();
			if(cate3 != null) {
				psmt = conn.prepareStatement(SQL.SELECT_BOARDS_SUB_CATE);
				psmt.setString(1, group);
				psmt.setString(2, cate2);
				psmt.setString(3, cate3);	
				psmt.setInt(4, start);	
			}else if(cate2 != null) {
				psmt = conn.prepareStatement(SQL.SELECT_BOARDS_MIDDLE_CATE);
				psmt.setString(1, group);
				psmt.setString(2, cate2);
				psmt.setInt(3, start);	
			}else{
				psmt = conn.prepareStatement(SQL.SELECT_BOARDS_MAIN_CATE);
				psmt.setString(1, group);
				psmt.setInt(2, start);	
			}
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsDTO dto = new CsDTO();
				dto.setNo(rs.getString(1));
				dto.setParent(rs.getString(2));
				dto.setGroup(rs.getString(3));
				dto.setCate1(rs.getString(4));
				dto.setCate2(rs.getString(5));
				dto.setUid(rs.getString(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setRdate(rs.getString(9));
				board.add(dto);	
			}
				close();
			
		} catch (Exception e) {
			logger.error("selectBoards() ERROR : " + e.getMessage());
		}
		return board;
	}
	
	public void updateBoard(CsDTO dto) {
	}
	
	public void deleteBoard(String no) {
		
	}
	
	// 페이징을 위한 메서드
	public int selectCountBoard(String group, String cate1) {
		int total = 0;
		try {
			conn = getConnection();
			
			if(group != null) {
				psmt = conn.prepareStatement(SQL.SELECT_COUNT_MAIN_CATE);
				psmt.setString(1, group);
			
			}else {
				psmt = conn.prepareStatement(SQL.SELECT_COUNT_MIDDLE_CATE);
				psmt.setString(1, group);
				psmt.setString(2, cate1);
			}
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();	
			
		}catch (Exception e) {
			logger.error("selectCountMainCate() ERROR : " + e.getMessage());
		}
		return total;
	}
	
	// 카테고리 상세 선택 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

	public List<CsDTO> selectCate1ListWhenGroupChoose(String group) {
		List<CsDTO> cate1List = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CATE1_LIST_WHEN_GROUP_CHOOSE);
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsDTO cate = new CsDTO();
				cate.setGroup(rs.getString(1));
				cate.setCate1(rs.getString(2));
				cate.setCate1_name(rs.getString(3));
				cate.setCate1_discription(rs.getString(4));
				cate1List.add(cate);
			}
			close();
			
		} catch (Exception e) {
			logger.error("selectCate1List()... : " + e.getMessage());
		}
		return cate1List;
	}
	
	public List<CsDTO> selectCate2ListWhenCate1Choose(String cate1) {
		List<CsDTO> cate2List = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CATE2_LIST_WHEN_CATE1_CHOOSE);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsDTO cate = new CsDTO();
				cate.setCate1(rs.getString(1));
				cate.setCate2(rs.getString(2));
				cate.setCate2_name(rs.getString(3));
				cate2List.add(cate);
			}
			close();
		} catch (Exception e) {
			logger.error("selectCate2List()... : " + e.getMessage());
		}
		return cate2List;
	}
}
