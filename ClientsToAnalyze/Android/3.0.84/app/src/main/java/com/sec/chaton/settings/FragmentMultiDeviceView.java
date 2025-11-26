package com.sec.chaton.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p035io.entry.inner.MappingInfoEntry;
import com.sec.chaton.registration.ActivitySyncSignInPopup;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentMultiDeviceView extends Fragment {

    /* renamed from: c */
    private TextView f9152c;

    /* renamed from: d */
    private Context f9153d;

    /* renamed from: g */
    private C1345w f9156g;

    /* renamed from: h */
    private C1307at f9157h;

    /* renamed from: i */
    private ArrayList<MappingInfoEntry> f9158i;

    /* renamed from: l */
    private FragmentActivity f9161l;

    /* renamed from: m */
    private ListView f9162m;

    /* renamed from: n */
    private View f9163n;

    /* renamed from: b */
    private String f9151b = ActivityMultiDeviceView.class.getSimpleName();

    /* renamed from: e */
    private final int f9154e = 0;

    /* renamed from: f */
    private C2654dr f9155f = null;

    /* renamed from: j */
    private ProgressDialog f9159j = null;

    /* renamed from: k */
    private String f9160k = "";

    /* renamed from: a */
    Handler f9150a = new HandlerC2653dq(this, Looper.getMainLooper());

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_multidevice, viewGroup, false);
        C3250y.m11453c("[LIFE] onCreateView, isTaskRoot: " + this.f9161l.isTaskRoot() + ", Task ID: " + this.f9161l.getTaskId() + ", Memory Address:" + this, this.f9151b);
        ((TextView) viewInflate.findViewById(R.id.text1)).setText(getResources().getString(R.string.setting_samsung_account));
        this.f9152c = (TextView) viewInflate.findViewById(R.id.text2);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.layout_header);
        ((TextView) linearLayout.findViewById(R.id.text1)).setText(getResources().getString(R.string.account_connected_device));
        linearLayout.setClickable(false);
        this.f9162m = (ListView) viewInflate.findViewById(R.id.device_list);
        this.f9163n = layoutInflater.inflate(R.layout.layout_connected_device_comment, (ViewGroup) null);
        this.f9162m.addFooterView(this.f9163n);
        this.f9153d = this.f9161l;
        this.f9155f = new C2654dr(this);
        this.f9156g = new C1345w(this.f9150a);
        this.f9157h = new C1307at(this.f9150a);
        if (C3171am.m11080r()) {
            this.f9152c.setText(C3171am.m11079q());
            if (bundle == null) {
                this.f9159j = ProgressDialogC3265l.m11489a(this.f9153d, null, getResources().getString(R.string.dialog_provision_ing));
            }
            this.f9156g.m5942f("");
        } else {
            Intent intent = new Intent(this.f9153d, (Class<?>) ActivitySyncSignInPopup.class);
            intent.setFlags(67108864);
            intent.putExtra("isSyncContacts", true);
            startActivityForResult(intent, 0);
        }
        BaseActivity.m3081a(this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9161l = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9161l = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 != -1) {
                    C3250y.m11450b("mapping was FAILED", getClass().getSimpleName());
                    this.f9161l.finish();
                    break;
                } else {
                    this.f9152c.setText(C3171am.m11079q());
                    this.f9159j = ProgressDialogC3265l.m11489a(this.f9153d, null, getResources().getString(R.string.dialog_provision_ing));
                    this.f9156g.m5942f("");
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + this.f9161l.isTaskRoot() + ", Task ID: " + this.f9161l.getTaskId() + ", Memory Address:" + this, this.f9151b);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + this.f9161l.isTaskRoot() + ", Task ID: " + this.f9161l.getTaskId() + ", Memory Address:" + this, this.f9151b);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + this.f9161l.isTaskRoot() + ", Task ID: " + this.f9161l.getTaskId() + ", Memory Address:" + this, this.f9151b);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + this.f9161l.isTaskRoot() + ", Task ID: " + this.f9161l.getTaskId() + ", Memory Address:" + this, this.f9151b);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + this.f9161l.isTaskRoot() + ", Task ID: " + this.f9161l.getTaskId() + ", Memory Address:" + this, this.f9151b);
    }
}
