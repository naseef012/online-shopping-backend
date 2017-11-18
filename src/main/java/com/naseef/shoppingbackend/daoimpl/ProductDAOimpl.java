package com.naseef.shoppingbackend.daoimpl;

import com.naseef.shoppingbackend.dao.ProductDAO;
import com.naseef.shoppingbackend.dto.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 10/26/2017 at 11:46 AM
 */
@Repository("productDAO")
@Transactional
public class ProductDAOimpl implements ProductDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    /*
    Get single product
     */
    public Product get(int productId)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Product product = currentSession.get(Product.class,Integer.valueOf(productId));
        return product;
    }

    public List<Product> list()
    {
        String selectQuery = "FROM Product";
        Query query = sessionFactory.getCurrentSession().createQuery(selectQuery , Product.class);
        return query.getResultList();
    }

    /*
    Insert Data
     */
    public boolean add(Product product)
    {
        try
        {
            //Add the product in the database
            sessionFactory.getCurrentSession().persist(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    Update product
     */
    public boolean update(Product product)
    {
        try
        {
            //Update product
            sessionFactory.getCurrentSession().update(product);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Product product)
    {
        product.setActive(false);
        try
        {
            //Calling the update method of this class
            return this.update(product);
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getActiveProducts()
    {
        String selectActiveQuery = "FROM Product WHERE active = :active";
        Query query = sessionFactory
                        .getCurrentSession()
                            .createQuery(selectActiveQuery,Product.class);
        query.setParameter("active" , true);

        return query.getResultList();
    }

    public List<Product> getActiveProductByCategory(int categoryId)
    {
        String selectActiveQueryByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
        Query query = sessionFactory
                        .getCurrentSession()
                            .createQuery(selectActiveQueryByCategory,Product.class);
        query.setParameter("active" , true).setParameter("categoryId",categoryId);

        return query.getResultList();
    }

    public List<Product> getLatestActiveProducts(int count)
    {
        String selectQuery = "FROM Product WHERE active = :active ORDER BY id";
        Query query = sessionFactory
                        .getCurrentSession()
                            .createQuery(selectQuery , Product.class);
        query.setParameter("active", true).setFirstResult(0).setMaxResults(count);

        return query.getResultList();
    }
}
