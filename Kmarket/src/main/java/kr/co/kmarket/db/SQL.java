package kr.co.kmarket.db;

public class SQL {

	//**************************************************************************************************//
	//********************************************* Member *********************************************//
	//**************************************************************************************************//
	public static final String INSERT_MEMBER = "INSERT INTO `km_member` SET "
												+ "`uid`= ?, "
												+ "`pass`= SHA2(?, 256), "
												+ "`name`= ?, "
												+ "`gender`= ?, "
												+ "`email`= ?, "
												+ "`type` = 1, "
												+ "`hp`= ?, "
												+ "`zip`= ?, "
												+ "`addr1`= ?, "
												+ "`addr2`= ?, "
												+ "`regip`= ?, "
												+ "`rdate`= NOW()";
	
	public static final String SELECT_MEMBER = "SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?, 256)";
	
	
	//********************************************************************************************************//
	//********************************************* Member_Point *********************************************//
	//********************************************************************************************************//
	
	
	
	//*************************************************************************************************//
	//********************************************* Terms *********************************************//
	//*************************************************************************************************//
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
	
	
	//***************************************************************************************************//
	//********************************************* Product *********************************************//
	//***************************************************************************************************//
	
	
	
	//********************************************************************************************************//
	//********************************************* Product_Cart *********************************************//
	//********************************************************************************************************//
	
	
	
	//*********************************************************************************************************//
	//********************************************* Product_Cate1 *********************************************//
	//*********************************************************************************************************//
	
	
	
	//*********************************************************************************************************//
	//********************************************* Product_Cate2 *********************************************//
	//*********************************************************************************************************//
	
	
	
	//*********************************************************************************************************//
	//********************************************* Product_Order *********************************************//
	//*********************************************************************************************************//
	
	
	
	//**************************************************************************************************************//
	//********************************************* Product_Order_Item *********************************************//
	//**************************************************************************************************************//
	
	
	
	//**********************************************************************************************************//
	//********************************************* Product_Review *********************************************//
	//**********************************************************************************************************//
}
