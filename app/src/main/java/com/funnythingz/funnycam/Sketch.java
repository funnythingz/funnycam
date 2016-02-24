package com.funnythingz.funnycam;

import android.util.Log;

import in.omerjerk.processing.video.android.*;
import processing.core.PApplet;

public class Sketch extends PApplet {

    private Capture capture;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        String[] captureList = Capture.list();
        if (captureList.length == 0) {
            Log.d("", "There are no cameras available for capture.");
            exit();
        }

        capture = new Capture(this, captureList[0]);
        capture.start();
    }

    @Override
    public void draw() {
        if (capture.available()) {
            capture.read();
        }
        image(capture, 0, 0);
    }
}