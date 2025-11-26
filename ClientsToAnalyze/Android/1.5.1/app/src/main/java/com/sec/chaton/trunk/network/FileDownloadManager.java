package com.sec.chaton.trunk.network;

import android.net.Uri;
import android.os.Handler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FileDownloadManager {
    private static final String TAG = FileDownloadManager.class.getSimpleName();
    private static FileDownloadManager instance;
    private Map mapper = new HashMap();

    private FileDownloadManager() {
    }

    public static FileDownloadManager getInstance() {
        if (instance == null) {
            instance = new FileDownloadManager();
        }
        return instance;
    }

    public synchronized Uri cache(String str, String str2) {
        return new File(str, str2).exists() ? Uri.parse(str + File.separator + str2) : null;
    }

    public FileDownloadTask download(Handler handler, String str, String str2, String str3, Object obj) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(handler, str, str2, str3, false, obj);
        fileDownloadTask.execute(new Void[0]);
        return fileDownloadTask;
    }

    public Map getMapper() {
        return this.mapper;
    }
}
