/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dmis_zadatak_3;

/**
 *
 * @author vabiel
 */
public class FactorielWorker extends Thread {

    private static int threadCounter = 0;
    private int threadId;

    private FactorielValue factorielValue;
    private double localProduct = 1.0;

    public FactorielWorker(FactorielValue fv) {
        this.factorielValue = fv;
        this.threadId = ++threadCounter;
    }

    @Override
    public void run() {
        System.out.println("Nit " + threadId + " je krenula sa radom");

        int number;

        while ((number = factorielValue.getNextNumber()) > 1) {
            localProduct *= number;
            System.out.println("Nit " + threadId + " je pomnozila sa " + number
                    + ", lokalni proizvod = " + localProduct);
        }

        factorielValue.multiply(localProduct);

        System.out.println("Nit " + threadId + " je zavrsila sa radom. "
                + "Lokalni proizvod: " + localProduct);
    }

    public double getLocalProduct() {
        return localProduct;
    }
}
