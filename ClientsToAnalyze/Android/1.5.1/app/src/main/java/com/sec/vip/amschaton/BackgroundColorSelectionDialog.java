package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class BackgroundColorSelectionDialog extends Dialog implements View.OnClickListener, InterfaceC0666bm {

    /* renamed from: a */
    private int f4107a;

    /* renamed from: b */
    private int f4108b;

    /* renamed from: c */
    private int f4109c;

    /* renamed from: d */
    private ColorPickerView f4110d;

    /* renamed from: e */
    private LinearLayout f4111e;

    /* renamed from: f */
    private View f4112f;

    /* renamed from: g */
    private LinearLayout f4113g;

    /* renamed from: h */
    private ImageView[] f4114h;

    /* renamed from: i */
    private int[] f4115i;

    /* renamed from: j */
    private int[] f4116j;

    /* renamed from: k */
    private ImageView f4117k;

    /* renamed from: l */
    private OnApplyListener f4118l;

    /* renamed from: m */
    private View.OnClickListener f4119m;

    public BackgroundColorSelectionDialog(Context context, int i) {
        super(context, i);
        this.f4110d = null;
        this.f4114h = null;
        this.f4115i = new int[]{C0062R.id.default_color_01, C0062R.id.default_color_02, C0062R.id.default_color_03, C0062R.id.default_color_04, C0062R.id.default_color_05, C0062R.id.default_color_06, C0062R.id.default_color_07, C0062R.id.default_color_08, C0062R.id.default_color_09, C0062R.id.default_color_10, C0062R.id.default_color_11, C0062R.id.default_color_12, C0062R.id.default_color_13, C0062R.id.default_color_14, C0062R.id.default_color_15};
        this.f4116j = new int[]{C0062R.color.ams_tool_default_color_01, C0062R.color.ams_tool_default_color_02, C0062R.color.ams_tool_default_color_03, C0062R.color.ams_tool_default_color_04, C0062R.color.ams_tool_default_color_05, C0062R.color.ams_tool_default_color_06, C0062R.color.ams_tool_default_color_07, C0062R.color.ams_tool_default_color_08, C0062R.color.ams_tool_default_color_09, C0062R.color.ams_tool_default_color_10, C0062R.color.ams_tool_default_color_11, C0062R.color.ams_tool_default_color_12, C0062R.color.ams_tool_default_color_13, C0062R.color.ams_tool_default_color_14, C0062R.color.ams_tool_default_color_15};
        this.f4117k = null;
        this.f4118l = null;
        this.f4119m = new ViewOnClickListenerC0649aw(this);
        requestWindowFeature(1);
        setContentView(C0062R.layout.ams_bg_color_layout);
        m4136b();
        this.f4117k = (ImageView) findViewById(C0062R.id.btn_default_color);
        this.f4117k.setVisibility(4);
        this.f4117k.setOnClickListener(new ViewOnClickListenerC0650ax(this));
        this.f4114h = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f4114h[i2] = (ImageView) this.f4112f.findViewById(this.f4115i[i2]);
            this.f4114h[i2].setOnClickListener(this.f4119m);
        }
        m4132a(m4134b(this.f4107a), true);
        ((Button) findViewById(C0062R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(C0062R.id.btn_cancel)).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4132a(int i, boolean z) {
        this.f4114h[i].setSelected(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m4134b(int i) {
        for (int i2 = 0; i2 < 14; i2++) {
            if (i == getContext().getResources().getColor(this.f4116j[i2])) {
                return i2;
            }
        }
        return 14;
    }

    /* renamed from: b */
    private void m4136b() {
        this.f4108b = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        this.f4109c = getContext().getResources().getDimensionPixelOffset(C0062R.dimen.ams_color_picker_height);
        this.f4110d = new ColorPickerView(getContext(), this.f4108b, this.f4109c, this.f4107a);
        this.f4110d.setColorChangedListener(this);
        this.f4111e = new LinearLayout(getContext());
        this.f4111e.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f4109c));
        this.f4111e.addView(this.f4110d);
        this.f4113g = (LinearLayout) findViewById(C0062R.id.layout_color_selector);
        this.f4113g.addView(this.f4111e);
        this.f4113g.setVisibility(8);
        this.f4112f = ((ViewStub) findViewById(C0062R.id.stub_default_color)).inflate();
        this.f4112f.setVisibility(0);
    }

    /* renamed from: a */
    public int m4141a() {
        return this.f4107a;
    }

    /* renamed from: a */
    public void m4142a(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            m4132a(i2, false);
        }
        this.f4107a = i;
        if (this.f4110d != null) {
            this.f4110d.setColor(i);
        }
        m4132a(m4134b(this.f4107a), true);
    }

    /* renamed from: a */
    public void m4143a(OnApplyListener onApplyListener) {
        this.f4118l = onApplyListener;
    }

    @Override // com.sec.vip.amschaton.InterfaceC0666bm
    /* renamed from: c */
    public boolean mo3895c(int i) {
        this.f4107a = i;
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_ok /* 2131427351 */:
                if (this.f4118l != null) {
                    this.f4118l.mo4161b();
                }
                dismiss();
                break;
            case C0062R.id.btn_cancel /* 2131427352 */:
                if (this.f4118l != null) {
                    this.f4118l.mo4160a();
                }
                dismiss();
                break;
        }
    }
}
