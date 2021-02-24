package br.com.codenation.desafioexe;

import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

// Source: https://www.guj.com.br/t/qual-o-melhor-algoritmo-para-a-sequencia-fibonacci/84076/3
	public static List<Integer> fibonacci() {
		ArrayList<Integer> fibonacci = new ArrayList<>();
		int n1 = 0;
		int n2 = 1;
		int maxNumberInSequence = 350;

		while (n1 <= maxNumberInSequence){
			fibonacci.add(n1);
			n2 = n1 + n2 + ( n1 = n2 ) - n2;
		} ;

	return fibonacci;
	}

// Source: https://pt.stackoverflow.com/questions/82114/verificar-se-o-elemento-existe-na-arraylist-e-se-n%C3%A3o-adicion%C3%A1-lo/82119#:~:text=Para%20tu%20verificar%20se%20o,void%20como%20est%C3%A1s%20fazendo%20atualmente.
	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

      public static void main(String[] args) {
		 System.out.print (fibonacci());
	}

}