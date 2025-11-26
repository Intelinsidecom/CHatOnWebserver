package com.infraware.office.evengine;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface EvListener {

    public interface ViewerListener {
        Bitmap GetBitmap(int i, int i2);

        void OnCloseDoc();

        void OnDrawBitmap(int i, int i2);

        void OnLoadComplete();

        void OnLoadFail(int i);

        void OnPageMove(int i, int i2, int i3);

        void OnPrintMode(String str);

        void OnPrintedCount(int i);

        void OnProgress(int i, int i2);

        void OnProgressStart(int i);

        void OnTerminate();

        void OnTotalLoadComplete();
    }
}
