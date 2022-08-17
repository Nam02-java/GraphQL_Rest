package thrid_step.Service_graphQL.datafetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import thrid_step.Service_graphQL.datafetcher.datafetcher.AllPersonsDataFetcher;
import thrid_step.Service_graphQL.datafetcher.datafetcher.PersonDataFetcher;
import thrid_step.model_graphQL.Person_graphql;
import thrid_step.repository_graphQL.PersonRepository;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class GraphQLService {

    @Autowired
    PersonRepository personRepository;

    @Value("classpath:persons.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllPersonsDataFetcher allPersonsDataFetcher;
    @Autowired
    private PersonDataFetcher personDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {
        loadDataIntoHSQL();
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private void loadDataIntoHSQL() {
        Stream.of(new Person_graphql("123", "a", "a", "a", "A")).forEach(person_graphql -> {
            personRepository.save(person_graphql);
        });
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allPersons", allPersonsDataFetcher)
                        .dataFetcher("person", personDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
