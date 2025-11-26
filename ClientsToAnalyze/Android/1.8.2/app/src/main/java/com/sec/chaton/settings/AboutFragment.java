package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AboutFragment extends Fragment {

    /* renamed from: a */
    String f4443a;

    /* renamed from: b */
    String f4444b;

    /* renamed from: c */
    protected Boolean f4445c;

    /* renamed from: d */
    protected Boolean f4446d;

    /* renamed from: e */
    protected String f4447e;

    /* renamed from: f */
    public Handler f4448f = new HandlerC1275c(this);

    /* renamed from: g */
    private TextView f4449g;

    /* renamed from: h */
    private TextView f4450h;

    /* renamed from: i */
    private Button f4451i;

    /* renamed from: j */
    private Button f4452j;

    /* renamed from: k */
    private ProgressDialog f4453k;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f4443a = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f4443a = "";
        }
        this.f4444b = C1789u.m6075a().getString("UpdateTargetVersion", "");
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1786r.m6066e("onConfigurationChagne", getClass().getSimpleName());
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment(), "containter").commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_about, viewGroup, false);
        this.f4453k = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.setting_about_version_checking);
        this.f4449g = (TextView) viewInflate.findViewById(R.id.setting_current_version);
        this.f4450h = (TextView) viewInflate.findViewById(R.id.setting_upgrade_version);
        TextView textView = (TextView) viewInflate.findViewById(R.id.setting_sina_for_china);
        if (C1789u.m6075a().getString("country_letter", "").equals("CN") || ((C1721ad.m5883j() != null && C1721ad.m5883j().equals("461")) || (C1721ad.m5878e() != null && C1721ad.m5878e().equals("CN")))) {
            textView.setVisibility(0);
        }
        if (GlobalApplication.m3265f()) {
            this.f4449g.setTextColor(Color.parseColor("#787878"));
            this.f4450h.setTextColor(Color.parseColor("#787878"));
        } else {
            this.f4449g.setTextColor(-1);
            this.f4450h.setTextColor(-1);
        }
        this.f4449g.setText(getString(R.string.setting_about_current_ver) + " " + this.f4443a);
        this.f4450h.setText(getString(R.string.setting_about_latest_ver) + " " + (this.f4444b.length() > 0 ? this.f4444b : this.f4443a));
        this.f4450h.setVisibility(0);
        this.f4447e = C1789u.m6075a().getString("UpdateUrl", "");
        this.f4451i = (Button) viewInflate.findViewById(R.id.setting_about_btn1);
        if (this.f4447e != null && this.f4447e.length() > 0) {
            this.f4451i.setOnClickListener(new ViewOnClickListenerC1221a(this));
        } else {
            this.f4451i.setEnabled(false);
            if (GlobalApplication.m3265f()) {
                this.f4451i.setTextColor(R.color.dark_gray);
            }
        }
        this.f4452j = (Button) viewInflate.findViewById(R.id.setting_about_btn_license);
        this.f4452j.setOnClickListener(new ViewOnClickListenerC1248b(this));
        return viewInflate;
    }

    /* renamed from: a */
    public static boolean m4476a(Context context, boolean z) {
        Uri uri;
        String string = C1789u.m6075a().getString("UpdateUrl", "");
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(8192);
        if (z) {
            Iterator<ApplicationInfo> it = installedApplications.iterator();
            while (it.hasNext()) {
                if (it.next().packageName.equals("com.sec.android.app.samsungapps")) {
                    C1786r.m6061b("This device has apps maeket", "ActivityAbout");
                    return true;
                }
            }
        }
        String strReplace = string != null ? string.replace("com.sec.chaton", context.getPackageName()) : string;
        String strReplace2 = !"com.sec.chaton".equals(context.getPackageName()) ? "http://www.chaton.com/download.html?s=normal&r=global".replace("global", "canada") : "http://www.chaton.com/download.html?s=normal&r=global";
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            uri = Uri.parse(strReplace);
            intent.setData(uri);
            context.startActivity(intent);
            C1786r.m6061b("There is no apps market in the device", "ActivityAbout");
        } catch (ActivityNotFoundException e) {
            uri = Uri.parse(strReplace2);
            intent.setData(uri);
            context.startActivity(intent);
            C1786r.m6061b("There is no apps and google markget in the device", "ActivityAbout");
        }
        C1786r.m6066e("uri :" + uri, "ActivityAbout");
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f4453k.dismiss();
    }

    /* renamed from: a */
    protected void m4479a(int i) {
        switch (i) {
            case 1:
                new OpenSourceDialog().show(getFragmentManager(), "dialogOpensource");
                break;
        }
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
