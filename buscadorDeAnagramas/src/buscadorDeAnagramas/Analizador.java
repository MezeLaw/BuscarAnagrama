package buscadorDeAnagramas;

public class Analizador {

	private static Buscador buscador;

	public static void main(String[] args) {
		// TODO Implementar mejora para ingresar por consola el texto y el subString a
		// buscar..
		buscador = new Buscador();

		buscador.buscarAnagrama("hola, que buena ola laomir aaaaa oo", "ola");

	}

}
