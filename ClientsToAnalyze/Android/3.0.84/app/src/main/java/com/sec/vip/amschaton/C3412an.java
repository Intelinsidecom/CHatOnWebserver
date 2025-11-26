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
/* renamed from: com.sec.vip.amschaton.an */
/* loaded from: classes.dex */
public class C3412an extends C3421aw {

    /* renamed from: g */
    private int f12500g;

    /* renamed from: h */
    private ImageView[] f12501h;

    /* renamed from: i */
    private int f12502i;

    /* renamed from: j */
    private SeekBar f12503j;

    /* renamed from: k */
    private ImageView f12504k;

    /* renamed from: l */
    private int f12505l;

    /* renamed from: m */
    private ImageView[] f12506m;

    /* renamed from: n */
    private ImageView f12507n;

    /* renamed from: o */
    private int[] f12508o;

    /* renamed from: p */
    private int[] f12509p;

    /* renamed from: q */
    private View f12510q;

    /* renamed from: r */
    private View.OnClickListener f12511r;

    /* renamed from: s */
    private View.OnClickListener f12512s;

    /* renamed from: t */
    private View.OnClickListener f12513t;

    public C3412an(Context context, int i, View view, boolean z) {
        super(context, i, z);
        this.f12500g = 0;
        this.f12502i = 5;
        this.f12503j = null;
        this.f12504k = null;
        this.f12505l = -256;
        this.f12506m = null;
        this.f12507n = null;
        this.f12508o = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f12509p = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f12510q = null;
        this.f12511r = new ViewOnClickListenerC3417as(this);
        this.f12512s = new ViewOnClickListenerC3418at(this);
        this.f12513t = new ViewOnClickListenerC3420av(this);
        m12212a(view);
    }

    /* renamed from: a */
    private void m12212a(View view) {
        ((ImageView) m12243f().findViewById(R.id.btn_close_popup)).setOnClickListener(new ViewOnClickListenerC3413ao(this));
        this.f12501h = new ImageView[4];
        this.f12501h[0] = (ImageView) m12243f().findViewById(R.id.btn_pen_style1);
        this.f12501h[1] = (ImageView) m12243f().findViewById(R.id.btn_pen_style2);
        this.f12501h[3] = (ImageView) m12243f().findViewById(R.id.btn_pen_style3);
        this.f12501h[2] = (ImageView) m12243f().findViewById(R.id.btn_pen_style4);
        for (int i = 0; i < 4; i++) {
            this.f12501h[i].setOnClickListener(this.f12511r);
        }
        m12211a(this.f12500g, true);
        this.f12504k = (ImageView) m12243f().findViewById(R.id.iv_pen_stroke_preview);
        this.f12503j = (SeekBar) m12243f().findViewById(R.id.seekbar_pen_size);
        this.f12503j.setMax(9);
        this.f12503j.setOnSeekBarChangeListener(new C3415aq(this));
        m12216b(this.f12502i, true);
        this.f12510q = ((ViewStub) m12243f().findViewById(R.id.stub_pen_color)).inflate();
        this.f12506m = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f12506m[i2] = (ImageView) this.f12510q.findViewById(this.f12508o[i2]);
            this.f12506m[i2].setOnClickListener(this.f12512s);
        }
        this.f12507n = (ImageView) this.f12510q.findViewById(R.id.btn_color16);
        this.f12507n.setOnClickListener(this.f12513t);
        m12219c(m12224f(this.f12505l), true);
        m12217b(view);
    }

    /* renamed from: b */
    private void m12217b(View view) {
        view.post(new RunnableC3416ar(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12225j() {
        dismiss();
    }

    /* renamed from: a */
    private void m12211a(int i, boolean z) {
        if (i >= 0 && i < 4) {
            this.f12501h[i].setSelected(z);
        }
    }

    /* renamed from: a */
    public void m12227a(int i) {
        m12211a(this.f12500g, false);
        this.f12500g = i;
        m12211a(this.f12500g, true);
    }

    /* renamed from: a */
    public int m12226a() {
        return this.f12500g;
    }

    /* renamed from: b */
    private void m12216b(int i, boolean z) {
        this.f12503j.setProgress(m12222e(i));
        m12210a(i, this.f12505l);
    }

    /* renamed from: b */
    public void m12229b(int i) {
        m12216b(this.f12502i, false);
        this.f12502i = i;
        m12216b(this.f12502i, true);
    }

    /* renamed from: b */
    public int m12228b() {
        return this.f12502i;
    }

    /* renamed from: e */
    private int m12222e(int i) {
        int i2 = i - 1;
        if (i2 < 0 || i2 >= 10) {
            return 4;
        }
        return i2;
    }

    /* renamed from: a */
    private void m12210a(int i, int i2) {
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        int measuredWidth = this.f12504k.getMeasuredWidth();
        int measuredHeight = this.f12504k.getMeasuredHeight();
        if (this.f12525c != null) {
            this.f12525c.recycle();
            this.f12525c = null;
        }
        this.f12525c = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12525c);
        paint.setColor(i2);
        canvas.drawCircle(measuredWidth * 0.5f, measuredHeight * 0.5f, ((measuredWidth * 0.048f) * i) - 2.0f, paint);
        this.f12504k.setImageBitmap(this.f12525c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12219c(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f12506m[i2].setSelected(false);
                }
                this.f12507n.setSelected(z);
                return;
            }
            this.f12506m[i].setSelected(z);
        }
    }

    /* renamed from: a */
    private void m12215a(boolean z) {
        for (int i = 0; i < 15; i++) {
            this.f12506m[i].setSelected(z);
        }
        this.f12507n.setSelected(z);
    }

    /* renamed from: c */
    public void m12231c(int i) {
        m12215a(false);
        this.f12505l = i;
        m12219c(m12224f(this.f12505l), true);
        m12210a(this.f12502i, this.f12505l);
    }

    /* renamed from: c */
    public int m12230c() {
        return this.f12505l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public int m12224f(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == m12242e().getResources().getColor(this.f12509p[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: d */
    public void m12233d(int i) {
        this.f12526d = new C3576i(m12242e());
        this.f12526d.m12770a(i);
        m12232d();
        this.f12526d.m12774d();
    }

    /* renamed from: d */
    public void m12232d() {
        this.f12526d.m12771a(new C3419au(this));
    }
}
