package com.sds.coolots.call;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ChangeRingtone implements ChangeRingtoneInterface {

    /* renamed from: a */
    private static final String f2323a = "[ChangeRingtone]";

    /* renamed from: b */
    private static ChangeRingtoneInterface f2324b = new ChangeRingtone();

    private ChangeRingtone() {
    }

    /* renamed from: a */
    private static void m2102a(String str) {
        Log.m2963i(f2323a + str);
    }

    /* renamed from: b */
    private static void m2103b(String str) {
        Log.m2958e(f2323a + str);
    }

    public static ChangeRingtoneInterface getChangeRingtone() {
        return f2324b;
    }

    public static ArrayList getRingtoneList() {
        m2102a("getRingtoneList()");
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        int i = 0;
        try {
            RingtoneManager ringtoneManager = new RingtoneManager(MainApplication.mContext.getApplicationContext());
            ringtoneManager.setType(1);
            ringtoneManager.setIncludeDrm(true);
            cursor = ringtoneManager.getCursor();
            cursor.moveToFirst();
            do {
                String string = cursor.getString(cursor.getColumnIndex(SlookSmartClipMetaTag.TAG_TYPE_TITLE));
                m2103b("getRingtoneList - Index : " + i + ", Title : " + string);
                arrayList.add(string);
                i++;
            } while (cursor.moveToNext());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.res.AssetFileDescriptor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // com.sds.coolots.call.ChangeRingtoneInterface
    public MediaPlayer setChatONVDefaultRingtone(MediaPlayer mediaPlayer) throws Throwable {
        m2102a("setChatONDefaultRingtone()");
        int rawRingtone = MainApplication.mResources.getRawRingtone();
        ?? r1 = 0;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                mediaPlayer.setAudioStreamType(2);
                mediaPlayer.setLooping(true);
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = MainApplication.mContext.getResources().openRawResourceFd(rawRingtone);
                try {
                    FileDescriptor fileDescriptor = assetFileDescriptorOpenRawResourceFd.getFileDescriptor();
                    mediaPlayer.setDataSource(fileDescriptor, assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                    r1 = fileDescriptor;
                    if (assetFileDescriptorOpenRawResourceFd != null) {
                        try {
                            assetFileDescriptorOpenRawResourceFd.close();
                            r1 = fileDescriptor;
                        } catch (IOException e) {
                            e.printStackTrace();
                            r1 = fileDescriptor;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    e.printStackTrace();
                    r1 = assetFileDescriptor;
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                            r1 = assetFileDescriptor;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            r1 = assetFileDescriptor;
                        }
                    }
                    return mediaPlayer;
                } catch (Throwable th) {
                    th = th;
                    r1 = assetFileDescriptorOpenRawResourceFd;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            return mediaPlayer;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.sds.coolots.call.ChangeRingtoneInterface
    public MediaPlayer setDeviceDefaultRingtone(MediaPlayer mediaPlayer) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        m2102a("setDeviceDefaultRingtone()");
        Uri defaultUri = RingtoneManager.getDefaultUri(1);
        if (defaultUri != null) {
            try {
                mediaPlayer.setDataSource(MainApplication.mContext, defaultUri);
                mediaPlayer.setAudioStreamType(2);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            } catch (SecurityException e4) {
                e4.printStackTrace();
            }
        }
        return mediaPlayer;
    }

    @Override // com.sds.coolots.call.ChangeRingtoneInterface
    public MediaPlayer setUserPersonalRingtone(String str, MediaPlayer mediaPlayer) throws Throwable {
        m2102a("setUserPersonalRingtone() - uriPath : " + str);
        Uri uri = Uri.parse(str);
        if (uri != null) {
            try {
                mediaPlayer.setDataSource(MainApplication.mContext, uri);
                mediaPlayer.setAudioStreamType(2);
                mediaPlayer.setLooping(true);
            } catch (Exception e) {
                m2102a("setUserPersonalRingtone() - setDataSource fail >>> setChatONVDefaultRingtone");
                setChatONVDefaultRingtone(mediaPlayer);
                e.printStackTrace();
            }
        }
        return mediaPlayer;
    }

    @Override // com.sds.coolots.call.ChangeRingtoneInterface
    public MediaPlayer setUserSelectedRingtone(int i, MediaPlayer mediaPlayer) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        m2102a("setUserSelectedRingtone() : " + i);
        if (i == -1) {
            mediaPlayer.setAudioStreamType(0);
            m2102a("User selected Ringtone - Silent");
        } else {
            try {
                RingtoneManager ringtoneManager = new RingtoneManager(MainApplication.mContext.getApplicationContext());
                ringtoneManager.setType(1);
                ringtoneManager.setIncludeDrm(true);
                ringtoneManager.getCursor();
                ringtoneManager.getRingtone(i);
                Uri ringtoneUri = ringtoneManager.getRingtoneUri(i);
                if (ringtoneUri != null) {
                    m2102a("User selected Ringtone URI : " + ringtoneUri.toString());
                    mediaPlayer.setDataSource(MainApplication.mContext, ringtoneUri);
                    mediaPlayer.setAudioStreamType(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mediaPlayer;
    }
}
