package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p065io.entry.inner.MappingInfoEntry;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.eo */
/* loaded from: classes.dex */
public class C3605eo extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentMultiDeviceView f13131a;

    /* renamed from: b */
    private LayoutInflater f13132b;

    /* renamed from: c */
    private TextView f13133c;

    /* renamed from: d */
    private TextView f13134d;

    /* renamed from: e */
    private Button[] f13135e;

    public C3605eo(FragmentMultiDeviceView fragmentMultiDeviceView) {
        this.f13131a = fragmentMultiDeviceView;
        this.f13132b = LayoutInflater.from(fragmentMultiDeviceView.f12707d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13131a.f12713j.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13131a.f12713j.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f13132b.inflate(R.layout.list_item_common_4, viewGroup, false) : view;
        this.f13135e = new Button[getCount()];
        this.f13133c = (TextView) viewInflate.findViewById(R.id.text1);
        this.f13134d = (TextView) viewInflate.findViewById(R.id.text2);
        this.f13135e[i] = (Button) viewInflate.findViewById(R.id.button1);
        if (this.f13131a.f12719p) {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        } else {
            this.f13135e[i].setVisibility(0);
        }
        this.f13135e[i].setText(R.string.connected_device_deregister);
        if (this.f13131a.f12713j != null && this.f13131a.f12713j.size() > 0) {
            String str = ((MappingInfoEntry) this.f13131a.f12713j.get(i)).model;
            boolean zBooleanValue = ((MappingInfoEntry) this.f13131a.f12713j.get(i)).isAsker != null ? ((MappingInfoEntry) this.f13131a.f12713j.get(i)).isAsker.booleanValue() : false;
            String str2 = ((MappingInfoEntry) this.f13131a.f12713j.get(i)).phoneNumber;
            this.f13133c.setText(str);
            if (str != null && str.contains("web")) {
                this.f13134d.setText(this.f13131a.f12715l);
                this.f13135e[i].setVisibility(8);
            } else if (!TextUtils.isEmpty(str2)) {
                if (!zBooleanValue) {
                    this.f13134d.setText(((MappingInfoEntry) this.f13131a.f12713j.get(i)).phoneNumber);
                } else {
                    this.f13134d.setSingleLine(false);
                    this.f13134d.setText(((MappingInfoEntry) this.f13131a.f12713j.get(i)).phoneNumber + "\n" + this.f13131a.getResources().getString(R.string.regist_setting_current_device));
                }
            } else if (zBooleanValue) {
                this.f13134d.setText(this.f13131a.getResources().getString(R.string.regist_setting_current_device));
            }
            if (TextUtils.isEmpty(this.f13134d.getText())) {
                this.f13134d.setVisibility(8);
                this.f13133c.setGravity(16);
            }
            String str3 = ((MappingInfoEntry) this.f13131a.f12713j.get(i)).chatonid;
            if (zBooleanValue) {
                this.f13135e[i].setOnClickListener(new ViewOnClickListenerC3606ep(this));
            } else {
                this.f13135e[i].setOnClickListener(new ViewOnClickListenerC3607eq(this, str3));
            }
        }
        return viewInflate;
    }
}
