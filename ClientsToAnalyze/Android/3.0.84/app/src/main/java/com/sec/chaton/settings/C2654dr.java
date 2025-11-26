package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p035io.entry.inner.MappingInfoEntry;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.dr */
/* loaded from: classes.dex */
public class C2654dr extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentMultiDeviceView f9914a;

    /* renamed from: b */
    private LayoutInflater f9915b;

    /* renamed from: c */
    private TextView f9916c;

    /* renamed from: d */
    private TextView f9917d;

    /* renamed from: e */
    private Button[] f9918e;

    public C2654dr(FragmentMultiDeviceView fragmentMultiDeviceView) {
        this.f9914a = fragmentMultiDeviceView;
        this.f9915b = LayoutInflater.from(fragmentMultiDeviceView.f9153d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9914a.f9158i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f9914a.f9158i.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f9915b.inflate(R.layout.list_item_common_4, viewGroup, false);
        }
        this.f9918e = new Button[getCount()];
        this.f9916c = (TextView) view.findViewById(R.id.text1);
        this.f9917d = (TextView) view.findViewById(R.id.text2);
        this.f9918e[i] = (Button) view.findViewById(R.id.button1);
        this.f9918e[i].setVisibility(0);
        this.f9918e[i].setText(R.string.connected_device_deregister);
        if (this.f9914a.f9158i != null && this.f9914a.f9158i.size() > 0) {
            String str = ((MappingInfoEntry) this.f9914a.f9158i.get(i)).model;
            boolean zBooleanValue = ((MappingInfoEntry) this.f9914a.f9158i.get(i)).isAsker != null ? ((MappingInfoEntry) this.f9914a.f9158i.get(i)).isAsker.booleanValue() : false;
            String str2 = ((MappingInfoEntry) this.f9914a.f9158i.get(i)).phoneNumber;
            this.f9916c.setText(str);
            if (str != null && str.contains("web")) {
                this.f9917d.setText(this.f9914a.f9160k);
                this.f9918e[i].setVisibility(8);
            } else if (!TextUtils.isEmpty(str2)) {
                if (!zBooleanValue) {
                    this.f9917d.setText(((MappingInfoEntry) this.f9914a.f9158i.get(i)).phoneNumber);
                } else {
                    this.f9917d.setSingleLine(false);
                    this.f9917d.setText(((MappingInfoEntry) this.f9914a.f9158i.get(i)).phoneNumber + "\n" + this.f9914a.getResources().getString(R.string.regist_setting_current_device));
                }
            } else if (zBooleanValue) {
                this.f9917d.setText(this.f9914a.getResources().getString(R.string.regist_setting_current_device));
            }
            if (TextUtils.isEmpty(this.f9917d.getText())) {
                this.f9917d.setVisibility(8);
                this.f9916c.setGravity(16);
            }
            this.f9918e[i].setOnClickListener(new ViewOnClickListenerC2655ds(this, ((MappingInfoEntry) this.f9914a.f9158i.get(i)).chatonid));
        }
        return view;
    }
}
