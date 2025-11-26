package com.sec.chaton.control.task;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.database.helper.BuddyGroupDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.p000io.entry.GetBuddyList;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ProfileImageLoader;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetAllBuddiesTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private Long f1578a;

    public GetAllBuddiesTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws RemoteException, OperationApplicationException {
        if (!httpEntry.m1950a() || httpEntry.m1955d() == null) {
            return;
        }
        GetBuddyList getBuddyList = (GetBuddyList) httpEntry.m1955d();
        this.f1578a = getBuddyList.timestamp;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ChatONLogWriter.m3508c("the number of buddy from Server : " + getBuddyList.buddy.size(), getClass().getSimpleName());
        Iterator it = getBuddyList.buddy.iterator();
        while (it.hasNext()) {
            Buddy buddy = (Buddy) it.next();
            ChatONLogWriter.m3511e("NO : " + buddy.value + ", OrgNumber : " + buddy.orgnum + ", Name : " + buddy.name + ", Deleted : " + buddy.deleted + ", OrgName : " + buddy.orgname, getClass().getSimpleName());
            ChatONLogWriter.m3511e("StatusMsg : " + buddy.status + ", ImageStatus : " + buddy.getImagestatus().toString() + ", BIRTHDAY : " + buddy.birthday + ", showphonenumber=" + buddy.showphonenumber, getClass().getSimpleName());
            if (buddy.deleted.booleanValue()) {
                arrayList.add(BuddyDatabaseHelper.m2222b(buddy));
                arrayList.add(BuddyGroupDatabaseHelper.m2225a(buddy.value));
            } else {
                arrayList.add(BuddyDatabaseHelper.m2217a(buddy));
                if (buddy.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                    ProfileImageLoader.m3610a(GlobalApplication.m2387e()).m3625a(buddy.value);
                }
            }
        }
        GlobalApplication.m2387e().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        ChatONLogWriter.m3508c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", getClass().getSimpleName());
        ContactManager.m404a(GlobalApplication.m2387e(), getBuddyList.buddy);
        ChatONPref.m3522a("get_all_buddies_timestamp", this.f1578a);
        this.f1578a = null;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
