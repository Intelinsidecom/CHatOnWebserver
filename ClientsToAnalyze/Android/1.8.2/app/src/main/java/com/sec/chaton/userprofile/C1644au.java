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
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.widget.ProfileImageView;
import java.util.List;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.au */
/* loaded from: classes.dex */
class C1644au extends ArrayAdapter {

    /* renamed from: a */
    LayoutInflater f6134a;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C0257c) getItem(i)).m2344p() < 4 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public C1644au(Context context, int i, List list) {
        super(context, i, list);
        this.f6134a = LayoutInflater.from(getContext());
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (getItemViewType(i) == 0) {
                view = this.f6134a.inflate(R.layout.list_relationship_rank_big_wgui, (ViewGroup) null);
            } else {
                view = this.f6134a.inflate(R.layout.list_relationship_rank_wgui, (ViewGroup) null);
            }
        }
        m5801a(view, i);
        return view;
    }

    /* renamed from: a */
    private void m5801a(View view, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        ProfileImageView profileImageView = (ProfileImageView) relativeLayout.findViewById(R.id.relation_img);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.relation_status_msg);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.relation_point);
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.relation_rank_text);
        TextView textView4 = (TextView) relativeLayout.findViewById(R.id.relation_rank_text_name);
        TextView textView5 = (TextView) relativeLayout.findViewById(R.id.relation_send);
        TextView textView6 = (TextView) relativeLayout.findViewById(R.id.relation_received);
        TextView textView7 = (TextView) relativeLayout.findViewById(R.id.relation_gap);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rbar);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.relation_rank_img);
        TextView textView8 = (TextView) relativeLayout.findViewById(R.id.relation_received_pt);
        TextView textView9 = (TextView) relativeLayout.findViewById(R.id.relation_send_pt);
        C1746bb.m5945a(getContext()).m5959a(profileImageView, ((C0257c) getItem(i)).m2318a());
        profileImageView.setClickable(true);
        profileImageView.setOnClickListener(new ViewOnClickListenerC1645av(this, i));
        textView2.setText(Integer.toString(((C0257c) getItem(i)).m2341m()));
        textView9.setText(Integer.toString(((C0257c) getItem(i)).m2339k()));
        textView8.setText(Integer.toString(((C0257c) getItem(i)).m2340l()));
        textView3.setText(Integer.toString(((C0257c) getItem(i)).m2344p()));
        int iM2340l = MyPageRelationshipRankFragment.f5925g - (((C0257c) getItem(i)).m2340l() + ((C0257c) getItem(i)).m2339k());
        textView7.setText(Integer.toString(iM2340l));
        textView6.setEnabled(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams.weight = ((C0257c) getItem(i)).m2340l();
        textView6.setLayoutParams(layoutParams);
        textView5.setEnabled(true);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView5.getLayoutParams();
        layoutParams2.weight = ((C0257c) getItem(i)).m2339k();
        textView5.setLayoutParams(layoutParams2);
        relativeLayout2.setEnabled(true);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) relativeLayout2.getLayoutParams();
        layoutParams3.weight = iM2340l;
        relativeLayout2.setLayoutParams(layoutParams3);
        relativeLayout2.setVisibility(0);
        if (getItemViewType(i) == 0) {
            if (!TextUtils.isEmpty(((C0257c) getItem(i)).m2327c())) {
                textView.setText("\"" + ((C0257c) getItem(i)).m2327c() + "\"");
            } else if (((C0257c) getItem(i)).m2318a() != null) {
                imageView.setVisibility(0);
            }
            switch (((C0257c) getItem(i)).m2344p()) {
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
        textView4.setText(((C0257c) getItem(i)).m2324b());
    }
}
