package com.sec.chaton.multimedia.emoticon.anicon;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer;
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.common.p056b.C1812a;
import com.sec.common.p056b.p059c.C1821b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AniconContainer extends AbsEmoticonContainer {

    /* renamed from: g */
    private C1821b f3384g;

    /* renamed from: h */
    private String f3385h;

    /* renamed from: i */
    private boolean f3386i;

    /* renamed from: j */
    private Cursor f3387j;

    /* renamed from: k */
    private InterfaceC0920c f3388k;

    /* renamed from: f */
    private static final String f3383f = AniconContainer.class.getSimpleName();

    /* renamed from: e */
    public static final String f3382e = String.valueOf(Integer.MIN_VALUE);

    /* renamed from: a */
    public static final AniconContainer m3674a(int i) {
        return m3675a(i, f3382e, false);
    }

    /* renamed from: a */
    public static final AniconContainer m3675a(int i, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        bundle.putBoolean("download", z);
        bundle.putString("packageId", str);
        AniconContainer aniconContainer = new AniconContainer();
        aniconContainer.setArguments(bundle);
        return aniconContainer;
    }

    /* renamed from: a */
    public void m3679a(InterfaceC0920c interfaceC0920c) {
        this.f3388k = interfaceC0920c;
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f3385h = arguments.getString("packageId");
        this.f3386i = arguments.getBoolean("download", false);
        this.f3384g = new C1821b(m3678d());
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f3387j != null && this.f3387j.isClosed()) {
            this.f3387j.close();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f3384g.m6191a();
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer
    /* renamed from: a */
    public ListAdapter mo3654a() {
        if (this.f3385h == f3382e) {
            this.f3387j = this.f3345a.getContentResolver().query(C0950e.f3514a.buildUpon().appendPath("recentused").build(), null, null, null, null);
            return new C0915a(this.f3345a, this.f3387j, 1, this.f3384g);
        }
        this.f3387j = this.f3345a.getContentResolver().query(C0950e.f3514a, null, "package_id=?", new String[]{this.f3385h}, "anicon_id");
        if (this.f3386i) {
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            map.put("_id", 0);
            map.put("anicon_id", Integer.MIN_VALUE);
            arrayList.add(map);
            this.f3387j = new C1812a(this.f3387j, arrayList, null);
        }
        return new C0915a(this.f3345a, this.f3387j, 1, this.f3384g);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(String.valueOf(Integer.MIN_VALUE))) {
                m3677c();
            } else if (this.f3388k != null) {
                this.f3388k.mo3668a(this, str);
            }
        }
    }

    /* renamed from: c */
    private void m3677c() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AniconPackageListView(), "container").commit();
        getActivity().findViewById(R.id.base_divider).setVisibility(0);
    }

    /* renamed from: d */
    private ExecutorService m3678d() {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC0919b(this));
    }
}
