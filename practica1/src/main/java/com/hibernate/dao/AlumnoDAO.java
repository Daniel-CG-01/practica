package com.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import com.hibernate.model.Alumno;
import com.hibernate.util.HibernateUtil;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

public class AlumnoDAO {
    
    //Inserción
	public void insertAlumno(Alumno al) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(al);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//Actualización
	public void updateAlumno(Alumno al) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(al);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//Borrado
	public void deleteAlumno(int id) {
		Transaction transaction = null;
		Alumno al = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			al = session.get(Alumno.class, id);
			session.remove(al);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//Selección simple
	public Alumno selectAlumnoById(int id) {
		Transaction transaction = null;
		Alumno al = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			al = session.get(Alumno.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
		return al;
	}

	//Selección múltiple
	public List<Alumno> selectAllAlumnos() {
		Transaction transaction = null;
		List<Alumno> alumnos = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			alumnos = session.createQuery("FROM Alumno", Alumno.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
		return alumnos;
	}
}