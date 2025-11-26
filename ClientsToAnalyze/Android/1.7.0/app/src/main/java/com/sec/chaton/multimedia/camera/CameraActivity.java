package com.sec.chaton.multimedia.camera;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.p029f.C0684a;

/* loaded from: classes.dex */
public class CameraActivity extends FragmentActivity {

    /* renamed from: a */
    private InterfaceC0796g f2690a;

    /* renamed from: b */
    private ImageButton f2691b;

    /* renamed from: c */
    private boolean f2692c = false;

    /* renamed from: d */
    private OrientationEventListener f2693d;

    /* renamed from: e */
    private int f2694e;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        this.f2690a = new C0795f(this).m3281a(this);
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.layout_camera, (ViewGroup) null);
        this.f2691b = (ImageButton) relativeLayout.findViewById(R.id.cameraButton);
        this.f2691b.setOnClickListener(new ViewOnClickListenerC0792c(this));
        if (C0684a.f2330a >= 5) {
            this.f2693d = new C0793d(this, this);
            this.f2693d.enable();
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView((SurfaceView) this.f2690a);
        frameLayout.addView(relativeLayout);
        setContentView(frameLayout);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f2692c = false;
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.f2692c = true;
        super.onResume();
    }
}
