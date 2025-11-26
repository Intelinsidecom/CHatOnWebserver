package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class AMSFigureSelectionDialog extends AMSToolSelectionDialog implements InterfaceC0666bm {

    /* renamed from: f */
    private int f3918f;

    /* renamed from: g */
    private int f3919g;

    /* renamed from: h */
    private int f3920h;

    /* renamed from: i */
    private ImageView[] f3921i;

    /* renamed from: j */
    private ImageView f3922j;

    /* renamed from: k */
    private ImageView f3923k;

    /* renamed from: l */
    private LinearLayout f3924l;

    /* renamed from: m */
    private LinearLayout f3925m;

    /* renamed from: n */
    private ColorPickerView f3926n;

    /* renamed from: o */
    private LinearLayout f3927o;

    /* renamed from: p */
    private View f3928p;

    /* renamed from: q */
    private SeekBar f3929q;

    /* renamed from: r */
    private View f3930r;

    /* renamed from: s */
    private LinearLayout f3931s;

    /* renamed from: t */
    private ImageView f3932t;

    /* renamed from: u */
    private ImageView[] f3933u;

    /* renamed from: v */
    private int[] f3934v;

    /* renamed from: w */
    private int[] f3935w;

    /* renamed from: x */
    private View.OnClickListener f3936x;

    /* renamed from: y */
    private View.OnClickListener f3937y;

    public AMSFigureSelectionDialog(Context context, int i) {
        super(context, i);
        this.f3918f = 0;
        this.f3919g = -1;
        this.f3920h = 0;
        this.f3926n = null;
        this.f3929q = null;
        this.f3932t = null;
        this.f3933u = null;
        this.f3934v = new int[]{C0062R.id.default_color_01, C0062R.id.default_color_02, C0062R.id.default_color_03, C0062R.id.default_color_04, C0062R.id.default_color_05, C0062R.id.default_color_06, C0062R.id.default_color_07, C0062R.id.default_color_08, C0062R.id.default_color_09, C0062R.id.default_color_10, C0062R.id.default_color_11, C0062R.id.default_color_12, C0062R.id.default_color_13, C0062R.id.default_color_14, C0062R.id.default_color_15};
        this.f3935w = new int[]{C0062R.color.ams_tool_default_color_01, C0062R.color.ams_tool_default_color_02, C0062R.color.ams_tool_default_color_03, C0062R.color.ams_tool_default_color_04, C0062R.color.ams_tool_default_color_05, C0062R.color.ams_tool_default_color_06, C0062R.color.ams_tool_default_color_07, C0062R.color.ams_tool_default_color_08, C0062R.color.ams_tool_default_color_09, C0062R.color.ams_tool_default_color_10, C0062R.color.ams_tool_default_color_11, C0062R.color.ams_tool_default_color_12, C0062R.color.ams_tool_default_color_13, C0062R.color.ams_tool_default_color_14, C0062R.color.ams_tool_default_color_15};
        this.f3936x = new ViewOnClickListenerC0627aa(this);
        this.f3937y = new ViewOnClickListenerC0722y(this);
        requestWindowFeature(1);
        setContentView(C0062R.layout.ams_figure_selection_layout);
        m3880d();
        this.f3926n.setColor(this.f3919g);
        this.f3921i = new ImageView[6];
        this.f3921i[4] = (ImageView) findViewById(C0062R.id.btn_tool_figure1);
        this.f3921i[3] = (ImageView) findViewById(C0062R.id.btn_tool_figure2);
        this.f3921i[5] = (ImageView) findViewById(C0062R.id.btn_tool_figure3);
        this.f3921i[1] = (ImageView) findViewById(C0062R.id.btn_tool_figure4);
        this.f3921i[0] = (ImageView) findViewById(C0062R.id.btn_tool_figure5);
        this.f3921i[2] = (ImageView) findViewById(C0062R.id.btn_tool_figure6);
        for (int i2 = 0; i2 < 6; i2++) {
            this.f3921i[i2].setOnClickListener(this.f3937y);
        }
        this.f3924l = (LinearLayout) findViewById(C0062R.id.layout_style1);
        this.f3925m = (LinearLayout) findViewById(C0062R.id.layout_style2);
        this.f3922j = (ImageView) findViewById(C0062R.id.btn_tool_figure_fill);
        this.f3923k = (ImageView) findViewById(C0062R.id.btn_tool_figure_line);
        this.f3922j.setOnClickListener(this);
        this.f3923k.setOnClickListener(this);
        m3875a(this.f3918f, true);
        this.f3933u = new ImageView[15];
        for (int i3 = 0; i3 < 15; i3++) {
            this.f3933u[i3] = (ImageView) this.f3930r.findViewById(this.f3934v[i3]);
            this.f3933u[i3].setOnClickListener(this.f3936x);
        }
        m3878b(m3888h(this.f3919g), true);
        this.f3932t = (ImageView) findViewById(C0062R.id.btn_default_color);
        this.f3932t.setVisibility(4);
        this.f3932t.setOnClickListener(new ViewOnClickListenerC0630ad(this));
        this.f3928p = ((ViewStub) findViewById(C0062R.id.stub_tool_size)).inflate();
        this.f3929q = (SeekBar) findViewById(C0062R.id.seekbar_line_size);
        this.f3929q.setOnSeekBarChangeListener(new C0628ab(this));
        m3884f(this.f3920h);
        ((Button) findViewById(C0062R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(C0062R.id.btn_cancel)).setOnClickListener(this);
    }

    /* renamed from: a */
    private void m3875a(int i, boolean z) {
        this.f3921i[i].setSelected(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3878b(int i, boolean z) {
        this.f3933u[i].setSelected(z);
    }

    /* renamed from: d */
    private void m3880d() {
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        this.f4081a = defaultDisplay.getWidth();
        this.f4082b = defaultDisplay.getHeight();
        float f = this.f4081a / 480.0f;
        float f2 = this.f4082b / 800.0f;
        if (f >= f2) {
            f = f2;
        }
        this.f4083c = f;
        this.f3926n = new ColorPickerView(getContext(), this.f4081a, this.f4084d, -1);
        this.f3926n.setColorChangedListener(this);
        this.f3927o = new LinearLayout(getContext());
        this.f3927o.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f4084d));
        this.f3927o.addView(this.f3926n);
        this.f3931s = (LinearLayout) findViewById(C0062R.id.layout_color_selector);
        this.f3931s.addView(this.f3927o);
        this.f3931s.setVisibility(8);
        this.f3930r = ((ViewStub) findViewById(C0062R.id.stub_default_color)).inflate();
        this.f3930r.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3883e() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (86.0f * this.f4083c), (int) (87.0f * this.f4083c), Bitmap.Config.ARGB_8888);
        AMSObjectDrawings aMSObjectDrawings = new AMSObjectDrawings(this.f3918f, this.f3919g, this.f3920h + 1);
        aMSObjectDrawings.mo3954a(this.f4083c * 2.0f);
        aMSObjectDrawings.m3957a(bitmapCreateBitmap);
        aMSObjectDrawings.mo3963a((float) (bitmapCreateBitmap.getWidth() * 0.2d), (float) (bitmapCreateBitmap.getHeight() * 0.2d), (float) (bitmapCreateBitmap.getWidth() * 0.8d), (float) (bitmapCreateBitmap.getHeight() * 0.8d), 255);
        ((ImageView) this.f3928p.findViewById(C0062R.id.image_line_preview)).setImageBitmap(bitmapCreateBitmap);
    }

    /* renamed from: f */
    private void m3884f(int i) {
        this.f3929q.setProgress(i);
    }

    /* renamed from: g */
    private void m3886g(int i) {
        if (i < 3) {
            this.f3924l.setVisibility(8);
            this.f3925m.setVisibility(0);
        } else {
            this.f3925m.setVisibility(8);
            this.f3924l.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public int m3888h(int i) {
        for (int i2 = 0; i2 < 14; i2++) {
            if (i == getContext().getResources().getColor(this.f3935w[i2])) {
                return i2;
            }
        }
        return 14;
    }

    /* renamed from: a */
    public int m3890a() {
        return this.f3918f;
    }

    /* renamed from: a */
    public void m3891a(int i) {
        m3897e(i);
        m3875a(this.f3918f, false);
        this.f3918f = i;
        m3875a(this.f3918f, true);
        m3883e();
        m3886g(this.f3918f);
    }

    /* renamed from: b */
    public int m3892b() {
        return this.f3919g;
    }

    /* renamed from: b */
    public void m3893b(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            m3878b(i2, false);
        }
        this.f3919g = i;
        this.f3926n.setColor(this.f3919g);
        m3878b(m3888h(this.f3919g), true);
        m3883e();
    }

    /* renamed from: c */
    public int m3894c() {
        return this.f3920h + 1;
    }

    @Override // com.sec.vip.amschaton.InterfaceC0666bm
    /* renamed from: c */
    public boolean mo3895c(int i) {
        this.f3919g = i;
        m3883e();
        return true;
    }

    /* renamed from: d */
    public void m3896d(int i) {
        int i2 = i < 1 ? 1 : i;
        if (i2 >= 10) {
            i2 = 10;
        }
        this.f3920h = i2 - 1;
        m3884f(this.f3920h);
        m3883e();
    }

    /* renamed from: e */
    public void m3897e(int i) {
        if (i < 3) {
            this.f3929q.setEnabled(true);
            this.f3929q.setOnTouchListener(new ViewOnTouchListenerC0629ac(this));
        } else {
            this.f3929q.setEnabled(false);
            this.f3929q.setOnTouchListener(new ViewOnTouchListenerC0723z(this));
        }
    }

    @Override // com.sec.vip.amschaton.AMSToolSelectionDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_tool_figure_fill /* 2131427416 */:
                m3886g(0);
                break;
            case C0062R.id.btn_tool_figure_line /* 2131427421 */:
                m3886g(3);
                break;
            default:
                super.onClick(view);
                break;
        }
    }
}
