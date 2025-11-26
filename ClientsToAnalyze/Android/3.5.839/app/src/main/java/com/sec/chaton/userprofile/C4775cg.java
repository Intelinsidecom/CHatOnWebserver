package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import java.io.IOException;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cg */
/* loaded from: classes.dex */
class C4775cg implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17493a;

    C4775cg(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17493a = profileImageHistoryFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws IOException {
        if (C4904y.f17872b) {
            C4904y.m18639b("OnItemClickListener", getClass().getSimpleName());
            C4904y.m18639b("mProfileListView Position: " + i, getClass().getSimpleName());
        }
        ProfileImageHistoryFragment.ProfileImageItem profileImageItem = (ProfileImageHistoryFragment.ProfileImageItem) view.getTag();
        C4904y.m18646e("mProfileListView view: " + profileImageItem.f17357id, getClass().getSimpleName());
        if (this.f17493a.f17325ao || j != 0) {
            if (this.f17493a.f17316af != i) {
                this.f17493a.f17339g.setImageBitmap(null);
                this.f17493a.f17315ae = profileImageItem.imageId;
                this.f17493a.f17295L = profileImageItem.f17357id;
                this.f17493a.setHasOptionsMenu(true);
                if (this.f17493a.f17324an) {
                    ((ActionBarFragmentActivity) this.f17493a.getActivity()).mo51u_();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mIsFirstOptionMenuOpen = true", ProfileImageHistoryFragment.f17281d);
                    }
                    this.f17493a.f17324an = false;
                }
                if (this.f17493a.f17325ao) {
                    i++;
                }
                this.f17493a.f17316af = i;
                ProfileImageHistoryActivity.f17280n = profileImageItem.imageId;
                this.f17493a.f17321ak.m17933h().mo18823a(((Object) this.f17493a.getText(R.string.mypage_profile_image)) + " (" + this.f17493a.f17316af + "/" + this.f17493a.f17317ag + ")");
                this.f17493a.m17962a(this.f17493a.f17315ae);
                this.f17493a.f17293J.m19015a((View) this.f17493a.f17339g);
                this.f17493a.m17964a(this.f17493a.f17315ae, profileImageItem.f17357id, false);
                C4904y.m18646e("item.id :" + profileImageItem.f17357id, getClass().getSimpleName());
                C4904y.m18646e("dirCachePath+FullfileName : " + profileImageItem.dirCachePath + profileImageItem.FullfileName, getClass().getSimpleName());
                return;
            }
            return;
        }
        if (this.f17493a.f17317ag >= this.f17493a.f17318ah) {
            if (this.f17493a.f17311aa == null) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f17493a.f17302S);
                abstractC4932aM18733a.mo18734a(R.string.mypage_profile_add_photo).mo18746b(R.string.mypage_maximum_image_exceed).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4776ch(this));
                this.f17493a.f17311aa = abstractC4932aM18733a.mo18745a();
            }
            this.f17493a.f17311aa.show();
            return;
        }
        this.f17493a.f17344l = false;
        this.f17493a.m18025a();
    }
}
