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
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.widget.C5179v;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentChatView2 extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: c */
    private Activity f12681c;

    /* renamed from: d */
    private EnumC3594ed f12682d;

    /* renamed from: e */
    private ListView f12683e;

    /* renamed from: f */
    private int f12684f = -1;

    /* renamed from: a */
    private Map<EnumC3594ed, String> f12679a = new HashMap();

    /* renamed from: b */
    private Map<EnumC3594ed, Float> f12680b = new HashMap();

    /* renamed from: a */
    private void m13562a() {
        Resources resources = this.f12681c.getResources();
        this.f12679a.put(EnumC3594ed.System, resources.getString(R.string.use_device_font_size));
        this.f12680b.put(EnumC3594ed.System, Float.valueOf(C4822an.m18220b(this.f12681c)));
        this.f12679a.put(EnumC3594ed.Tiny, resources.getString(R.string.chat_font_extra_small));
        this.f12680b.put(EnumC3594ed.Tiny, Float.valueOf(resources.getDimension(R.dimen.font_size_tiny)));
        this.f12679a.put(EnumC3594ed.Small, resources.getString(R.string.chat_font_small));
        this.f12680b.put(EnumC3594ed.Small, Float.valueOf(resources.getDimension(R.dimen.font_size_small)));
        this.f12679a.put(EnumC3594ed.Normal, resources.getString(R.string.chat_font_medium));
        this.f12680b.put(EnumC3594ed.Normal, Float.valueOf(resources.getDimension(R.dimen.font_size_normal)));
        this.f12679a.put(EnumC3594ed.Large, resources.getString(R.string.chat_font_large));
        this.f12680b.put(EnumC3594ed.Large, Float.valueOf(resources.getDimension(R.dimen.font_size_large)));
        this.f12679a.put(EnumC3594ed.Huge, resources.getString(R.string.chat_font_extra_large));
        this.f12680b.put(EnumC3594ed.Huge, Float.valueOf(resources.getDimension(R.dimen.font_size_huge)));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m13562a();
        this.f12682d = EnumC3594ed.m13899a(C4809aa.m18104a().m18121a("Default Font Size", EnumC3594ed.Normal.m13900a()));
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_chatview2, viewGroup, false);
        this.f12683e = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f12683e.setAdapter((ListAdapter) new C3596ef(this));
        this.f12683e.setItemChecked(this.f12682d.ordinal(), true);
        this.f12683e.setOnItemClickListener(this);
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12681c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            if (this.f12684f != -1) {
                this.f12682d = EnumC3594ed.m13898a(this.f12684f);
                C4809aa.m18104a().m18128b("Default Font Size", EnumC3594ed.m13898a(this.f12684f).m13900a());
            }
            C5179v.m19810a(getActivity(), R.string.toast_save_media, 0).show();
        }
        ((InterfaceC3595ee) getActivity()).mo13381h();
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((CheckBox) ((ViewGroup) view).findViewById(android.R.id.checkbox)).sendAccessibilityEvent(1);
        this.f12684f = i;
    }
}
