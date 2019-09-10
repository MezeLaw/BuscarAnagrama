package buscadorDeAnagramas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Buscador {

	private String cadena;
	private String anagrama;

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getAnagrama() {
		return anagrama;
	}

	public void setAnagrama(String anagrama) {
		this.anagrama = anagrama;
	}

	public int buscarAnagrama(String cadena, String stringABuscar) {
		int cantidadInicial = 0;
		int cantidadErronea = 0;

		System.out.println("Cadena a analizar >> " + cadena);
		System.out.println("Palabra a buscar en cadena >> " + stringABuscar);

		String regexBuscaMatcheoGral = "(";

		char[] letrasDelStringABuscar = stringABuscar.toCharArray();

		// Creo la regex con las letras del string a buscar

		int tamanoArray = letrasDelStringABuscar.length;

		for (int i = 0; i < tamanoArray; i++) {
			if (i == tamanoArray - 1) {
				regexBuscaMatcheoGral += "[" + letrasDelStringABuscar[i] + "])";
			} else {

				regexBuscaMatcheoGral += "[" + letrasDelStringABuscar[i] + "]|";
			}
		}

		String regexBaseFinal = "";

		for (int i = 0; i < tamanoArray; i++) {
			regexBaseFinal += regexBuscaMatcheoGral;
		}

		Pattern p = Pattern.compile(regexBaseFinal);
		Matcher m = p.matcher(cadena);

		while (m.find()) {
			cantidadInicial++;
		}

		String regexRestadora = "";
		for (int i = 0; i < tamanoArray; i++) {

			if (i == tamanoArray - 1) {
				regexRestadora += "([" + letrasDelStringABuscar[i] + "]{" + tamanoArray + "})";
			} else {

				regexRestadora += "([" + letrasDelStringABuscar[i] + "]{" + tamanoArray + "})|";
			}
		}

		Pattern p2 = Pattern.compile(regexRestadora);
		Matcher m2 = p2.matcher(cadena);

		while (m2.find()) {
			cantidadErronea++;
		}

		int resultadoFinal = cantidadInicial - cantidadErronea;
		System.out.println("La cantidad de apariciones del anagrama es: " + resultadoFinal);
		return resultadoFinal;
	}

}
