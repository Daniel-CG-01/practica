package com.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import com.hibernate.model.Asignatura;
import com.hibernate.util.HibernateUtil;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

public class AsignaturaDAO {

    //Inserción
	public void insertAsignatura(Asignatura as) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(as);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//Actualización
	public void updateAsignatura(Asignatura as) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(as);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//Borrado
	public void deleteAsignatura(int id) {
		Transaction transaction = null;
		Asignatura as = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			as = session.get(Asignatura.class, id);
			session.remove(as);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//Selección simple
	public Asignatura selectAsignaturaById(int id) {
		Transaction transaction = null;
		Asignatura as = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			as = session.get(Asignatura.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
		return as;
	}

	//Selección múltiple
	public List<Asignatura> selectAllAsignaturas() {
		Transaction transaction = null;
		List<Asignatura> asignaturas = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			asignaturas = session.createQuery("FROM Asignatura", Asignatura.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
		return asignaturas;
	}
}