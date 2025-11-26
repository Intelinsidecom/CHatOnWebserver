package com.sec.chaton.multimedia.vcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: ContactPicker.java */
/* renamed from: com.sec.chaton.multimedia.vcard.f */
/* loaded from: classes.dex */
class C1036f extends BaseAdapter {

    /* renamed from: a */
    Context f3839a;

    /* renamed from: b */
    ArrayList f3840b;

    /* renamed from: c */
    final /* synthetic */ ContactPicker f3841c;

    public C1036f(ContactPicker contactPicker, Context context, ArrayList arrayList) {
        this.f3841c = contactPicker;
        this.f3839a = context;
        this.f3840b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3840b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3840b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1035e c1035e = (C1035e) this.f3840b.get(i);
        if (c1035e.f3834b == 1) {
            if (view == null) {
                view = LayoutInflater.from(this.f3839a).inflate(R.layout.layout_contact_pick_header, (ViewGroup) null);
            }
        } else if (view == null) {
            view = LayoutInflater.from(this.f3839a).inflate(R.layout.layout_contact_pick_item, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.contactImage);
        ((TextView) view.findViewById(R.id.contactName)).setText(c1035e.f3835c);
        if (c1035e.f3836d != null && imageView != null) {
            imageView.setImageBitmap(c1035e.f3836d);
        } else if (imageView != null && c1035e.f3836d == null) {
            imageView.setImageResource(R.drawable.profile_noimage);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C1035e) this.f3840b.get(i)).f3834b == 2 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return ((C1035e) this.f3840b.get(i)).f3834b == 2;
    }
}
