package ressources;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.*;


public class peupleur {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("jdbc");
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		
		Utilisateur steven= new Utilisateur("steven@test.fr", "azeRTY", "DE CARVALHO","Steven", new Date() , "Jérôme");
		Utilisateur soufian= new Utilisateur("soufian@test.fr", "AZErty","AIT TIRITE" ,"Soufian", new Date(), "Jérôme");
		Utilisateur jerome= new Utilisateur("jerome@test.fr", "AZERTY","JOUËT", "Jerome", new Date(), "Jérôme");
		Utilisateur elie= new Utilisateur("elie@test.fr", "azerty","ABOU HAYDAR", "Elie", new Date(), "Jérôme");
		
		Role admin= new Role("Administrateur", new Date(), "Steven", "TOUS LES DROITS");
		Role magasin= new Role("Magasin", new Date(), "Steven", "Annonce et vendre une guitare");
		Role particulier= new Role("Particulier", new Date(), "Steven", "Utilise la plateforme");
		
		Action admcreation= new Action("Admin: Créer une section", new Date(), "Jérôme", "");
		Action admajout= new Action("Admin: Ajouter une annonce", new Date(), "Jérôme", "");
		Action admedit= new Action("Admin: Editer une annonce", new Date(), "Jérôme", "");
		Action admsuppr= new Action("Admin: Supprimer une annonce", new Date(), "Jérôme", "");
		Action admban= new Action("Admin: Bannir un client", new Date(), "Jérôme", "");
		

		Action magajout= new Action("Mag: Ajouter une annonce", new Date(), "Jérôme", "");
		Action magedit= new Action("Mag: Editer une annonce", new Date(), "Jérôme", "");
		Action magsuppr= new Action("Mag: Supprimer une annonce", new Date(), "Jérôme", "");
		

		Action partiajout= new Action("Particulier: Ajouter une annonce", new Date(), "Jérôme", "");
		Action partiedit= new Action("Particulier: Editer une annonce", new Date(), "Jérôme", "");
	
		admin.ajoutAction(admcreation);
		admin.ajoutAction(admajout);
		admin.ajoutAction(admedit);
		admin.ajoutAction(admsuppr);
		admin.ajoutAction(admban);
		
		magasin.ajoutAction(magajout);
		magasin.ajoutAction(magedit);
		magasin.ajoutAction(magsuppr);
		
		
		particulier.ajoutAction(partiajout);
		particulier.ajoutAction(partiedit);
		
		admin.ajoutUtilisateur(jerome);
		
		magasin.ajoutUtilisateur(soufian);
		
		particulier.ajoutUtilisateur(elie);
		particulier.ajoutUtilisateur(steven);
		
		em.persist(admin);
		em.persist(magasin);
		em.persist(particulier);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
