package br.com.sistemas.controller;

import br.com.sistemas.dao.ReservaDao;
import br.com.sistemas.model.Pessoa;
import br.com.sistemas.model.Reserva;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ReservaBean implements Serializable{
    
    private Pessoa pessoa = new Pessoa();
    private Reserva reserva = new Reserva();
    private final ReservaDao reservaDao = new ReservaDao();
        private List<Reserva> listaReserva;

    public ReservaBean() {
    }
    
     //metodo salvar
    public String adicionarReserva() {        
        reservaDao.addReserva(reserva);

        reserva = new Reserva();
        return "listar_reserva";
    }
    
    //metodo listar todos
    public List listarReserva() {
        listaReserva = reservaDao.getList();
        return this.listaReserva;
    }

    
    //get e setts
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }   

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }        
}
