package com.sec.chaton.settings;

import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;

/* renamed from: com.sec.chaton.settings.ap */
/* loaded from: classes.dex */
class C0467ap implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ RelationHideActivity f3159a;

    C0467ap(RelationHideActivity relationHideActivity) {
        this.f3159a = relationHideActivity;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 != 1) {
                Toast.makeText(this.f3159a.f3103g, this.f3159a.getResources().getString(C0062R.string.buddy_profile_saveprofile_toast_failed), 1).show();
                return;
            }
            this.f3159a.f3100d = this.f3159a.f3107k.query(ChatONContract.BuddyTable.f1713a, null, "buddy_relation_hide = 'Y' ", null, null);
            if (this.f3159a.f3100d.getCount() == 0) {
                this.f3159a.f3104h.setVisibility(8);
                this.f3159a.f3108l.setVisibility(0);
            }
            this.f3159a.m3202a(this.f3159a.f3100d);
            this.f3159a.f3106j.notifyDataSetChanged();
        }
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) {
    }
}
