package com.sec.chaton.shop;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.settings.p096a.p097a.C3434a;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.MultiDownloadRequest;
import com.sec.chaton.shop.items.AniconItem;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.shop.p099a.C3707e;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Future;

/* compiled from: ShopMultiDownloadSticker.java */
/* renamed from: com.sec.chaton.shop.ah */
/* loaded from: classes.dex */
public class C3717ah {

    /* renamed from: b */
    private static final String f13370b = C3717ah.class.getSimpleName();

    /* renamed from: c */
    private Context f13372c;

    /* renamed from: d */
    private ArrayList<String> f13373d;

    /* renamed from: f */
    private AlertDialogC4916i f13375f;

    /* renamed from: g */
    private Handler f13376g;

    /* renamed from: i */
    private int f13378i;

    /* renamed from: j */
    private Future<C0778b> f13379j;

    /* renamed from: l */
    private C2210x f13381l;

    /* renamed from: m */
    private MultiDownloadRequest f13382m;

    /* renamed from: k */
    private ArrayList<Item> f13380k = new ArrayList<>();

    /* renamed from: n */
    private Handler f13383n = new HandlerC3718ai(this);

    /* renamed from: o */
    private Handler f13384o = new HandlerC3719aj(this);

    /* renamed from: a */
    InterfaceC2211y f13371a = new C3720ak(this);

    /* renamed from: e */
    private C3707e f13374e = C3707e.m13998a(this.f13384o);

    /* renamed from: h */
    private int f13377h = 0;

    /* renamed from: i */
    static /* synthetic */ int m14043i(C3717ah c3717ah) {
        int i = c3717ah.f13377h;
        c3717ah.f13377h = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14029a(DownloadRequestEntry downloadRequestEntry) {
        ArrayList arrayList = new ArrayList();
        if (C4904y.f17872b) {
            C4904y.m18639b("Remove all anicon packages from database.", f13370b);
        }
        arrayList.add(ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Anicon)).withSelection(C5052r.m19199a("install", " = ?"), new String[]{Spam.ACTIVITY_CANCEL}).build());
        if (C4904y.f17872b) {
            C4904y.m18639b("Save anicon package to database.", f13370b);
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

    public C3717ah(Context context, MultiDownloadRequest multiDownloadRequest, ArrayList<String> arrayList, Handler handler) {
        this.f13372c = context;
        this.f13373d = arrayList;
        this.f13382m = multiDownloadRequest;
        this.f13376g = handler;
        this.f13380k.clear();
        this.f13381l = new C2210x(context.getContentResolver(), this.f13371a);
    }

    /* renamed from: a */
    public void m14047a() {
        this.f13381l.startQuery(0, null, C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath("install").build(), null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14036c() {
        if (this.f13372c != null) {
            C3469m.m13795b(this.f13372c).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3721al(this)).mo18752b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m14038d() {
        if (this.f13373d.size() > 0) {
            this.f13379j = this.f13374e.m14001a(this.f13373d.get(this.f13377h), null);
        } else {
            C5179v.m19810a(this.f13372c, R.string.already_downloaded, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14034b(DownloadRequestEntry downloadRequestEntry) {
        String string = Long.toString(downloadRequestEntry.itemId);
        EnumC2258bd enumC2258bd = EnumC2258bd.Anicon;
        String str = downloadRequestEntry.aniconPackage.downloadUrl;
        if (string != null && str != null) {
            C3434a c3434a = (C3434a) C3445l.m13723a().m13724a(enumC2258bd, string);
            if (c3434a == null) {
                C3434a c3434a2 = new C3434a(downloadRequestEntry, enumC2258bd);
                c3434a2.m13716a(this.f13383n);
                c3434a2.m19059d(new Void[0]);
                m14030a(string);
                return;
            }
            if (c3434a.m13721e() == 5) {
                C3434a c3434a3 = new C3434a(downloadRequestEntry, enumC2258bd);
                c3434a3.m13716a(this.f13383n);
                c3434a3.m19059d(new Void[0]);
                m14030a(string);
            }
        }
    }

    /* renamed from: a */
    private void m14030a(String str) {
        if (this.f13375f == null) {
            this.f13375f = new AlertDialogC4916i(this.f13372c);
            this.f13375f.setTitle(R.string.download_title);
            this.f13375f.setMessage(this.f13372c.getResources().getString(R.string.anicon_file_downloading) + "    (" + this.f13377h + "/" + this.f13378i + ")");
            this.f13375f.setCancelable(false);
        }
        this.f13375f.setButton(-2, this.f13372c.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3722am(this, EnumC2258bd.Anicon, str));
        if (this.f13375f.getButton(-2) != null) {
            this.f13375f.getButton(-2).setEnabled(true);
        }
        if (!this.f13375f.isShowing()) {
            this.f13375f.show();
        }
        this.f13375f.m18719a(0);
    }
}
