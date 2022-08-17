package thrid_step.Service_graphQL.datafetcher.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thrid_step.model_graphQL.Person_graphql;
import thrid_step.repository_graphQL.PersonRepository;

import java.util.List;

@Component
public class AllPersonsDataFetcher implements DataFetcher<List<Person_graphql>> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person_graphql> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return personRepository.findAll();
    }
}
