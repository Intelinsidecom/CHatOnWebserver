package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class FragmentSelectCountry extends Fragment {

    /* renamed from: c */
    private Map<CharSequence, CharSequence> f692c;

    /* renamed from: d */
    private CharSequence[] f693d;

    /* renamed from: e */
    private CharSequence[] f694e;

    /* renamed from: f */
    private String f695f;

    /* renamed from: h */
    private Context f697h;

    /* renamed from: a */
    final int f690a = 16;

    /* renamed from: b */
    final int f691b = 0;

    /* renamed from: g */
    private ProgressDialog f696g = null;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f697h = getActivity();
        C3250y.m11450b("onCreate..............", getClass().getSimpleName());
        this.f696g = new ProgressDialogC3265l(getActivity());
        this.f692c = new HashMap();
        this.f693d = getResources().getTextArray(R.array.country);
        this.f694e = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        for (int i = 0; i < this.f693d.length; i++) {
            this.f692c.put(this.f694e[i], this.f693d[i]);
        }
        Intent intent = new Intent(getActivity(), (Class<?>) CountryActivity.class);
        intent.putExtra(RtspHeaders.Values.MODE, 0);
        intent.setFlags(67108864);
        startActivityForResult(intent, 16);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 16:
                if (i2 == -1) {
                    this.f695f = intent.getExtras().getString("PARAMS_COUNTRY_NAME");
                    if (this.f695f != null) {
                        String strValueOf = String.valueOf(this.f692c.get(this.f695f));
                        C3159aa.m10966a("country_letter", this.f695f);
                        C3159aa.m10966a("country_name", strValueOf);
                        C3250y.m11450b("[ACS] mCountryLetter: " + this.f695f + " selectedCountryName: " + strValueOf, getClass().getSimpleName());
                        getActivity().setResult(-1);
                    } else {
                        C3250y.m11450b("selectedCountryName is null", getClass().getSimpleName());
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
        }
    }
}
