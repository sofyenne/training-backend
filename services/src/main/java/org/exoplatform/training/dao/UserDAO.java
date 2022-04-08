package org.exoplatform.training.dao;

import org.exoplatform.commons.persistence.impl.GenericDAOJPAImpl;
import org.exoplatform.training.Entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO  extends GenericDAOJPAImpl<Users, Long> {

    public Users findByName(String name){
        TypedQuery<Users> query = getEntityManager().createNamedQuery("findByName",Users.class);
        query.setParameter("name",name);
        Users user = query.getSingleResult();
        return user ;

    }
}
