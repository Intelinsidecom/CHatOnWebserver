package com.sec.chaton.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentAlertTypeView extends Fragment {

    /* renamed from: a */
    private ListView f4585a;

    /* renamed from: b */
    private SharedPreferences f4586b = null;

    /* renamed from: c */
    private SharedPreferences.Editor f4587c = null;

    /* renamed from: d */
    private String[] f4588d;

    /* renamed from: e */
    private int f4589e;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("onCreate is called", getClass().getSimpleName());
        this.f4586b = C1789u.m6075a();
        this.f4587c = this.f4586b.edit();
        this.f4588d = getActivity().getResources().getStringArray(R.array.settings_type_options_value);
        BaseActivity.m1829b(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_alert_type, viewGroup, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f4588d[0]);
        arrayList.add(this.f4588d[1]);
        arrayList.add(this.f4588d[2]);
        arrayList.add(this.f4588d[3]);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.simple_list_item_single_choice, arrayList);
        this.f4585a = (ListView) viewInflate.findViewById(R.id.list_alert_type);
        this.f4585a.setAdapter((ListAdapter) arrayAdapter);
        this.f4585a.setChoiceMode(1);
        String string = this.f4586b.getString("Set Type Text", this.f4588d[0]);
        if (string.equals(this.f4588d[0])) {
            this.f4585a.setItemChecked(0, true);
        } else if (string.equals(this.f4588d[1])) {
            this.f4585a.setItemChecked(1, true);
        } else if (string.equals(this.f4588d[2])) {
            this.f4585a.setItemChecked(2, true);
        } else if (string.equals(this.f4588d[3])) {
            this.f4585a.setItemChecked(3, true);
        }
        this.f4585a.setOnItemClickListener(new C1263bo(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        String str = this.f4588d[this.f4589e];
        if (str.equals(this.f4588d[0])) {
            this.f4587c.putString("Set Type", "ALL");
        } else if (str.equals(this.f4588d[1])) {
            this.f4587c.putString("Set Type", "MELODY");
        } else if (str.equals(this.f4588d[2])) {
            this.f4587c.putString("Set Type", "VIBRATION");
        } else if (str.equals(this.f4588d[3])) {
            this.f4587c.putString("Set Type", "OFF");
        }
        if (GlobalApplication.m3265f()) {
            this.f4587c.putString("Set Type Text", str);
            this.f4587c.commit();
        }
        SettingFragment.m4702a(this.f4586b.getString("Set Type Text", ""));
    }
}
