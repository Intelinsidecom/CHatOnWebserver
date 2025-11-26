package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.C0062R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class InsertSound extends Activity {

    /* renamed from: a */
    Context f2033a;

    /* renamed from: b */
    ListView f2034b;

    /* renamed from: e */
    private ArrayList f2035e = new ArrayList();

    /* renamed from: d */
    private static final String f2032d = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: c */
    public static String f2031c = "extra fileuri";

    /* renamed from: b */
    private void m2453b() {
        File[] fileArrListFiles = new File(f2032d).listFiles(new C0283n(this));
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            this.f2035e.add(file.getName());
        }
        Collections.sort(this.f2035e);
        this.f2034b.setAdapter((ListAdapter) new AudioListAdapter(this.f2033a, C0062R.layout.list_audio, this.f2035e));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_list_audio);
        this.f2033a = this;
        this.f2034b = (ListView) findViewById(C0062R.id.audio_list);
        this.f2034b.setOnItemClickListener(new C0272c(this));
        m2453b();
    }
}
