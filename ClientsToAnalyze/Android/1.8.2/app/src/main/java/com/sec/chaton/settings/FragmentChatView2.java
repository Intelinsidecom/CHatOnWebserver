package com.sec.chaton.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentChatView2 extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Map f4608a = new HashMap();

    /* renamed from: b */
    private Map f4609b = new HashMap();

    /* renamed from: c */
    private Activity f4610c;

    /* renamed from: d */
    private EnumC1267bs f4611d;

    /* renamed from: e */
    private ListView f4612e;

    /* renamed from: f */
    private Button f4613f;

    /* renamed from: a */
    private void m4593a() {
        Resources resources = this.f4610c.getResources();
        this.f4608a.put(EnumC1267bs.Tiny, resources.getString(R.string.chat_font_extra_small));
        this.f4609b.put(EnumC1267bs.Tiny, Float.valueOf(resources.getDimension(R.dimen.font_size_tiny)));
        this.f4608a.put(EnumC1267bs.Small, resources.getString(R.string.chat_font_small));
        this.f4609b.put(EnumC1267bs.Small, Float.valueOf(resources.getDimension(R.dimen.font_size_small)));
        this.f4608a.put(EnumC1267bs.Normal, resources.getString(R.string.chat_font_medium));
        this.f4609b.put(EnumC1267bs.Normal, Float.valueOf(resources.getDimension(R.dimen.font_size_normal)));
        this.f4608a.put(EnumC1267bs.Large, resources.getString(R.string.chat_font_large));
        this.f4609b.put(EnumC1267bs.Large, Float.valueOf(resources.getDimension(R.dimen.font_size_large)));
        this.f4608a.put(EnumC1267bs.Huge, resources.getString(R.string.chat_font_extra_large));
        this.f4609b.put(EnumC1267bs.Huge, Float.valueOf(resources.getDimension(R.dimen.font_size_huge)));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m4593a();
        this.f4611d = EnumC1267bs.m4744a(C1789u.m6075a().getString("Default Font Size", EnumC1267bs.Normal.m4745a()));
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_chatview2, viewGroup, false);
        this.f4613f = (Button) viewInflate.findViewById(R.id.font_size_cancel_button);
        this.f4613f.setOnClickListener(new ViewOnClickListenerC1266br(this));
        this.f4612e = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f4612e.setAdapter((ListAdapter) new C1268bt(this));
        this.f4612e.setItemChecked(this.f4611d.ordinal(), true);
        this.f4612e.setOnItemClickListener(this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f4610c = activity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1789u.m6075a().edit().putString("Default Font Size", EnumC1267bs.m4743a(i).m4745a()).commit();
        getActivity().finish();
    }
}
