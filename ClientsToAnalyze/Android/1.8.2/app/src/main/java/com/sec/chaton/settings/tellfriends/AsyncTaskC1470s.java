package com.sec.chaton.settings.tellfriends;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.R;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.s */
/* loaded from: classes.dex */
public class AsyncTaskC1470s extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ InviteFacebookActivity f5381a;

    public AsyncTaskC1470s(InviteFacebookActivity inviteFacebookActivity) {
        this.f5381a = inviteFacebookActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Message doInBackground(Object... objArr) throws Resources.NotFoundException, NumberFormatException, IOException {
        String str = (String) objArr[0];
        ImageView imageView = (ImageView) objArr[1];
        int i = Integer.parseInt((String) objArr[2]);
        Message message = new Message();
        try {
            InputStream inputStream = (InputStream) new URL(str).getContent();
            Drawable drawableCreateFromStream = Drawable.createFromStream(inputStream, "srcName");
            inputStream.close();
            if (drawableCreateFromStream == null) {
                drawableCreateFromStream = this.f5381a.getResources().getDrawable(R.drawable.contacts_default_image);
            }
            ((C1373ba) this.f5381a.f4957n.get(i)).f5205d = drawableCreateFromStream;
            message.obj = imageView;
            message.what = i;
        } catch (Exception e) {
            e.printStackTrace();
            message.obj = "image download failed";
        }
        return message;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Message message) {
        this.f5381a.f4954j.sendMessage(message);
    }
}
