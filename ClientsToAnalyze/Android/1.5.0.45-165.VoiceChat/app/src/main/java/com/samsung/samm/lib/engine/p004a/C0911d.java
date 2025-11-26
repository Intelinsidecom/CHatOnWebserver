package com.samsung.samm.lib.engine.p004a;

import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* renamed from: com.samsung.samm.lib.engine.a.d */
/* loaded from: classes.dex */
public class C0911d {

    /* renamed from: a */
    final MediaRecorder f656a = new MediaRecorder();

    /* renamed from: b */
    final String f657b;

    public C0911d(String str) {
        this.f657b = m660a(str);
    }

    /* renamed from: a */
    private String m660a(String str) {
        if (!str.startsWith("/")) {
            return "/" + str;
        }
        return str;
    }

    /* renamed from: a */
    public void m661a() throws IllegalStateException, IOException, IllegalArgumentException {
        String externalStorageState = Environment.getExternalStorageState();
        if (!externalStorageState.equals("mounted")) {
            throw new IOException("SD Card is not mounted.  It is " + externalStorageState + ".");
        }
        File parentFile = new File(this.f657b).getParentFile();
        if (parentFile == null) {
            Log.e("AMSLib", "AnimationAudioRecorder : directory is null");
            return;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Path to file could not be created.");
        }
        this.f656a.setAudioSource(1);
        this.f656a.setOutputFormat(1);
        this.f656a.setAudioEncoder(1);
        this.f656a.setMaxFileSize(6291456L);
        this.f656a.setOutputFile(this.f657b);
        this.f656a.prepare();
        this.f656a.start();
    }

    /* renamed from: b */
    public void m662b() throws IllegalStateException, IOException {
        this.f656a.stop();
        this.f656a.release();
    }
}
