package com.sec.chaton.settings.tellfriends;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bq */
/* loaded from: classes.dex */
public class AsyncTaskC1389bq extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5240a;

    public AsyncTaskC1389bq(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5240a = tWFollowingsListActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Object... objArr) throws Resources.NotFoundException, NumberFormatException, IOException {
        String str = (String) objArr[0];
        ImageView imageView = (ImageView) objArr[1];
        int i = Integer.parseInt((String) objArr[2]);
        if (this.f5240a.f5015a != null) {
            Message messageObtainMessage = this.f5240a.f5015a.obtainMessage();
            messageObtainMessage.what = 9002;
            Bundle bundle = new Bundle();
            try {
                InputStream inputStream = (InputStream) new URL(str).getContent();
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStream, "srcName");
                inputStream.close();
                if (drawableCreateFromStream == null) {
                    drawableCreateFromStream = this.f5240a.getResources().getDrawable(R.drawable.contacts_default_image);
                }
                ((C1383bk) this.f5240a.f5019f.get(i)).f5223a = drawableCreateFromStream;
                bundle.putInt("Key_Position", i);
                messageObtainMessage.obj = imageView;
                C1786r.m6061b("doInBackground() \t- Position : " + i, getClass().getSimpleName());
            } catch (Exception e) {
                C1786r.m6054a("doInBackground() \t- Error", getClass().getSimpleName());
                e.printStackTrace();
                bundle.putInt("Key_Position", -1);
                messageObtainMessage.obj = null;
            }
            messageObtainMessage.setData(bundle);
            if (this.f5240a.f5015a != null) {
                this.f5240a.f5015a.sendMessage(messageObtainMessage);
            }
        }
        return null;
    }
}
