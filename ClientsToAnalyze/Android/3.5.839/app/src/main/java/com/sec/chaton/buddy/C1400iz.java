package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: TellFriendsSnsListFragment.java */
/* renamed from: com.sec.chaton.buddy.iz */
/* loaded from: classes.dex */
public class C1400iz extends ArrayAdapter<C1399iy> {

    /* renamed from: a */
    final /* synthetic */ TellFriendsSnsListFragment f5028a;

    /* renamed from: b */
    private Context f5029b;

    /* renamed from: c */
    private LayoutInflater f5030c;

    /* renamed from: d */
    private List<C1399iy> f5031d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1400iz(TellFriendsSnsListFragment tellFriendsSnsListFragment, Context context, int i, List<C1399iy> list) {
        super(context, i, list);
        this.f5028a = tellFriendsSnsListFragment;
        this.f5029b = context;
        this.f5030c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5031d = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1399iy c1399iy = this.f5031d.get(i);
        if (view == null) {
            view = this.f5030c.inflate(R.layout.list_item_common_1, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.text1)).setText(c1399iy.m7514a());
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1399iy getItem(int i) {
        return this.f5031d.get(i);
    }
}
