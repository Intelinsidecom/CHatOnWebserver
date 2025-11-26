package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentRingToneView extends Fragment {

    /* renamed from: c */
    private ArrayList f4632c;

    /* renamed from: d */
    private ListView f4633d;

    /* renamed from: e */
    private String[] f4634e;

    /* renamed from: f */
    private RingtoneManager f4635f;

    /* renamed from: g */
    private Ringtone f4636g;

    /* renamed from: h */
    private LayoutInflater f4637h;

    /* renamed from: i */
    private ViewGroup f4638i;

    /* renamed from: j */
    private View f4639j;

    /* renamed from: k */
    private String f4640k;

    /* renamed from: m */
    private ProgressDialog f4642m;

    /* renamed from: a */
    private SharedPreferences f4630a = null;

    /* renamed from: b */
    private SharedPreferences.Editor f4631b = null;

    /* renamed from: l */
    private String f4641l = null;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4630a = C1789u.m6075a();
        this.f4631b = this.f4630a.edit();
        BaseActivity.m1829b(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4637h = layoutInflater;
        this.f4638i = viewGroup;
        new AsyncTaskC1279cd(this).execute(new String[0]);
        return this.f4639j;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f4636g.isPlaying()) {
            this.f4636g.stop();
        }
        if (this.f4641l != null) {
            this.f4631b.putString("Ringtone", this.f4641l);
        }
        this.f4631b.commit();
    }
}
