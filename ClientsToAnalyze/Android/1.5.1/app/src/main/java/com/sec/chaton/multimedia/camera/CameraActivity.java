package com.sec.chaton.multimedia.camera;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.C0062R;
import com.sec.chaton.constant.ChatONConst;

/* loaded from: classes.dex */
public class CameraActivity extends FragmentActivity {

    /* renamed from: a */
    private InterfaceC0296f f2103a;

    /* renamed from: b */
    private ImageButton f2104b;

    /* renamed from: c */
    private boolean f2105c = false;

    /* renamed from: d */
    private OrientationEventListener f2106d;

    /* renamed from: e */
    private int f2107e;

    public class PreviewManager {

        /* renamed from: b */
        private InterfaceC0296f f2109b;

        public PreviewManager() {
        }

        /* renamed from: a */
        public InterfaceC0296f m2508a(Context context) {
            if (ChatONConst.f1337a >= 5) {
                this.f2109b = new SurfaceHolderCallbackC0295e(CameraActivity.this, context);
            } else {
                this.f2109b = new SurfaceHolderCallbackC0292b(CameraActivity.this, context);
            }
            return this.f2109b;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        this.f2103a = new PreviewManager().m2508a(this);
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(C0062R.layout.layout_camera, (ViewGroup) null);
        this.f2104b = (ImageButton) relativeLayout.findViewById(C0062R.id.cameraButton);
        this.f2104b.setOnClickListener(new ViewOnClickListenerC0293c(this));
        if (ChatONConst.f1337a >= 5) {
            this.f2106d = new C0294d(this, this);
            this.f2106d.enable();
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView((SurfaceView) this.f2103a);
        frameLayout.addView(relativeLayout);
        setContentView(frameLayout);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f2105c = false;
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.f2105c = true;
        super.onResume();
    }
}
