package com.sec.chaton.userprofile;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bl */
/* loaded from: classes.dex */
class AsyncTaskC3113bl extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11327a;

    AsyncTaskC3113bl(MyPageFragment myPageFragment, File file, Uri uri) {
        this.f11327a = myPageFragment;
        myPageFragment.f11129aG = file;
        myPageFragment.f11130aH = uri;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[CoverStory] doInBackground()", MyPageFragment.f11095a);
        }
        C1561g.m6628a().m6630a(this.f11327a.f11145aW, this.f11327a.f11129aG, EnumC1455w.IMAGE, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        super.onPostExecute(r3);
        if (C3250y.f11734b) {
            C3250y.m11450b("[CoverStory] onPostExecute()", MyPageFragment.f11095a);
        }
    }
}
