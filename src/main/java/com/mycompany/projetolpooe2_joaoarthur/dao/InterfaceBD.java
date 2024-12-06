/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.dao;

/**
 *
 * @author vanessalagomachado
 */
public interface InterfaceBD {
    Boolean conexaoAberta();
    void fecharConexao();
    Object find(Class c, Object id) throws Exception;
    void persist(Object o) throws Exception;
    void remover(Object o) throws Exception;
    void deleteLivroById(int idLivro) throws Exception;
    void deleteFuncionarioById(long idFuncionario) throws Exception;
    void deleteUsuarioById(int idUsuario) throws Exception;
}