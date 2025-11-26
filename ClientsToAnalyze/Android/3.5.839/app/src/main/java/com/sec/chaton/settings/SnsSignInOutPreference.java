package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;

/* loaded from: classes.dex */
public class SnsSignInOutPreference extends Preference {

    /* renamed from: a */
    Context f12825a;

    /* renamed from: b */
    InterfaceC3650gc f12826b;

    /* renamed from: c */
    EnumC3651gd f12827c;

    public SnsSignInOutPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12827c = EnumC3651gd.SIGN_OUT;
        this.f12825a = context;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        Button button = (Button) view.findViewById(R.id.log_in);
        Button button2 = (Button) view.findViewById(R.id.log_out);
        if (C4822an.m18255w()) {
            button2.setText(R.string.account_disconnect);
        }
        button.setOnClickListener(new ViewOnClickListenerC3643fz(this));
        button2.setOnClickListener(new ViewOnClickListenerC3645ga(this));
        switch (m13675a()) {
            case SIGN_IN:
                button.setVisibility(8);
                button2.setVisibility(0);
                break;
            case SIGN_OUT:
                button.setVisibility(0);
                button2.setVisibility(8);
                break;
        }
        super.onBindView(view);
    }

    /* renamed from: a */
    public void m13677a(EnumC3651gd enumC3651gd) {
        if (this.f12827c != enumC3651gd) {
            this.f12827c = enumC3651gd;
            notifyChanged();
        }
    }

    /* renamed from: a */
    public EnumC3651gd m13675a() {
        return this.f12827c;
    }

    /* renamed from: a */
    public void m13676a(InterfaceC3650gc interfaceC3650gc) {
        if (interfaceC3650gc != null) {
            this.f12826b = interfaceC3650gc;
        }
    }
}
