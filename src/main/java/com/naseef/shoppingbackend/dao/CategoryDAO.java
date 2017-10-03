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
    List<Category> list();
    Category get(int id);
}
