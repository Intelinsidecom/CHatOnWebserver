package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileImageViewFragment;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.userprofile.CallableC4761bt;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* compiled from: BuddyProfileHistoryAdapter.java */
/* renamed from: com.sec.chaton.buddy.gi */
/* loaded from: classes.dex */
public class C1329gi extends BaseAdapter {

    /* renamed from: a */
    LayoutInflater f4865a;

    /* renamed from: b */
    ArrayList<BuddyProfileImageViewFragment.ProfileImageItem> f4866b;

    /* renamed from: c */
    int f4867c;

    /* renamed from: d */
    boolean f4868d;

    /* renamed from: e */
    private Context f4869e;

    /* renamed from: f */
    private C5007c f4870f;

    public C1329gi(Context context, int i, ArrayList<BuddyProfileImageViewFragment.ProfileImageItem> arrayList, C5007c c5007c) {
        this.f4868d = true;
        this.f4869e = context;
        this.f4867c = i;
        this.f4866b = arrayList;
        this.f4870f = c5007c;
        this.f4865a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4868d = true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4866b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuddyProfileImageViewFragment.ProfileImageItem getItem(int i) {
        return this.f4866b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4865a.inflate(this.f4867c, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.profile_image_bg);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.profile_image_selctor);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.profile_image_select_layout);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.profile_image_loading);
        if (!Spam.ACTIVITY_REPORT.equals(this.f4866b.get(i).Represent)) {
            this.f4866b.get(i).selectedImage = imageView3;
        }
        this.f4866b.get(i).thumbImage = imageView;
        this.f4870f.m19015a((View) imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setVisibility(8);
        imageView.setImageDrawable(null);
        this.f4870f.m19023b(imageView, new CallableC4761bt(imageView4, this.f4866b.get(i).f4064id + "&size=100", 60, 60, this.f4866b.get(i).dirCachePath, this.f4866b.get(i).ThumbfileName));
        if (Spam.ACTIVITY_REPORT.equals(this.f4866b.get(i).Represent)) {
            imageView2.setVisibility(0);
            if (this.f4866b.get(i).imageId.equals(BuddyProfileImageView.f4020n)) {
                imageView3.setVisibility(0);
            }
        } else if (this.f4866b.get(i).imageId.equals(BuddyProfileImageView.f4020n)) {
            C4904y.m18646e("UserProfileImageView.PROFILE_CURRENT_IMAGE" + BuddyProfileImageView.f4020n, getClass().getSimpleName());
            this.f4866b.get(i).selectedImage.setVisibility(0);
        } else {
            C4904y.m18646e("UserProfileImageView.PROFILE_CURRENT_IMAGE(NO)" + BuddyProfileImageView.f4020n, getClass().getSimpleName());
            this.f4866b.get(i).selectedImage.setVisibility(8);
        }
        view.setTag(this.f4866b.get(i));
        return view;
    }
}
