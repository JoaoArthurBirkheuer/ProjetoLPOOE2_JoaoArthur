package com.mycompany.projetolpooe2_joaoarthur.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa {
    public Usuario(String nome, String cpf, String email) {
        super(nome, cpf, email, false);
    }

    public Usuario() {
        super();
    }

    public void setId(long idParaCadastrar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}