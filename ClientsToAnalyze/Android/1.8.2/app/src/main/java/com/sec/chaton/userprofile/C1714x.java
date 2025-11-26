package com.sec.chaton.userprofile;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.widget.ProfileImageView;
import java.util.List;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.x */
/* loaded from: classes.dex */
public class C1714x extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6228a;

    /* renamed from: b */
    private List f6229b;

    /* renamed from: c */
    private Context f6230c;

    /* renamed from: d */
    private LayoutInflater f6231d;

    public C1714x(MyPageFragment myPageFragment, Context context, List list) {
        this.f6228a = myPageFragment;
        this.f6230c = context;
        this.f6229b = list;
        this.f6231d = (LayoutInflater) this.f6230c.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6229b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6229b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6231d.inflate(R.layout.user_profile_item, viewGroup, false);
            view.setLayoutParams(new Gallery.LayoutParams(-2, -2));
        }
        ProfileImageView profileImageView = (ProfileImageView) view.findViewById(R.id.imgfriend1);
        TextView textView = (TextView) view.findViewById(R.id.textfriend1);
        C0257c c0257c = (C0257c) this.f6229b.get(i);
        if (!TextUtils.isEmpty(c0257c.m2318a())) {
            C1746bb.m5945a(this.f6228a.f5820H).m5959a(profileImageView, c0257c.m2318a());
            textView.setText(c0257c.m2324b());
        } else {
            profileImageView.setImageBitmap(C1746bb.m5940a(profileImageView.getContext(), R.drawable.msg_list_id_1));
            profileImageView.setClickable(false);
            textView.setText("");
        }
        return view;
    }
}
