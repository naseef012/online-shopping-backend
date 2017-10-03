package com.naseef.shoppingbackend.daoimpl;

import com.naseef.shoppingbackend.dao.CategoryDAO;
import com.naseef.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naseef M Abdus Sattar on 9/26/2017.
 */
@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO
{
    private static List<Category> categories = new ArrayList<Category>();

    //This Static block is used to initialize the List<Category> with some values.
    static
    {
        //Adding first Category
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("TV");
        category1.setDescription("Description TV");
        category1.setImageURL("CAT_1.png");

        categories.add(category1);

        //Adding 2nd Category
        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Mobile");
        category2.setDescription("Description Mobile");
        category2.setImageURL("CAT_2.png");

        categories.add(category2);

        //Adding 3rd Category
        Category category3 = new Category();
        category3.setId(3);
        category3.setName("Laptop");
        category3.setDescription("Description Laptop");
        category3.setImageURL("CAT_3.png");

        categories.add(category3);

    }

    public List<Category> list()
    {
        return categories;
    }

    public Category get(int id)
    {
        for (Category c: categories)
        {
            if (c.getId()== id)
                return c;
        }
        return null;
    }
}
