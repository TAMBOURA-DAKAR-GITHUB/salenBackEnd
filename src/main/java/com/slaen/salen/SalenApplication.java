package com.slaen.salen;

import com.slaen.salen.entity.*;
import com.slaen.salen.repository.*;
import com.slaen.salen.service.Saleninterface.AffecterPlaceMarchandInterface;
import com.slaen.salen.service.Saleninterface.AffecterPlaceUtilisateurInterface;
import com.slaen.salen.service.Saleninterface.MarchandInterface;
import com.slaen.salen.service.Saleninterface.UtilisateurInterface;
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


	public SalenApplication(RegionRepository regionRepository, CercleRepository cercleRepository,
							RepositoryRestConfiguration repositoryRestConfiguration, CommuneRepository communeRepository,
							MairieRepository mairieRepository, PlaceRepository placeRepository, UtilisateurRepository utilisateurRepository, MarcherRepository marcherRepository, UtilisateurInterface utilisateurInterface, AffecterPlaceUtilisateurInterface utilisateurInterface1, AffecterPlaceMarchandInterface affecterPlaceMarchandInterface, MarchandInterface marchandInterface) {
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

		Commune commune1= communeRepository.save(new Commune("Commune I",cercle1));
		Commune commune2=communeRepository.save(new Commune("Commune II",cercle1));
		Commune commune3=communeRepository.save(new Commune("Commune III",cercle1));
		Commune commune4=communeRepository.save(new Commune("Commune VI",cercle1));
		Commune commune5=communeRepository.save(new Commune("Commune V",cercle1));
		Commune commune6=communeRepository.save(new Commune("Commune VI",cercle1));

		Commune commune7=communeRepository.save(new Commune("Commune I",cercle2));
		Commune commune8=communeRepository.save(new Commune("Commune II",cercle2));
		Commune commune9=communeRepository.save(new Commune("Commune III",cercle2));
		Commune commune10=communeRepository.save(new Commune("Commune VI",cercle2));
		Commune commune11=communeRepository.save(new Commune("Commune V",cercle2));
		Commune commune12=communeRepository.save(new Commune("Commune VI",cercle2));

		Commune commune13=communeRepository.save(new Commune("Commune I",cercle3));
		Commune commune14=communeRepository.save(new Commune("Commune II",cercle3));
		Commune commune15=communeRepository.save(new Commune("Commune III",cercle3));
		Commune commune16=communeRepository.save(new Commune("Commune VI",cercle3));
		Commune commune17=communeRepository.save(new Commune("Commune V",cercle3));
		Commune commune18=communeRepository.save(new Commune("Commune VI",cercle3));

		Mairie mairie1= mairieRepository.save(new Mairie("Mairie Sokonigo","Sokonigo","Principale" ,commune6));
		Mairie mairie2=mairieRepository.save(new Mairie("Mairie Yirimadio","Yirimadio","Secondiare" ,commune6));
		Mairie mairie3=mairieRepository.save(new Mairie("Mairie Faladie","Faladie","Secondiare" ,commune6));
		Mairie mairie4=mairieRepository.save(new Mairie("Mairie Banankabougou","Banankabougou","Secondiare" ,commune6));

		Marcher marcher1= marcherRepository.save(new Marcher("Marcher S-A",mairie1));
		Marcher marcher2=marcherRepository.save(new Marcher("Marcher S-B",mairie1));
		Marcher marcher3=marcherRepository.save(new Marcher("Marcher Y-A",mairie2));
		Marcher marcher4=marcherRepository.save(new Marcher("Marcher Y-A",mairie2));

		Place place1= placeRepository.save(new Place("P00001",marcher3));
		Place place2=placeRepository.save(new Place("P00002",marcher3));
		Place place3=placeRepository.save(new Place("P00003",marcher3));
		Place place4=placeRepository.save(new Place("P00004",marcher3));
		Place place5=placeRepository.save(new Place("P00005",marcher3));


		Marchand marchand1= marchandInterface.addMarchand(new Marchand("BABA","BABA",new Date(),"89 76 34 09"));
		Marchand marchand2=marchandInterface.addMarchand(new Marchand("CISSE","OUMAR",new Date(),"89 76 34 09"));
		Marchand marchand3=marchandInterface.addMarchand(new Marchand("TRAORE","ABDOU",new Date(),"89 76 34 09"));
		Marchand marchand4=marchandInterface.addMarchand(new Marchand("DIARRA","MAMADOU",new Date(),"89 76 34 09"));



		Utilisateur utilisateur1= utilisateurRepository.save(new Utilisateur("TAMBOURA","Nouhoum","Yirimadio","C00001","87 97 65 33","ntam@gmail.com",mairie2));
		Utilisateur utilisateur2=utilisateurRepository.save(new Utilisateur("DIARRA","Mamadou","Yirimadio","C00002","88 97 00 33","ma@gmail.com",mairie2));
		Utilisateur utilisateur3=utilisateurRepository.save(new Utilisateur("COULIBALY","Fousseny","Yirimadio","C00003","34 00 65 33","fous@gmail.com",mairie2));
		Utilisateur utilisateur4=utilisateurRepository.save(new Utilisateur("SANOGO","Al","Yirimadio","C00004","90 97 65 33","al@gmail.com",mairie2));


		utilisateurInterface.AffecterPlaceToUtilisateur(utilisateur1,place1);
		utilisateurInterface.AffecterPlaceToUtilisateur(utilisateur2,place4);
		utilisateurInterface.AffecterPlaceToUtilisateur(utilisateur3,place3);
		utilisateurInterface.AffecterPlaceToUtilisateur(utilisateur4,place2);

		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(marchand1,place1);
		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(marchand2,place2);
		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(marchand1,place2);
		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(marchand3,place4);
		affecterPlaceMarchandInterface.AffecterPlaceToMarchand(marchand4,place3);







	}
}
