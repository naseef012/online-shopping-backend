package com.naseef.shoppingbackend.daoimpl;

import com.naseef.shoppingbackend.dao.CategoryDAO;
import com.naseef.shoppingbackend.dto.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Naseef M Abdus Sattar on 9/26/2017.
 */
@Repository("categoryDAO")
@Transactional
public class CategoryDAOimpl implements CategoryDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> list()
    {
       String selectActiveCategory = "FROM Category WHERE active = :active";
       Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
       query.setParameter("active", true);
       return query.getResultList();
    }

    /*
    Getting single category based on Id
     */
    public Category get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, Integer.valueOf(id));
        return category;
    }


    public boolean add(Category category)
    {
        try{
            //add the category to the database table
            sessionFactory.getCurrentSession().persist(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Category category)
    {
        try{
            //update the category to the database table
            sessionFactory.getCurrentSession().update(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Category category)
    {
        category.setActive(false);

        try{
            //update the category after setting Active to false to the database table
            sessionFactory.getCurrentSession().update(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
