package es.upm.dit.adsw.ej3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

/**
 * Pruebas de diccionario
 * 
 * @author jpuente
 * @version 20160217
 */
public class HashListasTest {
	
	private Diccionario diccionario;
	
	private static int NSLOTS = 8;
	
	private final Random random = new Random();	
	
	@Before
	public void setUp() {
		diccionario = new HashListas(NSLOTS);
	}
	
	/**
	 * Diccionario vacío
	 */
	@Test
	public void testEmpty() {
		testEmpty(diccionario);
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
		testPut00(diccionario);
	}
	
	private void testPut00 (Diccionario diccionario) {
        diccionario.put(null, "valor");

	}
	
	/**
	 * Introducir clave vacía
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testPut01() {
		testPut01(diccionario);
	}
	
	private void testPut01(Diccionario diccionario) {
        diccionario.put("", "valor01");
	}
	
	/**
	 * Introducir clave nueva
	 */
	@Test
	public void testPut02(){
		testPut02(diccionario);
	}
	
	private void testPut02 (Diccionario diccionario) {
		diccionario.put("clave02", "valor02");
		assertEquals(1,diccionario.size());
		assertEquals("valor02",diccionario.get("clave02"));	
	}

	/** 
	 * Introducir clave repetida
	 */
	@Test
	public void testPut03 () {	
		testPut03(diccionario);		
	}
	
	private void testPut03 (Diccionario diccionario) {
		diccionario.put("clave03", "valor1");
		assertEquals(1,diccionario.size());
		diccionario.put("clave03", "valor2");
		assertEquals(1,diccionario.size());
		assertEquals("valor2",diccionario.get("clave03"));	
	}
	
	/**
	 * Recuperar clave nula 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGet00(){
		testGet00(diccionario);
	}
	
	private void testGet00 (Diccionario diccionario) {
		diccionario.get(null);
	}
 	
	/**
	 * Recuperar clave vacía
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGet01() {
		testGet01(diccionario);
	}
	
	private void testGet01 (Diccionario diccionario) {
		diccionario.get("");
	}
	
	/**
	 * Recuperar clave inexistente (diccionario vacío)
	 */
	@Test
	public void testGet02(){
		testGet02(diccionario);
	}
	
	private void testGet02 (Diccionario diccionario) {
		assertNull(diccionario.get("clave inxistente"));			
	}

	/**
	 * Recuperar clave inexistente
	 */
	@Test
	public void testGet03(){
		testGet03(diccionario);
	}
	
	private void testGet03 (Diccionario diccionario) {
		diccionario.put("clave válida", "valor");
		assertNull(diccionario.get("clave inexistente"));		
	}

	/**
	 * Eliminar clave nula
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemove00(){
		testRemove00(diccionario);
	}
	
	private void testRemove00 (Diccionario diccionario) {
		diccionario.remove(null);
	}
	
	/**
	 * Eliminar clave vacía
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemove01(){
		testRemove01(diccionario);
	}
	
	private void testRemove01 (Diccionario diccionario) {
		diccionario.remove("");
	}
	
	
	/**
	 * Eliminar clave inexistente (diccionario vacío)
	 */
	@Test 
	public void testRemove02() {
		testRemove02(diccionario);
	}
	
	private void testRemove02 (Diccionario diccionario) {
		assertNull(diccionario.remove("clave02"));
		assertEquals(0,diccionario.size());		
	}
	
	/**
	 * Eliminar clave inexistente
	 */
	@Test
	public void testRemove03() {
		testRemove03(diccionario);
	}
	
	private void testRemove03 (Diccionario diccionario) {
		diccionario.put("clave válida", "valor");
		assertNull(diccionario.remove("clave inexistente"));
		assertEquals(1,diccionario.size());
	}
	
	/**
	 * Eliminar clave existente
	 */
	@Test
	public void testRemove04(){
		testRemove04(diccionario);
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
		testRemove05(diccionario);
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
		testClear00(diccionario);
	}
	
