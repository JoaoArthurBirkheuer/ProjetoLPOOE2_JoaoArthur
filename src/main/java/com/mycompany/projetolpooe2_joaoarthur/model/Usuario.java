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
}