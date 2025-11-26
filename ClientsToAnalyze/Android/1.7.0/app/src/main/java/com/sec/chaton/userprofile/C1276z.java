package com.sec.chaton.userprofile;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.ProfileImageView;
import java.util.List;

/* compiled from: InteractionAdapter.java */
/* renamed from: com.sec.chaton.userprofile.z */
/* loaded from: classes.dex */
public class C1276z extends ArrayAdapter {

    /* renamed from: a */
    LayoutInflater f4377a;

    /* renamed from: b */
    InterfaceC1238bh f4378b;

    /* renamed from: a */
    public void m4431a(InterfaceC1238bh interfaceC1238bh) {
        this.f4378b = interfaceC1238bh;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C0363a) getItem(i)).m2330p() < 4 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public C1276z(Context context, int i, List list) {
        super(context, i, list);
        this.f4377a = LayoutInflater.from(getContext());
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (getItemViewType(i) == 0) {
                view = this.f4377a.inflate(R.layout.list_relationship_rank_big, (ViewGroup) null);
            } else {
                view = this.f4377a.inflate(R.layout.list_relationship_rank, (ViewGroup) null);
            }
        }
        m4430a(view, i);
        return view;
    }

    /* renamed from: a */
    private void m4430a(View view, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        ProfileImageView profileImageView = (ProfileImageView) relativeLayout.findViewById(R.id.relation_img);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.relation_status_msg);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.relation_point);
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.relation_rank_text);
        TextView textView4 = (TextView) relativeLayout.findViewById(R.id.relation_rank_text_name);
        TextView textView5 = (TextView) relativeLayout.findViewById(R.id.relation_send);
        TextView textView6 = (TextView) relativeLayout.findViewById(R.id.relation_received);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.relation_rank_img);
        TextView textView7 = (TextView) relativeLayout.findViewById(R.id.relation_received_pt);
        TextView textView8 = (TextView) relativeLayout.findViewById(R.id.relation_send_pt);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rlay_relation);
        C1348w.m4685a(getContext()).m4699a(profileImageView, ((C0363a) getItem(i)).m2308a());
        profileImageView.setClickable(true);
        profileImageView.setOnClickListener(new ViewOnClickListenerC1252bv(this, i));
        relativeLayout2.setClickable(true);
        relativeLayout2.setOnClickListener(new ViewOnClickListenerC1251bu(this, i));
        textView2.setText(Integer.toString(((C0363a) getItem(i)).m2327m()));
        textView8.setText(Integer.toString(((C0363a) getItem(i)).m2325k()));
        textView7.setText(Integer.toString(((C0363a) getItem(i)).m2326l()));
        textView3.setText(Integer.toString(((C0363a) getItem(i)).m2330p()));
        int iM2327m = ((C0363a) getItem(i)).m2327m() - (((C0363a) getItem(i)).m2326l() + ((C0363a) getItem(i)).m2325k());
        textView6.setEnabled(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams.weight = ((C0363a) getItem(i)).m2326l();
        textView6.setLayoutParams(layoutParams);
        textView5.setEnabled(true);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView5.getLayoutParams();
        layoutParams2.weight = ((C0363a) getItem(i)).m2325k();
        textView5.setLayoutParams(layoutParams2);
        if (getItemViewType(i) == 0) {
            if (!TextUtils.isEmpty(((C0363a) getItem(i)).m2316c())) {
                textView.setText("\"" + ((C0363a) getItem(i)).m2316c() + "\"");
            } else if (((C0363a) getItem(i)).m2308a() != null) {
                imageView.setVisibility(0);
            }
            switch (((C0363a) getItem(i)).m2330p()) {
                case 1:
                    imageView.setBackgroundResource(R.drawable.rank_list_01);
                    break;
                case 2:
                    imageView.setBackgroundResource(R.drawable.rank_list_02);
                    break;
                case 3:
                    imageView.setBackgroundResource(R.drawable.rank_list_03);
                    break;
            }
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        textView4.setText(((C0363a) getItem(i)).m2314b());
    }
}
