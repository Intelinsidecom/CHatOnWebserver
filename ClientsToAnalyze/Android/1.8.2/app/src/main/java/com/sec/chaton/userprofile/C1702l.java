package com.sec.chaton.userprofile;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p010a.C0257c;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.l */
/* loaded from: classes.dex */
class C1702l implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6213a;

    C1702l(MyPageFragment myPageFragment) {
        this.f6213a = myPageFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f6213a.f5854u != null && this.f6213a.f5854u.size() > 0) {
            String strM2318a = ((C0257c) this.f6213a.f5854u.get(i)).m2318a();
            if (!TextUtils.isEmpty(strM2318a)) {
                this.f6213a.f5815C = true;
                Intent intent = new Intent(this.f6213a.getActivity(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", strM2318a);
                this.f6213a.startActivity(intent);
            }
        }
    }
}
