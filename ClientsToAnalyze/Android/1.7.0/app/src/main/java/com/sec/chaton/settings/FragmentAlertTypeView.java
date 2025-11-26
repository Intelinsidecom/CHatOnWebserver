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
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentAlertTypeView extends Fragment {

    /* renamed from: a */
    private ListView f3477a;

    /* renamed from: b */
    private SharedPreferences f3478b = null;

    /* renamed from: c */
    private SharedPreferences.Editor f3479c = null;

    /* renamed from: d */
    private String[] f3480d;

    /* renamed from: e */
    private int f3481e;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("onCreate is called", getClass().getSimpleName());
        this.f3478b = C1323bs.m4575a();
        this.f3479c = this.f3478b.edit();
        this.f3480d = getActivity().getResources().getStringArray(R.array.settings_type_options_value);
        BaseActivity.m2043b(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_alert_type, viewGroup, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3480d[0]);
        arrayList.add(this.f3480d[1]);
        arrayList.add(this.f3480d[2]);
        arrayList.add(this.f3480d[3]);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_single_choice, arrayList);
        this.f3477a = (ListView) viewInflate.findViewById(R.id.list_alert_type);
        this.f3477a.setAdapter((ListAdapter) arrayAdapter);
        this.f3477a.setChoiceMode(1);
        String string = this.f3478b.getString("Set Type Text", this.f3480d[0]);
        if (string.equals(this.f3480d[0])) {
            this.f3477a.setItemChecked(0, true);
        } else if (string.equals(this.f3480d[1])) {
            this.f3477a.setItemChecked(1, true);
        } else if (string.equals(this.f3480d[2])) {
            this.f3477a.setItemChecked(2, true);
        } else if (string.equals(this.f3480d[3])) {
            this.f3477a.setItemChecked(3, true);
        }
        this.f3477a.setOnItemClickListener(new C1010ah(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1057ca.m3934a(this.f3478b.getString("Set Type Text", ""));
        String str = this.f3480d[this.f3481e];
        if (str.equals(this.f3480d[0])) {
            this.f3479c.putString("Set Type", "ALL");
            return;
        }
        if (str.equals(this.f3480d[1])) {
            this.f3479c.putString("Set Type", "MELODY");
        } else if (str.equals(this.f3480d[2])) {
            this.f3479c.putString("Set Type", "VIBRATION");
        } else if (str.equals(this.f3480d[3])) {
            this.f3479c.putString("Set Type", "OFF");
        }
    }
}
