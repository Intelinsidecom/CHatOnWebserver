package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bu */
/* loaded from: classes.dex */
class C3122bu implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11355a;

    C3122bu(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11355a = profileImageHistoryFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws Throwable {
        C3250y.m11456e("mProfileListView Position: " + i, getClass().getSimpleName());
        ProfileImageHistoryFragment.ProfileImageItem profileImageItem = (ProfileImageHistoryFragment.ProfileImageItem) view.getTag();
        C3250y.m11456e("mProfileListView view: " + profileImageItem.f11265id, getClass().getSimpleName());
        if (this.f11355a.f11234ai || j != 0) {
            this.f11355a.f11247g.setImageBitmap(null);
            this.f11355a.f11224Z = profileImageItem.imageId;
            this.f11355a.f11210L = profileImageItem.f11265id;
            if (this.f11355a.f11234ai) {
                i++;
            }
            this.f11355a.f11226aa = i;
            ProfileImageHistoryActivity.f11195a = profileImageItem.imageId;
            this.f11355a.f11231af.m10781c().mo11583a(((Object) this.f11355a.getText(R.string.mypage_profile_image)) + " (" + this.f11355a.f11226aa + "/" + this.f11355a.f11227ab + ")");
            this.f11355a.m10808a(this.f11355a.f11224Z);
            this.f11355a.f11208J.m11732a(this.f11355a.f11247g);
            this.f11355a.m10810a(this.f11355a.f11224Z, profileImageItem.f11265id, false);
            C3250y.m11456e("item.id :" + profileImageItem.f11265id, getClass().getSimpleName());
            C3250y.m11456e("dirCachePath+FullfileName : " + profileImageItem.dirCachePath + profileImageItem.FullfileName, getClass().getSimpleName());
            return;
        }
        if (this.f11355a.f11227ab >= this.f11355a.f11228ac) {
            if (this.f11355a.f11220V == null) {
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f11355a.f11217S);
                abstractC3271aM11494a.mo11495a(R.string.mypage_profile_add_photo).mo11506b(R.string.mypage_maximum_image_exceed).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3123bv(this));
                this.f11355a.f11220V = abstractC3271aM11494a.mo11505a();
            }
            this.f11355a.f11220V.show();
            return;
        }
        this.f11355a.f11252l = false;
        this.f11355a.m10869a();
    }
}
