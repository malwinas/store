package com.malwinas.store.config;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Autowired
    private CassandraProperties cassandraProperties;

    @Override
    protected String getKeyspaceName() {
        return cassandraProperties.getKeyspaceName();
    }

    @Override
    protected String getContactPoints() {
        return cassandraProperties.getContactPoints();
    }

    @Override
    protected int getPort() {
        return cassandraProperties.getPort();
    }

    @Override
    protected AuthProvider getAuthProvider() {
        return new PlainTextAuthProvider(cassandraProperties.getUsername(), cassandraProperties.getPassword());
    }

    @Bean
    public CassandraOperations operations() throws Exception {
        return new CassandraTemplate(session().getObject(), new MappingCassandraConverter(new BasicCassandraMappingContext()));
    }
}
