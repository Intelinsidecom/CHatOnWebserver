package com.sec.chaton.multimedia.audio;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import java.util.List;

/* loaded from: classes.dex */
public class AudioListAdapter extends BaseAdapter {

    /* renamed from: e */
    private static final String f2026e = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: a */
    Context f2027a;

    /* renamed from: b */
    LayoutInflater f2028b;

    /* renamed from: c */
    List f2029c;

    /* renamed from: d */
    int f2030d;

    public AudioListAdapter(Context context, int i, List list) {
        this.f2027a = context;
        this.f2028b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2029c = list;
        this.f2030d = i;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return (String) this.f2029c.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2029c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f2028b.inflate(this.f2030d, viewGroup, false) : view;
        ((TextView) viewInflate.findViewById(C0062R.id.audio_name)).setText(getItem(i));
        return viewInflate;
    }
}
