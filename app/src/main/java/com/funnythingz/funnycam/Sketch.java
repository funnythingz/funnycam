package com.funnythingz.funnycam;

import processing.core.PApplet;

public class Sketch extends PApplet {

    private int wpx;
    private int hpx;

    private enum BackgroundColor {
        BLACK,
        RANDOM,
    }

    private BackgroundColor backgroundColor;

    private void switchBackgroundColor() {
        switch (this.backgroundColor) {
            case BLACK:
                this.backgroundColor = BackgroundColor.RANDOM;
                background(random(256), random(256), random(256));
                break;
            case RANDOM:
                this.backgroundColor = BackgroundColor.BLACK;
                background(0);
                break;
        }
    }

    private void selectBackgroundColor(BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        switch (this.backgroundColor) {
            case BLACK:
                background(0);
                break;
            case RANDOM:
                background(random(256), random(256), random(256));
                break;
        }
    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        selectBackgroundColor(BackgroundColor.BLACK);
        wpx = displayWidth / 10;
        hpx = displayHeight / 16;
    }

    @Override
    public void draw() {
        if (mousePressed) {
            switchBackgroundColor();
        }

        for(int x = 0; x < width; x += wpx){
            for(int y = 0; y < height; y += hpx){
                noFill();
                stroke(random(255), random(255), random(255));
                rect(x, y, wpx, hpx);
            }
        }
        noFill();
        stroke(random(255), random(255), random(255));
        rect((wpx * 9) - 1, (hpx * 15) - 1, wpx, hpx);
    }
}