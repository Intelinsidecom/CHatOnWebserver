package com.sec.chaton.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentChatView2 extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Map f3493a = new HashMap();

    /* renamed from: b */
    private Map f3494b = new HashMap();

    /* renamed from: c */
    private Activity f3495c;

    /* renamed from: d */
    private EnumC1094z f3496d;

    /* renamed from: e */
    private ListView f3497e;

    /* renamed from: a */
    private void m3829a() {
        Resources resources = this.f3495c.getResources();
        this.f3493a.put(EnumC1094z.Tiny, resources.getString(R.string.chat_font_extra_small));
        this.f3494b.put(EnumC1094z.Tiny, Float.valueOf(resources.getDimension(R.dimen.font_size_tiny)));
        this.f3493a.put(EnumC1094z.Small, resources.getString(R.string.chat_font_small));
        this.f3494b.put(EnumC1094z.Small, Float.valueOf(resources.getDimension(R.dimen.font_size_small)));
        this.f3493a.put(EnumC1094z.Normal, resources.getString(R.string.chat_font_medium));
        this.f3494b.put(EnumC1094z.Normal, Float.valueOf(resources.getDimension(R.dimen.font_size_normal)));
        this.f3493a.put(EnumC1094z.Large, resources.getString(R.string.chat_font_large));
        this.f3494b.put(EnumC1094z.Large, Float.valueOf(resources.getDimension(R.dimen.font_size_large)));
        this.f3493a.put(EnumC1094z.Huge, resources.getString(R.string.chat_font_extra_large));
        this.f3494b.put(EnumC1094z.Huge, Float.valueOf(resources.getDimension(R.dimen.font_size_huge)));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m3829a();
        this.f3496d = EnumC1094z.m3956a(C1323bs.m4575a().getString("Default Font Size", EnumC1094z.Normal.m3957a()));
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_chatview2, viewGroup, false);
        this.f3497e = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f3497e.setAdapter((ListAdapter) new C1002a(this));
        this.f3497e.setItemChecked(this.f3496d.ordinal(), true);
        this.f3497e.setOnItemClickListener(this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3495c = activity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1323bs.m4575a().edit().putString("Default Font Size", EnumC1094z.m3955a(i).m3957a()).commit();
    }
}
