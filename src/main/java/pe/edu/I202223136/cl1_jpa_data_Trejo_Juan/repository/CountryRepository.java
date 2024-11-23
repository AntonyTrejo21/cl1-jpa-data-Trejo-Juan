package pe.edu.I202223136.cl1_jpa_data_Trejo_Juan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.I202223136.cl1_jpa_data_Trejo_Juan.entity.Country;
import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country,String> {
    Optional<Country> findByCode(String code);
}
