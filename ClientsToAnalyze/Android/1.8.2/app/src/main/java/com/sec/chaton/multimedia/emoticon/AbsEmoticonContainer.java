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

    /* renamed from: e */
    private static final String f3344e = AbsEmoticonContainer.class.getSimpleName();

    /* renamed from: a */
    protected Activity f3345a;

    /* renamed from: b */
    protected GridView f3346b;

    /* renamed from: c */
    protected View f3347c;

    /* renamed from: d */
    protected ListAdapter f3348d;

    /* renamed from: f */
    private int f3349f;

    /* renamed from: g */
    private DataSetObserver f3350g;

    /* renamed from: a */
    protected abstract ListAdapter mo3654a();

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3345a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3345a = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3349f = getArguments().getInt("layoutResId");
        this.f3350g = new C0909a(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(this.f3349f, viewGroup, false);
        this.f3348d = mo3654a();
        this.f3348d.registerDataSetObserver(this.f3350g);
        this.f3346b = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f3346b.setAdapter(this.f3348d);
        this.f3346b.setOnItemClickListener(this);
        this.f3347c = viewInflate.findViewById(R.id.emoticonEmptyView);
        if (this.f3348d.isEmpty()) {
            m3653c();
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3348d.unregisterDataSetObserver(this.f3350g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3651b() {
        this.f3346b.setVisibility(0);
        this.f3347c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3653c() {
        this.f3346b.setVisibility(8);
        this.f3347c.setVisibility(0);
    }
}
