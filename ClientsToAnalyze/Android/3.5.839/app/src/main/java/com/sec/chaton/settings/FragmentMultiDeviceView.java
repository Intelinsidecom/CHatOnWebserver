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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.p065io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p065io.entry.inner.MappingInfoEntry;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentMultiDeviceView extends Fragment {

    /* renamed from: c */
    private TextView f12706c;

    /* renamed from: d */
    private Context f12707d;

    /* renamed from: h */
    private C2075ah f12711h;

    /* renamed from: i */
    private C2104bj f12712i;

    /* renamed from: j */
    private ArrayList<MappingInfoEntry> f12713j;

    /* renamed from: m */
    private FragmentActivity f12716m;

    /* renamed from: n */
    private ListView f12717n;

    /* renamed from: o */
    private View f12718o;

    /* renamed from: q */
    private LinearLayout f12720q;

    /* renamed from: b */
    private String f12705b = ActivityMultiDeviceView.class.getSimpleName();

    /* renamed from: e */
    private final int f12708e = 0;

    /* renamed from: f */
    private final int f12709f = 1;

    /* renamed from: g */
    private C3605eo f12710g = null;

    /* renamed from: k */
    private ProgressDialog f12714k = null;

    /* renamed from: l */
    private String f12715l = "";

    /* renamed from: p */
    private boolean f12719p = false;

    /* renamed from: r */
    private boolean f12721r = false;

    /* renamed from: s */
    private Button f12722s = null;

    /* renamed from: a */
    Handler f12704a = new HandlerC3604en(this, Looper.getMainLooper());

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_multidevice, viewGroup, false);
        C4904y.m18641c("[LIFE] onCreateView, isTaskRoot: " + this.f12716m.isTaskRoot() + ", Task ID: " + this.f12716m.getTaskId() + ", Memory Address:" + this, this.f12705b);
        ((TextView) viewInflate.findViewById(R.id.main_title)).setText(getResources().getString(R.string.setting_samsung_account));
        this.f12706c = (TextView) viewInflate.findViewById(R.id.sub_title);
        ((Button) viewInflate.findViewById(R.id.button)).setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.layout_header);
        ((TextView) linearLayout.findViewById(R.id.text1)).setText(getResources().getString(R.string.account_connected_device));
        linearLayout.setClickable(false);
        linearLayout.setFocusable(false);
        this.f12717n = (ListView) viewInflate.findViewById(R.id.device_list);
        this.f12720q = (LinearLayout) viewInflate.findViewById(R.id.layoutSA);
        this.f12707d = this.f12716m;
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getExtras() != null) {
            this.f12719p = getActivity().getIntent().getExtras().getBoolean("request_max_device");
            if (this.f12719p) {
                this.f12718o = layoutInflater.inflate(R.layout.layout_connected_device_comment, (ViewGroup) null);
                ((TextView) this.f12718o.findViewById(R.id.textVeiw)).setVisibility(8);
                this.f12722s = (Button) this.f12718o.findViewById(R.id.button);
                this.f12722s.setVisibility(0);
                this.f12717n.addFooterView(this.f12718o, null, false);
                this.f12720q.setVisibility(8);
            } else if (!C4822an.m18255w()) {
                Toast.makeText(this.f12707d, R.string.chatonv_install_dialog_title, 0).show();
                getActivity().finish();
                return viewInflate;
            }
        } else if (!C4822an.m18255w()) {
            Toast.makeText(this.f12707d, R.string.chatonv_install_dialog_title, 0).show();
            getActivity().finish();
            return viewInflate;
        }
        this.f12710g = new C3605eo(this);
        this.f12711h = new C2075ah(this.f12704a);
        this.f12712i = new C2104bj(this.f12704a);
        if (this.f12722s != null) {
            this.f12722s.setOnClickListener(new ViewOnClickListenerC3600ej(this));
        }
        if (C4822an.m18255w() || this.f12719p) {
            this.f12706c.setText(C4822an.m18254v());
            if (bundle == null) {
                this.f12714k = ProgressDialogC4926s.m18727a(this.f12707d, null, getResources().getString(R.string.dialog_provision_ing));
                this.f12714k.setCancelable(true);
                this.f12714k.setCanceledOnTouchOutside(false);
                this.f12714k.setOnCancelListener(new DialogInterfaceOnCancelListenerC3603em(this));
            }
            if (C4822an.m18255w()) {
                this.f12711h.m9320g("");
            } else {
                this.f12711h.m9319g();
            }
        }
        BaseActivity.m6160a((Fragment) this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12716m = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12716m = null;
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
        if (getActivity() != null) {
            switch (i) {
                case 0:
                    if (i2 != -1) {
                        C4904y.m18639b("mapping was FAILED", getClass().getSimpleName());
                        this.f12716m.finish();
                        break;
                    } else {
                        this.f12706c.setText(C4822an.m18254v());
                        this.f12714k = ProgressDialogC4926s.m18727a(this.f12707d, null, getResources().getString(R.string.dialog_provision_ing));
                        if (C4822an.m18255w()) {
                            this.f12711h.m9320g("");
                            break;
                        } else {
                            this.f12711h.m9319g();
                            break;
                        }
                    }
                case 1:
                    if (i2 == -1) {
                        this.f12706c.setText(C4822an.m18254v());
                        this.f12714k = ProgressDialogC4926s.m18727a(this.f12707d, null, getResources().getString(R.string.dialog_provision_ing));
                        if (C4822an.m18255w()) {
                            this.f12711h.m9320g("");
                            break;
                        } else {
                            this.f12711h.m9319g();
                            break;
                        }
                    }
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + this.f12716m.isTaskRoot() + ", Task ID: " + this.f12716m.getTaskId() + ", Memory Address:" + this, this.f12705b);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + this.f12716m.isTaskRoot() + ", Task ID: " + this.f12716m.getTaskId() + ", Memory Address:" + this, this.f12705b);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + this.f12716m.isTaskRoot() + ", Task ID: " + this.f12716m.getTaskId() + ", Memory Address:" + this, this.f12705b);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C4904y.m18641c("[LIFE] onStop, isTaskRoot: " + this.f12716m.isTaskRoot() + ", Task ID: " + this.f12716m.getTaskId() + ", Memory Address:" + this, this.f12705b);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f12714k != null && this.f12714k.isShowing()) {
            this.f12714k.dismiss();
        }
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + this.f12716m.isTaskRoot() + ", Task ID: " + this.f12716m.getTaskId() + ", Memory Address:" + this, this.f12705b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13576a(BuddyMappingInfo buddyMappingInfo) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < buddyMappingInfo.MappingInfo.size()) {
                String str = buddyMappingInfo.MappingInfo.get(i2).emailSamsung;
                if (TextUtils.isEmpty(str)) {
                    i = i2 + 1;
                } else {
                    this.f12706c.setText(str);
                    C4822an.m18215a(str);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13578a(ArrayList<MappingInfoEntry> arrayList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                String str = arrayList.get(i2).model;
                if (str == null || !str.contains("web")) {
                    i = i2 + 1;
                } else {
                    arrayList.remove(i2);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public boolean m13590a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("didDeletedDevice : " + this.f12721r, this.f12705b);
        }
        return this.f12721r;
    }
}
