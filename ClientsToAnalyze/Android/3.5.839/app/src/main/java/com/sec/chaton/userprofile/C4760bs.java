package com.sec.chaton.userprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* compiled from: ProfileHistoryAdapter.java */
/* renamed from: com.sec.chaton.userprofile.bs */
/* loaded from: classes.dex */
public class C4760bs extends BaseAdapter {

    /* renamed from: a */
    LayoutInflater f17447a;

    /* renamed from: b */
    ArrayList<ProfileImageHistoryFragment.ProfileImageItem> f17448b;

    /* renamed from: c */
    int f17449c;

    /* renamed from: d */
    private Context f17450d;

    /* renamed from: e */
    private C5007c f17451e;

    public C4760bs(Context context, int i, ArrayList<ProfileImageHistoryFragment.ProfileImageItem> arrayList, C5007c c5007c) {
        this.f17450d = context;
        this.f17449c = i;
        this.f17448b = arrayList;
        this.f17451e = c5007c;
        this.f17447a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17448b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProfileImageHistoryFragment.ProfileImageItem getItem(int i) {
        return this.f17448b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f17447a.inflate(this.f17449c, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.profile_image_bg);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.profile_image_selctor);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.profile_image_select_layout);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.profile_image_loading);
        this.f17448b.get(i).selectedImage = imageView3;
        this.f17448b.get(i).thumbImage = imageView;
        if (this.f17448b.get(i).f17357id.equals("addImage")) {
            this.f17451e.m19015a((View) imageView);
            this.f17451e.m19015a((View) imageView4);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setBackgroundColor(android.R.color.black);
            imageView.setImageResource(R.drawable.setting_add);
            imageView4.setImageDrawable(null);
            this.f17448b.get(i).selectedImage.setVisibility(8);
            imageView.setContentDescription(this.f17450d.getResources().getString(R.string.mypage_profile_add_photo));
        } else {
            this.f17451e.m19015a((View) imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setVisibility(8);
            imageView.setImageDrawable(null);
            imageView.setContentDescription(this.f17450d.getResources().getString(R.string.media_photo));
            this.f17451e.m19023b(imageView, new CallableC4761bt(imageView4, this.f17448b.get(i).f17357id + "&size=140", 60, 60, this.f17448b.get(i).dirCachePath, this.f17448b.get(i).ThumbfileName));
            if (Spam.ACTIVITY_REPORT.equals(this.f17448b.get(i).Represent)) {
                imageView2.setVisibility(0);
            }
            if (this.f17448b.get(i).imageId.equals(ProfileImageHistoryActivity.f17280n)) {
                C4904y.m18646e("UserProfileImageView.PROFILE_CURRENT_IMAGE" + ProfileImageHistoryActivity.f17280n, getClass().getSimpleName());
                this.f17448b.get(i).selectedImage.setVisibility(0);
            } else {
                C4904y.m18646e("UserProfileImageView.PROFILE_CURRENT_IMAGE(NO)" + ProfileImageHistoryActivity.f17280n, getClass().getSimpleName());
                this.f17448b.get(i).selectedImage.setVisibility(8);
            }
        }
        view.setTag(this.f17448b.get(i));
        return view;
    }
}
