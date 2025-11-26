package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class SelectCountry extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new RegisteFragment();
    }

    public class RegisteFragment extends Fragment {

        /* renamed from: c */
        private Map f281c;

        /* renamed from: d */
        private CharSequence[] f282d;

        /* renamed from: e */
        private CharSequence[] f283e;

        /* renamed from: f */
        private String f284f;

        /* renamed from: h */
        private Context f286h;

        /* renamed from: a */
        final int f279a = 16;

        /* renamed from: b */
        final int f280b = 0;

        /* renamed from: g */
        private ProgressDialog f285g = null;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f286h = getActivity();
            C1341p.m4658b("onCreate..............", getClass().getSimpleName());
            this.f285g = new ProgressDialogC1354a(getActivity());
            this.f281c = new HashMap();
            this.f282d = getResources().getTextArray(R.array.country);
            this.f283e = getResources().getTextArray(R.array.ISO_country_code_Letter2);
            for (int i = 0; i < this.f282d.length; i++) {
                this.f281c.put(this.f283e[i], this.f282d[i]);
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
                        this.f284f = intent.getExtras().getString("PARAMS_COUNTRY_NAME");
                        if (this.f284f != null) {
                            String strValueOf = String.valueOf(this.f281c.get(this.f284f));
                            C1323bs.m4579a("country_letter", this.f284f);
                            C1323bs.m4579a("country_name", strValueOf);
                            C1341p.m4658b("[ACS] mCountryLetter: " + this.f284f + " selectedCountryName: " + strValueOf, getClass().getSimpleName());
                            getActivity().setResult(-1);
                        } else {
                            C1341p.m4658b("selectedCountryName is null", getClass().getSimpleName());
                        }
                        getActivity().finish();
                        break;
                    } else if (i2 == 0) {
                        getActivity().setResult(0);
                        getActivity().finish();
                        break;
                    } else {
                        getActivity().finish();
                        break;
                    }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
