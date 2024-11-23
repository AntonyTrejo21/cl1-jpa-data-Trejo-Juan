package pe.edu.I202223136.cl1_jpa_data_Trejo_Juan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class CountryLanguage {

    @Embeddable
    @Getter
    @Setter
    public static class CountryLanguageId implements Serializable {
        private String countryCode;
        private String language;

        public CountryLanguageId() {}

        public CountryLanguageId(String countryCode, String language) {
            this.countryCode = countryCode;
            this.language = language;
        }
    }
    @EmbeddedId
    private CountryLanguageId id;
    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;
    private String isOfficial;
    private float percentage;

    public CountryLanguage() {}

    public CountryLanguage(Country country, String language, String isOfficial, float percentage) {
        this.id = new CountryLanguageId(country.getCode(), language);
        this.country = country;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }
}
