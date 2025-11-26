package com.sec.chaton.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: PostONHideAdapter.java */
/* renamed from: com.sec.chaton.settings.fi */
/* loaded from: classes.dex */
public class C3626fi extends ArrayAdapter<String> {

    /* renamed from: a */
    ArrayList<String> f13173a;

    /* renamed from: b */
    InterfaceC3629fl f13174b;

    /* renamed from: c */
    private Context f13175c;

    /* renamed from: d */
    private String f13176d;

    /* renamed from: e */
    private String f13177e;

    /* renamed from: f */
    private LayoutInflater f13178f;

    /* renamed from: a */
    public void m13909a(InterfaceC3629fl interfaceC3629fl) {
        this.f13174b = interfaceC3629fl;
    }

    public C3626fi(Context context, ArrayList<String> arrayList) {
        super(context, 0);
        this.f13175c = context;
        this.f13173a = arrayList;
        this.f13178f = (LayoutInflater) this.f13175c.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3628fk c3628fk;
        if (view == null) {
            view = this.f13178f.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c3628fk = new C3628fk();
            c3628fk.f13181a = (TextView) view.findViewById(R.id.text1);
            c3628fk.f13182b = (ImageView) view.findViewById(R.id.image1);
            c3628fk.f13183c = (Button) view.findViewById(R.id.button1);
            view.setTag(c3628fk);
        } else {
            c3628fk = (C3628fk) view.getTag();
        }
        if (C4822an.m18218a()) {
            c3628fk.f13182b.setBackgroundResource(R.drawable.circle_background);
        } else {
            c3628fk.f13182b.setBackgroundResource(R.drawable.frame_background);
        }
        this.f13177e = this.f13173a.get(i);
        this.f13176d = C2190d.m9827c(CommonApplication.m18732r().getContentResolver(), this.f13173a.get(i));
        c3628fk.f13183c.setText(R.string.setting_block_unblock);
        c3628fk.f13183c.setOnClickListener(new ViewOnClickListenerC3627fj(this, i));
        c3628fk.f13181a.setText(this.f13176d);
        C2496n.m10765a(c3628fk.f13182b, this.f13177e, EnumC2498p.ROUND);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f13173a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.f13173a.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
