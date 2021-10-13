package DAO;

import domain.OVChipkaart;
import domain.Reiziger;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OVChipkaartDAO {

    List<OVChipkaart> findByReiziger(Reiziger reiziger) throws HibernateException;

    boolean deleteOVChipkaart(OVChipkaart ov) throws HibernateException;

    boolean saveOVChipkaart(OVChipkaart ov) throws HibernateException;

    boolean updateOVChipkaart(OVChipkaart ov) throws HibernateException;

    List<OVChipkaart> findAll() throws HibernateException;


}
