package com.sec.chaton.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.util.ProfileImageLoader;
import java.util.ArrayList;

/* loaded from: classes.dex */
class RelationHideAdapter extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f3110a;

    /* renamed from: b */
    private Context f3111b;

    /* renamed from: c */
    private int f3112c;

    /* renamed from: d */
    private String f3113d;

    /* renamed from: e */
    private String f3114e;

    /* renamed from: f */
    private LayoutInflater f3115f;

    /* renamed from: g */
    private NotifyingAsyncQueryHandler f3116g;

    public class MyViewHolder {

        /* renamed from: a */
        TextView f3117a;

        /* renamed from: b */
        TextView f3118b;

        /* renamed from: c */
        ImageView f3119c;

        /* renamed from: d */
        Button f3120d;
    }

    public RelationHideAdapter(RelationHideActivity relationHideActivity, int i, ArrayList arrayList, NotifyingAsyncQueryHandler.AsyncQueryListener asyncQueryListener) {
        super(relationHideActivity, 0);
        this.f3112c = i;
        this.f3111b = relationHideActivity;
        this.f3110a = arrayList;
        this.f3116g = new NotifyingAsyncQueryHandler(this.f3111b.getContentResolver(), asyncQueryListener);
        this.f3115f = (LayoutInflater) this.f3111b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuddyItem getItem(int i) {
        return (BuddyItem) this.f3110a.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f3110a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder;
        View viewInflate;
        if (view == null) {
            viewInflate = this.f3115f.inflate(C0062R.layout.item_hide_list, (ViewGroup) null);
            MyViewHolder myViewHolder2 = new MyViewHolder();
            myViewHolder2.f3118b = (TextView) viewInflate.findViewById(C0062R.id.name);
            myViewHolder2.f3117a = (TextView) viewInflate.findViewById(C0062R.id.buddyid);
            myViewHolder2.f3119c = (ImageView) viewInflate.findViewById(C0062R.id.friendImageCheck);
            myViewHolder2.f3120d = (Button) viewInflate.findViewById(C0062R.id.menuCall);
            viewInflate.setTag(myViewHolder2);
            myViewHolder = myViewHolder2;
        } else {
            myViewHolder = (MyViewHolder) view.getTag();
            viewInflate = view;
        }
        myViewHolder.f3119c.setOnClickListener(new ViewOnClickListenerC0522w(this, i));
        myViewHolder.f3120d.setOnClickListener(new ViewOnClickListenerC0521v(this, i));
        BuddyItem item = getItem(i);
        myViewHolder.f3118b.setText(item.m673b());
        myViewHolder.f3117a.setText(item.m668a());
        ProfileImageLoader.m3610a(this.f3111b).m3623a(myViewHolder.f3119c, item.m668a());
        return viewInflate;
    }
}
