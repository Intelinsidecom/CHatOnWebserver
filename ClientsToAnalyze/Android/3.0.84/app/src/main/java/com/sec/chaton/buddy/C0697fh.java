package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileImageViewFragment;
import com.sec.chaton.userprofile.CallableC3115bn;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: BuddyProfileHistoryAdapter.java */
/* renamed from: com.sec.chaton.buddy.fh */
/* loaded from: classes.dex */
public class C0697fh extends BaseAdapter {

    /* renamed from: a */
    LayoutInflater f2919a;

    /* renamed from: b */
    ArrayList<BuddyProfileImageViewFragment.ProfileImageItem> f2920b;

    /* renamed from: c */
    int f2921c;

    /* renamed from: d */
    boolean f2922d;

    /* renamed from: e */
    private Context f2923e;

    /* renamed from: f */
    private C3326c f2924f;

    public C0697fh(Context context, int i, ArrayList<BuddyProfileImageViewFragment.ProfileImageItem> arrayList, C3326c c3326c) {
        this.f2922d = true;
        this.f2923e = context;
        this.f2921c = i;
        this.f2920b = arrayList;
        this.f2924f = c3326c;
        this.f2919a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2922d = true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2920b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuddyProfileImageViewFragment.ProfileImageItem getItem(int i) {
        return this.f2920b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2919a.inflate(this.f2921c, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.profile_image_bg);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.profile_image_selctor);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.profile_image_select_layout);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.profile_image_loading);
        if (!"1".equals(this.f2920b.get(i).Represent)) {
            this.f2920b.get(i).selectedImage = imageView3;
        }
        this.f2920b.get(i).thumbImage = imageView;
        this.f2924f.m11732a(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setVisibility(8);
        imageView.setImageDrawable(null);
        this.f2924f.m11730a(imageView, new CallableC3115bn(imageView4, this.f2920b.get(i).f2168id + "&size=100", 60, 60, this.f2920b.get(i).dirCachePath, this.f2920b.get(i).ThumbfileName));
        if ("1".equals(this.f2920b.get(i).Represent)) {
            imageView2.setVisibility(0);
            if (this.f2920b.get(i).imageId.equals(BuddyProfileImageView.f2124a)) {
                imageView3.setVisibility(0);
            }
        } else if (this.f2920b.get(i).imageId.equals(BuddyProfileImageView.f2124a)) {
            C3250y.m11456e("UserProfileImageView.PROFILE_CURRENT_IMAGE" + BuddyProfileImageView.f2124a, getClass().getSimpleName());
            this.f2920b.get(i).selectedImage.setVisibility(0);
        } else {
            C3250y.m11456e("UserProfileImageView.PROFILE_CURRENT_IMAGE(NO)" + BuddyProfileImageView.f2124a, getClass().getSimpleName());
            this.f2920b.get(i).selectedImage.setVisibility(8);
        }
        view.setTag(this.f2920b.get(i));
        return view;
    }
}
