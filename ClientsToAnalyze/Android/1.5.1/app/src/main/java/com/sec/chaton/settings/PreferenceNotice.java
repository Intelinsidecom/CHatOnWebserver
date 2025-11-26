package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class PreferenceNotice extends Preference {

    /* renamed from: a */
    private boolean f3095a;

    /* renamed from: b */
    private ImageView f3096b;

    public PreferenceNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3095a = false;
        setWidgetLayoutResource(C0062R.layout.preference_widget_notice);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        this.f3096b = (ImageView) view.findViewById(C0062R.id.widget_notice);
        if (this.f3095a) {
            this.f3096b.setVisibility(0);
        } else {
            this.f3096b.setVisibility(4);
        }
    }
}
