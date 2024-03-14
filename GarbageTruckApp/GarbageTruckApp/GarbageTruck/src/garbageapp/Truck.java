package garbageapp;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Truck implements GarbageInfo {

 private int curLoad;
 private int totalTime;
 private int totalField;
 private int curPoint;
 private GarbagePoint[] gps;
 private ArrayList<String> workLogs = new ArrayList<>();
 private boolean diemcuoi = false;

   public Truck() {
    }

   public Truck(int[] gws) {
        gps = new GarbagePoint[gws.length];
        for (int i = 0; i < gws.length; i++) {
            gps[i] = new GarbagePoint(i + 1, gws[i], "Address " + (i + 1));
        }
    }

   
   public double calculateTotalCost() {
        return FEE * totalField + SALARY * ((double) totalTime / 60);
    }

   public void specialPoint() {
        int n = gps[curPoint].getGetLoad();
        if (n > 10000 && curLoad == 0) {
            curLoad = 10000;
            gps[curPoint].setGetLoad(n - 10000);
        }
    }

   public void start() {
        workLogs.add("Start at " + LocalDateTime.now());
        goNext();
    }

   public void goNext() {
        if (curLoad + gps[curPoint].getGetLoad() <= MAX_LOAD) {
            curLoad += gps[curPoint].getGetLoad();
            gps[curPoint].setGetLoad(0);
            totalTime += AVG_TIME;
            workLogs.add("Collect at point " + (curPoint + 1));
            if ((curPoint + 1) == gps.length) {
                diemcuoi = true;
                goField();
            } else {
                curPoint++;
                goNext();
            }
        } else {
            specialPoint();
            goField();
        }
    }

   public void goField() {
        curLoad = 0;
        totalField++;
        totalTime += AVG_HT;
        workLogs.add("Go to field for " + totalField + " time");
        if (diemcuoi) {
            goHome();
        } else {
            goNext();
        }
    }

   public void goHome() {
        System.out.printf("Tong chi phi: %.0f Đ", calculateTotalCost());

    }
}