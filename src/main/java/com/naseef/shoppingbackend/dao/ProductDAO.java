package com.naseef.shoppingbackend.dao;

import com.naseef.shoppingbackend.dto.Product;

import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 10/26/2017 at 2:08 AM
 */
public interface ProductDAO
{
     Product get(int productId);
     List<Product> list();
     boolean add (Product product);
     boolean update (Product product);
     boolean delete (Product product);

    //Business methods
    List<Product> getActiveProducts();
    List<Product> getActiveProductByCategory(int categoryId);
    List<Product> getLatestActiveProducts (int count);
}
