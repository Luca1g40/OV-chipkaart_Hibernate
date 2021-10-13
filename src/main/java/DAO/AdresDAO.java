package DAO;

import domain.Adres;
import domain.Reiziger;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AdresDAO {


    boolean saveAdres(Adres adres) throws HibernateException;

    boolean updateAdres(Adres adres) throws HibernateException;

    boolean deleteAdres(Adres adres) throws HibernateException;

    List findByReiziger(Reiziger reiziger) throws HibernateException;

    List<Adres> findAll() throws HibernateException;

}
