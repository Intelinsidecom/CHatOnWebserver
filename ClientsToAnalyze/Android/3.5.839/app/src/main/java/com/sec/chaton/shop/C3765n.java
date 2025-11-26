package com.sec.chaton.shop;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.p097a.C3434a;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.items.AniconItem;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ShopAniconDownloads.java */
/* renamed from: com.sec.chaton.shop.n */
/* loaded from: classes.dex */
public class C3765n {

    /* renamed from: a */
    private static final String f13505a = C3765n.class.getSimpleName();

    /* renamed from: b */
    private AlertDialogC4916i f13506b;

    /* renamed from: c */
    private Context f13507c;

    /* renamed from: d */
    private Handler f13508d;

    /* renamed from: e */
    private Handler f13509e = new HandlerC3766o(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14149a(DownloadRequestEntry downloadRequestEntry) {
        ArrayList arrayList = new ArrayList();
        if (C4904y.f17872b) {
            C4904y.m18639b("Remove all anicon packages from database.", f13505a);
        }
        arrayList.add(ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Anicon)).withSelection(C5052r.m19199a("install", " = ?"), new String[]{Spam.ACTIVITY_CANCEL}).build());
        if (C4904y.f17872b) {
            C4904y.m18639b("Save anicon package to database.", f13505a);
        }
        arrayList.add(C2188b.m9785a(downloadRequestEntry));
        C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        Iterator<AniconItem> it = downloadRequestEntry.aniconPackage.anicon.iterator();
        while (it.hasNext()) {
            arrayList.add(C2188b.m9786a(downloadRequestEntry, it.next()));
        }
        C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        C3460d.m13784d(Long.toString(downloadRequestEntry.itemId));
    }

    public C3765n(Context context, DownloadRequestEntry downloadRequestEntry, Handler handler) {
        this.f13507c = context;
        this.f13508d = handler;
        m14153b(downloadRequestEntry);
    }

    /* renamed from: b */
    private void m14153b(DownloadRequestEntry downloadRequestEntry) {
        String string = Long.toString(downloadRequestEntry.itemId);
        int i = downloadRequestEntry.downloadType;
        EnumC2258bd enumC2258bd = EnumC2258bd.Anicon;
        String str = downloadRequestEntry.aniconPackage.downloadUrl;
        String str2 = downloadRequestEntry.aniconPackage.panelUrl;
        if (string != null && str != null) {
            C3434a c3434a = (C3434a) C3445l.m13723a().m13724a(enumC2258bd, string);
            if (c3434a == null) {
                C3434a c3434a2 = new C3434a(downloadRequestEntry, enumC2258bd);
                c3434a2.m13716a(this.f13509e);
                c3434a2.m19059d(new Void[0]);
                m14151a(string, i);
                return;
            }
            if (c3434a.m13721e() == 5) {
                C3434a c3434a3 = new C3434a(downloadRequestEntry, enumC2258bd);
                c3434a3.m13716a(this.f13509e);
                c3434a3.m19059d(new Void[0]);
                m14151a(string, i);
            }
        }
    }

    /* renamed from: a */
    private void m14151a(String str, int i) {
        if (this.f13506b == null) {
            this.f13506b = new AlertDialogC4916i(this.f13507c);
            if (i == 0) {
                this.f13506b.setTitle(R.string.download_title);
                this.f13506b.setMessage(this.f13507c.getResources().getString(R.string.anicon_file_downloading));
            } else if (i == 1) {
                this.f13506b.setTitle(R.string.setting_update_text);
                this.f13506b.setMessage(this.f13507c.getResources().getString(R.string.interaction_updating));
            }
            this.f13506b.setCancelable(false);
        }
        this.f13506b.setButton(-2, this.f13507c.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3767p(this, EnumC2258bd.Anicon, str));
        this.f13506b.show();
        this.f13506b.m18719a(0);
    }
}
