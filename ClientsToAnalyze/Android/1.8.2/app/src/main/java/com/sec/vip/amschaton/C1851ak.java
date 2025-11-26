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
/* renamed from: com.sec.vip.amschaton.ak */
/* loaded from: classes.dex */
public class C1851ak extends C1860at {

    /* renamed from: f */
    private int f6789f;

    /* renamed from: g */
    private ImageView[] f6790g;

    /* renamed from: h */
    private int f6791h;

    /* renamed from: i */
    private SeekBar f6792i;

    /* renamed from: j */
    private ImageView f6793j;

    /* renamed from: k */
    private int f6794k;

    /* renamed from: l */
    private ImageView[] f6795l;

    /* renamed from: m */
    private ImageView f6796m;

    /* renamed from: n */
    private int[] f6797n;

    /* renamed from: o */
    private int[] f6798o;

    /* renamed from: p */
    private View f6799p;

    /* renamed from: q */
    private View.OnClickListener f6800q;

    /* renamed from: r */
    private View.OnClickListener f6801r;

    /* renamed from: s */
    private View.OnClickListener f6802s;

    public C1851ak(Context context, int i, View view, boolean z) {
        super(context, i, z);
        this.f6789f = 0;
        this.f6791h = 5;
        this.f6792i = null;
        this.f6793j = null;
        this.f6794k = -256;
        this.f6795l = null;
        this.f6796m = null;
        this.f6797n = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f6798o = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f6799p = null;
        this.f6800q = new ViewOnClickListenerC1856ap(this);
        this.f6801r = new ViewOnClickListenerC1857aq(this);
        this.f6802s = new ViewOnClickListenerC1859as(this);
        m6414a(view);
    }

    /* renamed from: a */
    private void m6414a(View view) {
        ((ImageView) m6444f().findViewById(R.id.btn_close_popup)).setOnClickListener(new ViewOnClickListenerC1852al(this));
        this.f6790g = new ImageView[4];
        this.f6790g[0] = (ImageView) m6444f().findViewById(R.id.btn_pen_style1);
        this.f6790g[1] = (ImageView) m6444f().findViewById(R.id.btn_pen_style2);
        this.f6790g[3] = (ImageView) m6444f().findViewById(R.id.btn_pen_style3);
        this.f6790g[2] = (ImageView) m6444f().findViewById(R.id.btn_pen_style4);
        for (int i = 0; i < 4; i++) {
            this.f6790g[i].setOnClickListener(this.f6800q);
        }
        m6413a(this.f6789f, true);
        this.f6793j = (ImageView) m6444f().findViewById(R.id.iv_pen_stroke_preview);
        this.f6792i = (SeekBar) m6444f().findViewById(R.id.seekbar_pen_size);
        this.f6792i.setMax(9);
        this.f6792i.setOnSeekBarChangeListener(new C1854an(this));
        m6418b(this.f6791h, true);
        this.f6799p = ((ViewStub) m6444f().findViewById(R.id.stub_pen_color)).inflate();
        this.f6795l = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f6795l[i2] = (ImageView) this.f6799p.findViewById(this.f6797n[i2]);
            this.f6795l[i2].setOnClickListener(this.f6801r);
        }
        this.f6796m = (ImageView) this.f6799p.findViewById(R.id.btn_color16);
        this.f6796m.setOnClickListener(this.f6802s);
        m6421c(m6426f(this.f6794k), true);
        m6419b(view);
    }

    /* renamed from: b */
    private void m6419b(View view) {
        view.post(new RunnableC1855ao(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6427i() {
        dismiss();
    }

    /* renamed from: a */
    private void m6413a(int i, boolean z) {
        if (i >= 0 && i < 4) {
            this.f6790g[i].setSelected(z);
        }
    }

    /* renamed from: a */
    public void m6429a(int i) {
        m6413a(this.f6789f, false);
        this.f6789f = i;
        m6413a(this.f6789f, true);
    }

    /* renamed from: a */
    public int m6428a() {
        return this.f6789f;
    }

    /* renamed from: b */
    private void m6418b(int i, boolean z) {
        this.f6792i.setProgress(m6424e(i));
        m6412a(i, this.f6794k);
    }

    /* renamed from: b */
    public void m6431b(int i) {
        m6418b(this.f6791h, false);
        this.f6791h = i;
        m6418b(this.f6791h, true);
    }

    /* renamed from: b */
    public int m6430b() {
        return this.f6791h;
    }

    /* renamed from: e */
    private int m6424e(int i) {
        int i2 = i - 1;
        if (i2 < 0 || i2 >= 10) {
            return 4;
        }
        return i2;
    }

    /* renamed from: a */
    private void m6412a(int i, int i2) {
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        int measuredWidth = this.f6793j.getMeasuredWidth();
        int measuredHeight = this.f6793j.getMeasuredHeight();
        if (this.f6814c != null) {
            this.f6814c.recycle();
            this.f6814c = null;
        }
        this.f6814c = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f6814c);
        canvas.drawCircle(measuredWidth * 0.5f, measuredHeight * 0.5f, measuredWidth * 0.048f * i, paint);
        paint.setColor(i2);
        canvas.drawCircle(measuredWidth * 0.5f, measuredHeight * 0.5f, ((measuredWidth * 0.048f) * i) - 2.0f, paint);
        this.f6793j.setImageBitmap(this.f6814c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6421c(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f6795l[i2].setSelected(false);
                }
                this.f6796m.setSelected(z);
                return;
            }
            this.f6795l[i].setSelected(z);
        }
    }

    /* renamed from: a */
    private void m6417a(boolean z) {
        for (int i = 0; i < 15; i++) {
            this.f6795l[i].setSelected(z);
        }
        this.f6796m.setSelected(z);
    }

    /* renamed from: c */
    public void m6433c(int i) {
        m6417a(false);
        this.f6794k = i;
        m6421c(m6426f(this.f6794k), true);
        m6412a(this.f6791h, this.f6794k);
    }

    /* renamed from: c */
    public int m6432c() {
        return this.f6794k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public int m6426f(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == m6443e().getResources().getColor(this.f6798o[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: d */
    public void m6435d(int i) {
        this.f6815d = new DialogC1891h(m6443e());
        this.f6815d.m6534a(i);
        m6434d();
        this.f6815d.show();
    }

    /* renamed from: d */
    public void m6434d() {
        this.f6815d.m6535a(new C1858ar(this));
    }
}
