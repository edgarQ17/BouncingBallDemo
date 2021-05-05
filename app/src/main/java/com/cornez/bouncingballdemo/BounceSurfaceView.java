package com.cornez.bouncingballdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BounceSurfaceView extends SurfaceView implements
        SurfaceHolder.Callback {

    private BounceThread bounceThread;

    public BounceSurfaceView (Context context, AttributeSet attrs){
        super (context, attrs);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        //create new thread
        bounceThread = new BounceThread (holder);
    }

    //implent inherited abstarct methods
    public void surfaceChanged (SurfaceHolder holder, int format,
                                int width, int height) {}
    public void surfaceCreated (SurfaceHolder holder) {
        bounceThread.start();
    }

    public void surfaceDestroyed (SurfaceHolder holder) {
        bounceThread.endBounce();
        Thread dummyThread = bounceThread;
        bounceThread = null;
        dummyThread.interrupt();
    }
}
