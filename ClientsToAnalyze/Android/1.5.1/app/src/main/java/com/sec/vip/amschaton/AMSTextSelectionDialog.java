package com.sec.vip.amschaton;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class AMSTextSelectionDialog extends AMSToolSelectionDialog implements SeekBar.OnSeekBarChangeListener, InterfaceC0666bm {

    /* renamed from: f */
    private final int f4066f;

    /* renamed from: g */
    private int f4067g;

    /* renamed from: h */
    private int f4068h;

    /* renamed from: i */
    private int[] f4069i;

    /* renamed from: j */
    private ColorPickerView f4070j;

    /* renamed from: k */
    private LinearLayout f4071k;

    /* renamed from: l */
    private TextView[] f4072l;

    /* renamed from: m */
    private View f4073m;

    /* renamed from: n */
    private LinearLayout f4074n;

    /* renamed from: o */
    private ImageView f4075o;

    /* renamed from: p */
    private ImageView[] f4076p;

    /* renamed from: q */
    private int[] f4077q;

    /* renamed from: r */
    private int[] f4078r;

    /* renamed from: s */
    private View.OnClickListener f4079s;

    /* renamed from: t */
    private View.OnClickListener f4080t;

    public AMSTextSelectionDialog(Context context, int i) {
        super(context, i);
        this.f4066f = 99;
        this.f4067g = -1;
        this.f4068h = 0;
        this.f4069i = new int[]{10, 12, 13, 15, 17};
        this.f4070j = null;
        this.f4075o = null;
        this.f4076p = null;
        this.f4077q = new int[]{C0062R.id.default_color_01, C0062R.id.default_color_02, C0062R.id.default_color_03, C0062R.id.default_color_04, C0062R.id.default_color_05, C0062R.id.default_color_06, C0062R.id.default_color_07, C0062R.id.default_color_08, C0062R.id.default_color_09, C0062R.id.default_color_10, C0062R.id.default_color_11, C0062R.id.default_color_12, C0062R.id.default_color_13, C0062R.id.default_color_14, C0062R.id.default_color_15};
        this.f4078r = new int[]{C0062R.color.ams_tool_default_color_01, C0062R.color.ams_tool_default_color_02, C0062R.color.ams_tool_default_color_03, C0062R.color.ams_tool_default_color_04, C0062R.color.ams_tool_default_color_05, C0062R.color.ams_tool_default_color_06, C0062R.color.ams_tool_default_color_07, C0062R.color.ams_tool_default_color_08, C0062R.color.ams_tool_default_color_09, C0062R.color.ams_tool_default_color_10, C0062R.color.ams_tool_default_color_11, C0062R.color.ams_tool_default_color_12, C0062R.color.ams_tool_default_color_13, C0062R.color.ams_tool_default_color_14, C0062R.color.ams_tool_default_color_15};
        this.f4079s = new ViewOnClickListenerC0643aq(this);
        this.f4080t = new ViewOnClickListenerC0644ar(this);
        setContentView(C0062R.layout.ams_text_input_layout);
        m4096c();
        this.f4076p = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f4076p[i2] = (ImageView) this.f4073m.findViewById(this.f4077q[i2]);
            this.f4076p[i2].setOnClickListener(this.f4079s);
        }
        m4091a(m4097d(this.f4067g), true);
        this.f4070j.setColor(this.f4067g);
        this.f4075o = (ImageView) findViewById(C0062R.id.btn_default_color);
        this.f4075o.setVisibility(4);
        this.f4075o.setOnClickListener(new ViewOnClickListenerC0642ap(this));
        this.f4072l = new TextView[5];
        this.f4072l[0] = (TextView) findViewById(C0062R.id.btn_text_size1);
        this.f4072l[1] = (TextView) findViewById(C0062R.id.btn_text_size2);
        this.f4072l[2] = (TextView) findViewById(C0062R.id.btn_text_size3);
        this.f4072l[3] = (TextView) findViewById(C0062R.id.btn_text_size4);
        this.f4072l[4] = (TextView) findViewById(C0062R.id.btn_text_size5);
        for (int i3 = 0; i3 < 5; i3++) {
            this.f4072l[i3].setOnClickListener(this.f4080t);
        }
        m4094b(this.f4068h, true);
        ((Button) findViewById(C0062R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(C0062R.id.btn_cancel)).setOnClickListener(this);
        m4098d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4091a(int i, boolean z) {
        this.f4076p[i].setSelected(z);
    }

    /* renamed from: b */
    private void m4094b(int i, boolean z) {
        this.f4072l[i].setSelected(z);
    }

    /* renamed from: c */
    private void m4096c() {
        this.f4070j = new ColorPickerView(getContext(), this.f4081a, this.f4084d, -1);
        this.f4070j.setColorChangedListener(this);
        this.f4071k = new LinearLayout(getContext());
        this.f4071k.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f4084d));
        this.f4071k.addView(this.f4070j);
        this.f4074n = (LinearLayout) findViewById(C0062R.id.layout_color_selector);
        this.f4074n.addView(this.f4071k);
        this.f4074n.setVisibility(8);
        this.f4073m = ((ViewStub) findViewById(C0062R.id.stub_default_color)).inflate();
        this.f4073m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m4097d(int i) {
        for (int i2 = 0; i2 < 14; i2++) {
            if (i == getContext().getResources().getColor(this.f4078r[i2])) {
                return i2;
            }
        }
        return 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4098d() {
        for (int i = 0; i < 5; i++) {
            this.f4072l[i].setTextColor(this.f4067g);
            this.f4072l[i].setTextSize(this.f4069i[i] * this.f4083c * 2.0f);
            this.f4072l[i].setText("Aa");
        }
    }

    /* renamed from: a */
    public int m4104a() {
        return this.f4067g;
    }

    /* renamed from: a */
    public void m4105a(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            m4091a(i2, false);
        }
        this.f4067g = i;
        this.f4070j.setColor(this.f4067g);
        m4091a(m4097d(this.f4067g), true);
        m4098d();
    }

    /* renamed from: b */
    public int m4106b() {
        return this.f4068h;
    }

    /* renamed from: b */
    public void m4107b(int i) {
        m4094b(this.f4068h, false);
        this.f4068h = i;
        m4094b(this.f4068h, true);
    }

    @Override // com.sec.vip.amschaton.InterfaceC0666bm
    /* renamed from: c */
    public boolean mo3895c(int i) {
        this.f4067g = i;
        m4098d();
        return false;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f4068h = (i * 5) / 99;
        if (this.f4068h >= 5) {
            this.f4068h = 4;
        }
        m4098d();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
