package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.o */
/* loaded from: classes.dex */
class C0122o implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f703a;

    C0122o(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f703a = buddyGroupEditActivity;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                ChatONLogWriter.m3512f("onUpdateComplete()", BuddyGroupEditActivity.f487a);
                ChatONLogWriter.m3512f(this.f703a.f492E.toString() + " : " + this.f703a.f492E.getVisibility(), BuddyGroupEditActivity.f487a);
                this.f703a.f492E.setVisibility(8);
                ChatONLogWriter.m3512f(this.f703a.f492E.toString() + " : " + this.f703a.f492E.getVisibility(), BuddyGroupEditActivity.f487a);
                Toast.makeText(this.f703a.f514l, C0062R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
                this.f703a.f509g.m665a((String) obj);
                this.f703a.f515m.setText(this.f703a.f509g.m666b());
                this.f703a.f490C.setText(this.f703a.f509g.m666b());
                ChatONLogWriter.m3512f(this.f703a.f490C.toString() + " : " + this.f703a.f490C.getVisibility(), BuddyGroupEditActivity.f487a);
                this.f703a.f490C.setVisibility(0);
                ChatONLogWriter.m3512f(this.f703a.f490C.toString() + " : " + this.f703a.f490C.getVisibility(), BuddyGroupEditActivity.f487a);
            }
            this.f703a.m567f();
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
