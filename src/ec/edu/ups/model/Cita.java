package ec.edu.ups.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the "Cita" database table.
 * 
 */
@Entity
@Table(name="\"Cita\"")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cita")
	private Integer idCita;

	@Column(name="comentario_cita")
	private String comentarioCita;

	private BigDecimal costo;

	@Column(name="estado_cita")
	private String estadoCita;

	@Column(name="fecha_cita")
	private Timestamp fechaCita;

	private String sintomatologia;

	//bi-directional many-to-one association to Doctor_Especialidad
	@ManyToOne
	@JoinColumn(name="id_medico_especialidad")
	private Persona doctorEspecialidad;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Persona pacientePersona;
	


	public Cita() {
	}

	public Cita(String comentarioCita, BigDecimal costo, String estadoCita, Timestamp fechaCita, String sintomatologia,
			Persona doctorEspecialidad, Persona pacientePersona) {
		super();
		this.comentarioCita = comentarioCita;
		this.costo = costo;
		this.estadoCita = estadoCita;
		this.fechaCita = fechaCita;
		this.sintomatologia = sintomatologia;
		this.doctorEspecialidad = doctorEspecialidad;
		this.pacientePersona = pacientePersona;
	}

	public Integer getIdCita() {
		return this.idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public String getComentarioCita() {
		return this.comentarioCita;
	}

	public void setComentarioCita(String comentarioCita) {
		this.comentarioCita = comentarioCita;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public String getEstadoCita() {
		return this.estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Timestamp getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Timestamp fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getSintomatologia() {
		return this.sintomatologia;
	}

	public void setSintomatologia(String sintomatologia) {
		this.sintomatologia = sintomatologia;
	}

	public Persona getDoctorEspecialidad() {
		return this.doctorEspecialidad;
	}

	public void setDoctorEspecialidad(Persona doctorEspecialidad) {
		this.doctorEspecialidad = doctorEspecialidad;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", comentarioCita=" + comentarioCita + ", costo=" + costo + ", estadoCita="
				+ estadoCita + ", fechaCita=" + fechaCita + ", sintomatologia=" + sintomatologia
				+ ", doctorEspecialidad=" + doctorEspecialidad + ", pacientePersona=" + pacientePersona + "]";
	}

	
}