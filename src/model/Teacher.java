package model;
//idteacher, f_name, l_name, full_name, gender, nic, address, contact_no, email, subject, status
public class Teacher {
	int id;
	String f_name;
	String l_name;
	String full_name;
	String gender;
	String nic;
	String address;
	String contact_no;
	String email;
	String subject;
	int status;

	//constructors
	public Teacher(int id, String f_name, String l_name, String full_name, String gender, String nic, String address, String contact_no, String email, String subject, int status) {
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.full_name = full_name;
		this.gender = gender;
		this.nic = nic;
		this.address = address;
		this.contact_no = contact_no;
		this.email = email;
		this.subject = subject;
		this.status = status;
	}

	public Teacher() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
