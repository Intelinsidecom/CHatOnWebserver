package com.sec.chaton.multimedia.emoticon;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public abstract class AbsEmoticonContainer extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    protected Activity f9983a;

    /* renamed from: b */
    protected GridView f9984b;

    /* renamed from: c */
    protected View f9985c;

    /* renamed from: d */
    protected ListAdapter f9986d;

    /* renamed from: e */
    private int f9987e;

    /* renamed from: f */
    private DataSetObserver f9988f;

    /* renamed from: a */
    protected abstract ListAdapter m11625a();

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9983a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9983a = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9987e = getArguments().getInt("layoutResId");
        this.f9988f = new C2767a(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(this.f9987e, viewGroup, false);
        this.f9986d = m11625a();
        this.f9986d.registerDataSetObserver(this.f9988f);
        this.f9984b = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f9984b.setAdapter(this.f9986d);
        this.f9984b.setOnItemClickListener(this);
        this.f9985c = viewInflate.findViewById(R.id.emoticonEmptyView);
        if (this.f9986d.isEmpty()) {
            m11624c();
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9986d.unregisterDataSetObserver(this.f9988f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11622b() {
        this.f9984b.setVisibility(0);
        this.f9985c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11624c() {
        this.f9984b.setVisibility(8);
        this.f9985c.setVisibility(0);
    }
}
