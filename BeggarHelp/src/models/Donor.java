package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Donor extends User{
	
	@Column(length = 14)
    String cpf;

    public Donor() {}


	public Donor(int id, String profilePicture, String name, String phone, String email, String password,
			String neighborhood, String street, String number, String city, String uf) {
		super(id, profilePicture, name, phone, email, password, neighborhood, street, number, city, uf);
		// TODO Auto-generated constructor stub
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
	
	
	
	
}
