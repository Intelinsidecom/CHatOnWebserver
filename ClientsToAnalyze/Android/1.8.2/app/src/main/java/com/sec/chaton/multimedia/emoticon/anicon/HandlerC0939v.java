package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.entry.InstallPackageEntry;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.settings.ActivityDownload2;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.common.p056b.p061e.C1836g;
import com.sec.widget.C2153y;
import java.io.File;
import java.io.IOException;

/* compiled from: AniconPackageListView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.v */
/* loaded from: classes.dex */
class HandlerC0939v extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageListView f3502a;

    HandlerC0939v(AniconPackageListView aniconPackageListView) {
        this.f3502a = aniconPackageListView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        File fileM6231b = null;
        super.handleMessage(message);
        if (this.f3502a.f3436b != null) {
            if (message.what == 1002) {
                C0101b c0101b = (C0101b) message.obj;
                this.f3502a.f3442h = null;
                if (this.f3502a.f3451q) {
                    this.f3502a.f3451q = false;
                    return;
                }
                this.f3502a.m3744d();
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f3502a.f3445k = this.f3502a.m3736b();
                    this.f3502a.f3444j = new C0934q(this.f3502a.f3436b, this.f3502a.f3445k, true, this.f3502a.f3449o);
                    this.f3502a.f3444j.m3803a(this.f3502a);
                    this.f3502a.f3437c.setItemsCanFocus(true);
                    this.f3502a.f3437c.setAdapter((ListAdapter) this.f3502a.f3444j);
                    this.f3502a.f3437c.setDivider(this.f3502a.getResources().getDrawable(R.drawable.list_2line));
                } else {
                    this.f3502a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityDownload2(), "container").addToBackStack(ActivitySettings.f4559g).commit();
                    this.f3502a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
                    C2153y.makeText(this.f3502a.f3436b, this.f3502a.m3725a(R.string.popup_no_network_connection), 1).show();
                }
            } else if (message.what == 1001) {
                C0101b c0101b2 = (C0101b) message.obj;
                this.f3502a.f3443i = null;
                if (c0101b2.m665b() != EnumC0803m.SUCCESS) {
                    this.f3502a.m3748f();
                    this.f3502a.m3750g();
                } else {
                    InstallPackageEntry installPackageEntry = (InstallPackageEntry) c0101b2.m671d();
                    this.f3502a.f3446l = installPackageEntry.f3536id;
                    this.f3502a.f3447m = installPackageEntry.packagezipurl;
                    try {
                        File fileM6212a = C1830a.m6212a(this.f3502a.f3436b);
                        this.f3502a.f3448n = new File(fileM6212a, String.valueOf(System.currentTimeMillis()));
                        C1830a.m6211a().m6214a(this.f3502a.f3450p, this.f3502a.f3447m, this.f3502a.f3448n, null);
                    } catch (IOException e) {
                        if (C1786r.f6455e) {
                            C1786r.m6056a(e, AniconPackageListView.f3435a);
                        }
                        if (this.f3502a.f3448n != null && this.f3502a.f3448n.exists()) {
                            this.f3502a.f3448n.delete();
                        }
                        this.f3502a.m3748f();
                        this.f3502a.m3750g();
                    }
                }
            }
            if (message.what == 2) {
                if (C1786r.f6452b) {
                    C1786r.m6061b("File download is completed", AniconPackageListView.f3435a);
                }
                try {
                    try {
                        fileM6231b = ((C1836g) message.obj).m6231b();
                        C0921d.m3788a(this.f3502a.f3436b, this.f3502a.f3446l, fileM6231b);
                    } catch (IOException e2) {
                        if (C1786r.f6455e) {
                            C1786r.m6056a(e2, AniconPackageListView.f3435a);
                        }
                        this.f3502a.m3750g();
                        if (fileM6231b != null && fileM6231b.exists()) {
                        }
                    }
                    this.f3502a.m3748f();
                } finally {
                    if (fileM6231b != null && fileM6231b.exists()) {
                        fileM6231b.delete();
                    }
                }
            }
            if (message.what == 1 && this.f3502a.f3439e.isShowing()) {
                this.f3502a.f3439e.setProgress(message.arg1);
            }
            if (message.what == 3) {
                this.f3502a.m3748f();
            }
            if (message.what == 4) {
                this.f3502a.m3748f();
                this.f3502a.m3750g();
            }
        }
    }
}
