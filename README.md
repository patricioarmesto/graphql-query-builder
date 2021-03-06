# graphql-query-builder [![Build Status](https://travis-ci.org/k0kubun/graphql-query-builder.svg?branch=master)](https://travis-ci.org/k0kubun/graphql-query-builder)

GraphQL query builder for Java

## Installation

### Maven (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>com.github.k0kubun</groupId>
        <artifactId>graphql-query-builder</artifactId>
        <version>0.2.2</version>
    </dependency>
</dependencies>
```

### Gradle (build.gradle)

```groovy
dependencies {
    compile 'com.github.k0kubun:graphql-query-builder:0.2.2'
}
```

## Usage

To build following query,

```graphql
user(name:"k0kubun") {
  name
  friends(first:10 after:"Y3Vyc29yMQ==") {
    totalCount
    edges {
      cursor
      node {
        ... on User {
          name
        }
      }
    }
  }
}
```

you can write code in the following way.

```java
import com.github.k0kubun.builder.query.graphql.GraphQL;
import java.util.HashMap;
import java.util.Map;

Map<String, String> userParams = new HashMap<>();
userParams.put("name", "k0kubun");

String query = GraphQL.createQueryBuilder()
    .object("user", userParams, GraphQL.createObjectBuilder()
        .field("name")
        .objects("friends", 10, "Y3Vyc29yMQ==", GraphQL.createObjectBuilder()
            .field("totalCount")
            .object("edges", GraphQL.createObjectBuilder()
                .field("cursor")
                .object("node", GraphQL.createObjectBuilder()
                    .on("User", GraphQL.createObjectBuilder()
                        .field("name")
                        .build()
                    ).build()
                ).build()
            ).build()
        ).build()
    ).build();
```

## Project Status

Experimental.

### Unsupported features

- `@include`
- `@skip`
- Mutation
- Fragments
- Variables
- Aliases

## License

MIT License
