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
    protected Activity f6691a;

    /* renamed from: b */
    protected GridView f6692b;

    /* renamed from: c */
    protected View f6693c;

    /* renamed from: d */
    protected ListAdapter f6694d;

    /* renamed from: e */
    private int f6695e;

    /* renamed from: f */
    private DataSetObserver f6696f;

    /* renamed from: a */
    protected abstract ListAdapter m7430a();

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6691a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6691a = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6695e = getArguments().getInt("layoutResId");
        this.f6696f = new C1803a(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(this.f6695e, viewGroup, false);
        this.f6694d = m7430a();
        this.f6694d.registerDataSetObserver(this.f6696f);
        this.f6692b = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f6692b.setAdapter(this.f6694d);
        this.f6692b.setOnItemClickListener(this);
        this.f6693c = viewInflate.findViewById(R.id.emoticonEmptyView);
        if (this.f6694d.isEmpty()) {
            m7429c();
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f6694d.unregisterDataSetObserver(this.f6696f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7427b() {
        this.f6692b.setVisibility(0);
        this.f6693c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7429c() {
        this.f6692b.setVisibility(8);
        this.f6693c.setVisibility(0);
    }
}
