package com.sec.chaton.interlocked;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.HandleIntent;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;

/* loaded from: classes.dex */
public class InterlockedImage implements InterlockWithNative {

    /* renamed from: a */
    private Intent f1912a;

    public InterlockedImage(Intent intent) {
        this.f1912a = intent;
    }

    @Override // com.sec.chaton.interlocked.InterlockWithNative
    /* renamed from: a */
    public HandleIntent.IntentDest mo2391a() {
        this.f1912a.putExtra("callForward", true);
        this.f1912a.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, ChatONContract.MessageTable.MsgContentType.IMAGE.m2197a());
        Uri uri = (Uri) this.f1912a.getExtras().get("android.intent.extra.STREAM");
        if (uri.getScheme() != null && uri.getScheme().equals(DatabaseConstant.TrunkCommentColumns.KEY_CONTENT)) {
            Cursor cursorQuery = GlobalApplication.m2387e().getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    this.f1912a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                    return HandleIntent.IntentDest.FORWARD;
                }
                File file = StorageStateInfoUtil.m3677a() ? new File(GlobalApplication.m2387e().getExternalCacheDir() + "/tmp/") : new File(GlobalApplication.m2387e().getCacheDir() + "/tmp/");
                if (!file.exists()) {
                    file.mkdir();
                }
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = GlobalApplication.m2387e().getContentResolver().openAssetFileDescriptor(uri, "r");
                Bitmap bitmapM3530a = ChatOnGraphics.m3530a(GlobalApplication.m2387e(), uri, (int) assetFileDescriptorOpenAssetFileDescriptor.getLength());
                String str = System.currentTimeMillis() + "jpeg";
                ChatOnGraphics.m3538a(bitmapM3530a, file, str, Bitmap.CompressFormat.JPEG, 100);
                assetFileDescriptorOpenAssetFileDescriptor.close();
                File file2 = new File(file, str);
                if (file2.exists()) {
                    this.f1912a.putExtra("download_uri", Uri.fromFile(file2).toString());
                    return HandleIntent.IntentDest.FORWARD;
                }
            } catch (Exception e) {
                return HandleIntent.IntentDest.HOME;
            } finally {
                cursorQuery.close();
            }
        } else if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f1912a.putExtra("download_uri", uri.toString());
            return HandleIntent.IntentDest.FORWARD;
        }
        return HandleIntent.IntentDest.HOME;
    }
}
