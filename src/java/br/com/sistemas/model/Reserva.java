package br.com.sistemas.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private Integer id;
    private Date dataChegada;
    private Date dataReserva;
    private String tempoEstadia;
    private Pessoa pessoa;
    
    public Reserva() {}
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CHEGADA")
    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_RESERVA")
    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    @Column(name = "TEMPO_ESTADIA")
    public String getTempoEstadia() {
        return tempoEstadia;
    }

    public void setTempoEstadia(String tempoEstadia) {
        this.tempoEstadia = tempoEstadia;
    }

    @ManyToOne
    @JoinColumn(name = "PESSOA_ID")
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }       
}
