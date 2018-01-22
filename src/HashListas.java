package es.upm.dit.adsw.ej3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jpuente
 * @version 2016.03.09
 */
public class HashListas implements Diccionario {
	
	private final List<CV>[] slots; 
	private int nDatos = 0;
	
	/**
	* constructor.
	* @param nSlots numero de ranuras (slots). 
	*/
	@SuppressWarnings("unchecked")
	public HashListas(int nSlots) {
		slots = new List[nSlots];
		nDatos = 0;
	}

	@Override
	public void put(String clave, String valor) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException("put clave inválida");
		int h = Math.abs(clave.hashCode()) % slots.length;
		if (slots[h] == null)
			slots[h] = new ArrayList<CV>();
		for (CV c : slots[h]) {
			if (clave.equals(c.getClave())) {
				c.setValor(valor);
				return;
			}
		}
		slots[h].add(new CV(clave, valor));
		nDatos++;
	}

	@Override
	public String get(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException("get clave inválida");
		int h = Math.abs(clave.hashCode()) % slots.length;
		if (slots[h] == null || slots[h].isEmpty())
			return null;
		for (CV c : slots[h]) {
			if (OpMeter.compareTo(clave, c.getClave()) == 0)
				return c.getValor();
		}
		return null;
	}

	@Override
	public String remove(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException("remove clave inválida");
		int h = Math.abs(clave.hashCode()) % slots.length;
		if (slots[h] == null || slots[h].isEmpty())
			return null;
		for (CV c : slots[h]) {
			if (clave.equals(c.getClave())) {
				String valor = c.getValor();
				slots[h].remove(c);
				nDatos--;
				return valor;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return nDatos;
	}

	@Override
	public void clear() {
		Arrays.fill(slots, null);
		nDatos = 0;
	}

}
