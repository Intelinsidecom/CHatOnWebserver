package com.sec.chaton.multimedia.audio;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: AudioListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.a */
/* loaded from: classes.dex */
public class C0763a extends BaseAdapter {

    /* renamed from: e */
    private static final String f2654e = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: a */
    Context f2655a;

    /* renamed from: b */
    LayoutInflater f2656b;

    /* renamed from: c */
    List f2657c;

    /* renamed from: d */
    int f2658d;

    public C0763a(Context context, int i, List list) {
        this.f2655a = context;
        this.f2656b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2657c = list;
        this.f2658d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2657c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return (String) this.f2657c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2656b.inflate(this.f2658d, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.audio_name)).setText(getItem(i));
        return view;
    }
}
