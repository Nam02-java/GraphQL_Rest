package thrid_step.Repositories_Rest;

import org.springframework.data.jpa.repository.JpaRepository;
import thrid_step.Model_Rest.Person_rest;

public interface Name_Repository_Rest extends JpaRepository<Person_rest,Long> {
}
