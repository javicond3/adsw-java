package es.upm.dit.adsw.ej1;

import java.util.Arrays;

/**
 * Implementación de un diccionario mediante una tabla lineal
 * 
 * @author jpuente
 * @version 2016.02.09
 */
public class DiccionarioLineal implements Diccionario {

	private CV[] datos;
	private int nDatos;

	/**
	 * Constructor
	 * 
	 * @param número
	 *            máximo de entradas del diccionario
	 */
	public DiccionarioLineal(int max) {
		nDatos = 0;
		datos = new CV[max];
	}

	@Override
	public void put(String clave, String valor) {
		if ((clave == null) || (clave.length() == 0)) {
			throw new IllegalArgumentException("put : clave inválida");
		}
		// si ya está, reemplazar el valor
		for (int i = 0; i < nDatos; i++) {
			if (clave.equals(datos[i].getClave())) {
				datos[i].setValor(valor);
				return;
			}
		}
		// si no está, añadir al final
		datos[nDatos] = new CV(clave, valor);
		nDatos++;
	}

	@Override
	public String get(String clave) {
		if ((clave == null) || (clave.length() == 0)) {
			throw new IllegalArgumentException("get : clave inválida");
		}
		for (int i = 0; i < nDatos; i++) {
			if (clave.equals(datos[i].getClave())) {
				return datos[i].getValor();
			}
		}
		return null;
	}

	@Override
	public String remove(String clave) {
		if ((clave == null) || (clave.length() == 0)) {
			throw new IllegalArgumentException("remove : clave inválida");
		}

		for (int i = 0; i < nDatos; i++) {
			if (clave.equals(datos[i].getClave())) {
				CV old = datos[i];
				System.arraycopy(datos, i+1, datos, i, nDatos-(i+1));
				nDatos--;
				datos[nDatos] = null;
				return old.getValor();
			}
		}

		// no encontrada
		return null;
	}

	/**
	 * Número de entradas del diccionario
	 * 
	 * @return número de elementos almacenados.
	 */
	@Override
	public int size() {
		return nDatos;
	}

	/**
	 * Eliminar todas las claves.
	 */
	@Override
	public void clear() {
		Arrays.fill(datos, null);
		nDatos = 0;
	}

}
