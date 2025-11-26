package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.widget.C3263j;
import java.util.ArrayList;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.io */
/* loaded from: classes.dex */
public class C0785io extends ArrayAdapter<C0784in> {

    /* renamed from: a */
    ArrayList<C0784in> f3059a;

    /* renamed from: b */
    String f3060b;

    /* renamed from: c */
    String f3061c;

    /* renamed from: d */
    final /* synthetic */ SpecialBuddyRecommendListFragment f3062d;

    /* renamed from: e */
    private Context f3063e;

    /* renamed from: f */
    private LayoutInflater f3064f;

    /* renamed from: g */
    private ViewGroup f3065g;

    /* renamed from: h */
    private View.OnClickListener f3066h;

    /* renamed from: i */
    private View.OnClickListener f3067i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0785io(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment, Context context, int i, ArrayList<C0784in> arrayList) {
        super(context, 0, arrayList);
        this.f3062d = specialBuddyRecommendListFragment;
        this.f3066h = new ViewOnClickListenerC0786ip(this);
        this.f3067i = new ViewOnClickListenerC0787iq(this);
        this.f3063e = context;
        this.f3059a = arrayList;
        this.f3064f = (LayoutInflater) this.f3063e.getSystemService("layout_inflater");
        this.f3065g = (ViewGroup) this.f3064f.inflate(i, (ViewGroup) null);
        specialBuddyRecommendListFragment.f2328g = (ProgressDialog) new C3263j(this.f3063e).m11487a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0788ir c0788ir;
        if (view == null) {
            view = this.f3064f.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c0788ir = new C0788ir(this);
            c0788ir.f3070a = (ImageView) view.findViewById(R.id.image1);
            c0788ir.f3071b = (TextView) view.findViewById(R.id.text1);
            c0788ir.f3072c = (Button) view.findViewById(R.id.button1);
            view.setTag(c0788ir);
        } else {
            c0788ir = (C0788ir) view.getTag();
        }
        c0788ir.f3072c.setTag(Integer.valueOf(i));
        c0788ir.f3072c.setBackgroundResource(R.drawable.ic_arrow);
        c0788ir.f3072c.setOnClickListener(this.f3066h);
        c0788ir.f3071b.setTag(Integer.valueOf(i));
        c0788ir.f3071b.setOnClickListener(this.f3066h);
        C0784in item = getItem(i);
        c0788ir.f3071b.setText(item.f3057b);
        c0788ir.f3070a.setTag(Integer.valueOf(i));
        c0788ir.f3070a.setOnClickListener(this.f3066h);
        if (this.f3062d.f2332k != 1) {
            if (this.f3062d.f2332k > 1) {
                c0788ir.f3070a.setVisibility(0);
                this.f3062d.f2335n.setVisibility(8);
                C3205bt.m11182a(this.f3063e).m11210a(c0788ir.f3070a, item.f3056a);
            } else {
                c0788ir.f3070a.setVisibility(8);
                this.f3062d.f2335n.setVisibility(8);
            }
        } else {
            c0788ir.f3070a.setVisibility(8);
            this.f3062d.f2335n.setVisibility(0);
            C3205bt.m11182a(this.f3063e).m11210a(this.f3062d.f2335n, item.f3056a);
        }
        return view;
    }
}
