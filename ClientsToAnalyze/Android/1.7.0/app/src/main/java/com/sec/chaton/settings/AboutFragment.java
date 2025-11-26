package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;

/* loaded from: classes.dex */
public class AboutFragment extends Fragment {

    /* renamed from: a */
    String f3404a;

    /* renamed from: b */
    String f3405b;

    /* renamed from: c */
    protected Boolean f3406c;

    /* renamed from: d */
    protected Boolean f3407d;

    /* renamed from: e */
    protected String f3408e;

    /* renamed from: f */
    public Handler f3409f = new HandlerC1009ag(this);

    /* renamed from: g */
    private TextView f3410g;

    /* renamed from: h */
    private TextView f3411h;

    /* renamed from: i */
    private Button f3412i;

    /* renamed from: j */
    private Button f3413j;

    /* renamed from: k */
    private ProgressDialog f3414k;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f3404a = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f3404a = "";
        }
        this.f3405b = C1323bs.m4575a().getString("UpdateTargetVersion", "");
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1341p.m4662e("onConfigurationChagne", getClass().getSimpleName());
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment(), "containter").commit();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_about, viewGroup, false);
        this.f3414k = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.setting_about_version_checking);
        this.f3410g = (TextView) viewInflate.findViewById(R.id.setting_current_version);
        this.f3411h = (TextView) viewInflate.findViewById(R.id.setting_upgrade_version);
        this.f3410g.setText(getString(R.string.setting_about_current_ver) + " " + this.f3404a);
        this.f3411h.setText(getString(R.string.setting_about_latest_ver) + " " + (this.f3405b.length() > 0 ? this.f3405b : this.f3404a));
        this.f3411h.setVisibility(0);
        this.f3408e = C1323bs.m4575a().getString("UpdateUrl", "");
        this.f3412i = (Button) viewInflate.findViewById(R.id.setting_about_btn1);
        if (this.f3408e != null && this.f3408e.length() > 0) {
            this.f3412i.setOnClickListener(new ViewOnClickListenerC1008af(this));
        } else {
            this.f3412i.setEnabled(false);
        }
        this.f3413j = (Button) viewInflate.findViewById(R.id.setting_about_btn_license);
        this.f3413j.setOnClickListener(new ViewOnClickListenerC1007ae(this));
        return viewInflate;
    }

    /* renamed from: a */
    public static void m3776a(Context context) {
        Uri uri;
        String string = C1323bs.m4575a().getString("UpdateUrl", "");
        String string2 = C1323bs.m4575a().getString("SamsungappsUrl", "");
        if (string != null) {
            string = string.replace("com.sec.chaton", context.getPackageName());
        }
        if (string2 != null) {
            string2 = string2.replace("com.sec.chaton", context.getPackageName());
        }
        String strReplace = "http://market.android.com/details?id=com.sec.chaton" != 0 ? "http://market.android.com/details?id=com.sec.chaton".replace("com.sec.chaton", context.getPackageName()) : "http://market.android.com/details?id=com.sec.chaton";
        Intent intent = new Intent("android.intent.action.VIEW");
        Intent intent2 = new Intent("android.intent.action.VIEW");
        Uri uri2 = Uri.parse(string2);
        intent.addFlags(335544352);
        intent.setData(uri2);
        try {
            context.startActivity(intent);
            C1341p.m4658b("apps market was installed in the device", "ActivityAbout");
            uri = uri2;
        } catch (ActivityNotFoundException e) {
            try {
                Uri uri3 = Uri.parse(string);
                intent2.setData(uri3);
                context.startActivity(intent2);
                C1341p.m4658b("There is no apps market in the device", "ActivityAbout");
                uri = uri3;
            } catch (ActivityNotFoundException e2) {
                uri = Uri.parse(strReplace);
                intent2.setData(uri);
                context.startActivity(intent2);
                C1341p.m4658b("There is no apps and google markget in the device", "ActivityAbout");
            }
        }
        C1341p.m4662e("uri :" + uri, "ActivityAbout");
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f3414k.dismiss();
    }

    public class OpenSourceDialog extends DialogFragment {
        /* JADX WARN: Removed duplicated region for block: B:63:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
        @Override // android.support.v4.app.DialogFragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.app.Dialog onCreateDialog(android.os.Bundle r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 220
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.AboutFragment.OpenSourceDialog.onCreateDialog(android.os.Bundle):android.app.Dialog");
        }
    }
}
