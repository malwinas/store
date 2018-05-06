package com.malwinas.store.repository;

import com.malwinas.store.domain.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product> {
}
