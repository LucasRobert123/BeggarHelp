package models;

import javax.persistence.EntityManager;

import conf.JPAUtil;

public class Main {

	public static void main(String[] args) {


		 EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		//Testes
		/*Institution institution = new Institution();
		institution.setId(1);
		institution.setProfilePicture("https://image.com/profile.png");
		institution.setName("IAMDR");
		institution.setPhone("3841616616161");
		institution.setEmail("institution@gmail.com");
		institution.setPassword("jskamk45151");
		institution.setNeighborhood("Pio XII");
		institution.setStreet("Rua Carlos Caiafa");
		institution.setNumber("185");
		institution.setCity("São Tomé das Letras");
		institution.setUf("MG");
		institution.setCnpj("664646-466");
		institution.setDescription("Instituição focada em doas mantimentos");
		
		
		Donor donor = new Donor();
		
		List<Donor> listDonor = new ArrayList<Donor>();
		
		donor.setId(1);
		donor.setProfilePicture("https://image.com/profile.png");
		donor.setName("Fautão");
		donor.setPhone("3841616616161");
		donor.setEmail("faustão@gmail.com");
		donor.setPassword("jskamk45151");
		donor.setNeighborhood("São Benedito");
		donor.setStreet("Rua José Augusto");
		donor.setNumber("196");
		donor.setCity("São Tomé das Letras");
		donor.setUf("MG");
		donor.setCpf("1662642626595");
		
		listDonor.add(donor);
		institution.setDoadores(listDonor);
		
		System.out.println(institution);*/
		JPAUtil.shutdown();
	}

}
