package br.com.codenation;
import java.util.*;
import java.util.stream.*;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum;
		sum = Arrays.stream(elements).reduce(0, Integer::sum);
		return sum / elements.length;
	}

	public static int mode(int[] elements) {
		int numberOfRepets = 1;
		int maxRepeatNumber = 0;
 		for(int i = 0; i < elements.length; i++){
 			int currentElement = elements[i];
 			int currentNumerOfRepeats = 1;
 			for(int f = 0; f < elements.length; f++){
 				if(currentElement == elements[f]){
 					currentNumerOfRepeats +=1;
				}
			} if(currentNumerOfRepeats > numberOfRepets){
 				numberOfRepets = currentNumerOfRepeats;
 				maxRepeatNumber = currentElement;
			}
		} return maxRepeatNumber;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int index = (elements.length - 1) / 2;
		int position = 0;

		if(elements.length % 2 == 0) {
			position = (elements[index] + elements[index + 1])/2;
		}else{
			position = Math.round(elements.length / 2) + 1;
		}
		return elements[position];
	}
}