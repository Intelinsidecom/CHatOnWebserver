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
import com.sec.chaton.util.C1323bs;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentRingToneView extends Fragment {

    /* renamed from: a */
    private SharedPreferences f3505a = null;

    /* renamed from: b */
    private SharedPreferences.Editor f3506b = null;

    /* renamed from: c */
    private ArrayList f3507c;

    /* renamed from: d */
    private ListView f3508d;

    /* renamed from: e */
    private String[] f3509e;

    /* renamed from: f */
    private RingtoneManager f3510f;

    /* renamed from: g */
    private Ringtone f3511g;

    /* renamed from: h */
    private LayoutInflater f3512h;

    /* renamed from: i */
    private ViewGroup f3513i;

    /* renamed from: j */
    private View f3514j;

    /* renamed from: k */
    private String f3515k;

    /* renamed from: l */
    private String f3516l;

    /* renamed from: m */
    private ProgressDialog f3517m;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3505a = C1323bs.m4575a();
        this.f3506b = this.f3505a.edit();
        BaseActivity.m2043b(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3512h = layoutInflater;
        this.f3513i = viewGroup;
        new AsyncTaskC1074f(this).execute(new String[0]);
        return this.f3514j;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f3511g.isPlaying()) {
            this.f3511g.stop();
        }
        this.f3506b.putString("Ringtone", this.f3516l);
        this.f3506b.commit();
    }
}
