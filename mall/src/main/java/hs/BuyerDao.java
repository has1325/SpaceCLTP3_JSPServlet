package hs;

import java.util.List;

public interface BuyerDao {
	boolean insert(Buyer buyer);
	
	List<Buyer> findAll();
	
	Buyer findById(String BUYER_ID);
	
	boolean update(Buyer buyer);
	
	boolean deleteById(String BUYER_ID);
}
