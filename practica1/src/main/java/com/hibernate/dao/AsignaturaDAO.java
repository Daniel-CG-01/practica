package com.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import com.hibernate.model.Asignatura;

public class AsignaturaDAO {

    //Inserción
	public void insertAsignatura(Session session, Asignatura as) {
		session.persist(as);
	}

	//Actualización
	public void updateAsignatura(Session session, Asignatura as) {
		session.merge(as);
	}

	//Borrado
	public void deleteAsignatura(Session session, int id) {
		Asignatura as = session.get(Asignatura.class, id);
		if (as != null) {
			session.remove(as);
		}
	}

	//Selección simple
	public Asignatura selectAsignaturaById(Session session, int id) {
		return session.get(Asignatura.class, id);
	}

	//Selección múltiple
	public List<Asignatura> selectAllAsignaturas(Session session) {
		return session.createQuery("FROM Asignatura", Asignatura.class).getResultList();
	}
}