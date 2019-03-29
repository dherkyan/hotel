package br.com.sistemas.controller;

import br.com.sistemas.dao.HospedagemDao;
import br.com.sistemas.model.Hospedagem;
import br.com.sistemas.model.Reserva;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class HospedagemBean implements Serializable{
    
    
    private Hospedagem hospedagem = new Hospedagem();    
    private Reserva reserva = new Reserva();
    private final HospedagemDao hospedagemDao = new HospedagemDao();                    
        private List<Hospedagem> listaHospedagem;

    public HospedagemBean() {
    }
    
     //metodo salvar
    public String adicionarhospedagem() {
        hospedagemDao.addHospedagem(hospedagem);
        
        hospedagem = new Hospedagem();        
        return "listar_hospedagem";
    }
    
    //metodo listar todos
    public List listarHospedagem() {
        listaHospedagem = hospedagemDao.getList();                
        return this.listaHospedagem;
    }

    
    //get e setts
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }   

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    
    
}
