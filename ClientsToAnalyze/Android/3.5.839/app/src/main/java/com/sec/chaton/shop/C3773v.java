package com.sec.chaton.shop;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2185ak;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3451r;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.MultiDownloadRequest;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.shop.p099a.C3707e;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.concurrent.Future;
import org.json.JSONException;

/* compiled from: ShopMultiDownloadRingTone.java */
/* renamed from: com.sec.chaton.shop.v */
/* loaded from: classes.dex */
public class C3773v {

    /* renamed from: b */
    private static final String f13523b = C3773v.class.getSimpleName();

    /* renamed from: c */
    private Context f13525c;

    /* renamed from: d */
    private ArrayList<String> f13526d;

    /* renamed from: g */
    private AlertDialogC4916i f13529g;

    /* renamed from: h */
    private Handler f13530h;

    /* renamed from: i */
    private int f13531i;

    /* renamed from: j */
    private Future<C0778b> f13532j;

    /* renamed from: l */
    private C2210x f13534l;

    /* renamed from: m */
    private MultiDownloadRequest f13535m;

    /* renamed from: k */
    private ArrayList<Item> f13533k = new ArrayList<>();

    /* renamed from: n */
    private Handler f13536n = new HandlerC3774w(this);

    /* renamed from: o */
    private Handler f13537o = new HandlerC3775x(this);

    /* renamed from: a */
    InterfaceC2211y f13524a = new C3777z(this);

    /* renamed from: f */
    private C3707e f13528f = C3707e.m13998a(this.f13537o);

    /* renamed from: e */
    private int f13527e = 0;

    /* renamed from: i */
    static /* synthetic */ int m14182i(C3773v c3773v) {
        int i = c3773v.f13527e;
        c3773v.f13527e = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14167a(DownloadRequestEntry downloadRequestEntry) {
        String string = Long.toString(downloadRequestEntry.itemId);
        if (string != null) {
            C3451r c3451r = (C3451r) C3445l.m13723a().m13724a(EnumC2258bd.Sound, string);
            if (c3451r == null || c3451r.m13721e() == 5) {
                C3451r c3451r2 = new C3451r(downloadRequestEntry);
                c3451r2.m13716a(this.f13536n);
                c3451r2.m19059d(new Void[0]);
                m14169a(string);
            }
        }
    }

    /* renamed from: a */
    private void m14169a(String str) {
        if (this.f13529g == null) {
            this.f13529g = new AlertDialogC4916i(this.f13525c);
            this.f13529g.setTitle(R.string.download_title);
            this.f13529g.setMessage(this.f13525c.getResources().getString(R.string.anicon_file_downloading) + "    (" + this.f13527e + "/" + this.f13531i + ")");
            this.f13529g.setCancelable(false);
        }
        this.f13529g.setButton(-2, this.f13525c.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3776y(this, EnumC2258bd.Sound, str));
        if (this.f13529g.getButton(-2) != null) {
            this.f13529g.getButton(-2).setEnabled(true);
        }
        if (!this.f13529g.isShowing()) {
            this.f13529g.show();
        }
        this.f13529g.m18719a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14172b(DownloadRequestEntry downloadRequestEntry) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ContentProviderOperation> arrayListM13744a = C3455ab.m13744a(CommonApplication.m18732r());
        if (arrayListM13744a != null && arrayListM13744a.size() >= 0) {
            arrayList.addAll(arrayListM13744a);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("download_sound, Remove all item list from database.", f13523b);
        }
        arrayList.add(ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Sound)).withSelection(C5052r.m19199a("install", " = ?"), new String[]{Spam.ACTIVITY_CANCEL}).build());
        if (C4904y.f17872b) {
            C4904y.m18639b("download_sound, Save item to database.", f13523b);
        }
        try {
            arrayList.add(C2185ak.m9756a(downloadRequestEntry));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
    }

    public C3773v(Context context, MultiDownloadRequest multiDownloadRequest, ArrayList<String> arrayList, Handler handler) {
        this.f13526d = new ArrayList<>();
        this.f13525c = context;
        this.f13526d = arrayList;
        this.f13535m = multiDownloadRequest;
        this.f13530h = handler;
        this.f13533k.clear();
        this.f13534l = new C2210x(context.getContentResolver(), this.f13524a);
    }

    /* renamed from: a */
    public void m14186a() {
        this.f13534l.startQuery(0, null, C2257bc.m10121a(EnumC2258bd.Sound).buildUpon().appendPath("install").build(), null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14175c() {
        if (this.f13525c != null) {
            C3469m.m13795b(this.f13525c).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3710aa(this)).mo18752b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m14177d() {
        if (this.f13526d.size() > 0) {
            this.f13532j = this.f13528f.m14003b(this.f13526d.get(this.f13527e));
        } else {
            C5179v.m19810a(this.f13525c, R.string.already_downloaded, 0).show();
        }
    }
}
