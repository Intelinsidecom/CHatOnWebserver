package com.sec.chaton.block;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: BlockListBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.k */
/* loaded from: classes.dex */
class C1083k extends ArrayAdapter<C1093u> {

    /* renamed from: a */
    ArrayList<C1093u> f3463a;

    /* renamed from: b */
    ArrayList<C1093u> f3464b;

    /* renamed from: c */
    public boolean[] f3465c;

    /* renamed from: d */
    public Handler f3466d;

    /* renamed from: e */
    private Context f3467e;

    /* renamed from: f */
    private C2126g f3468f;

    /* renamed from: g */
    private LayoutInflater f3469g;

    /* renamed from: h */
    private ProgressDialog f3470h;

    /* renamed from: i */
    private ViewGroup f3471i;

    /* renamed from: j */
    private InterfaceC1085m f3472j;

    /* renamed from: a */
    public void m6228a(InterfaceC1085m interfaceC1085m) {
        this.f3472j = interfaceC1085m;
    }

    public C1083k(Context context, int i, ArrayList<C1093u> arrayList) {
        super(context, 0, arrayList);
        this.f3466d = new HandlerC1084l(this);
        this.f3467e = context;
        this.f3463a = arrayList;
        this.f3464b = new ArrayList<>();
        this.f3465c = new boolean[this.f3463a.size()];
        this.f3469g = (LayoutInflater) this.f3467e.getSystemService("layout_inflater");
        this.f3471i = (ViewGroup) this.f3469g.inflate(i, (ViewGroup) null);
        this.f3470h = (ProgressDialog) new C4923p(this.f3467e).m18724a(R.string.dialog_userprofile_updating);
    }

    /* renamed from: a */
    public void m6227a() {
        this.f3468f = C2126g.m9476a(this.f3466d);
        this.f3468f.m9480a(this.f3464b);
        this.f3470h.show();
    }

    /* renamed from: a */
    public void m6229a(boolean z) {
        int length = this.f3465c.length;
        for (int i = 0; i < length; i++) {
            this.f3465c[i] = z;
        }
        if (z) {
            this.f3464b.clear();
            this.f3464b.addAll(this.f3463a);
        } else {
            this.f3464b.clear();
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m6230b() {
        String str = "";
        int i = 0;
        while (i < this.f3464b.size()) {
            String str2 = str + this.f3464b.get(i).f3485b + ", ";
            i++;
            str = str2;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1086n c1086n;
        if (view == null) {
            View viewInflate = this.f3469g.inflate(R.layout.list_item_common_6, (ViewGroup) null);
            C1086n c1086n2 = new C1086n((CheckableRelativeLayout) viewInflate);
            viewInflate.setTag(c1086n2);
            view = viewInflate;
            c1086n = c1086n2;
        } else {
            c1086n = (C1086n) view.getTag();
        }
        c1086n.f3477d.setChecked(this.f3465c[i]);
        C1093u item = getItem(i);
        c1086n.f3474a.setText(item.f3485b);
        C2496n.m10765a(c1086n.f3476c, item.f3484a, EnumC2498p.ROUND);
        c1086n.f3476c.setBackgroundResource(R.drawable.circle_background);
        return view;
    }
}
