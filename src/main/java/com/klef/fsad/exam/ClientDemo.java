package com.klef.fsad.exam;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.Date;
import java.util.List;
public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Invoice inv1 = new Invoice("Invoice A", new Date(), "PAID", 5000);
        Invoice inv2 = new Invoice("Invoice B", new Date(), "PENDING", 3000);
        session.save(inv1);
        session.save(inv2);
        tx.commit();
        session.beginTransaction();
        String hql = "FROM Invoice WHERE 1=?1";
        Query<Invoice> query = session.createQuery(hql, Invoice.class);
        query.setParameter(1, 1);
        List<Invoice> list = query.getResultList();
        System.out.println("----- Invoice Records -----");
        for(Invoice i : list)
        {
            System.out.println(
                i.getId() + " | " +
                i.getName() + " | " +
                i.getDate() + " | " +
                i.getStatus() + " | " +
                i.getAmount()
            );
        }
        session.getTransaction().commit();
        session.close();
    }
}