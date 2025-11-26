package com.sec.chaton.block;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.widget.C3263j;
import java.util.ArrayList;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.a */
/* loaded from: classes.dex */
class C0472a extends ArrayAdapter<C0475ac> {

    /* renamed from: a */
    public ArrayList<C0475ac> f1570a;

    /* renamed from: b */
    public Handler f1571b;

    /* renamed from: c */
    private Context f1572c;

    /* renamed from: d */
    private C1328f f1573d;

    /* renamed from: e */
    private String f1574e;

    /* renamed from: f */
    private String f1575f;

    /* renamed from: g */
    private LayoutInflater f1576g;

    /* renamed from: h */
    private ProgressDialog f1577h;

    /* renamed from: i */
    private ViewGroup f1578i;

    /* renamed from: j */
    private InterfaceC0479e f1579j;

    /* renamed from: k */
    private View.OnClickListener f1580k;

    /* renamed from: l */
    private View.OnClickListener f1581l;

    /* renamed from: a */
    public void m3128a(InterfaceC0479e interfaceC0479e) {
        this.f1579j = interfaceC0479e;
    }

    public C0472a(Context context, int i, ArrayList<C0475ac> arrayList) {
        super(context, 0, arrayList);
        this.f1580k = new ViewOnClickListenerC0476b(this);
        this.f1581l = new ViewOnClickListenerC0477c(this);
        this.f1571b = new HandlerC0478d(this);
        this.f1572c = context;
        this.f1570a = arrayList;
        this.f1576g = (LayoutInflater) this.f1572c.getSystemService("layout_inflater");
        this.f1578i = (ViewGroup) this.f1576g.inflate(i, (ViewGroup) null);
        this.f1577h = (ProgressDialog) new C3263j(this.f1572c).m11487a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0480f c0480f;
        if (view == null) {
            view = this.f1576g.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c0480f = new C0480f();
            c0480f.f1590a = (TextView) view.findViewById(R.id.text1);
            c0480f.f1591b = (ImageView) view.findViewById(R.id.image1);
            c0480f.f1592c = (Button) view.findViewById(R.id.button1);
            view.setTag(c0480f);
        } else {
            c0480f = (C0480f) view.getTag();
        }
        c0480f.f1591b.setBackgroundResource(R.drawable.frame_background);
        c0480f.f1591b.setOnClickListener(this.f1580k);
        c0480f.f1591b.setTag(Integer.valueOf(i));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f1572c).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        c0480f.f1592c.setMaxWidth((int) (displayMetrics.density * 100.0f));
        c0480f.f1592c.setSingleLine(false);
        c0480f.f1592c.setMaxLines(2);
        c0480f.f1592c.setEllipsize(TextUtils.TruncateAt.END);
        c0480f.f1592c.setText(R.string.buddy_group_edit_menubar_remove);
        c0480f.f1592c.setTag(Integer.valueOf(i));
        c0480f.f1592c.setOnClickListener(this.f1581l);
        C0475ac item = getItem(i);
        c0480f.f1590a.setText(item.f1585b);
        C3205bt.m11182a(this.f1572c).m11210a(c0480f.f1591b, item.f1584a);
        return view;
    }
}
