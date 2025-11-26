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
import twitter4j.Query;

/* loaded from: classes.dex */
public class EmoticonContainer extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private int f6698a;

    /* renamed from: b */
    private String f6699b;

    /* renamed from: c */
    private Activity f6700c;

    /* renamed from: d */
    private GridView f6701d;

    /* renamed from: e */
    private View f6702e;

    /* renamed from: f */
    private View f6703f;

    /* renamed from: g */
    private View f6704g;

    /* renamed from: h */
    private ListAdapter f6705h;

    /* renamed from: i */
    private ListAdapter f6706i;

    /* renamed from: j */
    private InterfaceC1831f f6707j;

    /* renamed from: a */
    public static final EmoticonContainer m7432a(int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        EmoticonContainer emoticonContainer = new EmoticonContainer();
        emoticonContainer.setArguments(bundle);
        return emoticonContainer;
    }

    /* renamed from: a */
    public void m7434a(InterfaceC1831f interfaceC1831f) {
        this.f6707j = interfaceC1831f;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6700c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6700c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6698a = getArguments().getInt("layoutResId");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f6699b = null;
        String string = bundle != null ? bundle.getString("currentTabId") : null;
        String str = TextUtils.isEmpty(string) ? "normal" : string;
        View viewInflate = layoutInflater.inflate(this.f6698a, viewGroup, false);
        this.f6701d = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f6701d.setOnItemClickListener(this);
        this.f6702e = viewInflate.findViewById(R.id.emoticonEmptyView);
        this.f6703f = viewInflate.findViewById(R.id.emoticonRecentTabIndicator);
        this.f6703f.setOnClickListener(this);
        this.f6704g = viewInflate.findViewById(R.id.emoticonNormalTabIndicator);
        this.f6704g.setOnClickListener(this);
        m7435a(str);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f6705h = null;
        this.f6706i = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f6699b);
    }

    /* renamed from: a */
    private ListAdapter m7431a() {
        String[] strArr = new String[1];
        return new C1830e(this.f6700c, C1833h.m7506c());
    }

    /* renamed from: b */
    private ListAdapter m7433b() {
        return new C1832g(this.f6700c, C1833h.m7505b());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str) && this.f6707j != null) {
            this.f6707j.mo7440a(this, str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f6704g)) {
            m7435a("normal");
        } else if (view.equals(this.f6703f)) {
            m7435a(Query.RECENT);
        }
    }

    /* renamed from: a */
    public void m7435a(String str) {
        if (TextUtils.isEmpty(this.f6699b) || !this.f6699b.equals(str)) {
            if (Query.RECENT.equals(str)) {
                this.f6699b = Query.RECENT;
                this.f6703f.setSelected(true);
                this.f6704g.setSelected(false);
                if (this.f6705h == null) {
                    this.f6705h = m7433b();
                }
                if (this.f6705h.isEmpty()) {
                    this.f6702e.setVisibility(0);
                    this.f6701d.setVisibility(8);
                } else {
                    this.f6702e.setVisibility(8);
                    this.f6701d.setVisibility(0);
                }
                this.f6701d.setAdapter(this.f6705h);
                return;
            }
            if ("normal".equals(str)) {
                this.f6699b = "normal";
                this.f6703f.setSelected(false);
                this.f6704g.setSelected(true);
                if (this.f6706i == null) {
                    this.f6706i = m7431a();
                }
                this.f6702e.setVisibility(8);
                this.f6701d.setVisibility(0);
                this.f6701d.setAdapter(this.f6706i);
            }
        }
    }
}
