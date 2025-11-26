package com.sec.chaton.block;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.BlockControl;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.widget.SMSProgressBar;
import java.util.ArrayList;

/* loaded from: classes.dex */
class BlockBuddyAdapter extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f355a;

    /* renamed from: b */
    public Handler f356b;

    /* renamed from: c */
    private Context f357c;

    /* renamed from: d */
    private int f358d;

    /* renamed from: e */
    private BlockControl f359e;

    /* renamed from: f */
    private String f360f;

    /* renamed from: g */
    private String f361g;

    /* renamed from: h */
    private LayoutInflater f362h;

    /* renamed from: i */
    private ProgressDialog f363i;

    /* renamed from: j */
    private ViewGroup f364j;

    /* renamed from: k */
    private LinearLayout f365k;

    /* renamed from: l */
    private ListView f366l;

    public class MyViewHolder {

        /* renamed from: a */
        TextView f367a;

        /* renamed from: b */
        TextView f368b;

        /* renamed from: c */
        ImageView f369c;

        /* renamed from: d */
        Button f370d;
    }

    public BlockBuddyAdapter(Context context, int i, ArrayList arrayList, LinearLayout linearLayout) {
        super(context, 0, arrayList);
        this.f356b = new HandlerC0073c(this);
        this.f358d = i;
        this.f357c = context;
        this.f355a = arrayList;
        this.f362h = (LayoutInflater) this.f357c.getSystemService("layout_inflater");
        this.f364j = (ViewGroup) this.f362h.inflate(i, (ViewGroup) null);
        this.f365k = linearLayout;
        this.f366l = (ListView) this.f364j.findViewById(C0062R.id.list);
        this.f363i = (ProgressDialog) new SMSProgressBar(this.f357c).onCreate(C0062R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder;
        View view2;
        if (view == null) {
            View viewInflate = this.f362h.inflate(C0062R.layout.item_mylist, (ViewGroup) null);
            MyViewHolder myViewHolder2 = new MyViewHolder();
            myViewHolder2.f368b = (TextView) viewInflate.findViewById(C0062R.id.name);
            myViewHolder2.f367a = (TextView) viewInflate.findViewById(C0062R.id.buddyid);
            myViewHolder2.f369c = (ImageView) viewInflate.findViewById(C0062R.id.friendImageCheck);
            myViewHolder2.f370d = (Button) viewInflate.findViewById(C0062R.id.menuCall);
            viewInflate.setTag(myViewHolder2);
            view2 = viewInflate;
            myViewHolder = myViewHolder2;
        } else {
            myViewHolder = (MyViewHolder) view.getTag();
            view2 = view;
        }
        myViewHolder.f369c.setOnClickListener(new ViewOnClickListenerC0075e(this, i));
        myViewHolder.f370d.setOnClickListener(new ViewOnClickListenerC0074d(this, i));
        C0071a c0071a = (C0071a) getItem(i);
        myViewHolder.f368b.setText(c0071a.f373c);
        myViewHolder.f367a.setText(c0071a.f372b);
        ProfileImageLoader.m3610a(this.f357c).m3623a(myViewHolder.f369c, c0071a.f372b);
        return view2;
    }
}
