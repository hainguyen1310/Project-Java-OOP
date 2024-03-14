/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbageapp;

import java.util.Scanner;

/**
 *
 * @author duchieu
 */
public class GarbageApp {
    public static int[] input() {
        System.out.print("Enter the number of garbage point: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] gLoad = new int[n];
        for(int i = 0; i < n; i++) {
            gLoad[i] = sc.nextInt();
        }
        return gLoad;
    }
    public static void main(String[] args) {
        int[] gloads = input();
        
        Truck truck = new Truck(gloads);
        truck.start();
    }
}

