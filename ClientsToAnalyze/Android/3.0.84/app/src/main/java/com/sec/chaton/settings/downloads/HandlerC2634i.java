package com.sec.chaton.settings.downloads;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p035io.entry.AmsItemDownloadEntry;
import com.sec.chaton.p035io.entry.inner.AmsItem;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.p056a.C2510a;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.p070a.C3332a;
import com.sec.common.util.p070a.C3338g;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.IOException;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.i */
/* loaded from: classes.dex */
class HandlerC2634i extends Handler {

    /* renamed from: a */
    final /* synthetic */ AmsItemDownloads f9877a;

    HandlerC2634i(AmsItemDownloads amsItemDownloads) {
        this.f9877a = amsItemDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9877a.f9430b != null) {
            if (message.what == 1200) {
                this.f9877a.f9438j = null;
                this.f9877a.m9290e();
                if (((C0267d) message.obj).m1351b() != EnumC1587o.SUCCESS) {
                    C3641ai.m13210a(this.f9877a.f9430b, C2555av.m9488a(R.string.dev_network_error), 1).show();
                    this.f9877a.f9430b.finish();
                } else {
                    this.f9877a.m9307a(true);
                    this.f9877a.getLoaderManager().initLoader(0, null, this.f9877a);
                }
            }
            if (message.what == 1201) {
                C0267d c0267d = (C0267d) message.obj;
                this.f9877a.f9439k = null;
                if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    this.f9877a.m9293g();
                    this.f9877a.m9296h();
                } else {
                    this.f9877a.f9442n = ((AmsItemDownloadEntry) c0267d.m1354e()).imageurl;
                    try {
                        C3332a.m11750a().m11754a(this.f9877a.f9446r, this.f9877a.f9442n, new File(C3332a.m11751a(this.f9877a.f9430b), String.valueOf(this.f9877a.f9442n.hashCode())), AmsItemDownloads.f9429a);
                    } catch (IOException e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, AmsItemDownloads.f9429a);
                        }
                        this.f9877a.m9293g();
                        this.f9877a.m9296h();
                    }
                }
            }
            if (message.what == 1 && this.f9877a.f9434f.isShowing()) {
                this.f9877a.f9434f.m11483a(message.arg1);
            }
            if (message.what == 2) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_ams, Download is done.", AmsItemDownloads.f9429a);
                }
                this.f9877a.f9443o = ((C3338g) message.obj).m11772b().getAbsolutePath();
                if (this.f9877a.f9431c != EnumC1327e.Background) {
                    if (this.f9877a.f9431c == EnumC1327e.Template) {
                        Intent intent = new Intent(this.f9877a.f9430b, (Class<?>) AMSPlayerActivity.class);
                        intent.putExtra("AMS_FILE_PATH", this.f9877a.f9443o);
                        intent.putExtra("VIEWER_MODE", 1002);
                        intent.putExtra("AMS_DOWNLOAD_PREVIEW", true);
                        intent.putExtra("AMS_FROM_DOWNLOADS", true);
                        intent.putExtra("AMS_ITEM_ID", this.f9877a.f9441m);
                        AmsItem amsItemM9421a = this.f9877a.f9436h.m9421a(this.f9877a.f9441m);
                        C2510a c2510a = (C2510a) C2525p.m9458a().m9459a(this.f9877a.f9431c.m5703b(), this.f9877a.f9441m);
                        boolean z = c2510a != null && c2510a.m9455d() == 5;
                        if (amsItemM9421a != null) {
                            intent.putExtra("AMS_FILE_SIZE", amsItemM9421a.filesize);
                            intent.putExtra("AMS_EXPIRATION_DATE", amsItemM9421a.expirationdate);
                            intent.putExtra("AMS_IS_FAILED_ITEM", z);
                        }
                        this.f9877a.startActivityForResult(intent, 0);
                    }
                } else {
                    Intent intent2 = new Intent(this.f9877a.f9430b, (Class<?>) ActivityAmsItemBackgroundDetail.class);
                    intent2.putExtra("filePath", this.f9877a.f9443o);
                    intent2.putExtra("amsItemId", this.f9877a.f9441m);
                    this.f9877a.startActivity(intent2);
                }
                this.f9877a.m9293g();
            }
            if (message.what == 3) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_ams, Download is canceled.", AmsItemDownloads.f9429a);
                }
                this.f9877a.m9293g();
            }
            if (message.what == 4) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_ams, Download is failed.", AmsItemDownloads.f9429a);
                }
                this.f9877a.m9293g();
                this.f9877a.m9296h();
            }
        }
    }
}
