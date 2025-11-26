package com.sec.chaton.multimedia.doc;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
public class FileExplorerActivity extends BaseActivity implements Comparator {

    /* renamed from: b */
    private static final String f3308b = FileExplorerActivity.class.getSimpleName();

    /* renamed from: m */
    private static HashMap f3309m = new HashMap();

    /* renamed from: n */
    private static HashMap f3310n = new HashMap();

    /* renamed from: a */
    ListView f3311a;

    /* renamed from: c */
    private ArrayList f3312c;

    /* renamed from: d */
    private C0907d f3313d;

    /* renamed from: e */
    private String f3314e;

    /* renamed from: i */
    private String f3315i;

    /* renamed from: j */
    private TextView f3316j;

    /* renamed from: k */
    private Stack f3317k = new Stack();

    /* renamed from: l */
    private LinearLayout f3318l;

    static {
        m3630a("pdf", EnumC0905b.PDF, MimeTypeMap.getSingleton().getMimeTypeFromExtension("pdf"));
        m3630a("gul", EnumC0905b.GUL, "application/jungumword");
        m3630a("hwp", EnumC0905b.HWP, "application/x-hwp");
        m3630a("ppt", EnumC0905b.PPT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("ppt"));
        m3630a("pptx", EnumC0905b.PPT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("pptx"));
        m3630a("doc", EnumC0905b.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("doc"));
        m3630a("docx", EnumC0905b.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("docx"));
        m3630a("xls", EnumC0905b.XLS, MimeTypeMap.getSingleton().getMimeTypeFromExtension("xls"));
        m3630a("xlsx", EnumC0905b.XLS, MimeTypeMap.getSingleton().getMimeTypeFromExtension("xlsx"));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_multimedia_file_explorer);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f3316j = (TextView) findViewById(R.id.file_path);
        this.f3311a = (ListView) findViewById(R.id.file_list);
        this.f3312c = new ArrayList();
        this.f3313d = new C0907d(this, R.layout.layout_file_list_item, this.f3312c);
        this.f3311a.setAdapter((ListAdapter) this.f3313d);
        this.f3314e = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f3315i = this.f3314e;
        this.f3316j.setText(this.f3314e);
        this.f3316j.setSelected(true);
        this.f3318l = (LinearLayout) findViewById(R.id.vcal_events_noresult);
        m3636c(this.f3314e);
        this.f3311a.setOnItemClickListener(new C0904a(this));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle(R.string.menu_multimedia_file);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_file, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_file /* 2131494124 */:
                if (this.f3316j.getText().toString().lastIndexOf("/") > 5 && !this.f3317k.isEmpty()) {
                    this.f3314e = (String) this.f3317k.pop();
                    this.f3316j.setText(this.f3314e);
                    m3636c(this.f3314e);
                    break;
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3636c(String str) {
        File[] fileArrListFiles;
        if (C1786r.f6452b) {
            C1786r.m6061b("strPath: " + str, f3308b);
        }
        File file = new File(str);
        this.f3312c.clear();
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                EnumC0905b enumC0905bM3625a = m3625a(file2);
                if (enumC0905bM3625a != EnumC0905b.UNKNOWN) {
                    C0906c c0906c = new C0906c();
                    c0906c.m3642a(enumC0905bM3625a);
                    c0906c.m3643a(file2.getName());
                    c0906c.m3641a(file2.length());
                    c0906c.m3645b(file2.lastModified());
                    c0906c.m3646b(file2.getAbsolutePath());
                    if (C1786r.f6452b) {
                        C1786r.m6061b("file item: " + c0906c.toString(), f3308b);
                    }
                    this.f3312c.add(c0906c);
                }
            }
        }
        if (this.f3312c.size() > 0) {
            this.f3311a.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f3318l.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            Collections.sort(this.f3312c, this);
            this.f3313d.notifyDataSetChanged();
            return;
        }
        this.f3311a.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f3318l.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* renamed from: a */
    private EnumC0905b m3625a(File file) {
        String strSubstring;
        EnumC0905b enumC0905bM3631b;
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                return EnumC0905b.DIRECTORY;
            }
            try {
                strSubstring = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            } catch (Exception e) {
                strSubstring = null;
            }
            if (strSubstring != null && (enumC0905bM3631b = m3631b(strSubstring)) != null) {
                return enumC0905bM3631b;
            }
        }
        return EnumC0905b.UNKNOWN;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        System.out.println("Manju FileExplorerActivity.onKeyDown()");
        if (i == 4) {
            if (!this.f3317k.isEmpty()) {
                this.f3314e = (String) this.f3317k.pop();
                this.f3316j.setText(this.f3314e);
                if (C1786r.f6452b) {
                    C1786r.m6061b("mCurrrentPath: " + this.f3314e, f3308b);
                }
                m3636c(this.f3314e);
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0906c c0906c, C0906c c0906c2) {
        if (!(c0906c.m3640a() == EnumC0905b.DIRECTORY && c0906c2.m3640a() == EnumC0905b.DIRECTORY) && (c0906c.m3640a() == EnumC0905b.DIRECTORY || c0906c2.m3640a() == EnumC0905b.DIRECTORY)) {
            return c0906c.m3640a() == EnumC0905b.DIRECTORY ? -1 : 1;
        }
        return c0906c.m3644b().compareTo(c0906c2.m3644b());
    }

    /* renamed from: a */
    static void m3630a(String str, EnumC0905b enumC0905b, String str2) {
        f3309m.put(str, str2);
        f3310n.put(str, enumC0905b);
    }

    /* renamed from: a */
    public static String m3628a(String str) {
        return (String) f3309m.get(str);
    }

    /* renamed from: b */
    public static EnumC0905b m3631b(String str) {
        return (EnumC0905b) f3310n.get(str);
    }

    /* renamed from: a */
    public static String m3626a() {
        StringBuilder sb = new StringBuilder();
        Iterator it = f3309m.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) f3309m.get((String) it.next()));
            sb.append(";");
        }
        return sb.toString();
    }
}
