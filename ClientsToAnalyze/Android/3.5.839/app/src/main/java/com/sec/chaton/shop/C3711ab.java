package com.sec.chaton.shop;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3447n;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.MultiDownloadRequest;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.shop.p099a.C3707e;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.concurrent.Future;

/* compiled from: ShopMultiDownloadSkin.java */
/* renamed from: com.sec.chaton.shop.ab */
/* loaded from: classes.dex */
public class C3711ab {

    /* renamed from: b */
    private static final String f13348b = C3711ab.class.getSimpleName();

    /* renamed from: c */
    private Context f13350c;

    /* renamed from: d */
    private ArrayList<String> f13351d;

    /* renamed from: g */
    private AlertDialogC4916i f13354g;

    /* renamed from: h */
    private Handler f13355h;

    /* renamed from: i */
    private int f13356i;

    /* renamed from: j */
    private Future<C0778b> f13357j;

    /* renamed from: l */
    private C2210x f13359l;

    /* renamed from: m */
    private MultiDownloadRequest f13360m;

    /* renamed from: k */
    private ArrayList<Item> f13358k = new ArrayList<>();

    /* renamed from: n */
    private Handler f13361n = new HandlerC3712ac(this);

    /* renamed from: o */
    private Handler f13362o = new HandlerC3713ad(this);

    /* renamed from: a */
    InterfaceC2211y f13349a = new C3714ae(this);

    /* renamed from: f */
    private C3707e f13353f = C3707e.m13998a(this.f13362o);

    /* renamed from: e */
    private int f13352e = 0;

