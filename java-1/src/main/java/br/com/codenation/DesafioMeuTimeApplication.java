package br.com.codenation;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private final List<Time> times = new ArrayList<>();
	private final List<Jogador> jogadores = new ArrayList<>();

	public boolean filterTimeID(Long identificador) {
		List ids = times.stream().filter((item) -> item.getId() == identificador).collect(Collectors.toList());
		return (ids.size() != 0);
	}

	public boolean filterPlayerID(Long identificador) {
		List ids = jogadores.stream().filter((item) -> item.getId() == identificador).collect(Collectors.toList());
		return (ids.size() != 0);
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(filterTimeID(id)) throw new IdentificadorUtilizadoException();
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		times.add(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(!filterTimeID(idTime)) throw new TimeNaoEncontradoException();
	  if(filterPlayerID(id)) throw new IdentificadorUtilizadoException();
	  Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
	  jogadores.add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		if(!filterPlayerID(idJogador)) throw new JogadorNaoEncontradoException();
		for(Jogador jogador : jogadores) {
			if(idJogador.equals(jogador.getId()))
				jogador.setCapitao(true);
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if(!filterTimeID(idTime)) throw new TimeNaoEncontradoException();
    for(Jogador jogador : jogadores){
    	if((idTime.equals(jogador.getIdTime()) && (jogador.isCapitao()))){
    		return jogador.getId();
			}
		}
    throw new CapitaoNaoInformadoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		for(Jogador jogador : jogadores){
			if(idJogador.equals(jogador.getId())){
				return jogador.getNome();
			}
		} throw new JogadorNaoEncontradoException();
	}

	public String buscarNomeTime(Long idTime) {
		for(Time time : times){
			if(idTime.equals(time.getId())){
				return time.getNome();
			}
		}
			throw new TimeNaoEncontradoException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!filterTimeID(idTime)) throw new TimeNaoEncontradoException();
		List players = jogadores.stream().filter((jogador) -> jogador.idTime == idTime).map((jogador) -> jogador.id).collect(Collectors.toList());
		return players;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException();
		Integer pontos = 0;
		Long bestPlayerID = 0L;
		for (Jogador jogador : jogadores) {
			if (idTime.equals(jogador.getIdTime())) {
				if (jogador.getNivelHabilidade() > pontos) {
					pontos = jogador.getNivelHabilidade();
					bestPlayerID = jogador.getId();
					System.out.println(pontos);
				}
			}
		}  return bestPlayerID;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if(!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException();
		LocalDate data = LocalDate.now();
		Long playerId = 0L;
		if(!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException();
		for(Jogador jogador : jogadores) {
			if(idTime.equals(jogador.getIdTime())) {
				if(data.isAfter(jogador.getDataNascimento())){
					data = jogador.getDataNascimento();
					playerId = jogador.getId();
				}
			}
		} return playerId;
	}

	public List<Long> buscarTimes() {
		List ids = times.size() == 0 ? times : times.stream().map((item)-> item.id).collect(Collectors.toList());
		return ids;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException();
		BigDecimal salario = new BigDecimal(0);
		Long playerId = 0L;
		for(Jogador jogador : jogadores){
			if(idTime.equals(jogador.getIdTime())) {
				if(salario.compareTo(jogador.getSalario()) == -1){
					salario = jogador.getSalario();
					playerId = jogador.getId();
				}
			}
		} return playerId;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		for(Jogador jogador : jogadores){
			if(idJogador.equals(jogador.id)) return jogador.getSalario();
		} throw new JogadorNaoEncontradoException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		this.jogadores.sort(new Comparator<Jogador>() {
			@Override
			public int compare(Jogador player1, Jogador player2) {
				int result = player2.getNivelHabilidade().compareTo(player1.getNivelHabilidade());
				Long player2id = player2.getId();
				return result != 0 ? result : player2id.compareTo(player1.getId());
			}
		});

		if(jogadores.size() == 0 ) return new ArrayList<>();
		for( int i=0; i < top; i ++) {
			topJogadores.add(jogadores.get(i).getId());
		}
		return topJogadores;
	}

}
