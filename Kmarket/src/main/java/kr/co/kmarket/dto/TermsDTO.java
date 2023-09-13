package kr.co.kmarket.dto;

public class TermsDTO {
	
	private String terms;
	private String privacy;
	private String location;
	private String finance;
	private String tax;
	
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFinance() {
		return finance;
	}
	public void setFinance(String finance) {
		this.finance = finance;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	
	String tv = (terms    == null)?"null":"data";
	String tp = (privacy  == null)?"null":"data";
	String tl = (location == null)?"null":"data";
	String tf = (finance  == null)?"null":"data";
	String tt = (tax      == null)?"null":"data";
	
	@Override
	public String toString() {
		return "TermsDTO [terms=" + tv + ", "
				+ "privacy=" + privacy + ", "
				+ "location=" + location + ", "
				+ "finance=" + finance + ", "
				+ "tax=" + tax + "]";
	}
}