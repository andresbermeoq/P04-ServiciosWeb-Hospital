package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Persona;

@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

	@PersistenceContext(unitName = "HospitalServices")
	private EntityManager entityManager;

	public PersonaFacade() {
		super(Persona.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	public Persona getPersona(String correo, String password) {
		String query = "SELECT p FROM Persona p WHERE p.correo = :correo AND p.password = :password";
		Persona persona = null;

		try {
			persona = (Persona) entityManager.createQuery(query).setParameter("correo", correo)
											 .setParameter("password", password).getSingleResult();

		} catch (Exception e) {
			System.out.println("--> ERROR Persona.getPersona" + e.getMessage());
		}
		return persona;
	}

	public List<Persona> getPersonasbyPaciente(String nombre, String apellido) {
		String query = "SELECT p FROM Persona p WHERE p.rol = :rol AND p.nombres = :nombre AND p.apellidos = :apellido";

		List<Persona> personas = new ArrayList<Persona>();

		try {
			personas = entityManager.createQuery(query, Persona.class)
									.setParameter("rol", "Paciente")
									.setParameter("nombre", nombre)
									.setParameter("apellido", apellido)
									.getResultList();

		} catch (Exception e) {
			System.out.println("--> ERROR Persona.getPersonabyPaciente" + e.getMessage());
		}

		return personas;
	}

	public List<Persona> getPersonabyEspecialidad(String especialidad) {

		String query = "SELECT p, doce, e FROM Doctor_Especialidad doce "
				+ "JOIN doce.doctorPersona p JOIN doce.especialidad e " + "WHERE e.nombreEspecialidad = :especialidad";

		List<Persona> personas = new ArrayList<Persona>();

		try {
			personas = entityManager.createQuery(query, Persona.class).setParameter("especialidad", especialidad)
					.getResultList();

		} catch (Exception e) {
			System.out.println("--> ERROR Persona.getPersonabyEspecialidad" + e.getMessage());
		}

		return personas;
	}

}
