package com.example.khiem.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SimpleDrawingView extends View {
    private ArrayList<Rect> rects;
    private Rect current;
    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        rects = new ArrayList<>();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        if (!rects.isEmpty()) {
            for (Rect r : rects)
                canvas.drawRect(r, paint);
        }
        if (current != null) {
            canvas.drawRect(current, paint);
        }
        postInvalidate();
    }

    private Rect find(int x, int y) {
        for (Rect r : rects) {
            if (r.contains(x, y)) {
                return r;
            }
        }
        return null;
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = Math.round(event.getX());
        int y = Math.round(event.getY());
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            current = find(x, y);
            if (current == null) {
                rects.add(new Rect(x - 10, y - 10, x + 10, y + 10));
            }
        }
        else if (action == MotionEvent.ACTION_MOVE&&current!=null)
            current.set(x - 10, y - 10, x + 10, y + 10);

        return true;
    }
}