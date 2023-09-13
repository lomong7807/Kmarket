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
	
	public String termsResult(String signup) {
		String result = null;
		result = (signup == null)?"EMPTY!!":"good";
		return result;
	}
	
	@Override
	public String toString() {
		return "TermsDTO [terms=" + termsResult(terms) + ", "
				+ "privacy=" + termsResult(privacy) + ", "
				+ "location=" + termsResult(location) + ", "
				+ "finance=" + termsResult(finance) + ", "
				+ "tax=" + termsResult(tax) + "]";
	}
}