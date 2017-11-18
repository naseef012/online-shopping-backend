package com.naseef.shoppingbackend.test;


import com.naseef.shoppingbackend.dao.ProductDAO;
import com.naseef.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created By Naseef M Abdus Sattar on 10/28/2017 at 12:31 AM
 */
public class ProductTestCase
{
    private static AnnotationConfigApplicationContext context;

    private static ProductDAO productDAO;

    private Product product;

    @BeforeClass
    public static void init()
    {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.naseef.shoppingbackend");
        context.refresh();

        productDAO = (ProductDAO)context.getBean("productDAO");
    }


    /*@Test
    public void testCrudProduct()
    {
        //Adding a product
        product = new Product();

        product.setName("Oppo Selfie S53");
        product.setBrand("Oppo");
        product.setDescription("Oppo Description");
        product.setUnitPrice(25000);
        product.setActive(true);
        product.setSupplierId(3);
        product.setCategoryId(1);
        product.setQuantity(5);


        assertEquals("Failed Adding a product in database",true,productDAO.add(product));
     }
        //Fetching and updating a product
        product = productDAO.get(2);
        product.setName("Samsung Galaxy S7");

        assertEquals("Failed Updating", true,productDAO.update(product));

        //Deleting a product
        product = productDAO.get(1);
        assertEquals("Failed in Deleting the record from the table ",true,productDAO.delete(product));

        //List of Product
        assertEquals("Failed in Fetching the list of product",6,productDAO.getActiveProducts().size());

    }*/

    @Test
    public void testActiveProductByCategory()
    {
        //List of active products by category
        assertEquals("Failed in fetching list of products by category",3,productDAO.getActiveProductByCategory(1).size());
        assertEquals("Failed in fetching list of products by category 3",2,productDAO.getActiveProductByCategory(3).size());
    }

    @Test
    public void testLatestActiveProduct()
    {
        assertEquals("Failed in getting list of latest list of products",3,productDAO.getLatestActiveProducts(3).size());
    }
}

