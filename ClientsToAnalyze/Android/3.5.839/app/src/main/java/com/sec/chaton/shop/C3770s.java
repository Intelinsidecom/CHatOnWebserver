package com.sec.chaton.shop;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.database.SQLException;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2197k;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3471o;
import com.sec.chaton.settings.p096a.p097a.C3438e;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ShopFontDownloads.java */
/* renamed from: com.sec.chaton.shop.s */
/* loaded from: classes.dex */
public class C3770s {

    /* renamed from: a */
    private static final String f13515a = C3770s.class.getSimpleName();

    /* renamed from: b */
    private Context f13516b;

    /* renamed from: c */
    private Handler f13517c;

    /* renamed from: d */
    private AlertDialogC4916i f13518d;

    /* renamed from: e */
    private Handler f13519e = new HandlerC3771t(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14159a(DownloadRequestEntry downloadRequestEntry) throws SQLException {
        ArrayList arrayList = new ArrayList();
        ArrayList<ContentProviderOperation> arrayListM13799a = C3471o.m13799a(CommonApplication.m18732r());
        if (arrayListM13799a != null && arrayListM13799a.size() >= 0) {
            arrayList.addAll(arrayListM13799a);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Remove all filters not installed from database.", f13515a);
        }
        C2197k.m9903a(CommonApplication.m18732r());
        if (C4904y.f17872b) {
            C4904y.m18639b("Remove all font packages from database.", f13515a);
        }
        arrayList.add(ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Font)).withSelection(C5052r.m19199a("install", " = ?"), new String[]{Spam.ACTIVITY_CANCEL}).build());
        if (C4904y.f17872b) {
            C4904y.m18639b("Save font items to database.", f13515a);
        }
        try {
            arrayList.add(C2197k.m9900a(downloadRequestEntry));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ContentProviderResult[] contentProviderResultArrM18190a = C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        if (C4904y.f17872b) {
            for (ContentProviderResult contentProviderResult : contentProviderResultArrM18190a) {
                C4904y.m18639b("download_font, applyBatch : - " + contentProviderResult.toString() + "\n", f13515a);
            }
        }
    }

    public C3770s(Context context, DownloadRequestEntry downloadRequestEntry, Handler handler) {
        this.f13516b = context;
        this.f13517c = handler;
        m14163b(downloadRequestEntry);
    }

    /* renamed from: b */
    private void m14163b(DownloadRequestEntry downloadRequestEntry) {
        String string = Long.toString(downloadRequestEntry.itemId);
        int i = downloadRequestEntry.downloadType;
        if (string != null) {
            C3438e c3438e = (C3438e) C3445l.m13723a().m13724a(EnumC2258bd.Font, string);
            if (c3438e == null) {
                C3438e c3438e2 = new C3438e(downloadRequestEntry);
                c3438e2.m13716a(this.f13519e);
                c3438e2.m19059d(new Void[0]);
                m14161a(string, i);
                return;
            }
            if (c3438e.m13721e() == 5) {
                C3438e c3438e3 = new C3438e(downloadRequestEntry);
                c3438e3.m13716a(this.f13519e);
                c3438e3.m19059d(new Void[0]);
                m14161a(string, i);
            }
        }
    }

    /* renamed from: a */
    private void m14161a(String str, int i) {
        if (this.f13518d == null) {
            this.f13518d = new AlertDialogC4916i(this.f13516b);
            if (i == 0) {
                this.f13518d.setTitle(R.string.download_title);
                this.f13518d.setMessage(this.f13516b.getResources().getString(R.string.anicon_file_downloading));
            } else if (i == 1) {
                this.f13518d.setTitle(R.string.setting_update_text);
                this.f13518d.setMessage(this.f13516b.getResources().getString(R.string.interaction_updating));
            }
            this.f13518d.setCancelable(false);
        }
        this.f13518d.setButton(-2, this.f13516b.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3772u(this, str));
        this.f13518d.show();
        this.f13518d.m18719a(0);
    }
}
