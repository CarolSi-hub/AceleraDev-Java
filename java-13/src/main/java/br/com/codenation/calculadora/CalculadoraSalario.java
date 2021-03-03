package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioINSS = calcularInss(salarioBase);
		double salarioLiquido = calcularIRRF(salarioINSS);
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		double newSalarioInss = 0;

		if (salarioBase > 1039) {
			if(salarioBase <= 1500) {
				newSalarioInss = salarioBase - salarioBase * 0.08;
			} else if (salarioBase <= 4000) {
				newSalarioInss = salarioBase - salarioBase * 0.09;
			} else {
				newSalarioInss = salarioBase - salarioBase * 0.11;
			}
		}
		return newSalarioInss;
	}

	private double calcularIRRF(double salarioBase) {

		double newSalarioIRRF = 0;

		if (salarioBase > 1039) {
			if(salarioBase <= 3000) {
				newSalarioIRRF = salarioBase;
			} else if(salarioBase <= 6000) {
				newSalarioIRRF = salarioBase - salarioBase * 0.075;
			} else {
				newSalarioIRRF = salarioBase - salarioBase * 0.15;
			}
		}
		return  newSalarioIRRF;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/