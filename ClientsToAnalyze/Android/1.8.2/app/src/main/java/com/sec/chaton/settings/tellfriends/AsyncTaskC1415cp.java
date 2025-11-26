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

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cp */
/* loaded from: classes.dex */
public class AsyncTaskC1415cp extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5281a;

    public AsyncTaskC1415cp(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5281a = tellFriendsWeiboActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Object... objArr) throws Resources.NotFoundException, NumberFormatException, IOException {
        String str = (String) objArr[0];
        ImageView imageView = (ImageView) objArr[1];
        int i = Integer.parseInt((String) objArr[2]);
        Message messageObtainMessage = this.f5281a.f5056a.obtainMessage();
        messageObtainMessage.what = 9002;
        Bundle bundle = new Bundle();
        try {
            InputStream inputStream = (InputStream) new URL(str).getContent();
            Drawable drawableCreateFromStream = Drawable.createFromStream(inputStream, "srcName");
            if (inputStream != null) {
                inputStream.close();
            }
            if (drawableCreateFromStream == null) {
                drawableCreateFromStream = this.f5281a.getResources().getDrawable(R.drawable.contacts_default_image);
            }
            ((C1417cr) this.f5281a.f5060f.get(i)).f5287b = drawableCreateFromStream;
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
        this.f5281a.f5056a.sendMessage(messageObtainMessage);
        return null;
    }
}
