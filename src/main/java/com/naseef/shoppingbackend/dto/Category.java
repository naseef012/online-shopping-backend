package com.naseef.shoppingbackend.dto;

import javax.persistence.*;

/**
 * Created by USER on 9/26/2017.
 *
 * In the Package Name, 'dto' stands for 'data transfer object'
 */
@Entity
public class Category
{
    /*
        Private Fields
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This ensures that 'id' is an auto generated field
    private int id;

    private String name;

    private String description;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "is_active")
    private boolean active = true;

    /*
        Setters and Getters
    */

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    /*
        To String method for checking purposes and solving errors
     */

    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", active=" + active +
                '}';
    }
}
