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
/* renamed from: com.sec.chaton.buddy.iw */
/* loaded from: classes.dex */
public class C1397iw extends ArrayAdapter<C1396iv> {

    /* renamed from: a */
    final /* synthetic */ TellFriendsFragment f5019a;

    /* renamed from: b */
    private final Context f5020b;

    /* renamed from: c */
    private final LayoutInflater f5021c;

    /* renamed from: d */
    private final List<C1396iv> f5022d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1397iw(TellFriendsFragment tellFriendsFragment, Context context, int i, List<C1396iv> list) {
        super(context, i, list);
        this.f5019a = tellFriendsFragment;
        this.f5020b = context;
        this.f5021c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5022d = list;
        if (tellFriendsFragment.f4188m == null) {
            tellFriendsFragment.f4188m = (AsyncTaskC1398ix) new AsyncTaskC1398ix(tellFriendsFragment).execute((Void) null);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1396iv c1396iv = this.f5022d.get(i);
        if (view == null) {
            view = this.f5021c.inflate(R.layout.list_item_common_5, (ViewGroup) null);
        }
        ((ImageView) view.findViewById(R.id.image1)).setImageDrawable(c1396iv.m7500a());
        ((TextView) view.findViewById(R.id.text1)).setText(c1396iv.m7504b());
        view.findViewById(R.id.button1).setVisibility(8);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1396iv getItem(int i) {
        return this.f5022d.get(i);
    }
}
