package com.sec.chaton.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.widget.C3641ai;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentChatView2 extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: c */
    private Activity f9129c;

    /* renamed from: d */
    private EnumC2504dk f9130d;

    /* renamed from: e */
    private ListView f9131e;

    /* renamed from: f */
    private int f9132f = -1;

    /* renamed from: a */
    private Map<EnumC2504dk, String> f9127a = new HashMap();

    /* renamed from: b */
    private Map<EnumC2504dk, Float> f9128b = new HashMap();

    /* renamed from: a */
    private void m9098a() {
        Resources resources = this.f9129c.getResources();
        this.f9127a.put(EnumC2504dk.System, resources.getString(R.string.use_device_font_size));
        this.f9128b.put(EnumC2504dk.System, Float.valueOf(C3171am.m11053b(this.f9129c)));
        this.f9127a.put(EnumC2504dk.Tiny, resources.getString(R.string.chat_font_extra_small));
        this.f9128b.put(EnumC2504dk.Tiny, Float.valueOf(resources.getDimension(R.dimen.font_size_tiny)));
        this.f9127a.put(EnumC2504dk.Small, resources.getString(R.string.chat_font_small));
        this.f9128b.put(EnumC2504dk.Small, Float.valueOf(resources.getDimension(R.dimen.font_size_small)));
        this.f9127a.put(EnumC2504dk.Normal, resources.getString(R.string.chat_font_medium));
        this.f9128b.put(EnumC2504dk.Normal, Float.valueOf(resources.getDimension(R.dimen.font_size_normal)));
        this.f9127a.put(EnumC2504dk.Large, resources.getString(R.string.chat_font_large));
        this.f9128b.put(EnumC2504dk.Large, Float.valueOf(resources.getDimension(R.dimen.font_size_large)));
        this.f9127a.put(EnumC2504dk.Huge, resources.getString(R.string.chat_font_extra_large));
        this.f9128b.put(EnumC2504dk.Huge, Float.valueOf(resources.getDimension(R.dimen.font_size_huge)));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m9098a();
        this.f9130d = EnumC2504dk.m9259a(C3159aa.m10962a().m10979a("Default Font Size", EnumC2504dk.Normal.m9260a()));
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_chatview2, viewGroup, false);
        this.f9131e = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f9131e.setAdapter((ListAdapter) new C2506dm(this));
        this.f9131e.setItemChecked(this.f9130d.ordinal(), true);
        this.f9131e.setOnItemClickListener(this);
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9129c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            if (this.f9132f != -1) {
                this.f9130d = EnumC2504dk.m9258a(this.f9132f);
                C3159aa.m10962a().m10986b("Default Font Size", EnumC2504dk.m9258a(this.f9132f).m9260a());
            }
            C3641ai.m13210a(getActivity(), R.string.toast_save_media, 0).show();
        }
        ((InterfaceC2505dl) getActivity()).mo8951c();
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f9132f = i;
    }
}
