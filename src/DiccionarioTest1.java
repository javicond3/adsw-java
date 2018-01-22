package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Pruebas de diccionario
 * 
 * @author jpuente
 * @version 20160217
 */
public class DiccionarioTest1 {
	
	private Diccionario diccionarioLineal;
	private Diccionario diccionarioHashMap;
	
	private static int size = 10;
	
	@Before
	public void setUp() {
		diccionarioLineal  = new DiccionarioLineal(size);
		diccionarioHashMap = new DiccionarioHashMap();
	}
	
	/**
	 * Diccionario vacío
	 */
	@Test
	public void testEmpty() {
		testEmpty(diccionarioLineal);
		testEmpty(diccionarioHashMap);
	}
	
	private void testEmpty(Diccionario diccionario) {
		assertEquals(0,diccionario.size());
		assertNull(diccionario.get("clave"));
		assertNull(diccionario.remove("clave)"));
	}
	
	/**
	 * Introducir clave nula
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testPut00() {
		testPut00(diccionarioLineal);
		testPut00(diccionarioHashMap);
	}
	
	private void testPut00 (Diccionario diccionario) {
        diccionario.put(null, "valor");

	}
	
	/**
	 * Introducir clave vacía
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testPut01() {
		testPut01(diccionarioLineal);
		testPut01(diccionarioHashMap);
	}
	
	private void testPut01(Diccionario diccionario) {
        diccionario.put("", "valor");
	}
	
	/**
	 * Introducir clave nueva
	 */
	@Test
	public void testPut02(){
		testPut02(diccionarioLineal);
		testPut02(diccionarioHashMap);
	}
	
	private void testPut02 (Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertEquals(1,diccionario.size());
		assertEquals("valor",diccionario.get("clave"));	
	}

	/** 
	 * Introducir clave repetida
	 */
	@Test
	public void testPut03 () {
		testPut03(diccionarioLineal);
		testPut03(diccionarioHashMap);		
	}
	
	private void testPut03 (Diccionario diccionario) {
		diccionario.put("clave", "valor1");
		assertEquals(1,diccionario.size());
		diccionario.put("clave", "valor2");
		assertEquals(1,diccionario.size());
		assertEquals("valor2",diccionario.get("clave"));	
	}
	
	/**
	 * Introducir valor nuevo en diccionario lleno
	 */
	@Test (expected = RuntimeException.class)
	public void testPut04() {
		testPut04(diccionarioLineal);
	}
	
	private void testPut04 (Diccionario diccionario) {
		for (int i =0; i < size; i++) {
			diccionario.put(Integer.toString(i), "valor");
		}
		diccionario.put("otro","lleno");
	}
	
	/**
	 * Recuperar clave nula 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGet00(){
		testGet00(diccionarioLineal);
		testGet00(diccionarioHashMap);
	}
	
	private void testGet00 (Diccionario diccionario) {
		diccionario.get(null);
	}
 	
	/**
	 * Recuperar clave vacía
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGet01() {
		testGet01(diccionarioLineal);
		testGet01(diccionarioHashMap);
	}
	
	private void testGet01 (Diccionario diccionario) {
		diccionario.get("");
	}
	
	/**
	 * Recuperar clave inexistente (diccionario vacío)
	 */
	@Test
	public void testGet02(){
		testGet02(diccionarioLineal);
		testGet02(diccionarioHashMap);
	}
	
	private void testGet02 (Diccionario diccionario) {
		assertNull(diccionario.get("clave"));			
	}

	/**
	 * Recuperar clave inexistente
	 */
	@Test
	public void testGet03(){
		testGet03(diccionarioLineal);
		testGet03(diccionarioHashMap);
	}
	
	private void testGet03 (Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertNull(diccionario.get("clave1"));		
	}

	/**
	 * Eliminar clave nula
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemove00(){
		testRemove00(diccionarioLineal);
		testRemove00(diccionarioHashMap);
	}
	
	private void testRemove00 (Diccionario diccionario) {
		diccionario.remove(null);
	}
	
	/**
	 * Eliminar clave vacía
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemove01(){
		testRemove01(diccionarioLineal);
		testRemove01(diccionarioHashMap);
	}
	
	private void testRemove01 (Diccionario diccionario) {
		diccionario.remove("");
	}
	
	
	/**
	 * Eliminar clave inexistente (diccionario vacío)
	 */
	@Test 
	public void testRemove02() {
		testRemove02(diccionarioLineal);
		testRemove02(diccionarioHashMap);
	}
	
	private void testRemove02 (Diccionario diccionario) {
		assertNull(diccionario.remove("clave"));
		assertEquals(0,diccionario.size());		
	}
	
	/**
	 * Eliminar clave inexistente
	 */
	@Test
	public void testRemove03() {
		testRemove03(diccionarioLineal);
		testRemove03(diccionarioHashMap);
	}
	
	private void testRemove03 (Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertNull(diccionario.remove("clave1"));
		assertEquals(1,diccionario.size());
	}
	
	/**
	 * Eliminar clave existente
	 */
	@Test
	public void testRemove04(){
		testRemove04(diccionarioLineal);
		testRemove04(diccionarioHashMap);
	}
	
	private void testRemove04 (Diccionario diccionario) {		
		diccionario.put("clave", "valor");
		assertEquals("valor", diccionario.remove("clave"));
		assertEquals(0,diccionario.size());
	}
	
	/**
	 * Eliminar clave existente, comprobar que el resto sigue igual
	 */
	@Test
	public void testRemove05(){
		testRemove05(diccionarioLineal);
		testRemove05(diccionarioHashMap);
	}
	
	private void testRemove05 (Diccionario diccionario) {			
		diccionario.put("clave1", "valor1");
		diccionario.put("clave2", "valor2");
		diccionario.put("clave3", "valor3");
		assertEquals(3,diccionario.size());
		assertEquals("valor2", diccionario.remove("clave2"));
		assertEquals("valor1", diccionario.get("clave1"));
		assertNull(diccionario.get("clave2"));
		assertEquals("valor3", diccionario.get("clave3"));
		assertEquals(2,diccionario.size());
	}
	
	/**
	 * Borrar todo el diccionario
	 */
	@Test
	public void testClear00(){
		testClear00(diccionarioLineal);
		testClear00(diccionarioHashMap);
	}
	
	private void testClear00 (Diccionario diccionario) {	
		diccionario.put("clave", "valor");
		diccionario.clear();
		assertNull(diccionario.get("clave"));
		assertEquals(0,diccionario.size());
	}
		
}
