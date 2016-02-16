package com.funnythingz.funnycam;

import processing.core.PApplet;

public class Sketch extends PApplet {
    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw() {
        background(0);
        if (mousePressed) {
            pen(120);
        }
    }

    private void pen(int size) {
        fill(random(255), random(255), random(255));
        ellipse(mouseX, mouseY, size, size);
    }
}