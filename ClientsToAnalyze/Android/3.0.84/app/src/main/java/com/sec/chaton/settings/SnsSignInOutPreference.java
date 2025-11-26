package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class SnsSignInOutPreference extends Preference {

    /* renamed from: a */
    Context f9250a;

    /* renamed from: b */
    InterfaceC2694fd f9251b;

    /* renamed from: c */
    EnumC2693fc f9252c;

    public SnsSignInOutPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9252c = EnumC2693fc.SIGN_OUT;
        this.f9250a = context;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        Button button = (Button) view.findViewById(R.id.log_in);
        Button button2 = (Button) view.findViewById(R.id.log_out);
        button.setOnClickListener(new ViewOnClickListenerC2689ez(this));
        button2.setOnClickListener(new ViewOnClickListenerC2691fa(this));
        switch (m9188a()) {
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
    public void m9189a(EnumC2693fc enumC2693fc) {
        if (this.f9252c != enumC2693fc) {
            this.f9252c = enumC2693fc;
            notifyChanged();
        }
    }

    /* renamed from: a */
    public EnumC2693fc m9188a() {
        return this.f9252c;
    }
}
