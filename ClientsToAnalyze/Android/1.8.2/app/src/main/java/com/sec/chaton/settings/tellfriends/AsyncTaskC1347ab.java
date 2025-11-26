package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.Timer;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ab */
/* loaded from: classes.dex */
public class AsyncTaskC1347ab extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5154a;

    public AsyncTaskC1347ab(OauthSignin oauthSignin) {
        this.f5154a = oauthSignin;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (this.f5154a.f4979j == null) {
            this.f5154a.f4979j = new Timer();
        } else {
            C1786r.m6063c("mTimer.purge()", getClass().getSimpleName());
            this.f5154a.f4979j.cancel();
            this.f5154a.f4979j = null;
            this.f5154a.f4979j = new Timer();
        }
        this.f5154a.f4979j.schedule(new C1349ad(this.f5154a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String token;
        String str = strArr[0];
        String str2 = strArr[1];
        this.f5154a.f4972b = new TwitterFactory().getInstance();
        this.f5154a.f4972b.setOAuthConsumer(str, str2);
        try {
            try {
                token = this.f5154a.f4972b.getOAuthRequestToken().getToken();
            } catch (TwitterException e) {
                e.printStackTrace();
                this.f5154a.f4976f.sendEmptyMessage(9001);
                token = "";
            }
            return token;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (str == null) {
            if (this.f5154a.f4980k == null) {
                this.f5154a.f4980k = new AlertDialogBuilderC2120a(this.f5154a.f4978i).setTitle(this.f5154a.getResources().getString(R.string.toast_error)).setMessage(this.f5154a.getResources().getString(R.string.toast_network_unable)).setCancelable(false).setPositiveButton(this.f5154a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1348ac(this)).create();
            }
            try {
                this.f5154a.f4980k.show();
                if (this.f5154a.f4977h != null) {
                    this.f5154a.f4977h.dismiss();
                    this.f5154a.f4977h = null;
                    return;
                }
                return;
            } catch (Exception e) {
                C1786r.m6054a("Caught Exception in mProgressDialog.dismiss()", getClass().getSimpleName());
                return;
            }
        }
        if (str.equals("")) {
            C1786r.m6054a("Incorrect Request Token!", getClass().getSimpleName());
        } else {
            this.f5154a.m4831a(str);
        }
    }
}