	private void testClear00 (Diccionario diccionario) {	
		diccionario.put("clave", "valor");
		diccionario.clear();
		assertNull(diccionario.get("clave"));
		assertEquals(0,diccionario.size());
	}
	
	/**
	 * Llenar la tabla
	 */
	@Test
	public void test01() {
		test01(diccionario);
	}
	
	private void test01(Diccionario diccionario) {
		int[] datos = {3, 1, 2, 5, 7, 4, 6, 9};
		
		for (int d : datos) {
			String c = String.format("[%d]",  d);
			String v = String.valueOf(d);
			diccionario.put(c, v);
		}
		assertEquals(datos.length, diccionario.size());
		
		for (int d : datos) {
			String c = String.format("[%d]",  d);
			String v = String.valueOf(d);
			assertEquals(v, diccionario.get(c));
		}
		assertNull(diccionario.get("clave"));
		assertNull(diccionario.remove("clave"));
		
		for (int d : datos) {
			String c = String.format("[%d]",  d);
			String v = String.valueOf(d);
			assertEquals(v, diccionario.remove(c));
		}	
        assertEquals(0, diccionario.size());		
	}
	
	/**
	 * Test aleatorios
	 */
	@Test
	public void testN() {
		testN(diccionario);
	}
	   
	private void testN(Diccionario diccionario) {
		int N = 2*NSLOTS;
		
		int[] datos = mkData(N);

		// carga el diccionario con claves y valores aleatorios
		for (int d : datos) {
			String clave = String.format("[%d]", d);
			String valor = String.valueOf(d);
			diccionario.put(clave, valor);
			assertEquals(valor,diccionario.get(clave));
			assertNull(diccionario.get("no esta"));
		}
		assertEquals(datos.length, diccionario.size());

		// recarga
		for (int d : datos) {
			String clave = String.format("[%d]", d);
			String valor2 = Integer.toString(2) + "_2";
			diccionario.put(clave, valor2);
			assertEquals(valor2,diccionario.get(clave));
			assertNull(diccionario.get("no esta"));
		}
		assertEquals(datos.length, diccionario.size());

		// borrado
		for (int d : datos) {
			String clave = String.format("[%d]", d);
			String valor2 = Integer.toString(2) + "_2";
			diccionario.put(clave, valor2);
			assertEquals(valor2,diccionario.remove(clave));
			assertNull(diccionario.remove("no esta"));
		}		
		assertEquals(0, diccionario.size());

	}
	
	/**
	 * eliminar
	 */

    @Test
    public void testNRemove() {
    	testNRemove(diccionario);
    }
    
    private void testNRemove( Diccionario diccionario) {
        int N = 2 * NSLOTS;
        int[] datos = mkData(N);

        for (int i = 0; i < NSLOTS / 2; i++) {
            int dato = datos[i];
            String clave = String.format("[%d]", dato);
            String valor = Integer.toString(dato);
            diccionario.put(clave, valor);
        }
        assertNull(diccionario.get("no esta"));
        assertEquals(NSLOTS/2, diccionario.size());
        diccionario.clear();
        assertNull(diccionario.get("no esta"));
        assertEquals(0, diccionario.size());

        for (int i = 0; i < N; i++) {
            int d = datos[i];
            String clave = String.format("[%d]", d);
            String valor = Integer.toString(d);
            diccionario.put(clave, valor);
        }
        assertNull(diccionario.get("no esta"));
        assertEquals(N, diccionario.size());
        assertNull(diccionario.get("no esta"));
        diccionario.clear();
        assertEquals(0, diccionario.size());
    }   	

	/**
	 * genera un vector de n enteros /* entre 0 y n, revueltos aleatoriamente 
	 * sin duplicados
	 **/
	private int[] mkData(int n) {
		int[] datos = new int[n];
		for (int i = 0; i < n; i++)
			datos[i] = i;
		for (int i = 0; i < n; i++) {
			int p = random.nextInt(n);
			int q = random.nextInt(n);
			int dp = datos[p];
			int dq = datos[q];
			datos[p] = dq;
			datos[q] = dp;
		}
		return datos;
	}
		
}
