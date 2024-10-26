package hs;

public class Buyer {
	private int BUYER_NUMBER;
	private String BUYER_ID;
	private String PASSWORD;
	private String NAME;
	private String POSTAL_CODE;
	private String STREET_ADDRESS;
	private String ADDRESS_DETAIL;
	private String PHONE_NUMBER;
	private String EMAIL;
	
	Buyer(){}
	
	public Buyer(int BUYER_NUMBER,String BUYER_ID,String PASSWORD,String NAME,String POSTAL_CODE,String STREET_ADDRESS,String ADDRESS_DETAIL,String PHONE_NUMBER,String EMAIL) {
		this.ADDRESS_DETAIL = ADDRESS_DETAIL;
		this.BUYER_ID = BUYER_ID;
		this.BUYER_NUMBER = BUYER_NUMBER;
		this.EMAIL = EMAIL;
		this.NAME = NAME;
		this.PASSWORD = PASSWORD;
		this.PHONE_NUMBER = PHONE_NUMBER;
		this.POSTAL_CODE = POSTAL_CODE;
		this.STREET_ADDRESS = STREET_ADDRESS;
	}

	public int getBUYER_NUMBER() {
		return BUYER_NUMBER;
	}

	public void setBUYER_NUMBER(int bUYER_NUMBER) {
		BUYER_NUMBER = bUYER_NUMBER;
	}

	public String getBUYER_ID() {
		return BUYER_ID;
	}

	public void setBUYER_ID(String bUYER_ID) {
		BUYER_ID = bUYER_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPOSTAL_CODE() {
		return POSTAL_CODE;
	}

	public void setPOSTAL_CODE(String pOSTAL_CODE) {
		POSTAL_CODE = pOSTAL_CODE;
	}

	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;
	}

	public void setSTREET_ADDRESS(String sTREET_ADDRESS) {
		STREET_ADDRESS = sTREET_ADDRESS;
	}

	public String getADDRESS_DETAIL() {
		return ADDRESS_DETAIL;
	}

	public void setADDRESS_DETAIL(String aDDRESS_DETAIL) {
		ADDRESS_DETAIL = aDDRESS_DETAIL;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	@Override
	public String toString() {
		return "Buyer [BUYER_NUMBER=" + BUYER_NUMBER + ", BUYER_ID=" + BUYER_ID + ", PASSWORD=" + PASSWORD + ", NAME="
				+ NAME + ", POSTAL_CODE=" + POSTAL_CODE + ", STREET_ADDRESS=" + STREET_ADDRESS + ", ADDRESS_DETAIL="
				+ ADDRESS_DETAIL + ", PHONE_NUMBER=" + PHONE_NUMBER + ", EMAIL=" + EMAIL + "]";
	}
	
	
}
