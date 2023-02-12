package model;

public class Emp {
	private int id;
	private String fname;
	private String address;
	
	
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public Emp(int id, String fname) {
		super();
		this.id = id;
		this.fname = fname;
	}






	public Emp(int id, String fname, String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.address = address;
	}






	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
