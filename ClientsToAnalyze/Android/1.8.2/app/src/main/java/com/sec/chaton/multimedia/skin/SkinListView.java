package com.sec.chaton.multimedia.skin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.skin.entry.inner.SkinView;
import com.sec.chaton.multimedia.skin.p035a.C0995a;
import com.sec.chaton.multimedia.skin.p035a.p036a.C0996a;
import com.sec.chaton.multimedia.skin.p035a.p036a.C0997b;
import com.sec.chaton.multimedia.skin.p037b.C1002c;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.widget.C1805i;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.common.widget.AlertDialogC1839a;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;

/* loaded from: classes.dex */
public class SkinListView extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private static final String f3666a = SkinListView.class.getSimpleName();

    /* renamed from: b */
    private Activity f3667b;

    /* renamed from: c */
    private ProgressDialog f3668c;

    /* renamed from: d */
    private AlertDialogC1839a f3669d;

    /* renamed from: e */
    private AlertDialog f3670e;

    /* renamed from: f */
    private GridView f3671f;

    /* renamed from: g */
    private C1821b f3672g;

    /* renamed from: h */
    private C0995a f3673h;

    /* renamed from: i */
    private C0997b f3674i;

    /* renamed from: j */
    private C0996a f3675j;

    /* renamed from: k */
    private Cursor f3676k;

    /* renamed from: l */
    private C0994a f3677l;

    /* renamed from: m */
    private SkinView f3678m;

    /* renamed from: n */
    private String f3679n;

    /* renamed from: o */
    private String f3680o;

    /* renamed from: p */
    private File f3681p;

    /* renamed from: q */
    private File f3682q;

    /* renamed from: r */
    private Handler f3683r = new HandlerC1015m(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3667b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3667b = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3673h = new C0995a(this.f3667b, this.f3683r);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f3672g = new C1821b();
        View viewInflate = layoutInflater.inflate(R.layout.layout_theme_package_list, viewGroup, false);
        this.f3671f = (GridView) viewInflate.findViewById(R.id.theme_package_list);
        this.f3671f.setOnItemClickListener(this);
        m3905c();
        this.f3674i = this.f3673h.m3928a(C1003c.m3942b(), C1003c.m3942b());
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f3676k != null) {
            this.f3676k.close();
        }
        if (this.f3674i != null) {
            this.f3674i.m2710c();
        }
        if (this.f3672g != null) {
            this.f3672g.m6191a();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f3676k != null && this.f3676k.moveToPosition(i)) {
            String string = this.f3676k.getString(this.f3676k.getColumnIndex("skin_id"));
            int i2 = this.f3676k.getInt(this.f3676k.getColumnIndex("install"));
            String string2 = this.f3676k.getString(this.f3676k.getColumnIndex("bg_type"));
            if (i2 == 0) {
                m3900a(string, string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Cursor m3901b() {
        return this.f3667b.getContentResolver().query(C1002c.f3694a, null, C1828c.m6207a("skin_id", " >= ?"), new String[]{"0"}, C1828c.m6207a("install", ",", "special", " DESC,", "_id", " DESC"));
    }

    /* renamed from: c */
    private void m3905c() {
        if (this.f3668c == null) {
            this.f3668c = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_geo_loading);
            this.f3668c.setProgressStyle(0);
            this.f3668c.setMessage(getResources().getString(R.string.dialog_connecting_server));
            this.f3668c.setOnCancelListener(new DialogInterfaceOnCancelListenerC1016n(this));
        }
        if (!this.f3668c.isShowing()) {
            this.f3668c.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3907d() {
        if (this.f3668c != null && this.f3668c.isShowing()) {
            this.f3668c.dismiss();
        }
    }

    /* renamed from: e */
    private void m3909e() {
        if (this.f3669d == null) {
            this.f3669d = new AlertDialogC1839a(this.f3667b);
            this.f3669d.setTitle(getString(R.string.skin_bubble_download_list_title));
            this.f3669d.setMessage(getString(R.string.anicon_file_downloading));
            this.f3669d.m6241b(0);
            this.f3669d.m6240a(2);
            this.f3669d.setButton(getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1017o(this));
            this.f3669d.setOnCancelListener(new DialogInterfaceOnCancelListenerC1018p(this));
        }
        if (!this.f3669d.isShowing()) {
            this.f3669d.show();
            this.f3669d.m6242c(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3911f() {
        if (this.f3669d != null && this.f3669d.isShowing()) {
            this.f3669d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3913g() throws Resources.NotFoundException {
        m3915h();
        if (this.f3670e == null) {
            Resources resources = this.f3667b.getResources();
            String string = resources.getString(R.string.toast_error);
            String string2 = resources.getString(R.string.setting_selfsms_retry);
            String string3 = resources.getString(R.string.dialog_cancel);
            String string4 = resources.getString(R.string.anicon_file_download_fail);
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this.f3667b);
            alertDialogBuilderC2120a.setTitle(string);
            alertDialogBuilderC2120a.setMessage(string4);
            alertDialogBuilderC2120a.setPositiveButton(string2, new DialogInterfaceOnClickListenerC1019q(this));
            alertDialogBuilderC2120a.setNegativeButton(string3, (DialogInterface.OnClickListener) null);
            this.f3670e = alertDialogBuilderC2120a.create();
        }
        if (!this.f3670e.isShowing()) {
            this.f3670e.setMessage(this.f3667b.getString(m3889a(R.string.anicon_file_download_fail)));
            this.f3670e.show();
        }
    }

    /* renamed from: h */
    private void m3915h() {
        if (this.f3670e != null && this.f3670e.isShowing()) {
            this.f3670e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3900a(String str, String str2) {
        m3909e();
        this.f3669d.m6241b(1);
        this.f3679n = str;
        this.f3680o = str2;
        this.f3675j = this.f3673h.m3927a(str, C1003c.m3935a(), C1003c.m3935a(), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3917i() {
        if (this.f3675j == null || this.f3675j.m2711d()) {
            C1830a.m6211a().m6216a(this.f3683r, this.f3678m.settingviewzipurl);
            C1830a.m6211a().m6216a(this.f3683r, this.f3678m.chatviewzipurl);
        } else {
            this.f3675j.m2710c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m3889a(int i) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            return R.string.popup_no_network_connection;
        }
        return i;
    }
}
