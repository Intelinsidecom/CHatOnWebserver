package com.sec.chaton.multimedia.emoticon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2301u;

/* loaded from: classes.dex */
public class EmoticonContainer extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private int f9989a;

    /* renamed from: b */
    private String f9990b;

    /* renamed from: c */
    private Activity f9991c;

    /* renamed from: d */
    private GridView f9992d;

    /* renamed from: e */
    private View f9993e;

    /* renamed from: f */
    private View f9994f;

    /* renamed from: g */
    private View f9995g;

    /* renamed from: h */
    private ListAdapter f9996h;

    /* renamed from: i */
    private ListAdapter f9997i;

    /* renamed from: j */
    private InterfaceC2794f f9998j;

    /* renamed from: k */
    private EnumC2301u f9999k = EnumC2301u.NORMAL;

    /* renamed from: a */
    public static final EmoticonContainer m11627a(int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        EmoticonContainer emoticonContainer = new EmoticonContainer();
        emoticonContainer.setArguments(bundle);
        return emoticonContainer;
    }

    /* renamed from: a */
    public void m11631a(InterfaceC2794f interfaceC2794f) {
        this.f9998j = interfaceC2794f;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9991c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9991c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9989a = getArguments().getInt("layoutResId");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f9990b = null;
        String string = bundle != null ? bundle.getString("currentTabId") : null;
        String str = TextUtils.isEmpty(string) ? "normal" : string;
        View viewInflate = layoutInflater.inflate(this.f9989a, viewGroup, false);
        this.f9992d = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f9992d.setOnItemClickListener(this);
        this.f9993e = viewInflate.findViewById(R.id.emoticonEmptyView);
        this.f9994f = viewInflate.findViewById(R.id.emoticonRecentTabIndicator);
        this.f9994f.setOnClickListener(this);
        this.f9995g = viewInflate.findViewById(R.id.emoticonNormalTabIndicator);
        this.f9995g.setOnClickListener(this);
        m11632a(str);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9996h = null;
        this.f9997i = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f9990b);
    }

    /* renamed from: a */
    private ListAdapter m11626a() {
        String[] strArr = new String[1];
        return new C2793e(this.f9991c, C2797i.m11707c());
    }

    /* renamed from: b */
    private ListAdapter m11628b() {
        return new C2795g(this.f9991c, C2797i.m11705a());
    }

    /* renamed from: c */
    private ListAdapter m11629c() {
        return new C2795g(this.f9991c, C2797i.m11706b());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str) && this.f9998j != null) {
            this.f9998j.mo11636a(this, str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f9995g)) {
            m11632a("normal");
        } else if (view.equals(this.f9994f)) {
            m11632a("recent");
        }
    }

    /* renamed from: a */
    public void m11632a(String str) {
        if (TextUtils.isEmpty(this.f9990b) || !this.f9990b.equals(str)) {
            if ("recent".equals(str)) {
                this.f9990b = "recent";
                this.f9994f.setSelected(true);
                this.f9995g.setSelected(false);
                if (this.f9996h == null) {
                    if (this.f9999k == EnumC2301u.LIVE) {
                        this.f9996h = m11629c();
                    } else {
                        this.f9996h = m11628b();
                    }
                }
                if (this.f9996h.isEmpty()) {
                    this.f9993e.setVisibility(0);
                    this.f9992d.setVisibility(8);
                } else {
                    this.f9993e.setVisibility(8);
                    this.f9992d.setVisibility(0);
                }
                this.f9992d.setAdapter(this.f9996h);
                return;
            }
            if ("normal".equals(str)) {
                this.f9990b = "normal";
                this.f9994f.setSelected(false);
                this.f9995g.setSelected(true);
                if (this.f9997i == null) {
                    this.f9997i = m11626a();
                }
                this.f9993e.setVisibility(8);
                this.f9992d.setVisibility(0);
                this.f9992d.setAdapter(this.f9997i);
            }
        }
    }

    /* renamed from: a */
    public void m11630a(EnumC2301u enumC2301u) {
        this.f9999k = enumC2301u;
    }
}
