package com.sec.chaton.settings.tellfriends;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.C2153y;
import weibo4android.WeiboException;

/* compiled from: WeiboMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dn */
/* loaded from: classes.dex */
public class AsyncTaskC1440dn extends AsyncTask {

    /* renamed from: b */
    boolean f5331b;

    /* renamed from: c */
    boolean f5332c;

    /* renamed from: d */
    final /* synthetic */ WeiboMessageActivity f5333d;

    /* renamed from: a */
    ProgressDialog f5330a = null;

    /* renamed from: e */
    private ProgressDialog f5334e = null;

    public AsyncTaskC1440dn(WeiboMessageActivity weiboMessageActivity) {
        this.f5333d = weiboMessageActivity;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f5331b = false;
        this.f5332c = false;
        EditText editText = (EditText) this.f5333d.findViewById(R.id.edit_text_input);
        this.f5333d.f5114d = editText.getText().toString();
        this.f5334e = (ProgressDialog) new C1805i(this.f5333d.f5111a).m6139a(R.string.facebook_post_wait);
        this.f5334e.setCancelable(false);
        this.f5334e.setOnKeyListener(new DialogInterfaceOnKeyListenerC1441do(this));
        this.f5334e.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        if (this.f5333d.f5118h == null) {
            this.f5333d.f5118h = C1472u.m5199a().m5203b();
        }
        try {
            if (!this.f5331b) {
                this.f5333d.f5118h.updateStatus(this.f5333d.f5114d);
                return str;
            }
            this.f5332c = true;
            return str;
        } catch (WeiboException e) {
            e.printStackTrace();
            this.f5333d.finish();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws Resources.NotFoundException {
        String string;
        if (!this.f5332c) {
            if (this.f5334e != null && this.f5334e.isShowing()) {
                this.f5334e.dismiss();
                this.f5334e = null;
            }
            if (str != null) {
                string = this.f5333d.getResources().getString(R.string.facebook_post_completed);
            } else {
                string = this.f5333d.getResources().getString(R.string.facebook_post_failed);
            }
            C2153y.m7536a(this.f5333d, string, 0).show();
        }
        this.f5333d.f5112b = null;
        this.f5333d.finish();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }
}
