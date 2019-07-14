package com.fabianisai.mediappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "signos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Signos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSignos;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_signo_paciente"))
    private Paciente paciente;

    @JsonSerialize(using = ToStringSerializer.class) // ISODate 2019-04-22T05:00:00
    private LocalDateTime fecha;

    @Column(name = "temperatura", nullable = false, length = 100)
    private String temperatura;

    @Column(name = "pulso", nullable = false, length = 100)
    private String pulso;

    @Column(name = "ritmo", nullable = false, length = 100)
    private String ritmo;

    public Signos() {
    }

    public Integer getIdSignos() {
        return idSignos;
    }

    public void setIdSigno(Integer idSignos) {
        this.idSignos = idSignos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getRitmo() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo = ritmo;
    }
}
