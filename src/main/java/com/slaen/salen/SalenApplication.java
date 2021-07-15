package com.slaen.salen;

import com.slaen.salen.entity.*;
import com.slaen.salen.repository.*;
import com.slaen.salen.service.Saleninterface.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class SalenApplication implements CommandLineRunner {

	private RegionRepository regionRepository;
	private CercleRepository cercleRepository;
	private RepositoryRestConfiguration repositoryRestConfiguration;
	private CommuneRepository communeRepository;
	private MairieRepository mairieRepository;
	private PlaceRepository placeRepository;
	private UtilisateurRepository utilisateurRepository;
	private MarcherRepository marcherRepository;

	private AffecterPlaceUtilisateurInterface utilisateurInterface;
	private AffecterPlaceMarchandInterface affecterPlaceMarchandInterface;
	private MarchandInterface marchandInterface;
	private PayementInterface payementInterface;


	public SalenApplication(RegionRepository regionRepository, CercleRepository cercleRepository,
							RepositoryRestConfiguration repositoryRestConfiguration, CommuneRepository communeRepository,
							MairieRepository mairieRepository, PlaceRepository placeRepository, UtilisateurRepository utilisateurRepository, MarcherRepository marcherRepository, UtilisateurInterface utilisateurInterface, AffecterPlaceUtilisateurInterface utilisateurInterface1, AffecterPlaceMarchandInterface affecterPlaceMarchandInterface, MarchandInterface marchandInterface, PayementInterface payementInterface) {
		this.regionRepository = regionRepository;
		this.cercleRepository = cercleRepository;
		this.repositoryRestConfiguration = repositoryRestConfiguration;
		this.communeRepository = communeRepository;
		this.mairieRepository = mairieRepository;
		this.placeRepository = placeRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.marcherRepository = marcherRepository;
		this.utilisateurInterface = utilisateurInterface1;
		this.affecterPlaceMarchandInterface = affecterPlaceMarchandInterface;
		this.marchandInterface = marchandInterface;
		this.payementInterface = payementInterface;
	}

	public static void main(String[] args) {
		SpringApplication.run(SalenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Region.class , Cercle.class);

		Region region1= regionRepository.save(new Region("Kayes"));
		Region region2= regionRepository.save(new Region("Koulikoro"));
		Region region3= regionRepository.save(new Region("Sikasso"));
		Region region4= regionRepository.save(new Region("Segou"));
		Region region5= regionRepository.save(new Region("Mopti"));
		Region region6= regionRepository.save(new Region("Gao"));
		Region region7= regionRepository.save(new Region("Tombouctou"));
		Region region8= regionRepository.save(new Region("Kidal"));
		Region region9= regionRepository.save(new Region("Taoudeni"));
		Region region10= regionRepository.save(new Region("Tessalite"));

		Region region11= regionRepository.save(new Region("Bamako"));

		Cercle cercle1= cercleRepository.save(new Cercle("cercle1", region1));
		Cercle cercle2= cercleRepository.save(new Cercle("cercle2", region1));
		Cercle cercle3= cercleRepository.save(new Cercle("cercle3", region1));

		Cercle cercle4= cercleRepository.save(new Cercle("cercle1", region2));
		Cercle cercle5= cercleRepository.save(new Cercle("cercle2", region2));
		Cercle cercle6= cercleRepository.save(new Cercle("cercle3", region3));

		Cercle cercle7= cercleRepository.save(new Cercle("cercle1", region3));
		Cercle cercle8= cercleRepository.save(new Cercle("cercle2", region3));
		Cercle cercle9= cercleRepository.save(new Cercle("cercle3", region3));

		Cercle cercle10= cercleRepository.save(new Cercle("cercle1", region4));
		Cercle cercle11= cercleRepository.save(new Cercle("cercle2", region4));
		Cercle cercle12= cercleRepository.save(new Cercle("cercle3", region4));

		Cercle cercle13= cercleRepository.save(new Cercle("cercle1", region5));
		Cercle cercle14= cercleRepository.save(new Cercle("cercle2", region5));
		Cercle cercle15= cercleRepository.save(new Cercle("cercle3", region5));

		Cercle cercle16= cercleRepository.save(new Cercle("cercle1", region6));
		Cercle cercle17= cercleRepository.save(new Cercle("cercle2", region6));
		Cercle cercle18= cercleRepository.save(new Cercle("cercle3", region6));

		Cercle cercle19= cercleRepository.save(new Cercle("cercle1", region7));
		Cercle cercle20= cercleRepository.save(new Cercle("cercle2", region7));
		Cercle cercle21= cercleRepository.save(new Cercle("cercle3", region7));

		Cercle cercle22= cercleRepository.save(new Cercle("cercle1", region8));
		Cercle cercle23= cercleRepository.save(new Cercle("cercle2", region8));
		Cercle cercle24= cercleRepository.save(new Cercle("cercle3", region8));

		Cercle cercle25= cercleRepository.save(new Cercle("cercle1", region9));
		Cercle cercle26= cercleRepository.save(new Cercle("cercle2", region9));
		Cercle cercle27= cercleRepository.save(new Cercle("cercle3", region9));

		Cercle cercle28= cercleRepository.save(new Cercle("cercle1", region10));
		Cercle cercle29= cercleRepository.save(new Cercle("cercle2", region10));
		Cercle cercle30= cercleRepository.save(new Cercle("cercle3", region10));

		Cercle cercle31= cercleRepository.save(new Cercle("Bamako", region11));



		Commune commune1= communeRepository.save(new Commune("Commune I",cercle31));
		Commune commune2=communeRepository.save(new Commune("Commune II",cercle31));
		Commune commune3=communeRepository.save(new Commune("Commune III",cercle31));
		Commune commune4=communeRepository.save(new Commune("Commune VI",cercle31));
		Commune commune5=communeRepository.save(new Commune("Commune V",cercle31));
		Commune commune6=communeRepository.save(new Commune("Commune VI",cercle31));



		Mairie mairie1= mairieRepository.save(new Mairie("Mairie Sokonigo","Sokonigo","Principale" ,commune6));
		Mairie mairie2=mairieRepository.save(new Mairie("Mairie Yirimadio","Yirimadio","Secondaire" ,commune6));
		Mairie mairie3=mairieRepository.save(new Mairie("Mairie Faladie","Faladie","Secondaire" ,commune6));
		Mairie mairie4=mairieRepository.save(new Mairie("Mairie Banankabougou","Banankabougou","Secondaire" ,commune6));

		Marcher marcher1= marcherRepository.save(new Marcher("Marcher S-A",mairie1));
		Marcher marcher2=marcherRepository.save(new Marcher("Marcher S-B",mairie1));
		Marcher marcher3=marcherRepository.save(new Marcher("Marcher Y-A",mairie2));
		Marcher marcher4=marcherRepository.save(new Marcher("Marcher Y-B",mairie2));

		Place place1= placeRepository.save(new Place("P00001", marcher3));
		Place place2=placeRepository.save(new Place("P00002",marcher3));
		Place place3=placeRepository.save(new Place("P00003",marcher3));
		Place place4=placeRepository.save(new Place("P00004",marcher3));
		Place place5=placeRepository.save(new Place("P00005",marcher3));

		Place place6= placeRepository.save(new Place("P00A01", marcher2));
		Place place7=placeRepository.save(new Place("P000A2",marcher2));
		Place place8=placeRepository.save(new Place("P000A3",marcher2));
		Place place9=placeRepository.save(new Place("P000A4",marcher2));
		Place place10=placeRepository.save(new Place("P00A05",marcher2));
		Place place11= placeRepository.save(new Place("P00001", marcher2));
		Place place12=placeRepository.save(new Place("P00002",marcher2));
		Place place13=placeRepository.save(new Place("P00003",marcher3));
		Place place14=placeRepository.save(new Place("P00004",marcher2));
		Place place15=placeRepository.save(new Place("P00005",marcher3));


		Marchand marchand1= marchandInterface.addMarchand(new Marchand("BABA","BABA","89 76 34 09",marcher3));
		Marchand marchand2=marchandInterface.addMarchand(new Marchand("CISSE","OUMAR","89 76 34 09",marcher3));
		Marchand marchand3=marchandInterface.addMarchand(new Marchand("TRAORE","ABDOU","89 76 34 09",marcher3));
		Marchand marchand4=marchandInterface.addMarchand(new Marchand("DIARRA","MAMADOU","89 76 34 09", marcher3));



		Utilisateur utilisateur1= utilisateurRepository.save(new Utilisateur("TAMBOURA","Nouhoum","Yirimadio","87 97 65 33","ntam@gmail.com",mairie2));
		Utilisateur utilisateur2=utilisateurRepository.save(new Utilisateur("DIARRA","Mamadou","Yirimadio","88 97 00 33","ma@gmail.com",mairie2));
		Utilisateur utilisateur3=utilisateurRepository.save(new Utilisateur("COULIBALY","Fousseny","Yirimadio","34 00 65 33","fous@gmail.com",mairie2));
		Utilisateur utilisateur4=utilisateurRepository.save(new Utilisateur("SANOGO","Al","Yirimadio","90 97 65 33","al@gmail.com",mairie2));

		Utilisateur utilisateur5= utilisateurRepository.save(new Utilisateur("TAMB","Nouhoum","Yirimadio","87 97 65 33","ntam@gmail.com",mairie1));
		Utilisateur utilisateur6=utilisateurRepository.save(new Utilisateur("DIA","Mamadou","Yirimadio","88 97 00 33","ma@gmail.com",mairie1));
		Utilisateur utilisateur7=utilisateurRepository.save(new Utilisateur("COUL","Fousseny","Yirimadio","34 00 65 33","fous@gmail.com",mairie1));
		Utilisateur utilisateur8=utilisateurRepository.save(new Utilisateur("SANG","Al","Yirimadio","90 97 65 33","al@gmail.com",mairie1));


		Utilisateur utilisateur9=utilisateurRepository.save(new Utilisateur("test","test","test","00 00 00 00","test@gmail.com",mairie1));

//		utilisateurInterface.AffecterPlaceToUtilisateur(1,1);
//		utilisateurInterface.AffecterPlaceToUtilisateur(1,2);
//		utilisateurInterface.AffecterPlaceToUtilisateur(1,3);
//		utilisateurInterface.AffecterPlaceToUtilisateur(1,4);
//		utilisateurInterface.AffecterPlaceToUtilisateur(1,5);
//
//		utilisateurInterface.AffecterPlaceToUtilisateur(2,6);
//		utilisateurInterface.AffecterPlaceToUtilisateur(2,7);
//		utilisateurInterface.AffecterPlaceToUtilisateur(2,8);
//		utilisateurInterface.AffecterPlaceToUtilisateur(2,9);
//		utilisateurInterface.AffecterPlaceToUtilisateur(2,10);

//		utilisateurInterface.AffecterPlaceToUtilisateur(1,1);
//		utilisateurInterface.AffecterPlaceToUtilisateur(1,2);
//		utilisateurInterface.AffecterPlaceToUtilisateur(9,3);
//		utilisateurInterface.AffecterPlaceToUtilisateur(9,4);
//		utilisateurInterface.AffecterPlaceToUtilisateur(9,5);
//
//		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(1,1);
//		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(2,2);
//		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(3,3);
//		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(3,4);
//		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(4,5);

		payementInterface.addPayement(new Payement(new Date(),100,0, marchand1,place1, utilisateur1));
		payementInterface.addPayement(new Payement(new Date(),100,0, marchand1,place2,utilisateur1));
		payementInterface.addPayement(new Payement(new Date(),100,0, marchand2,place3,utilisateur1));
		payementInterface.addPayement(new Payement(new Date(),100,0, marchand4,place5,utilisateur2));










	}
}
