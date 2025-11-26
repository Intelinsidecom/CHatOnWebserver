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
    Context f2601a;

    /* renamed from: b */
    ListView f2602b;

    /* renamed from: e */
    private ArrayList f2603e = new ArrayList();

    /* renamed from: d */
    private static final String f2600d = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: c */
    public static String f2599c = "extra fileuri";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_list_audio);
        this.f2601a = this;
        this.f2602b = (ListView) findViewById(R.id.audio_list);
        this.f2602b.setOnItemClickListener(new C0772i(this));
        m3208b();
    }

    /* renamed from: b */
    private void m3208b() {
        File[] fileArrListFiles = new File(f2600d).listFiles(new C0783t(this));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                this.f2603e.add(file.getName());
            }
            Collections.sort(this.f2603e);
            this.f2602b.setAdapter((ListAdapter) new C0763a(this.f2601a, R.layout.list_audio, this.f2603e));
        }
    }
}
