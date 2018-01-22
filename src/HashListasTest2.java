package es.upm.dit.adsw.ej3;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * @author jmanas
 * @version 2016.03.12
 */

public class HashListasTest2 {
    public static final int N_SLOTS = 5;
    private final Random random = new Random();
    private Diccionario diccionario;

    @Before
    public void setUp() {
        diccionario = new HashListas(N_SLOTS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        diccionario.put(null, "valor");
    }

    @Test
    public void test00() {
        assertEquals(0, diccionario.size());
        assertNull(diccionario.get("clave"));
        assertNull(diccionario.remove("clave"));
    }

    @Test
    public void test01() {
        diccionario.put("clave", "valor");
        assertEquals(1, diccionario.size());
        assertEquals("valor", diccionario.get("clave"));
        diccionario.put("clave", "valor2");
        assertEquals("valor2", diccionario.get("clave"));
        assertEquals("valor2", diccionario.remove("clave"));
        assertEquals(0, diccionario.size());
        assertNull(diccionario.get("clave"));
        assertNull(diccionario.remove("clave"));
        assertEquals(0, diccionario.size());
    }

    @Test
    public void test05() {
        int[] datos = {3, 1, 2, 7, 5};
        for (int dato : datos) {
            String k = String.format("[%d]", dato);
            String v = String.valueOf(dato);
            diccionario.put(k, v);
        }
        assertEquals(datos.length, diccionario.size());

        for (int dato : datos) {
            String k = String.format("[%d]", dato);
            String v = String.valueOf(dato);
            assertEquals(v, diccionario.get(k));
        }
        assertNull(diccionario.get("clave"));
        assertNull(diccionario.remove("clave"));

        for (int dato : datos) {
            String k = String.format("[%d]", dato);
            String v = String.valueOf(dato);
            String v2 = diccionario.remove(k);
            assertEquals(v, v2);
        }
        assertEquals(0, diccionario.size());
    }

    @Test
    public void test0N() {
        int N = 2 * N_SLOTS;
        int[] datos = mkData(N);
        for (int i = 0; i < datos.length; i++) {
            int dato = datos[i];
            String k = String.format("[%d]", dato);
            String v = Integer.toString(dato);
            diccionario.put(k, v);
            assertEquals(v, diccionario.get(k));
            assertNull(diccionario.get("no esta"));
            assertEquals(i + 1, diccionario.size());
        }
        for (int i = 0; i < datos.length; i++) {
            int dato = datos[i];
            String k = String.format("[%d]", dato);
            String v_2 = Integer.toString(dato) + "_2";
            diccionario.put(k, v_2);
            assertEquals(v_2, diccionario.get(k));
            assertNull(diccionario.get("no esta"));
            assertEquals(datos.length, diccionario.size());
        }
        for (int i = 0; i < datos.length; i++) {
            int dato = datos[i];
            String k = String.format("[%d]", dato);
            String v_2 = Integer.toString(dato) + "_2";
            assertEquals(v_2, diccionario.remove(k));
            assertEquals(datos.length - i - 1, diccionario.size());
        }
        assertEquals(0, diccionario.size());
    }

    @Test
    public void testRemoveN() {
        int N = 2 * N_SLOTS;
        int[] datos = mkData(N);

        for (int i = 0; i < N_SLOTS / 2; i++) {
            int dato = datos[i];
            String k = String.format("[%d]", dato);
            String v = Integer.toString(dato);
            diccionario.put(k, v);
        }
        assertNull(diccionario.get("no esta"));
        assertEquals(N_SLOTS/2, diccionario.size());
        diccionario.clear();
        assertNull(diccionario.get("no esta"));
        assertEquals(0, diccionario.size());

        for (int i = 0; i < N; i++) {
            int dato = datos[i];
            String k = String.format("[%d]", dato);
            String v = Integer.toString(dato);
            diccionario.put(k, v);
        }
        assertNull(diccionario.get("no esta"));
        assertEquals(N, diccionario.size());
        assertNull(diccionario.get("no esta"));
        diccionario.clear();
        assertEquals(0, diccionario.size());
    }

    private int[] mkData(int n) {
        int[] datos = new int[n];
        for (int i = 0; i < n; i++)
            datos[i] = i;
        for (int i = 0; i < n; i++) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            int v = datos[p];
            datos[p] = datos[q];
            datos[q] = v;
        }
        return datos;
    }

}
