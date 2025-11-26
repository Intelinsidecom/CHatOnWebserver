package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import java.io.File;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.ck */
/* loaded from: classes.dex */
class C4779ck implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17497a;

    C4779ck(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17497a = profileImageHistoryFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!C4847bl.m18333a()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("OnItemLongClickListener", getClass().getSimpleName());
                C4904y.m18639b("mProfileListView Position: " + i, getClass().getSimpleName());
            }
            ProfileImageHistoryFragment.ProfileImageItem profileImageItem = (ProfileImageHistoryFragment.ProfileImageItem) view.getTag();
            C4904y.m18646e("mProfileListView view: " + profileImageItem.f17357id, getClass().getSimpleName());
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f17497a.f17302S);
            if (this.f17497a.f17325ao || j != 0) {
                this.f17497a.f17315ae = profileImageItem.imageId;
                this.f17497a.f17295L = profileImageItem.f17357id;
                this.f17497a.f17316af = i;
                ProfileImageHistoryActivity.f17280n = profileImageItem.imageId;
                this.f17497a.setHasOptionsMenu(true);
                if (this.f17497a.f17324an) {
                    ((ActionBarFragmentActivity) this.f17497a.getActivity()).mo51u_();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mIsFirstOptionMenuOpen = true", ProfileImageHistoryFragment.f17281d);
                    }
                    this.f17497a.f17324an = false;
                }
                this.f17497a.f17321ak.m17933h().mo18823a(((Object) this.f17497a.getText(R.string.mypage_profile_image)) + " (" + this.f17497a.f17316af + "/" + this.f17497a.f17317ag + ")");
                this.f17497a.m17962a(this.f17497a.f17315ae);
                this.f17497a.f17293J.m19015a((View) this.f17497a.f17339g);
                this.f17497a.m17964a(this.f17497a.f17315ae, profileImageItem.f17357id, false);
                if (C4904y.f17871a) {
                    C4904y.m18646e("item.id :" + profileImageItem.f17357id, getClass().getSimpleName());
                    C4904y.m18646e("dirCachePath+FullfileName : " + profileImageItem.dirCachePath + profileImageItem.FullfileName, getClass().getSimpleName());
                }
                if (this.f17497a.f17314ad.equals(this.f17497a.f17315ae)) {
                    this.f17497a.f17323am = R.array.profile_image_long_click_main;
                    if (C4904y.f17872b) {
                        C4904y.m18639b("profile_image_long_click_main", ProfileImageHistoryFragment.f17281d);
                    }
                } else {
                    this.f17497a.f17323am = R.array.profile_image_long_click;
                    if (C4904y.f17872b) {
                        C4904y.m18639b("profile_image_long_click", ProfileImageHistoryFragment.f17281d);
                    }
                }
                abstractC4932aM18733a.mo18734a(R.string.mypage_profile_image).mo18736a(this.f17497a.f17323am, this.f17497a.f17331au);
                if (new File(this.f17497a.f17310a, "profile_f_mine_" + this.f17497a.f17315ae).exists()) {
                    this.f17497a.f17322al = abstractC4932aM18733a.mo18745a();
                    this.f17497a.f17322al.show();
                }
            }
        }
        return true;
    }
}
