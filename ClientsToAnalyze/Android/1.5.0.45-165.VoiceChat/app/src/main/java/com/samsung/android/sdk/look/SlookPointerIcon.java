package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;

/* loaded from: classes.dex */
public class SlookPointerIcon {
    private Drawable mDrawable;
    private final String TAG = "SlookPointerIcon";
    private Slook mSlook = new Slook();
    private int mHoverIconId = -1;

    public void setHoverIcon(View view, Drawable d) {
        if (isSupport(1)) {
            if (view == null) {
                throw new IllegalArgumentException("view is null.");
            }
            if (d == null) {
                view.setOnHoverListener(null);
                try {
                    PointerIcon.setHoveringSpenIcon(1, -1);
                    return;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.mDrawable = d;
            view.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.look.SlookPointerIcon.1
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.view.View.OnHoverListener
                public boolean onHover(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case 9:
                            try {
                                PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.this.mDrawable);
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                            return false;
                        case 10:
                            try {
                                PointerIcon.setHoveringSpenIcon(1, -1);
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                            return false;
                        default:
                            return false;
                    }
                }
            });
        }
    }

    private boolean isSupport(int ver) {
        if (this.mSlook.getVersionCode() >= ver) {
            return true;
        }
        Log.e("SlookPointerIcon", "This is not supported in device");
        return false;
    }
}
