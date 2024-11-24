package pe.edu.I202223136.cl1_jpa_data_Trejo_Juan.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguageId implements Serializable {
    private String countryCode;
    private String language;
}