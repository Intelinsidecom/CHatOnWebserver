package com.sec.chaton.multimedia.doc;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class FileExplorerActivity extends BaseSinglePaneActivity {

    /* renamed from: b */
    private static HashMap<String, String> f6640b = new HashMap<>();

    /* renamed from: c */
    private static HashMap<String, EnumC1794a> f6641c = new HashMap<>();

    /* renamed from: a */
    private InterfaceC1795b f6642a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        FileExplorerFragment fileExplorerFragment = new FileExplorerFragment();
        this.f6642a = fileExplorerFragment;
        return fileExplorerFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f6642a = (InterfaceC1795b) m3089b();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f6642a != null) {
            this.f6642a.mo7403a();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        m7388d();
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    /* renamed from: d */
    private void m7388d() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    static {
        m7384a("pdf", EnumC1794a.PDF, MimeTypeMap.getSingleton().getMimeTypeFromExtension("pdf"));
        m7384a("gul", EnumC1794a.GUL, "application/jungumword");
        m7384a("hwp", EnumC1794a.HWP, "application/x-hwp");
        m7384a("ppt", EnumC1794a.PPT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("ppt"));
        m7384a("pptx", EnumC1794a.PPT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("pptx"));
        m7384a("doc", EnumC1794a.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("doc"));
        m7384a("docx", EnumC1794a.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("docx"));
        m7384a("rtf", EnumC1794a.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("rtf"));
        m7384a("xls", EnumC1794a.XLS, MimeTypeMap.getSingleton().getMimeTypeFromExtension("xls"));
        m7384a("xlsx", EnumC1794a.XLS, MimeTypeMap.getSingleton().getMimeTypeFromExtension("xlsx"));
        m7384a("txt", EnumC1794a.TXT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("txt"));
        m7384a("snb", EnumC1794a.SNB, "application/snb");
        m7384a("jpg", EnumC1794a.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpg"));
        m7384a("jpeg", EnumC1794a.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpeg"));
        m7384a("png", EnumC1794a.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("png"));
        m7384a("gif", EnumC1794a.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("gif"));
        m7384a("mp4", EnumC1794a.VIDEO, MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4"));
        m7384a("3gp", EnumC1794a.VIDEO, MimeTypeMap.getSingleton().getMimeTypeFromExtension("3gp"));
    }

    /* renamed from: a */
    private static void m7384a(String str, EnumC1794a enumC1794a, String str2) {
        f6640b.put(str, str2);
        f6641c.put(str, enumC1794a);
    }

    /* renamed from: a */
    public static String m7383a(String str) {
        if (str == null) {
            return null;
        }
        return f6640b.get(str.toLowerCase());
    }

    /* renamed from: b */
    public static EnumC1794a m7385b(String str) {
        return (str == null || !f6641c.containsKey(str.toLowerCase())) ? EnumC1794a.UNKNOWN : f6641c.get(str.toLowerCase());
    }

    /* renamed from: c */
    public static EnumC1794a m7386c(String str) {
        if (TextUtils.isEmpty(str)) {
            return EnumC1794a.UNKNOWN;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        return m7385b(strNextToken);
    }

    /* renamed from: c */
    public static String m7387c() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = f6640b.entrySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next().getValue());
            sb.append(Config.KEYVALUE_SPLIT);
        }
        return sb.toString();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }
}
