package com.sec.chaton.multimedia.camera;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.p012c.C0452a;

/* loaded from: classes.dex */
public class CameraActivity extends FragmentActivity {

    /* renamed from: a */
    private InterfaceC0899c f3292a;

    /* renamed from: b */
    private ImageButton f3293b;

    /* renamed from: c */
    private boolean f3294c = false;

    /* renamed from: d */
    private OrientationEventListener f3295d;

    /* renamed from: e */
    private int f3296e;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        this.f3292a = new C0903g(this).m3624a(this);
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.layout_camera, (ViewGroup) null);
        this.f3293b = (ImageButton) relativeLayout.findViewById(R.id.cameraButton);
        this.f3293b.setOnClickListener(new ViewOnClickListenerC0897a(this));
        if (C0452a.f1722a >= 5) {
            this.f3295d = new C0898b(this, this);
            this.f3295d.enable();
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView((SurfaceView) this.f3292a);
        frameLayout.addView(relativeLayout);
        setContentView(frameLayout);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f3294c = false;
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.f3294c = true;
        super.onResume();
    }
}
