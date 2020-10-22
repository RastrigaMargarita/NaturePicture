package com.margretcraft.naturepicture;

import android.graphics.Bitmap;

public class ThreePicture {
    Bitmap bm1;
    Bitmap bm2;
    Bitmap bm3;


    public ThreePicture(Bitmap bm1, Bitmap bm2, Bitmap bm3) {
        this.bm1 = bm1;
        this.bm2 = bm2;
        this.bm3 = bm3;
    }

    public ThreePicture() {
    }

    public Bitmap getBm1() {
        return bm1;
    }

    public void setBm1(Bitmap bm1) {
        this.bm1 = bm1;
    }

    public Bitmap getBm2() {
        return bm2;
    }

    public void setBm2(Bitmap bm2) {
        this.bm2 = bm2;
    }

    public Bitmap getBm3() {
        return bm3;
    }

    public void setBm3(Bitmap bm3) {
        this.bm3 = bm3;
    }
}
