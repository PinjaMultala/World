package fi.academy.ekajpaharjoitus;

import fi.academy.ekajpaharjoitus.entities.Country;
        import org.springframework.data.repository.CrudRepository;

        import javax.validation.constraints.Size;
        import java.util.List;

public interface MaailmaRepository extends CrudRepository<Country, String> {

    List<Country> findCountryByNameContains(String name);

}
