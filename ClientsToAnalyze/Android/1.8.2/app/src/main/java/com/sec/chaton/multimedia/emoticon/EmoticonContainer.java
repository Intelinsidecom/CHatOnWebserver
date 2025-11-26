package com.sec.chaton.multimedia.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public class EmoticonContainer extends AbsEmoticonContainer {

    /* renamed from: e */
    private static final String f3351e = EmoticonContainer.class.getSimpleName();

    /* renamed from: f */
    private boolean f3352f;

    /* renamed from: g */
    private InterfaceC0960f f3353g;

    /* renamed from: a */
    public static final EmoticonContainer m3655a(int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        bundle.putBoolean("orderByRecentUsed", z);
        EmoticonContainer emoticonContainer = new EmoticonContainer();
        emoticonContainer.mo3654a();
        emoticonContainer.setArguments(bundle);
        return emoticonContainer;
    }

    /* renamed from: a */
    public void m3656a(InterfaceC0960f interfaceC0960f) {
        this.f3353g = interfaceC0960f;
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3352f = getArguments().getBoolean("orderByRecentUsed");
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbsEmoticonContainer
    /* renamed from: a */
    public ListAdapter mo3654a() {
        String[] strArr = new String[1];
        if (this.f3352f) {
            return new C0961g(this.f3345a, C0962h.m3819a());
        }
        return new C0959e(this.f3345a, C0962h.m3820b());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str) && this.f3353g != null) {
            this.f3353g.mo3667a(this, str);
        }
    }
}
