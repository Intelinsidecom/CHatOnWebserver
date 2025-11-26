package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class PreferenceNotice extends Preference {

    /* renamed from: a */
    private boolean f4702a;

    /* renamed from: b */
    private ImageView f4703b;

    public PreferenceNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4702a = false;
        setWidgetLayoutResource(R.layout.preference_widget_notice);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        this.f4703b = (ImageView) view.findViewById(R.id.widget_notice);
        if (this.f4702a) {
            this.f4703b.setVisibility(0);
        } else {
            this.f4703b.setVisibility(4);
        }
    }
}
