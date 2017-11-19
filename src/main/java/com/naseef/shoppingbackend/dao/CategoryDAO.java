package com.naseef.shoppingbackend.dao;

import com.naseef.shoppingbackend.dto.Category;

import java.util.List;

/**
 * Created by USER on 9/26/2017.
 *
 * Here in the package name'dao' stands for data access object
 */
public interface CategoryDAO
{
    Category get(int id);
    List<Category> getList();
    boolean add(Category category);
    boolean update(Category category);
    boolean delete (Category category);
}
