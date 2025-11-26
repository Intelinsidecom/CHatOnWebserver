package com.sec.vip.amschaton;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSViewerActivity extends AMSActivity {

    /* renamed from: a */
    protected Viewer f4086a = null;

    /* renamed from: b */
    protected LinearLayout f4087b = null;

    /* renamed from: c */
    protected int f4088c = 0;

    /* renamed from: d */
    protected RelativeLayout f4089d = null;

    /* renamed from: a */
    protected void m4109a() {
        this.f4088c = getWindowManager().getDefaultDisplay().getWidth();
        ChatONLogWriter.m3506b("[setViewerLayout] mViewerSize = " + this.f4088c, getClass().getSimpleName());
        this.f4087b = new LinearLayout(this);
        this.f4087b.setLayoutParams(new ViewGroup.LayoutParams(this.f4088c, this.f4088c));
        this.f4086a = new Viewer(this);
        this.f4086a.m4191a(this.f4087b, this.f4088c);
        this.f4089d = new RelativeLayout(this);
        this.f4089d.setLayoutParams(new ViewGroup.LayoutParams(this.f4088c, this.f4088c));
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalStateException, IOException {
        super.onDestroy();
        if (this.f4086a != null) {
            this.f4086a.m4197c();
            this.f4086a.m4198d();
        }
    }
}
