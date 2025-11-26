package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.by */
/* loaded from: classes.dex */
class C3126by implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11359a;

    C3126by(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11359a = profileImageHistoryFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) throws Throwable {
        C3250y.m11456e("mProfileListView Position: " + i, getClass().getSimpleName());
        ProfileImageHistoryFragment.ProfileImageItem profileImageItem = (ProfileImageHistoryFragment.ProfileImageItem) view.getTag();
        C3250y.m11456e("mProfileListView view: " + profileImageItem.f11265id, getClass().getSimpleName());
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f11359a.f11217S);
        if (this.f11359a.f11234ai || j != 0) {
            this.f11359a.f11247g.setImageBitmap(null);
            this.f11359a.f11224Z = profileImageItem.imageId;
            this.f11359a.f11210L = profileImageItem.f11265id;
            this.f11359a.f11226aa = i;
            ProfileImageHistoryActivity.f11195a = profileImageItem.imageId;
            this.f11359a.f11231af.m10781c().mo11583a(((Object) this.f11359a.getText(R.string.mypage_profile_image)) + " (" + this.f11359a.f11226aa + "/" + this.f11359a.f11227ab + ")");
            this.f11359a.m10808a(this.f11359a.f11224Z);
            this.f11359a.f11208J.m11732a(this.f11359a.f11247g);
            this.f11359a.m10810a(this.f11359a.f11224Z, profileImageItem.f11265id, false);
            if (C3250y.f11733a) {
                C3250y.m11456e("item.id :" + profileImageItem.f11265id, getClass().getSimpleName());
                C3250y.m11456e("dirCachePath+FullfileName : " + profileImageItem.dirCachePath + profileImageItem.FullfileName, getClass().getSimpleName());
            }
            if (this.f11359a.f11223Y.equals(this.f11359a.f11224Z)) {
                this.f11359a.f11233ah = R.array.profile_image_long_click_main;
                if (C3250y.f11734b) {
                    C3250y.m11450b("profile_image_long_click_main", ProfileImageHistoryFragment.f11196d);
                }
            } else {
                this.f11359a.f11233ah = R.array.profile_image_long_click;
                if (C3250y.f11734b) {
                    C3250y.m11450b("profile_image_long_click", ProfileImageHistoryFragment.f11196d);
                }
            }
            abstractC3271aM11494a.mo11495a(R.string.mypage_profile_image).mo11497a(this.f11359a.f11233ah, this.f11359a.f11239an);
            this.f11359a.f11232ag = abstractC3271aM11494a.mo11505a();
            this.f11359a.f11232ag.show();
            return false;
        }
        return true;
    }
}
