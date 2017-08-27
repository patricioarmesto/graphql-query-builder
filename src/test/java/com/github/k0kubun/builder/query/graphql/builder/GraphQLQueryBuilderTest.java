package com.github.k0kubun.builder.query.graphql.builder;

import com.github.k0kubun.builder.query.graphql.GraphQL;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphQLQueryBuilderTest
{
    @Test public void buildEmptyQuery()
    {
        String query = GraphQL.createQueryBuilder()
            .build();
        assertEquals("", query);
    }

    @Test public void buildFields()
    {
        String query = GraphQL.createQueryBuilder()
            .field("id")
            .field("name")
            .build();
        assertEquals(
                "id\n" +
                "name\n",
                query);
    }

    @Test public void buildEmptyObject()
    {
        String query = GraphQL.createQueryBuilder()
            .object("query", GraphQL.createObjectBuilder()
                .build()
            )
            .build();
        assertEquals(
                "query {\n" +
                "}\n",
                query);
    }
}