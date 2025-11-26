package com.sec.chaton.settings.tellfriends;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.C2153y;
import twitter4j.TwitterException;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bl */
/* loaded from: classes.dex */
public class AsyncTaskC1384bl extends AsyncTask {

    /* renamed from: a */
    boolean f5229a;

    /* renamed from: b */
    boolean f5230b;

    /* renamed from: c */
    final /* synthetic */ TWFollowingsListActivity f5231c;

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f5229a = false;
        this.f5230b = false;
        this.f5231c.f5016c = (ProgressDialog) new C1805i(this.f5231c.f5023j).m6139a(R.string.dialog_connecting_server);
        this.f5231c.f5016c.setCancelable(false);
        this.f5231c.f5016c.setOnKeyListener(new DialogInterfaceOnKeyListenerC1385bm(this));
        this.f5231c.f5016c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws Resources.NotFoundException {
        String str = strArr[0];
        String string = this.f5231c.getResources().getString(R.string.tellfriends_post_message);
        if (!string.contains("www.ChatON.com/invite.html") && string.contains("www.ChatON.com")) {
            string = string.replace("www.ChatON.com", "www.ChatON.com/invite.html");
        }
        String str2 = "@" + str + " " + string;
        C1786r.m6063c(str2, getClass().getSimpleName());
        try {
            if (!this.f5229a) {
                C1437dk.m5166a().m5170d().updateStatus(str2);
            } else {
                this.f5230b = true;
            }
            return str;
        } catch (TwitterException e) {
            C1786r.m6054a("Posting Failed.", getClass().getSimpleName());
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws Resources.NotFoundException {
        String string;
        if (!this.f5230b) {
            if (this.f5231c.f5016c != null && this.f5231c.f5016c.isShowing()) {
                this.f5231c.f5016c.dismiss();
                this.f5231c.f5016c = null;
            }
            if (str != null) {
                string = this.f5231c.getResources().getString(R.string.tellfriends_twitter_invite_posted);
            } else {
                string = this.f5231c.getResources().getString(R.string.facebook_post_failed);
            }
            C2153y.m7536a(this.f5231c, string, 0).show();
        }
        this.f5231c.f5012C = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f5231c.f5013D != null) {
            this.f5231c.f5013D.dismiss();
        }
    }
}
