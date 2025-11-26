package com.sec.chaton.settings.tellfriends;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.C2153y;
import weibo4android.WeiboException;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cm */
/* loaded from: classes.dex */
public class AsyncTaskC1412cm extends AsyncTask {

    /* renamed from: a */
    boolean f5276a;

    /* renamed from: b */
    boolean f5277b;

    /* renamed from: c */
    final /* synthetic */ TellFriendsWeiboActivity f5278c;

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f5276a = false;
        this.f5277b = false;
        this.f5278c.f5057c = (ProgressDialog) new C1805i(this.f5278c.f5065k).m6139a(R.string.dialog_connecting_server);
        this.f5278c.f5057c.setCancelable(false);
        this.f5278c.f5057c.setOnKeyListener(new DialogInterfaceOnKeyListenerC1413cn(this));
        this.f5278c.f5057c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws Resources.NotFoundException {
        String str = strArr[0];
        String string = this.f5278c.getResources().getString(R.string.tellfriends_post_message);
        if (!string.contains("www.ChatON.com/invite.html") && string.contains("www.ChatON.com")) {
            string = string.replace("www.ChatON.com", "http://www.ChatON.com/invite.html");
        }
        String str2 = "@" + str + " " + string;
        C1786r.m6063c(str2, getClass().getSimpleName());
        try {
            if (!this.f5276a) {
                this.f5278c.f5058d.updateStatus(str2);
            } else {
                this.f5277b = true;
            }
            return str;
        } catch (WeiboException e) {
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
        if (!this.f5277b) {
            if (this.f5278c.f5057c != null && this.f5278c.f5057c.isShowing()) {
                this.f5278c.f5057c.dismiss();
                this.f5278c.f5057c = null;
            }
            if (str != null) {
                string = this.f5278c.getResources().getString(R.string.tellfriends_twitter_invite_posted);
            } else {
                string = this.f5278c.getResources().getString(R.string.facebook_post_failed);
            }
            C2153y.m7536a(this.f5278c, string, 0).show();
        }
        this.f5278c.f5052E = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f5278c.f5053F != null) {
            this.f5278c.f5053F.dismiss();
        }
    }
}
