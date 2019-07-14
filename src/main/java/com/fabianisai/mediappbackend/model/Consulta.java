package com.fabianisai.mediappbackend.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_paciente"))
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_medico"))
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_especialidad"))
	private Especialidad especialidad;

	@JsonSerialize(using = ToStringSerializer.class) // ISODate 2019-04-22T05:00:00
	private LocalDateTime fecha;

	@OneToMany(mappedBy = "consulta", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleConsulta> detalleConsulta;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}

	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsulta == null) ? 0 : idConsulta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		return true;
	}
	
	

}
