package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class AMSPenSelectionDialog extends AMSToolSelectionDialog implements InterfaceC0666bm {

    /* renamed from: f */
    private int f4005f;

    /* renamed from: g */
    private int[] f4006g;

    /* renamed from: h */
    private int[] f4007h;

    /* renamed from: i */
    private ImageView[] f4008i;

    /* renamed from: j */
    private ColorPickerView f4009j;

    /* renamed from: k */
    private LinearLayout f4010k;

    /* renamed from: l */
    private View f4011l;

    /* renamed from: m */
    private SeekBar f4012m;

    /* renamed from: n */
    private View f4013n;

    /* renamed from: o */
    private LinearLayout f4014o;

    /* renamed from: p */
    private ImageView f4015p;

    /* renamed from: q */
    private ImageView[] f4016q;

    /* renamed from: r */
    private int[] f4017r;

    /* renamed from: s */
    private int[] f4018s;

    /* renamed from: t */
    private View.OnClickListener f4019t;

    /* renamed from: u */
    private View.OnClickListener f4020u;

    public AMSPenSelectionDialog(Context context, int i) {
        super(context, i);
        this.f4005f = 0;
        this.f4006g = null;
        this.f4007h = null;
        this.f4009j = null;
        this.f4012m = null;
        this.f4015p = null;
        this.f4016q = null;
        this.f4017r = new int[]{C0062R.id.default_color_01, C0062R.id.default_color_02, C0062R.id.default_color_03, C0062R.id.default_color_04, C0062R.id.default_color_05, C0062R.id.default_color_06, C0062R.id.default_color_07, C0062R.id.default_color_08, C0062R.id.default_color_09, C0062R.id.default_color_10, C0062R.id.default_color_11, C0062R.id.default_color_12, C0062R.id.default_color_13, C0062R.id.default_color_14, C0062R.id.default_color_15};
        this.f4018s = new int[]{C0062R.color.ams_tool_default_color_01, C0062R.color.ams_tool_default_color_02, C0062R.color.ams_tool_default_color_03, C0062R.color.ams_tool_default_color_04, C0062R.color.ams_tool_default_color_05, C0062R.color.ams_tool_default_color_06, C0062R.color.ams_tool_default_color_07, C0062R.color.ams_tool_default_color_08, C0062R.color.ams_tool_default_color_09, C0062R.color.ams_tool_default_color_10, C0062R.color.ams_tool_default_color_11, C0062R.color.ams_tool_default_color_12, C0062R.color.ams_tool_default_color_13, C0062R.color.ams_tool_default_color_14, C0062R.color.ams_tool_default_color_15};
        this.f4019t = new ViewOnClickListenerC0653b(this);
        this.f4020u = new ViewOnClickListenerC0626a(this);
        this.f4006g = new int[4];
        this.f4007h = new int[4];
        for (int i2 = 0; i2 < 4; i2++) {
            this.f4006g[i2] = -7829368;
            this.f4007h[i2] = 3;
        }
        setContentView(C0062R.layout.ams_line_selection_layout);
        m3992d();
        this.f4009j.setColor(-7829368);
        this.f4008i = new ImageView[4];
        this.f4008i[0] = (ImageView) findViewById(C0062R.id.btn_tool_pen1);
        this.f4008i[1] = (ImageView) findViewById(C0062R.id.btn_tool_pen2);
        this.f4008i[3] = (ImageView) findViewById(C0062R.id.btn_tool_pen3);
        this.f4008i[2] = (ImageView) findViewById(C0062R.id.btn_tool_pen4);
        for (int i3 = 0; i3 < 4; i3++) {
            this.f4008i[i3].setOnClickListener(this.f4019t);
        }
        m3985a(this.f4005f, true);
        this.f4016q = new ImageView[15];
        for (int i4 = 0; i4 < 15; i4++) {
            this.f4016q[i4] = (ImageView) this.f4013n.findViewById(this.f4017r[i4]);
            this.f4016q[i4].setOnClickListener(this.f4020u);
        }
        m3990b(m3998f(this.f4006g[this.f4005f]), true);
        this.f4015p = (ImageView) findViewById(C0062R.id.btn_default_color);
        this.f4015p.setVisibility(4);
        this.f4015p.setOnClickListener(new ViewOnClickListenerC0701d(this));
        this.f4011l = ((ViewStub) findViewById(C0062R.id.stub_tool_size)).inflate();
        this.f4012m = (SeekBar) this.f4011l.findViewById(C0062R.id.seekbar_line_size);
        this.f4012m.setOnSeekBarChangeListener(new C0680c(this));
        m3993d(3);
        ((Button) findViewById(C0062R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(C0062R.id.btn_cancel)).setOnClickListener(this);
    }

    /* renamed from: a */
    private void m3985a(int i, boolean z) {
        this.f4008i[i].setSelected(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3990b(int i, boolean z) {
        this.f4016q[i].setSelected(z);
    }

    /* renamed from: d */
    private void m3992d() {
        this.f4009j = new ColorPickerView(getContext(), this.f4081a, this.f4084d, -1);
        this.f4009j.setColorChangedListener(this);
        this.f4010k = new LinearLayout(getContext());
        this.f4010k.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f4084d));
        this.f4010k.addView(this.f4009j);
        this.f4014o = (LinearLayout) findViewById(C0062R.id.layout_color_selector);
        this.f4014o.addView(this.f4010k);
        this.f4014o.setVisibility(8);
        this.f4013n = ((ViewStub) findViewById(C0062R.id.stub_default_color)).inflate();
        this.f4013n.setVisibility(0);
    }

    /* renamed from: d */
    private void m3993d(int i) {
        this.f4012m.setProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3995e() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (88.0f * this.f4083c), (int) (86.0f * this.f4083c), Bitmap.Config.ARGB_8888);
        AMSObjectLine aMSObjectLine = new AMSObjectLine(this.f4005f, this.f4006g[this.f4005f], this.f4007h[this.f4005f] + 1);
        aMSObjectLine.mo3954a(this.f4083c * 2.0f);
        aMSObjectLine.m3957a(bitmapCreateBitmap);
        aMSObjectLine.mo3963a((float) (bitmapCreateBitmap.getWidth() * 0.2d), (float) (bitmapCreateBitmap.getHeight() * 0.5d), (float) (bitmapCreateBitmap.getWidth() * 0.8d), (float) (bitmapCreateBitmap.getHeight() * 0.5d), 255);
        ((ImageView) this.f4011l.findViewById(C0062R.id.image_line_preview)).setImageBitmap(bitmapCreateBitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3996e(int i) {
        m3993d(this.f4007h[this.f4005f]);
        int i2 = i < 1 ? 1 : i;
        if (i2 >= 10) {
            i2 = 10;
        }
        this.f4007h[this.f4005f] = i2 - 1;
        m3993d(this.f4007h[this.f4005f]);
        m3995e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public int m3998f(int i) {
        for (int i2 = 0; i2 < 14; i2++) {
            if (i == getContext().getResources().getColor(this.f4018s[i2])) {
                return i2;
            }
        }
        return 14;
    }

    /* renamed from: a */
    public int m4003a() {
        return this.f4005f;
    }

    /* renamed from: a */
    public void m4004a(int i) {
        m3985a(this.f4005f, false);
        m3993d(this.f4007h[this.f4005f]);
        this.f4005f = i;
        m4007b(this.f4006g[this.f4005f]);
        m3985a(this.f4005f, true);
        m3993d(this.f4007h[this.f4005f]);
        m3995e();
    }

    /* renamed from: a */
    public void m4005a(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            this.f4006g[i] = iArr[i];
        }
        this.f4009j.setColor(this.f4006g[this.f4005f]);
        m3995e();
    }

    /* renamed from: b */
    public int m4006b() {
        return this.f4006g[this.f4005f];
    }

    /* renamed from: b */
    public void m4007b(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            m3990b(i2, false);
        }
        this.f4006g[this.f4005f] = i;
        this.f4009j.setColor(i);
        m3990b(m3998f(this.f4006g[this.f4005f]), true);
    }

    /* renamed from: b */
    public void m4008b(int[] iArr) {
        m3993d(this.f4007h[this.f4005f]);
        for (int i = 0; i < 4; i++) {
            if (iArr[i] < 1) {
                iArr[i] = 1;
            }
            if (iArr[i] >= 10) {
                iArr[i] = 10;
            }
            this.f4007h[i] = iArr[i] - 1;
        }
        m3993d(this.f4007h[this.f4005f]);
        m3995e();
    }

    /* renamed from: c */
    public int m4009c() {
        return this.f4007h[this.f4005f] + 1;
    }

    @Override // com.sec.vip.amschaton.InterfaceC0666bm
    /* renamed from: c */
    public boolean mo3895c(int i) {
        this.f4006g[this.f4005f] = i;
        m3995e();
        return true;
    }
}
