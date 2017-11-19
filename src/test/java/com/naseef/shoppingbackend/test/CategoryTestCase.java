package com.naseef.shoppingbackend.test;

import com.naseef.shoppingbackend.dao.CategoryDAO;
import com.naseef.shoppingbackend.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created By Naseef M Abdus Sattar on 10/24/2017 at 2:02 PM
 */
public class CategoryTestCase
{
    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init()
    {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.naseef.shoppingbackend");
        context.refresh();

        categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
    }

   @Test
    public void testCrudCategory()
   {

       //Adding a category
       category = new Category();

       category.setName("TV");
       category.setDescription("TV Description");
       category.setImageURL("CAT_1.png");

       assertEquals("Failed Adding a product in database",true,categoryDAO.add(category));

       category = new Category();

       category.setName("Laptop");
       category.setDescription("Laptop Description");
       category.setImageURL("CAT_2.png");

       assertEquals("Failed Updating",true,categoryDAO.add(category));


       //Fetching and Updating a category
       category = categoryDAO.get(1);
       category.setName("Television");

       assertEquals("Successfully updated a single category in a table", true,categoryDAO.update(category));

       //Deleting a category
       category = categoryDAO.get(1);
       assertEquals("Successfully deleted the record from the table ",true,categoryDAO.delete(category));

       //List of category
       assertEquals("Successfully Fetched the list category",1,categoryDAO.getList().size());
   }
}
