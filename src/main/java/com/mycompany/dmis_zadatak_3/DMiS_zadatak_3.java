/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dmis_zadatak_3;

/**
 *
 * @author vabiel
 */
public class DMiS_zadatak_3 {

    private static final int FACTORIEL_NUMBER = 10;
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        System.out.println("=== Izracunavanje " + FACTORIEL_NUMBER + "! sa "
                + NUM_THREADS + " niti ===\n");

        FactorielValue fv = new FactorielValue(FACTORIEL_NUMBER);

        FactorielWorker[] threads = new FactorielWorker[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new FactorielWorker(fv);
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n=== REZULTAT ===");
        System.out.println(FACTORIEL_NUMBER + "! = " + fv.getResult());

        double provera = 1.0;
        for (int i = 2; i <= FACTORIEL_NUMBER; i++) {
            provera *= i;
        }
        System.out.println("Provera: " + provera);
    }
}
