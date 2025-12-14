/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dmis_zadatak_3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author vabiel
 */
public class FactorielValue {

    private AtomicInteger currentValue;
    private double finalProduct = 1.0;

    public FactorielValue(int n) {
        this.currentValue = new AtomicInteger(n);
    }

    public int getNextNumber() {
        return currentValue.getAndDecrement();
    }

    public synchronized void multiply(double value) {
        finalProduct *= value;
    }

    public synchronized double getResult() {
        return finalProduct;
    }

    public int getCurrentValue() {
        return currentValue.get();
    }
}
