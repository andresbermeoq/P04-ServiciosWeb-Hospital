package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Cita;
import ec.edu.ups.model.Persona;

@Stateless
public class CitaFacade extends AbstractFacade<Cita> {
	
	@PersistenceContext(unitName = "HospitalServices")
	private EntityManager entityManager;

	public CitaFacade() {
		super(Cita.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List<Cita> getCitasbyEstado(String estado) {
		String query = "SELECT c FROM Cita c WHERE c.estadoCita = :estado";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			citas = entityManager.createQuery(query, Cita.class)
								 .setParameter("estado", estado)
								 .getResultList();
			
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyEstado" + e.getMessage());
		}
		return citas;
	}
	
	public List<Cita> getCitasbyDate(Date fecha) {
		String query = "SELECT c FROM Cita c WHERE c.fechaCita = :fecha";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			citas =  entityManager.createQuery(query, Cita.class)
								  .setParameter("fecha", fecha)
								  .getResultList();
			
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyDate" + e.getMessage());
		}
		return citas;
	}
	
	public List<Cita> getCitasbyMedico(String nombre, String apellido) {
		String query = "SELECT p, c FROM Cita c JOIN c.doctorEspecialidad p WHERE p.nombres = :nombre AND p.apellidos = :apellido";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			
			citas = entityManager.createQuery(query, Cita.class)
								 .setParameter("nombre", nombre)
								 .setParameter("apellido", apellido)
								 .getResultList();
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyMedico" + e.getMessage());
		}
		
		return citas;
	}
	
	public List<Cita> getCitasbyPersona(Persona id) {
		String query = "SELECT c FROM Cita c WHERE c.pacientePersona = :idPersona";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			
			citas = entityManager.createQuery(query, Cita.class)
								 .setParameter("idPersona", id)
								 .getResultList();
			
			System.out.println(citas.toString());
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyMedico" + e.getMessage());
		}
		
		return citas;
	}
	
	
	

}
