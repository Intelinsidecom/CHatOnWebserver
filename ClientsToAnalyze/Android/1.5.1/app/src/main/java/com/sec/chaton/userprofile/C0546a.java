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
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.widget.ProfileImageView;
import java.util.List;

/* renamed from: com.sec.chaton.userprofile.a */
/* loaded from: classes.dex */
class C0546a extends ArrayAdapter {

    /* renamed from: a */
    LayoutInflater f3524a;

    public C0546a(Context context, int i, List list) {
        super(context, i, list);
        this.f3524a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    private void m3454a(View view, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        ProfileImageView profileImageView = (ProfileImageView) relativeLayout.findViewById(C0062R.id.relation_img);
        TextView textView = (TextView) relativeLayout.findViewById(C0062R.id.relation_status_msg);
        TextView textView2 = (TextView) relativeLayout.findViewById(C0062R.id.relation_point);
        TextView textView3 = (TextView) relativeLayout.findViewById(C0062R.id.relation_rank_text);
        ImageView imageView = (ImageView) relativeLayout.findViewById(C0062R.id.relation_img_increase);
        TextView textView4 = (TextView) relativeLayout.findViewById(C0062R.id.relation_rank_text_name);
        TextView textView5 = (TextView) relativeLayout.findViewById(C0062R.id.relation_increase);
        TextView textView6 = (TextView) relativeLayout.findViewById(C0062R.id.relation_send);
        TextView textView7 = (TextView) relativeLayout.findViewById(C0062R.id.relation_received);
        TextView textView8 = (TextView) relativeLayout.findViewById(C0062R.id.relation_gap);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(C0062R.id.rbar);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(C0062R.id.lbar);
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(C0062R.id.relation_rank_img);
        ProfileImageLoader.m3610a(getContext()).m3623a(profileImageView, ((BuddyItem) getItem(i)).m668a());
        profileImageView.setClickable(true);
        profileImageView.setOnClickListener(new ViewOnClickListenerC0593q(this, i));
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new ViewOnClickListenerC0594r(this, i));
        textView2.setText(Integer.toString(((BuddyItem) getItem(i)).m688m()));
        int iM690o = ((BuddyItem) getItem(i)).m690o();
        if (iM690o > 0) {
            imageView.setBackgroundResource(C0062R.drawable.relationship_arrow_up);
            textView5.setVisibility(0);
        } else if (iM690o < 0) {
            imageView.setBackgroundResource(C0062R.drawable.relationship_arrow_down);
            textView5.setVisibility(0);
        } else {
            imageView.setBackgroundResource(C0062R.drawable.relationship_unchangeable);
            textView5.setVisibility(8);
        }
        textView5.setText(Math.abs(iM690o) + "");
        textView6.setText(Integer.toString(((BuddyItem) getItem(i)).m686k()));
        textView7.setText(Integer.toString(((BuddyItem) getItem(i)).m687l()));
        textView3.setText(Integer.toString(((BuddyItem) getItem(i)).m691p()));
        int iM687l = RelationshipRank2.f3369g - (((BuddyItem) getItem(i)).m687l() + ((BuddyItem) getItem(i)).m686k());
        textView8.setText(Integer.toString(iM687l));
        textView7.setEnabled(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView7.getLayoutParams();
        layoutParams.weight = ((BuddyItem) getItem(i)).m687l();
        textView7.setLayoutParams(layoutParams);
        textView6.setEnabled(true);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams2.weight = ((BuddyItem) getItem(i)).m686k();
        textView6.setLayoutParams(layoutParams2);
        relativeLayout2.setEnabled(true);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) relativeLayout2.getLayoutParams();
        layoutParams3.weight = iM687l;
        relativeLayout2.setLayoutParams(layoutParams3);
        relativeLayout2.setVisibility(0);
        if (getItemViewType(i) == 0) {
            if (!TextUtils.isEmpty(((BuddyItem) getItem(i)).m676c())) {
                textView.setText("\"" + ((BuddyItem) getItem(i)).m676c() + "\"");
            } else if (((BuddyItem) getItem(i)).m668a() != null) {
                imageView2.setVisibility(0);
            }
            switch (((BuddyItem) getItem(i)).m691p()) {
                case 1:
                    imageView2.setBackgroundResource(C0062R.drawable.rank_1);
                    break;
                case 2:
                    imageView2.setBackgroundResource(C0062R.drawable.rank_2);
                    break;
                case 3:
                    imageView2.setBackgroundResource(C0062R.drawable.rank_3);
                    break;
            }
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(4);
        }
        textView4.setText(((BuddyItem) getItem(i)).m673b());
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((BuddyItem) getItem(i)).m691p() < 4 ? 0 : 1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? getItemViewType(i) == 0 ? this.f3524a.inflate(C0062R.layout.list_relationship_rank_big, (ViewGroup) null) : this.f3524a.inflate(C0062R.layout.list_relationship_rank, (ViewGroup) null) : view;
        m3454a(viewInflate, i);
        return viewInflate;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
