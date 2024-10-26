package hs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcBuyerDao implements BuyerDao{

	@Override
	public boolean insert(Buyer buyer) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO BUYER (BUYER_NUMBER,BUYER_ID,PASSWORD,NAME,POSTAL_CODE,STREET_ADDRESS,ADDRESS_DETAIL,PHONE_NUMBER,EMAIL) VALUES (?,?,?,?,?,?,?,?,?)")){
			
			pStatement.setInt(1, buyer.getBUYER_NUMBER());
			pStatement.setString(2, buyer.getBUYER_ID());
			pStatement.setString(3, buyer.getPASSWORD());
			pStatement.setString(4, buyer.getNAME());
			pStatement.setString(5, buyer.getPOSTAL_CODE());
			pStatement.setString(6, buyer.getSTREET_ADDRESS());
			pStatement.setString(7, buyer.getADDRESS_DETAIL());
			pStatement.setString(8, buyer.getPHONE_NUMBER());
			pStatement.setString(9, buyer.getEMAIL());
			
			
			int rows = pStatement.executeUpdate();
			
			if(rows > 0) {
				result = true;
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Buyer> findAll() {
		List<Buyer> buyers = new ArrayList<Buyer>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM BUYER ORDER BY BUYER_ID DESC");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
				Buyer buyer = new Buyer();
				
				buyer.setBUYER_NUMBER(rs.getInt("BUYER_NUMBER"));
				buyer.setBUYER_ID(rs.getString("BUYER_ID"));
				buyer.setPASSWORD(rs.getString("PASSWORD"));
				buyer.setNAME(rs.getString("NAME"));
				buyer.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
				buyer.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
				buyer.setADDRESS_DETAIL(rs.getString("ADDRESS_DETAIL"));
				buyer.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
				buyer.setEMAIL(rs.getString("EMAIL"));
				
				buyers.add(buyer);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return buyers;
	}

	@Override
	public Buyer findById(String BUYER_ID) {
		Buyer buyer = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM BUYER WHERE BUYER_ID = ?")
		) {
		
		pStatement.setString(1, BUYER_ID);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			buyer = new Buyer();
				
			buyer.setBUYER_NUMBER(rs.getInt("BUYER_NUMBER"));
			buyer.setBUYER_ID(rs.getString("BUYER_ID"));
			buyer.setPASSWORD(rs.getString("PASSWORD"));
			buyer.setNAME(rs.getString("NAME"));
			buyer.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
			buyer.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			buyer.setADDRESS_DETAIL(rs.getString("ADDRESS_DETAIL"));
			buyer.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
			buyer.setEMAIL(rs.getString("EMAIL"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return buyer;
	}

	@Override
	public boolean update(Buyer buyer) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("UPDATE BUYER SET PASSWORD = ? WHERE BUYER_ID = ?")){
			
			pStatement.setString(1, buyer.getPASSWORD());
			pStatement.setString(2, buyer.getBUYER_ID());
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteById(String BUYER_ID) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM BUYER WHERE BUYER_ID = ?")){
			
			pStatement.setString(1, BUYER_ID);
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}
	
	
}
