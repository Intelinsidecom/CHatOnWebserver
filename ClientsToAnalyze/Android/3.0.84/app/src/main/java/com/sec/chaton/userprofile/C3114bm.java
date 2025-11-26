package com.sec.chaton.userprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: ProfileHistoryAdapter.java */
/* renamed from: com.sec.chaton.userprofile.bm */
/* loaded from: classes.dex */
public class C3114bm extends BaseAdapter {

    /* renamed from: a */
    LayoutInflater f11328a;

    /* renamed from: b */
    ArrayList<ProfileImageHistoryFragment.ProfileImageItem> f11329b;

    /* renamed from: c */
    int f11330c;

    /* renamed from: d */
    private Context f11331d;

    /* renamed from: e */
    private C3326c f11332e;

    public C3114bm(Context context, int i, ArrayList<ProfileImageHistoryFragment.ProfileImageItem> arrayList, C3326c c3326c) {
        this.f11331d = context;
        this.f11330c = i;
        this.f11329b = arrayList;
        this.f11332e = c3326c;
        this.f11328a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11329b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProfileImageHistoryFragment.ProfileImageItem getItem(int i) {
        return this.f11329b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11328a.inflate(this.f11330c, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.profile_image_bg);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.profile_image_selctor);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.profile_image_select_layout);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.profile_image_loading);
        this.f11329b.get(i).selectedImage = imageView3;
        this.f11329b.get(i).thumbImage = imageView;
        if (this.f11329b.get(i).f11265id.equals("addImage")) {
            this.f11332e.m11732a(imageView);
            this.f11332e.m11732a(imageView4);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setBackgroundColor(android.R.color.black);
            imageView.setImageResource(R.drawable.setting_add);
            imageView4.setImageDrawable(null);
            this.f11329b.get(i).selectedImage.setVisibility(8);
        } else {
            this.f11332e.m11732a(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setVisibility(8);
            imageView.setImageDrawable(null);
            this.f11332e.m11730a(imageView, new CallableC3115bn(imageView4, this.f11329b.get(i).f11265id + "&size=140", 60, 60, this.f11329b.get(i).dirCachePath, this.f11329b.get(i).ThumbfileName));
            if ("1".equals(this.f11329b.get(i).Represent)) {
                imageView2.setVisibility(0);
            }
            if (this.f11329b.get(i).imageId.equals(ProfileImageHistoryActivity.f11195a)) {
                C3250y.m11456e("UserProfileImageView.PROFILE_CURRENT_IMAGE" + ProfileImageHistoryActivity.f11195a, getClass().getSimpleName());
                this.f11329b.get(i).selectedImage.setVisibility(0);
            } else {
                C3250y.m11456e("UserProfileImageView.PROFILE_CURRENT_IMAGE(NO)" + ProfileImageHistoryActivity.f11195a, getClass().getSimpleName());
                this.f11329b.get(i).selectedImage.setVisibility(8);
            }
        }
        view.setTag(this.f11329b.get(i));
        return view;
    }
}
