package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;


public class Time {
  public long id;
  public String nome;
  public LocalDate dataCriacao;
  public String corUniformePrincipal;
  public String corUniformeSecundario;


  public Time(long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
    this.setId(id);
    this.setNome(nome);
    this.setDataCriacao(dataCriacao);
    this.setCorUniformePrincipal(corUniformePrincipal);
    this.setCorUniformeSecundario(corUniformeSecundario);
  }

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public String getCorUniformePrincipal() {
    return corUniformePrincipal;
  }

  public String getCorUniformeSecundario() {
    return corUniformeSecundario;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public void setCorUniformePrincipal(String corUniformePrincipal) {
    this.corUniformePrincipal = corUniformePrincipal;
  }

  public void setCorUniformeSecundario(String corUniformeSecundario) {
    this.corUniformeSecundario = corUniformeSecundario;
  }

}
