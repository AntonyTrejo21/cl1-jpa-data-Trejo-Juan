package pe.edu.I202223136.cl1_jpa_data_Trejo_Juan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.I202223136.cl1_jpa_data_Trejo_Juan.entity.Country;
import pe.edu.I202223136.cl1_jpa_data_Trejo_Juan.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataTrejoJuanApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataTrejoJuanApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Optional<Country> optionalCountry = countryRepository.findByCode("ARG");
		optionalCountry.ifPresentOrElse(
				(country) -> {
					country.getLanguages().forEach(cl -> System.out.println(cl.getId().getLanguage()));
				},
				() -> countryRepository.findByCode("PER")
						.ifPresentOrElse(
								country -> country.getLanguages().forEach(cl -> System.out.println(cl.getId().getLanguage())),
								() -> System.out.println("No hay nada.")
						)
		);
//		List<String> lista = List.of("COL","ARG");
//        lista.stream().filter(countryRepository::existsById).collect(Collectors.toList());
//		countryRepository.deleteAllById(lista);
	}



}
