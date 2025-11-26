package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.sec.chaton.R;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.af */
/* loaded from: classes.dex */
public class C1369af extends C1560y {

    /* renamed from: e */
    private int f4799e;

    /* renamed from: f */
    private ImageView[] f4800f;

    /* renamed from: g */
    private int f4801g;

    /* renamed from: h */
    private SeekBar f4802h;

    /* renamed from: i */
    private ImageView f4803i;

    /* renamed from: j */
    private int f4804j;

    /* renamed from: k */
    private ImageView[] f4805k;

    /* renamed from: l */
    private ImageView f4806l;

    /* renamed from: m */
    private int[] f4807m;

    /* renamed from: n */
    private int[] f4808n;

    /* renamed from: o */
    private View f4809o;

    /* renamed from: p */
    private DialogC1363a f4810p;

    /* renamed from: q */
    private View.OnClickListener f4811q;

    /* renamed from: r */
    private View.OnClickListener f4812r;

    /* renamed from: s */
    private View.OnClickListener f4813s;

    public C1369af(Context context, int i, View view, boolean z) {
        super(context, i, z);
        this.f4799e = 0;
        this.f4801g = 5;
        this.f4802h = null;
        this.f4803i = null;
        this.f4804j = -256;
        this.f4805k = null;
        this.f4806l = null;
        this.f4807m = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f4808n = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f4809o = null;
        this.f4810p = null;
        this.f4811q = new ViewOnClickListenerC1392bb(this);
        this.f4812r = new ViewOnClickListenerC1393bc(this);
        this.f4813s = new ViewOnClickListenerC1394bd(this);
        m4904a(view);
    }

    /* renamed from: a */
    private void m4904a(View view) {
        ((ImageView) m5650b().findViewById(R.id.btn_close_popup)).setOnClickListener(new ViewOnClickListenerC1388ay(this));
        this.f4800f = new ImageView[4];
        this.f4800f[0] = (ImageView) m5650b().findViewById(R.id.btn_pen_style1);
        this.f4800f[1] = (ImageView) m5650b().findViewById(R.id.btn_pen_style2);
        this.f4800f[3] = (ImageView) m5650b().findViewById(R.id.btn_pen_style3);
        this.f4800f[2] = (ImageView) m5650b().findViewById(R.id.btn_pen_style4);
        for (int i = 0; i < 4; i++) {
            this.f4800f[i].setOnClickListener(this.f4811q);
        }
        m4903a(this.f4799e, true);
        this.f4803i = (ImageView) m5650b().findViewById(R.id.iv_pen_stroke_preview);
        this.f4802h = (SeekBar) m5650b().findViewById(R.id.seekbar_pen_size);
        this.f4802h.setMax(9);
        this.f4802h.setOnSeekBarChangeListener(new C1389az(this));
        m4908b(this.f4801g, true);
        this.f4809o = ((ViewStub) m5650b().findViewById(R.id.stub_pen_color)).inflate();
        this.f4805k = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f4805k[i2] = (ImageView) this.f4809o.findViewById(this.f4807m[i2]);
            this.f4805k[i2].setOnClickListener(this.f4812r);
        }
        this.f4806l = (ImageView) this.f4809o.findViewById(R.id.btn_color16);
        this.f4806l.setOnClickListener(this.f4813s);
        m4911c(m4915e(this.f4804j), true);
        m4909b(view);
    }

    /* renamed from: b */
    private void m4909b(View view) {
        view.post(new RunnableC1391ba(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4918h() {
        dismiss();
    }

    /* renamed from: a */
    private void m4903a(int i, boolean z) {
        if (i >= 0 && i < 4) {
            this.f4800f[i].setSelected(z);
        }
    }

    /* renamed from: a */
    public void m4919a(int i) {
        m4903a(this.f4799e, false);
        this.f4799e = i;
        m4903a(this.f4799e, true);
    }

    /* renamed from: e */
    public int m4922e() {
        return this.f4799e;
    }

    /* renamed from: b */
    private void m4908b(int i, boolean z) {
        this.f4802h.setProgress(m4913d(i));
        m4902a(i, this.f4804j);
    }

    /* renamed from: b */
    public void m4920b(int i) {
        m4908b(this.f4801g, false);
        this.f4801g = i;
        m4908b(this.f4801g, true);
    }

    /* renamed from: f */
    public int m4923f() {
        return this.f4801g;
    }

    /* renamed from: d */
    private int m4913d(int i) {
        int i2 = i - 1;
        if (i2 < 0 || i2 >= 10) {
            return 4;
        }
        return i2;
    }

    /* renamed from: a */
    private void m4902a(int i, int i2) {
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        int measuredWidth = this.f4803i.getMeasuredWidth();
        int measuredHeight = this.f4803i.getMeasuredHeight();
        if (this.f5417c != null) {
            this.f5417c.recycle();
            this.f5417c = null;
        }
        this.f5417c = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f5417c);
        canvas.drawCircle(measuredWidth * 0.5f, measuredHeight * 0.5f, measuredWidth * 0.048f * i, paint);
        paint.setColor(i2);
        canvas.drawCircle(measuredWidth * 0.5f, measuredHeight * 0.5f, ((measuredWidth * 0.048f) * i) - 2.0f, paint);
        this.f4803i.setImageBitmap(this.f5417c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4911c(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f4805k[i2].setSelected(false);
                }
                this.f4806l.setSelected(z);
                return;
            }
            this.f4805k[i].setSelected(z);
        }
    }

    /* renamed from: a */
    private void m4907a(boolean z) {
        for (int i = 0; i < 15; i++) {
            this.f4805k[i].setSelected(z);
        }
        this.f4806l.setSelected(z);
    }

    /* renamed from: c */
    public void m4921c(int i) {
        m4907a(false);
        this.f4804j = i;
        m4911c(m4915e(this.f4804j), true);
        m4902a(this.f4801g, this.f4804j);
    }

    /* renamed from: g */
    public int m4924g() {
        return this.f4804j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int m4915e(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == m5646a().getResources().getColor(this.f4808n[i2])) {
                return i2;
            }
        }
        return -1;
    }
}
