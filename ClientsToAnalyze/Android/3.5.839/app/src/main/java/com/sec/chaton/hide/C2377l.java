package com.sec.chaton.hide;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.R;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p055d.C2133n;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: HideListBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.l */
/* loaded from: classes.dex */
class C2377l extends ArrayAdapter<C1093u> {

    /* renamed from: a */
    ArrayList<C1093u> f8453a;

    /* renamed from: b */
    ArrayList<C1093u> f8454b;

    /* renamed from: c */
    public boolean[] f8455c;

    /* renamed from: d */
    public Handler f8456d;

    /* renamed from: e */
    private Context f8457e;

    /* renamed from: f */
    private C2133n f8458f;

    /* renamed from: g */
    private LayoutInflater f8459g;

    /* renamed from: h */
    private ProgressDialog f8460h;

    /* renamed from: i */
    private ViewGroup f8461i;

    /* renamed from: j */
    private InterfaceC2379n f8462j;

    /* renamed from: a */
    public void m10361a(InterfaceC2379n interfaceC2379n) {
        this.f8462j = interfaceC2379n;
    }

    public C2377l(Context context, int i, ArrayList<C1093u> arrayList) {
        super(context, 0, arrayList);
        this.f8456d = new HandlerC2378m(this);
        this.f8457e = context;
        this.f8453a = arrayList;
        this.f8454b = new ArrayList<>();
        this.f8455c = new boolean[this.f8453a.size()];
        this.f8459g = (LayoutInflater) this.f8457e.getSystemService("layout_inflater");
        this.f8461i = (ViewGroup) this.f8459g.inflate(i, (ViewGroup) null);
        this.f8460h = (ProgressDialog) new C4923p(this.f8457e).m18724a(R.string.dialog_userprofile_updating);
    }

    /* renamed from: a */
    public void m10360a() {
        this.f8458f = new C2133n(this.f8456d);
        this.f8458f.m9560a(this.f8454b);
        this.f8460h.show();
    }

    /* renamed from: a */
    public void m10362a(boolean z) {
        int length = this.f8455c.length;
        for (int i = 0; i < length; i++) {
            this.f8455c[i] = z;
        }
        if (z) {
            this.f8454b.clear();
            this.f8454b.addAll(this.f8453a);
        } else {
            this.f8454b.clear();
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m10363b() {
        String str = "";
        int i = 0;
        while (i < this.f8454b.size()) {
            String str2 = str + this.f8454b.get(i).f3485b + ", ";
            i++;
            str = str2;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2380o c2380o;
        if (view == null) {
            View viewInflate = this.f8459g.inflate(R.layout.list_item_common_6, (ViewGroup) null);
            C2380o c2380o2 = new C2380o((CheckableRelativeLayout) viewInflate);
            viewInflate.setTag(c2380o2);
            view = viewInflate;
            c2380o = c2380o2;
        } else {
            c2380o = (C2380o) view.getTag();
        }
        c2380o.f8467d.setChecked(this.f8455c[i]);
        C1093u item = getItem(i);
        c2380o.f8464a.setText(item.f3485b);
        C2496n.m10765a(c2380o.f8466c, item.f3484a, EnumC2498p.ROUND);
        c2380o.f8466c.setBackgroundResource(R.drawable.circle_background);
        return view;
    }
}
