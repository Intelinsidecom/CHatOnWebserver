package com.sec.chaton.interlocked;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.HandleIntent;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.database.DatabaseConstant;
import java.io.File;

/* loaded from: classes.dex */
public class InterlockedAudio implements InterlockWithNative {

    /* renamed from: a */
    private Intent f1909a;

    public InterlockedAudio(Intent intent) {
        this.f1909a = intent;
    }

    @Override // com.sec.chaton.interlocked.InterlockWithNative
    /* renamed from: a */
    public HandleIntent.IntentDest mo2391a() {
        this.f1909a.putExtra("callForward", true);
        this.f1909a.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, ChatONContract.MessageTable.MsgContentType.AUDIO.m2197a());
        Uri uri = (Uri) this.f1909a.getExtras().get("android.intent.extra.STREAM");
        if (uri.getScheme() != null && uri.getScheme().equals(DatabaseConstant.TrunkCommentColumns.KEY_CONTENT)) {
            Cursor cursorQuery = GlobalApplication.m2387e().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        this.f1909a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                        return HandleIntent.IntentDest.FORWARD;
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } else if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f1909a.putExtra("download_uri", uri.toString());
            return HandleIntent.IntentDest.FORWARD;
        }
        return HandleIntent.IntentDest.HOME;
    }
}
