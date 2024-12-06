package com.mycompany.projetolpooe2_joaoarthur.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "seq_pessoa", allocationSize = 1)
    private Long idPessoa;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column
    private final boolean ehFuncionario;

    public Pessoa(String nome, String cpf, String email, boolean ehFuncionario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ehFuncionario = ehFuncionario;
    }

    public Pessoa() {
        this.ehFuncionario = false;
    }

    // Getters e Setters
    public Long getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEhFuncionario() {
        return ehFuncionario;
    }
}