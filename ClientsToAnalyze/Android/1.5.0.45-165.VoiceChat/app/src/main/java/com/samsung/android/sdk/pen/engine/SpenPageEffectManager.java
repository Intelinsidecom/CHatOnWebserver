package com.samsung.android.sdk.pen.engine;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.samsung.android.sdk.pen.engine.SpenPageEffectHandler;

/* compiled from: SpenPageEffectHandler.java */
/* loaded from: classes.dex */
class SpenPageEffectManager implements SpenPageEffectHandler {
    private SpenPageEffectHandler mHandler;
    private SpenPageEffectHandler[] mPageEffectHandler = new SpenPageEffectHandler[2];

    SpenPageEffectManager(SpenPageEffectHandler.Listener listener) {
        this.mPageEffectHandler[0] = new SpenPageEffectHandler1(listener);
        this.mPageEffectHandler[1] = new SpenPageEffectHandler2(listener);
        this.mHandler = this.mPageEffectHandler[0];
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void close() {
        if (this.mPageEffectHandler != null) {
            this.mPageEffectHandler[0].close();
            this.mPageEffectHandler[0] = null;
            this.mPageEffectHandler[1].close();
            this.mPageEffectHandler[1] = null;
            this.mPageEffectHandler = null;
        }
        this.mHandler = null;
    }

    public void setType(int type) {
        if (type < 0) {
            type = 0;
        } else if (type >= this.mPageEffectHandler.length) {
            type = this.mPageEffectHandler.length - 1;
        }
        this.mHandler = this.mPageEffectHandler[type];
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setPaint(Paint paint) {
        for (SpenPageEffectHandler handler : this.mPageEffectHandler) {
            handler.setPaint(paint);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setScreenResolution(int w, int h) {
        for (SpenPageEffectHandler handler : this.mPageEffectHandler) {
            handler.setScreenResolution(w, h);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setCanvasInformation(int x, int y, int w, int h) {
        for (SpenPageEffectHandler handler : this.mPageEffectHandler) {
            handler.setCanvasInformation(x, y, w, h);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean saveScreenshot() {
        return this.mHandler.saveScreenshot();
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean startAnimation(int direction) {
        return this.mHandler.startAnimation(direction);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean isWorking() {
        return this.mHandler.isWorking();
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void drawAnimation(Canvas canvas) {
        this.mHandler.drawAnimation(canvas);
    }
}
