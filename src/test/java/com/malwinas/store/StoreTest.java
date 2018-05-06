package com.malwinas.store;

import com.malwinas.store.domain.Product;
import com.malwinas.store.repository.ProductRepository;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoreApplication.class)
public class StoreTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @Before
    public void insertProduct() {
        product = new Product();
        product.setId(UUID.randomUUID());
        product.setName("bread");
        product.setPrice(new BigDecimal(2.5));
        product.setExpiry(DateTime.now().plusDays(2).toDate());

        product = productRepository.save(product);
    }

    @Test
    public void findProduct() {
        Assert.assertNotNull(productRepository.findOne(BasicMapId.id("id", product.getId())));
    }
}
