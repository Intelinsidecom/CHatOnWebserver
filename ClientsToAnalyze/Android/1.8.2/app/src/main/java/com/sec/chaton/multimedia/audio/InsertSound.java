package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class InsertSound extends Activity {

    /* renamed from: a */
    Context f3204a;

    /* renamed from: b */
    ListView f3205b;

    /* renamed from: e */
    private ArrayList f3206e = new ArrayList();

    /* renamed from: d */
    private static final String f3203d = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: c */
    public static String f3202c = "extra fileuri";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_list_audio);
        this.f3204a = this;
        this.f3205b = (ListView) findViewById(R.id.audio_list);
        this.f3205b.setOnItemClickListener(new C0872b(this));
        m3548b();
    }

    /* renamed from: b */
    private void m3548b() {
        File[] fileArrListFiles = new File(f3203d).listFiles(new C0873c(this));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                this.f3206e.add(file.getName());
            }
            Collections.sort(this.f3206e);
            this.f3205b.setAdapter((ListAdapter) new C0871a(this.f3204a, R.layout.list_audio, this.f3206e));
        }
    }
}
