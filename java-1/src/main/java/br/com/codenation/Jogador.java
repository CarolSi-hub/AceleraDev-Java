package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
  long id;
  long idTime;
  String nome;
  LocalDate dataNascimento;
  Integer nivelHabilidade;
  BigDecimal salario;
  public boolean capitao;

  public Jogador(long id, long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
    this.id = id;
    this.idTime = idTime;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.nivelHabilidade = nivelHabilidade;
    this.salario = salario;
  }

  public long getId() {
    return id;
  }

  public long getIdTime() {
    return idTime;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public Integer getNivelHabilidade() {
    return nivelHabilidade;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setIdTime(long idTime) {
    this.idTime = idTime;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public void setNivelHabilidade(Integer nivelHabilidade) {
    this.nivelHabilidade = nivelHabilidade;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public boolean isCapitao() {
    return capitao;
  }

  public void setCapitao(boolean capitao) {
    this.capitao = capitao;
  }
}
