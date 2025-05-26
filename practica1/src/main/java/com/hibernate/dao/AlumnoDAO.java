package com.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import com.hibernate.model.Alumno;

public class AlumnoDAO {
    
    //Inserción
	public void insertAlumno(Session session, Alumno al) {
		session.persist(al);
	}

	//Actualización
	public void updateAlumno(Session session, Alumno al) {
		session.merge(al);
	}

	//Borrado
	public void deleteAlumno(Session session, int id) {
		Alumno al = session.get(Alumno.class, id);
		if (al != null) {
			session.remove(al);
		}
	}

	//Selección simple
	public Alumno selectAlumnoById(Session session, int id) {
		return session.get(Alumno.class, id);
	}

	//Selección múltiple
	public List<Alumno> selectAllAlumnos(Session session) {
		return session.createQuery("FROM Alumno", Alumno.class).getResultList();
	}
}