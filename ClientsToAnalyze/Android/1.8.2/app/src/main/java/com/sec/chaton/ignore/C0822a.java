package com.sec.chaton.ignore;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p009b.ProgressDialogC0238b;
import com.sec.chaton.p015d.C0636h;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;

/* compiled from: IgnoreBuddyAdapter.java */
/* renamed from: com.sec.chaton.ignore.a */
/* loaded from: classes.dex */
public class C0822a extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f3024a;

    /* renamed from: b */
    public Handler f3025b;

    /* renamed from: c */
    private Context f3026c;

    /* renamed from: d */
    private C0636h f3027d;

    /* renamed from: e */
    private String f3028e;

    /* renamed from: f */
    private LayoutInflater f3029f;

    /* renamed from: g */
    private ProgressDialogC0238b f3030g;

    /* renamed from: h */
    private ViewGroup f3031h;

    /* renamed from: i */
    private int f3032i;

    /* renamed from: j */
    private ArrayList f3033j;

    /* renamed from: k */
    private View.OnClickListener f3034k;

    public C0822a(Context context, int i, ArrayList arrayList) {
        super(context, 0, arrayList);
        this.f3033j = new ArrayList();
        this.f3034k = new ViewOnClickListenerC0823b(this);
        this.f3025b = new HandlerC0824c(this);
        this.f3026c = context;
        this.f3024a = arrayList;
        this.f3029f = (LayoutInflater) this.f3026c.getSystemService("layout_inflater");
        this.f3031h = (ViewGroup) this.f3029f.inflate(i, (ViewGroup) null);
        this.f3030g = (ProgressDialogC0238b) new C1805i(this.f3026c).m6139a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0825d c0825d;
        if (view == null) {
            view = this.f3029f.inflate(R.layout.item_mylist, (ViewGroup) null);
            c0825d = new C0825d();
            c0825d.f3037a = (TextView) view.findViewById(R.id.listItemText1);
            c0825d.f3038b = (ImageView) view.findViewById(R.id.listItemImage);
            c0825d.f3039c = (Button) view.findViewById(R.id.listItemButton);
            view.setTag(c0825d);
        } else {
            c0825d = (C0825d) view.getTag();
        }
        c0825d.f3039c.setTag(Integer.valueOf(i));
        c0825d.f3039c.setOnClickListener(this.f3034k);
        C0829h c0829h = (C0829h) getItem(i);
        c0825d.f3037a.setText(c0829h.f3043a);
        C1746bb.m5945a(this.f3026c).m5959a(c0825d.f3038b, c0829h.f3043a);
        return view;
    }
}
