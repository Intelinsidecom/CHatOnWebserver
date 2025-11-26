package com.sec.chaton.userprofile;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p010a.C0257c;

/* compiled from: MyPageInteraction.java */
/* renamed from: com.sec.chaton.userprofile.ak */
/* loaded from: classes.dex */
class C1634ak implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageInteraction f6121a;

    C1634ak(MyPageInteraction myPageInteraction) {
        this.f6121a = myPageInteraction;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f6121a.f5907c != null && this.f6121a.f5907c.size() > 0) {
            String strM2318a = ((C0257c) this.f6121a.f5907c.get(i)).m2318a();
            if (!TextUtils.isEmpty(strM2318a)) {
                Intent intent = new Intent(this.f6121a.getActivity(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", strM2318a);
                this.f6121a.startActivity(intent);
            }
        }
    }
}
