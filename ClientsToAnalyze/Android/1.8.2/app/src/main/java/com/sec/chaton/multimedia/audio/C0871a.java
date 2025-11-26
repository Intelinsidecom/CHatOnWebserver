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
public class C0871a extends BaseAdapter {

    /* renamed from: e */
    private static final String f3257e = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: a */
    Context f3258a;

    /* renamed from: b */
    LayoutInflater f3259b;

    /* renamed from: c */
    List f3260c;

    /* renamed from: d */
    int f3261d;

    public C0871a(Context context, int i, List list) {
        this.f3258a = context;
        this.f3259b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3260c = list;
        this.f3261d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3260c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return (String) this.f3260c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3259b.inflate(this.f3261d, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.audio_name)).setText(getItem(i));
        return view;
    }
}
