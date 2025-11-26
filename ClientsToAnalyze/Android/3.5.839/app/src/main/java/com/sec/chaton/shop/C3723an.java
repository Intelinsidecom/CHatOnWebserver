package com.sec.chaton.shop;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2185ak;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3451r;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ShopRingToneDownloads.java */
/* renamed from: com.sec.chaton.shop.an */
/* loaded from: classes.dex */
public class C3723an {

    /* renamed from: a */
    private static final String f13392a = C3723an.class.getSimpleName();

    /* renamed from: b */
    private Context f13393b;

    /* renamed from: c */
    private Handler f13394c;

    /* renamed from: d */
    private AlertDialogC4916i f13395d;

    /* renamed from: e */
    private Handler f13396e = new HandlerC3724ao(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14051a(DownloadRequestEntry downloadRequestEntry) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ContentProviderOperation> arrayListM13744a = C3455ab.m13744a(CommonApplication.m18732r());
        if (arrayListM13744a != null && arrayListM13744a.size() >= 0) {
            arrayList.addAll(arrayListM13744a);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("download_sound, Remove all item list from database.", f13392a);
        }
        arrayList.add(ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Sound)).withSelection(C5052r.m19199a("install", " = ?"), new String[]{Spam.ACTIVITY_CANCEL}).build());
        if (C4904y.f17872b) {
            C4904y.m18639b("download_sound, Save item to database.", f13392a);
        }
        try {
            arrayList.add(C2185ak.m9756a(downloadRequestEntry));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
    }

    public C3723an(Context context, DownloadRequestEntry downloadRequestEntry, Handler handler) {
        this.f13393b = context;
        this.f13394c = handler;
        m14054b(downloadRequestEntry);
    }

    /* renamed from: b */
    private void m14054b(DownloadRequestEntry downloadRequestEntry) {
        String string = Long.toString(downloadRequestEntry.itemId);
        int i = downloadRequestEntry.downloadType;
        if (string != null) {
            C3451r c3451r = (C3451r) C3445l.m13723a().m13724a(EnumC2258bd.Sound, string);
            if (c3451r == null) {
                C3451r c3451r2 = new C3451r(downloadRequestEntry);
                c3451r2.m13716a(this.f13396e);
                c3451r2.m19059d(new Void[0]);
                m14052a(string, i);
                return;
            }
            if (c3451r.m13721e() == 5) {
                C3451r c3451r3 = new C3451r(downloadRequestEntry);
                c3451r3.m13716a(this.f13396e);
                c3451r3.m19059d(new Void[0]);
                m14052a(string, i);
            }
        }
    }

    /* renamed from: a */
    private void m14052a(String str, int i) {
        if (this.f13395d == null) {
            this.f13395d = new AlertDialogC4916i(this.f13393b);
            if (i == 0) {
                this.f13395d.setTitle(R.string.download_title);
                this.f13395d.setMessage(this.f13393b.getResources().getString(R.string.anicon_file_downloading));
            } else if (i == 1) {
                this.f13395d.setTitle(R.string.setting_update_text);
                this.f13395d.setMessage(this.f13393b.getResources().getString(R.string.interaction_updating));
            }
            this.f13395d.setCancelable(false);
        }
        this.f13395d.setButton(-2, this.f13393b.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3725ap(this, str));
        this.f13395d.show();
        this.f13395d.m18719a(0);
    }
}
