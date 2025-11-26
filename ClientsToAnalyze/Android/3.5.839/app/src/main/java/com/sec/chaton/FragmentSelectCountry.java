package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentSelectCountry extends Fragment {

    /* renamed from: c */
    private Map<CharSequence, CharSequence> f1946c;

    /* renamed from: d */
    private CharSequence[] f1947d;

    /* renamed from: e */
    private CharSequence[] f1948e;

    /* renamed from: f */
    private String f1949f;

    /* renamed from: h */
    private Context f1951h;

    /* renamed from: i */
    private String f1952i;

    /* renamed from: a */
    final int f1944a = 16;

    /* renamed from: b */
    final int f1945b = 0;

    /* renamed from: g */
    private ProgressDialog f1950g = null;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1951h = getActivity();
        C4904y.m18639b("onCreate..............", getClass().getSimpleName());
        this.f1950g = new ProgressDialogC4926s(getActivity());
        this.f1946c = new HashMap();
        this.f1947d = getResources().getTextArray(R.array.country);
        this.f1948e = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        for (int i = 0; i < this.f1947d.length; i++) {
            this.f1946c.put(this.f1948e[i], this.f1947d[i]);
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f1952i = intent.getExtras().getString("sns_type");
        }
        Intent intent2 = new Intent(getActivity(), (Class<?>) CountryActivity.class);
        intent2.putExtra("mode", 0);
        intent2.putExtra("sns_type", this.f1952i);
        intent2.setFlags(67108864);
        startActivityForResult(intent2, 16);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 16:
                if (i2 == -1 || i2 == 8) {
                    this.f1949f = intent.getExtras().getString("PARAMS_COUNTRY_NAME");
                    if (this.f1949f != null) {
                        if (getActivity() == null || !C4859bx.m18387a(this.f1949f, getActivity())) {
                            String strValueOf = String.valueOf(this.f1946c.get(this.f1949f));
                            C4809aa.m18108a("country_letter", this.f1949f);
                            C4809aa.m18108a("country_name", strValueOf);
                            C4904y.m18639b("mCountryLetter: " + this.f1949f + " selectedCountryName: " + strValueOf, getClass().getSimpleName());
                            if (i2 == 8) {
                                getActivity().setResult(i2);
                            } else {
                                getActivity().setResult(-1);
                            }
                        }
                    } else {
                        C4904y.m18639b("selectedCountryName is null", getClass().getSimpleName());
                    }
                    getActivity().finish();
                    break;
                } else if (i2 == 0) {
                    getActivity().setResult(0);
                    getActivity().finish();
                    break;
                } else if (i2 == 2) {
                    getActivity().setResult(2);
                    getActivity().finish();
                    break;
                } else {
                    getActivity().finish();
                    break;
                }
                break;
        }
    }
}
