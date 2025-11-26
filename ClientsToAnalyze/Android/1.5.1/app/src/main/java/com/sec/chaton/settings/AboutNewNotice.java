package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class AboutNewNotice extends Preference {

    /* renamed from: a */
    private boolean f2969a;

    /* renamed from: b */
    private ImageView f2970b;

    public AboutNewNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2969a = false;
        setWidgetLayoutResource(C0062R.layout.preference_widget_notice);
    }

    /* renamed from: a */
    public void m3119a(boolean z) {
        this.f2969a = z;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        this.f2970b = (ImageView) view.findViewById(C0062R.id.widget_notice);
        if (this.f2969a) {
            this.f2970b.setVisibility(0);
        } else {
            this.f2970b.setVisibility(4);
        }
    }
}
