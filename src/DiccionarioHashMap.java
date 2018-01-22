package es.upm.dit.adsw.ej1;

import java.util.HashMap;

/**
 * Diccionario implementado con HashMap
 * 
 * @author jpuente
 * @version 2016.02.09
 */
public class DiccionarioHashMap 
	implements Diccionario {

	private final HashMap<String, String> map ;
	
	public DiccionarioHashMap() {
		map = new HashMap<>();
	}

	@Override
	public void put(String clave, String valor) {
		if ((clave == null) || (clave.length() == 0)) {
			throw new IllegalArgumentException("put : clave inválida");
		}
		map.put(clave, valor);
	}

	@Override
	public String get(String clave) {
		if ((clave == null) || (clave.length() == 0)) {
			throw new IllegalArgumentException("get : clave inválida");
		}
		return map.get(clave);
	}

	@Override
	public String remove(String clave) {
		if ((clave == null) || (clave.length() == 0)) {
			throw new IllegalArgumentException("remove : clave inválida");
		}
		return map.remove(clave);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public void clear() {
		map.clear();
	}

}
