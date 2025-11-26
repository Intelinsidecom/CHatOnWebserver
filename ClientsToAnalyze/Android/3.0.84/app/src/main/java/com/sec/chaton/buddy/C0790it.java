package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: TellFriendsFragment.java */
/* renamed from: com.sec.chaton.buddy.it */
/* loaded from: classes.dex */
public class C0790it extends ArrayAdapter<C0789is> {

    /* renamed from: a */
    final /* synthetic */ TellFriendsFragment f3077a;

    /* renamed from: b */
    private Context f3078b;

    /* renamed from: c */
    private LayoutInflater f3079c;

    /* renamed from: d */
    private List<C0789is> f3080d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0790it(TellFriendsFragment tellFriendsFragment, Context context, int i, List<C0789is> list) {
        super(context, i, list);
        this.f3077a = tellFriendsFragment;
        this.f3078b = context;
        this.f3079c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3080d = list;
        if (tellFriendsFragment.f2343e == null) {
            tellFriendsFragment.f2343e = (AsyncTaskC0791iu) new AsyncTaskC0791iu(tellFriendsFragment).execute((Void) null);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0789is c0789is = this.f3080d.get(i);
        if (view == null) {
            view = this.f3079c.inflate(R.layout.list_item_common_5, (ViewGroup) null);
        }
        ((ImageView) view.findViewById(R.id.image1)).setImageDrawable(c0789is.m4353a());
        ((TextView) view.findViewById(R.id.text1)).setText(c0789is.m4355b());
        view.findViewById(R.id.button1).setVisibility(8);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0789is getItem(int i) {
        return this.f3080d.get(i);
    }
}