    /* renamed from: i */
    static /* synthetic */ int m14021i(C3711ab c3711ab) {
        int i = c3711ab.f13352e;
        c3711ab.f13352e = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077 A[PHI: r1
  0x0077: PHI (r1v6 android.database.Cursor) = (r1v5 android.database.Cursor), (r1v9 android.database.Cursor) binds: [B:15:0x0075, B:28:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4  */
    /* JADX WARN: Type inference failed for: r0v17, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m14007a(com.sec.chaton.shop.entrys.DownloadRequestEntry r13) throws java.lang.Throwable {
        /*
            r12 = this;
            r11 = 2
            r10 = 1
            r9 = 0
            r6 = 0
            long r0 = r13.itemId
            java.lang.String r7 = java.lang.Long.toString(r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.sec.chaton.e.bd r0 = com.sec.chaton.p057e.EnumC2258bd.Skin
            android.net.Uri r0 = com.sec.chaton.p057e.C2257bc.m10121a(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.lang.String r1 = "install"
            android.net.Uri$Builder r0 = r0.appendPath(r1)
            android.net.Uri r1 = r0.build()
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Throwable -> Lb0 java.io.IOException -> Lc2
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lb0 java.io.IOException -> Lc2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb0 java.io.IOException -> Lc2
        L34:
            boolean r0 = r1.moveToNext()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            if (r0 == 0) goto Lbd
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            boolean r0 = com.sec.chaton.settings.p096a.C3474r.m13825b(r0, r7)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            if (r0 != 0) goto L34
            boolean r0 = com.sec.chaton.util.C4904y.f17874d     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            if (r0 == 0) goto L69
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            r2 = 0
            java.lang.String r3 = "Skin("
            r0[r2] = r3     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            r2 = 1
            long r3 = r13.itemId     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            r0[r2] = r3     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            r2 = 2
            java.lang.String r3 = ") directory isn't valid."
            r0[r2] = r3     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            java.lang.String r0 = com.sec.common.util.C5052r.m19199a(r0)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            java.lang.String r2 = com.sec.chaton.shop.C3711ab.f13348b     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            com.sec.chaton.util.C4904y.m18645d(r0, r2)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
        L69:
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            com.sec.chaton.settings.p096a.C3474r.m13842k(r0, r7)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> Lc0
            goto L34
        L71:
            r0 = move-exception
        L72:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lc0
            if (r1 == 0) goto L7a
        L77:
            r1.close()
        L7a:
            java.lang.String r0 = "item_id >= ? AND install = ?"
            java.lang.String[] r1 = new java.lang.String[r11]
            java.lang.String r2 = "0"
            r1[r9] = r2
            java.lang.String r2 = "0"
            r1[r10] = r2
            com.sec.chaton.e.bd r2 = com.sec.chaton.p057e.EnumC2258bd.Skin
            android.net.Uri r2 = com.sec.chaton.p057e.C2257bc.m10121a(r2)
            android.content.ContentProviderOperation$Builder r2 = android.content.ContentProviderOperation.newDelete(r2)
            android.content.ContentProviderOperation$Builder r0 = r2.withSelection(r0, r1)
            android.content.ContentProviderOperation r0 = r0.build()
            r8.add(r0)
            android.content.ContentProviderOperation r0 = com.sec.chaton.p057e.p058a.C2183ai.m9744a(r13)     // Catch: org.json.JSONException -> Lb8
            r8.add(r0)     // Catch: org.json.JSONException -> Lb8
        La5:
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            java.lang.String r1 = "com.sec.chaton.provider2"
            com.sec.chaton.util.C4821am.m18190a(r0, r1, r8)
            return
        Lb0:
            r0 = move-exception
            r1 = r6
        Lb2:
            if (r1 == 0) goto Lb7
            r1.close()
        Lb7:
            throw r0
        Lb8:
            r0 = move-exception
            r0.printStackTrace()
            goto La5
        Lbd:
            if (r1 == 0) goto L7a
            goto L77
        Lc0:
            r0 = move-exception
            goto Lb2
        Lc2:
            r0 = move-exception
            r1 = r6
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.shop.C3711ab.m14007a(com.sec.chaton.shop.entrys.DownloadRequestEntry):void");
    }

    public C3711ab(Context context, MultiDownloadRequest multiDownloadRequest, ArrayList<String> arrayList, Handler handler) {
        this.f13351d = new ArrayList<>();
        this.f13350c = context;
        this.f13351d = arrayList;
        this.f13360m = multiDownloadRequest;
        this.f13355h = handler;
        this.f13358k.clear();
        this.f13359l = new C2210x(context.getContentResolver(), this.f13349a);
    }

    /* renamed from: a */
    public void m14025a() {
        this.f13359l.startQuery(0, null, C2257bc.m10121a(EnumC2258bd.Skin).buildUpon().appendPath("install").build(), null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14014c() {
        if (this.f13350c != null) {
            C3469m.m13795b(this.f13350c).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3715af(this)).mo18752b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m14016d() {
        if (this.f13351d.size() > 0) {
            this.f13357j = this.f13353f.m14000a(this.f13351d.get(this.f13352e));
        } else {
            C5179v.m19810a(this.f13350c, R.string.already_downloaded, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14012b(DownloadRequestEntry downloadRequestEntry) {
        String string = Long.toString(downloadRequestEntry.itemId);
        String str = downloadRequestEntry.bgBubble.setting.downloadUrl;
        String str2 = downloadRequestEntry.bgBubble.chatview.downloadUrl;
        if (string != null && str != null && str2 != null) {
            C3447n c3447n = (C3447n) C3445l.m13723a().m13724a(EnumC2258bd.Skin, string);
            if (c3447n == null || c3447n.m13721e() == 5) {
                C3447n c3447n2 = new C3447n(downloadRequestEntry);
                c3447n2.m13716a(this.f13361n);
                c3447n2.m19059d(new Void[0]);
                m14008a(string);
            }
        }
    }

    /* renamed from: a */
    private void m14008a(String str) {
        if (this.f13354g == null) {
            this.f13354g = new AlertDialogC4916i(this.f13350c);
            this.f13354g.setTitle(R.string.download_title);
            this.f13354g.setMessage(this.f13350c.getResources().getString(R.string.anicon_file_downloading) + "    (" + this.f13352e + "/" + this.f13356i + ")");
            this.f13354g.setCancelable(false);
        }
        this.f13354g.setButton(-2, this.f13350c.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3716ag(this, EnumC2258bd.Skin, str));
        if (this.f13354g.getButton(-2) != null) {
            this.f13354g.getButton(-2).setEnabled(true);
        }
        if (!this.f13354g.isShowing()) {
            this.f13354g.show();
        }
        this.f13354g.m18719a(0);
    }
}
