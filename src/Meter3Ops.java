package es.upm.dit.adsw.ej3;

import java.util.Random;

/**
 * @author jmanas
 * @version 07-Dec-15.
 * @author jpuente
 * @version 2016.03.09
 */
//@SuppressWarnings("Duplicates")
public class Meter3Ops {
    private static final Random random = new Random();

    public static void main(String[] args) {
    	Diccionario diccionario;
    	
    	int nd = 5000;

        int[] ns = {
                500,  1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000,
                5500, 6000, 6500, 7000, 7500, 8000, 8500, 9000, 9500, 10000,
                10500, 11000, 11500, 12000, 12500, 13000, 13500, 14000, 14500, 15000,
                15500, 16000, 16500, 17000, 17500, 18000, 18500, 19000, 19500, 20000,
        };
        
        for (int n : ns) {
        	diccionario = new HashListas(n);
            for (int i = 0; i < 5; i++) {
                long t = meter(diccionario, nd);
                System.out.printf("%s %d%n", n, t);
            }
        }
    }

    private static long meter(Diccionario diccionario, int nd) {
        long t = 0;
        for (int j = 0; j < 100; j++) {
            load(diccionario, nd);
            long t0 = OpMeter.reset();
            for (int i = 0; i < 100; i++) {
                int r = random.nextInt(2 * nd);
                String clave = mkKey(r);
                String valor = mkValue(r);
                diccionario.get(clave);
            }
            long t2 = OpMeter.getOps();
            t += t2 - t0;
        }
        return t;
    }

    private static String mkKey(int k) {
        return String.valueOf(k);
    }
    private static String mkValue(int v) {
        return String.format("[%d]", v);
    }

    private static void load(Diccionario diccionario, int nd) {
        diccionario.clear();
        do {
            int r = random.nextInt(4 * nd);
            String clave = mkKey(r);
            String valor = mkValue(r);
            diccionario.put(clave, valor);
        } while (diccionario.size() < nd);
    }
}
