package DAO;

import domain.Reiziger;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ReizigerDAO {

    boolean saveReiziger(Reiziger reiziger) throws HibernateException;

    boolean updateReiziger(Reiziger reiziger) throws HibernateException;

    boolean deleteReiziger(Reiziger reiziger) throws HibernateException;

    List<Reiziger> findAll() throws HibernateException;

    Reiziger findById(int id) throws HibernateException;

    List<Reiziger> findByGbDatum(String datum) throws HibernateException;
}
