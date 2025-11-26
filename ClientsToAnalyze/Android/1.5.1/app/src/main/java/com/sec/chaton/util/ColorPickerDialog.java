package com.sec.chaton.util;

import android.app.Dialog;
import android.os.Bundle;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ColorSelector;
import com.sec.chaton.util.ColorSlider;

/* loaded from: classes.dex */
public class ColorPickerDialog extends Dialog {

    /* renamed from: a */
    private int f3639a;

    /* renamed from: b */
    private ColorSelector f3640b;

    /* renamed from: c */
    private ColorSlider f3641c;

    /* renamed from: d */
    private ColorSlider f3642d;

    /* renamed from: e */
    private ColorSelector.OnColorSelectedListener f3643e;

    /* renamed from: f */
    private ColorSelector.OnColorChangedListener f3644f;

    /* renamed from: g */
    private ColorSlider.OnSliderColorChangedListener f3645g;

    /* renamed from: h */
    private ColorSlider.OnSliderColorChangedListener f3646h;

    public interface OnColorSelectedListener {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_colorpickdlg);
        setTitle(getContext().getResources().getString(C0062R.string.select_color));
        this.f3640b = (ColorSelector) findViewById(C0062R.id.hue);
        this.f3642d = (ColorSlider) findViewById(C0062R.id.brightness);
        this.f3641c = (ColorSlider) findViewById(C0062R.id.satutation);
        this.f3640b.setColorPickerChangedListener(this.f3644f);
        this.f3640b.setColorPickerSelectedListener(this.f3643e);
        this.f3640b.setInitialColor(this.f3639a);
        this.f3641c.setColors(-1, this.f3639a);
        this.f3642d.setColors(-16777216, this.f3641c.m3562b());
        this.f3641c.setSliderColorChangedListener(this.f3645g);
        this.f3642d.setSliderColorChangedListener(this.f3646h);
    }
}
