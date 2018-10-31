package org.sid;

import java.util.Date;

import org.sid.dao.ClientRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.CompteEpargne;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
		
//		ApplicationContext ctx = SpringApplication.run(VotreBanqueApplication.class, args);
//		ClientRepository clientRepository =  ctx.getBean(ClientRepository.class);
//		clientRepository.save(new Client("Hassan", "hassan@gmail.com"));
		// Je suis DIOUM2TOUBA
		
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Client c1 = clientRepository.save(new Client("Hassan", "hassan@gmail.com"))	;	
//		Client c2 = clientRepository.save(new Client("Rachid", "rachid@gmail.com"))	;
//		
//		Compte cp1 = compteRepository.save(
//				new CompteCourant("cp1", new Date(), 90000, c1, 6000));
//		Compte cp2 = compteRepository.save(
//				new CompteEpargne("cp2", new Date(), 6000, c2, 5.5));
//		
//		operationRepository.save(new Versement(new Date(),9000 , cp1) );
//		operationRepository.save(new Versement(new Date(),6000 , cp1) );
//		operationRepository.save(new Versement(new Date(),2300 , cp1) );
//		operationRepository.save(new Retrait(new Date(),9000 , cp1) );
//		
//		operationRepository.save(new Versement(new Date(),2300 , cp2) );
//		operationRepository.save(new Versement(new Date(),400 , cp2) );
//		operationRepository.save(new Versement(new Date(),2300 , cp2) );
//		operationRepository.save(new Retrait(new Date(),3000 , cp2) );
//		
//		banqueMetier.verser("cp1", 111111);
	}
}
