package com.coolots.chaton.call.screenshare.util;

import android.R;
import android.app.INotificationManager;
import android.app.ITransientNotification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ScreenShareToast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    static final String TAG = "ScreenShareToast";
    static final boolean localLOGV = false;
    private static INotificationManager sService = null;
    final Context mContext;
    int mDuration;
    int mGravity = 81;
    final Handler mHandler = new Handler();
    float mHorizontalMargin;
    View mNextView;
    final ITransientNotificationStubC0212TN mTN;
    float mVerticalMargin;
    View mView;

    /* renamed from: mX */
    int f10mX;

    /* renamed from: mY */
    int f11mY;

    public ScreenShareToast(Context context) {
        this.mContext = context;
        this.mTN = new ITransientNotificationStubC0212TN(context);
        this.f11mY = context.getResources().getDimensionPixelSize(R.dimen.__removed_system_app_widget_internal_padding);
    }

    public void show() {
        if (this.mNextView == null) {
            throw new RuntimeException("setView must have been called");
        }
        INotificationManager service = getService();
        String pkg = this.mContext.getPackageName();
        ITransientNotificationStubC0212TN tn = this.mTN;
        try {
            service.enqueueToast(pkg, tn, this.mDuration);
        } catch (RemoteException e) {
        }
    }

    public void cancel() {
        this.mTN.hide();
    }

    public void setView(View view) {
        this.mNextView = view;
    }

    public View getView() {
        return this.mNextView;
    }

    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setMargin(float horizontalMargin, float verticalMargin) {
        this.mHorizontalMargin = horizontalMargin;
        this.mVerticalMargin = verticalMargin;
    }

    public float getHorizontalMargin() {
        return this.mHorizontalMargin;
    }

    public float getVerticalMargin() {
        return this.mVerticalMargin;
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        this.mGravity = gravity;
        this.f10mX = xOffset;
        this.f11mY = yOffset;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getXOffset() {
        return this.f10mX;
    }

    public int getYOffset() {
        return this.f11mY;
    }

    public static ScreenShareToast makeText(Context context, CharSequence text, int duration) {
        ScreenShareToast result = new ScreenShareToast(context);
        LayoutInflater inflate = (LayoutInflater) context.getSystemService("layout_inflater");
        View v = inflate.inflate(R.layout.screen_progress, (ViewGroup) null);
        TextView tv = (TextView) v.findViewById(R.id.message);
        tv.setText(text);
        result.mNextView = v;
        result.mDuration = duration;
        return result;
    }

    public static ScreenShareToast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    public void setText(int resId) {
        setText(this.mContext.getText(resId));
    }

    public void setText(CharSequence s) {
        if (this.mNextView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView tv = (TextView) this.mNextView.findViewById(R.id.message);
        if (tv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
    }

    private static INotificationManager getService() {
        if (sService == null) {
            sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        }
        return sService;
    }

    /* renamed from: com.coolots.chaton.call.screenshare.util.ScreenShareToast$TN */
    private class ITransientNotificationStubC0212TN extends ITransientNotification.Stub {
        WindowManager mWM;
        Runnable mShow = new Runnable() { // from class: com.coolots.chaton.call.screenshare.util.ScreenShareToast.TN.1
            @Override // java.lang.Runnable
            public void run() {
                ITransientNotificationStubC0212TN.this.handleShow();
            }
        };
        Runnable mHide = new Runnable() { // from class: com.coolots.chaton.call.screenshare.util.ScreenShareToast.TN.2
            @Override // java.lang.Runnable
            public void run() {
                ITransientNotificationStubC0212TN.this.handleHide();
            }
        };
        private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();

        ITransientNotificationStubC0212TN(Context context) {
            this.mParams.height = -2;
            this.mParams.width = -2;
            this.mParams.flags = 152;
            this.mParams.format = -3;
            this.mParams.windowAnimations = R.style.Animation.Toast;
            this.mParams.type = 2021;
            this.mParams.setTitle("Toast");
        }

        public void show() {
            ScreenShareToast.this.mHandler.post(this.mShow);
        }

        public void hide() {
            ScreenShareToast.this.mHandler.post(this.mHide);
        }

        public void handleShow() {
            if (ScreenShareToast.this.mView != ScreenShareToast.this.mNextView) {
                handleHide();
                ScreenShareToast.this.mView = ScreenShareToast.this.mNextView;
                if (this.mWM == null) {
                    this.mWM = (WindowManager) ScreenShareToast.this.mContext.getSystemService("window");
                }
                int gravity = ScreenShareToast.this.mGravity;
                this.mParams.gravity = gravity;
                if ((gravity & 7) == 7) {
                    this.mParams.horizontalWeight = 1.0f;
                }
                if ((gravity & 112) == 112) {
                    this.mParams.verticalWeight = 1.0f;
                }
                this.mParams.x = ScreenShareToast.this.f10mX;
                this.mParams.y = ScreenShareToast.this.f11mY;
                this.mParams.verticalMargin = ScreenShareToast.this.mVerticalMargin;
                this.mParams.horizontalMargin = ScreenShareToast.this.mHorizontalMargin;
                if (ScreenShareToast.this.mView.getParent() != null) {
                    this.mWM.removeView(ScreenShareToast.this.mView);
                }
                this.mWM.addView(ScreenShareToast.this.mView, this.mParams);
            }
        }

        public void handleHide() {
            if (ScreenShareToast.this.mView != null) {
                if (ScreenShareToast.this.mView.getParent() != null) {
                    this.mWM.removeView(ScreenShareToast.this.mView);
                }
                ScreenShareToast.this.mView = null;
            }
        }
    }
}
