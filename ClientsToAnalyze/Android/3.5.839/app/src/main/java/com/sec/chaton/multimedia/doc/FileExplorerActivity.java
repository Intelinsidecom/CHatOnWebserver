package com.sec.chaton.multimedia.doc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.spp.push.Config;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class FileExplorerActivity extends BaseSinglePaneActivity {

    /* renamed from: o */
    private static HashMap<String, String> f9929o = new HashMap<>();

    /* renamed from: p */
    private static HashMap<String, EnumC2758b> f9930p = new HashMap<>();

    /* renamed from: n */
    private InterfaceC2759c f9931n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        FileExplorerFragment fileExplorerFragment = new FileExplorerFragment();
        this.f9931n = fileExplorerFragment;
        return fileExplorerFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9931n = (InterfaceC2759c) m6162g();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f9931n != null) {
            this.f9931n.mo11597a();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    static {
        m11578a("pdf", EnumC2758b.PDF, MimeTypeMap.getSingleton().getMimeTypeFromExtension("pdf"));
        m11578a("gul", EnumC2758b.GUL, "application/jungumword");
        m11578a("hwp", EnumC2758b.HWP, "application/x-hwp");
        m11578a("ppt", EnumC2758b.PPT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("ppt"));
        m11578a("pptx", EnumC2758b.PPT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("pptx"));
        m11578a("doc", EnumC2758b.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("doc"));
        m11578a("docx", EnumC2758b.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("docx"));
        m11578a("rtf", EnumC2758b.DOC, MimeTypeMap.getSingleton().getMimeTypeFromExtension("rtf"));
        m11578a("xls", EnumC2758b.XLS, MimeTypeMap.getSingleton().getMimeTypeFromExtension("xls"));
        m11578a("xlsx", EnumC2758b.XLS, MimeTypeMap.getSingleton().getMimeTypeFromExtension("xlsx"));
        m11578a("txt", EnumC2758b.TXT, MimeTypeMap.getSingleton().getMimeTypeFromExtension("txt"));
        m11578a("snb", EnumC2758b.SNB, "application/snb");
        m11578a("scc", EnumC2758b.SCC, "application/scc");
        m11578a("spd", EnumC2758b.SPD, "application/spd");
        m11578a("jpg", EnumC2758b.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpg"));
        m11578a("jpeg", EnumC2758b.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpeg"));
        m11578a("png", EnumC2758b.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("png"));
        m11578a("gif", EnumC2758b.IMAGE, MimeTypeMap.getSingleton().getMimeTypeFromExtension("gif"));
        m11578a("mp4", EnumC2758b.VIDEO, MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4"));
        m11578a("3gp", EnumC2758b.VIDEO, MimeTypeMap.getSingleton().getMimeTypeFromExtension("3gp"));
        m11578a("wmv", EnumC2758b.VIDEO, MimeTypeMap.getSingleton().getMimeTypeFromExtension("wmv"));
    }

    /* renamed from: a */
    private static void m11578a(String str, EnumC2758b enumC2758b, String str2) {
        f9929o.put(str, str2);
        f9930p.put(str, enumC2758b);
    }

    /* renamed from: b */
    public static String m11579b(String str) {
        if (str == null) {
            return null;
        }
        return f9929o.get(str.toLowerCase());
    }

    /* renamed from: c */
    public static EnumC2758b m11580c(String str) {
        return (str == null || !f9930p.containsKey(str.toLowerCase())) ? EnumC2758b.UNKNOWN : f9930p.get(str.toLowerCase());
    }

    /* renamed from: d */
    public static EnumC2758b m11581d(String str) {
        if (TextUtils.isEmpty(str)) {
            return EnumC2758b.UNKNOWN;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        return m11580c(strNextToken);
    }

    /* renamed from: a */
    public static EnumC2214ab m11577a(EnumC2758b enumC2758b) {
        switch (enumC2758b) {
            case PDF:
            case GUL:
            case HWP:
            case PPT:
            case DOC:
            case XLS:
                return EnumC2214ab.DOCUMENT;
            case TXT:
            case SNB:
            case SCC:
            case SPD:
                return EnumC2214ab.FILE;
            case IMAGE:
                return EnumC2214ab.IMAGE;
            case VIDEO:
                return EnumC2214ab.VIDEO;
            default:
                return EnumC2214ab.FILE;
        }
    }

    /* renamed from: h */
    public static String m11582h() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = f9929o.entrySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next().getValue());
            sb.append(Config.KEYVALUE_SPLIT);
        }
        return sb.toString();
    }
}
