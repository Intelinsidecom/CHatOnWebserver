package com.sec.chaton.userprofile;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.ProfileImageView;
import java.util.List;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.t */
/* loaded from: classes.dex */
public class C1270t extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4367a;

    /* renamed from: b */
    private List f4368b;

    /* renamed from: c */
    private Context f4369c;

    /* renamed from: d */
    private LayoutInflater f4370d;

    public C1270t(MyPageFragment myPageFragment, Context context, List list) {
        this.f4367a = myPageFragment;
        this.f4369c = context;
        this.f4368b = list;
        this.f4370d = (LayoutInflater) this.f4369c.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4368b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f4368b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4370d.inflate(R.layout.user_profile_item, viewGroup, false);
            view.setLayoutParams(new Gallery.LayoutParams(-2, -2));
        }
        ProfileImageView profileImageView = (ProfileImageView) view.findViewById(R.id.imgfriend1);
        TextView textView = (TextView) view.findViewById(R.id.textfriend1);
        ImageView imageView = (ImageView) view.findViewById(R.id.rank_image);
        C0363a c0363a = (C0363a) this.f4368b.get(i);
        if (TextUtils.isEmpty(c0363a.m2308a())) {
            profileImageView.setImageBitmap(C1348w.m4680a(profileImageView.getContext(), R.drawable.contacts_default_image_cb));
            profileImageView.setClickable(false);
            textView.setText("");
            imageView.setVisibility(8);
        } else {
            if (i == 0) {
                imageView.setImageResource(R.drawable.interaction_rank_1);
            } else if (i == 1) {
                imageView.setImageResource(R.drawable.interaction_rank_2);
            } else if (i == 2) {
                imageView.setImageResource(R.drawable.interaction_rank_3);
            }
            if (i < 3) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            C1348w.m4685a(this.f4367a.f4116N).m4699a(profileImageView, c0363a.m2308a());
            textView.setText(c0363a.m2314b());
        }
        return view;
    }
}
