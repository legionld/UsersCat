package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public List<UsersDataSet> getAll() throws HibernateException {
        List<UsersDataSet> usersDataSet = session.createSQLQuery("select ID, FNAME, ADRESS, BDATA, SNAME, INFO, " +
                "LOGIN, PHOTO, PERMISSION from USERS").addEntity(UsersDataSet.class).list();
        return usersDataSet;
    }

    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public long insertUser(String login, String fname, String sname, String bdata,
                           String adress, String info, String permission, String photo) throws HibernateException {
        return (Long) session.save(new UsersDataSet(login, fname, sname, bdata, adress, info, permission, photo));
    }
}
