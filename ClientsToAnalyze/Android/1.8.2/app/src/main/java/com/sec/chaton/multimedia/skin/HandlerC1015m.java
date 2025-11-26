package com.sec.chaton.multimedia.skin;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.skin.entry.DownloadSkinEntry;
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

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.multimedia.skin.m */
/* loaded from: classes.dex */
class HandlerC1015m extends Handler {

    /* renamed from: a */
    final /* synthetic */ SkinListView f3712a;

    HandlerC1015m(SkinListView skinListView) {
        this.f3712a = skinListView;
    }

    /* JADX WARN: Finally extract failed */
    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        File file;
        super.handleMessage(message);
        if (this.f3712a.f3667b == null) {
            return;
        }
        if (message.what == 1100) {
            this.f3712a.f3674i = null;
            this.f3712a.m3907d();
            if (((C0101b) message.obj).m665b() == EnumC0803m.SUCCESS) {
                this.f3712a.f3676k = this.f3712a.m3901b();
                this.f3712a.f3677l = new C0994a(this.f3712a.f3667b, this.f3712a.f3676k, true, this.f3712a.f3672g);
                this.f3712a.f3671f.setAdapter((ListAdapter) this.f3712a.f3677l);
            } else {
                this.f3712a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityDownload2(), "container").addToBackStack(ActivitySettings.f4559g).commit();
                this.f3712a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
                C2153y.makeText(this.f3712a.f3667b, this.f3712a.m3889a(R.string.dev_network_error), 1).show();
            }
        } else if (message.what == 1101) {
            C0101b c0101b = (C0101b) message.obj;
            this.f3712a.f3675j = null;
            if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                DownloadSkinEntry downloadSkinEntry = (DownloadSkinEntry) c0101b.m671d();
                this.f3712a.f3678m = downloadSkinEntry.skinview;
                try {
                    this.f3712a.f3669d.m6242c(0);
                    File fileM6212a = C1830a.m6212a(this.f3712a.f3667b);
                    this.f3712a.f3681p = new File(fileM6212a, String.valueOf(System.currentTimeMillis()));
                    C1830a.m6211a().m6214a(this.f3712a.f3683r, this.f3712a.f3678m.settingviewzipurl, this.f3712a.f3681p, 0);
                } catch (IOException e) {
                    if (C1786r.f6455e) {
                        C1786r.m6056a(e, SkinListView.f3666a);
                    }
                    if (this.f3712a.f3681p != null && this.f3712a.f3681p.exists()) {
                        this.f3712a.f3681p.delete();
                    }
                    this.f3712a.m3911f();
                    this.f3712a.m3913g();
                }
            } else {
                this.f3712a.m3911f();
                this.f3712a.m3913g();
            }
        } else if (message.what == 1) {
            if (this.f3712a.f3669d.isShowing()) {
                this.f3712a.f3669d.m6242c(message.arg1);
            }
        } else if (message.what == 2) {
            C1836g c1836g = (C1836g) message.obj;
            if (c1836g.m6227a() == 0) {
                if (C1786r.f6452b) {
                    C1786r.m6061b("Setting view files download is completed.", SkinListView.f3666a);
                }
                this.f3712a.f3669d.m6241b(2);
                try {
                    File fileM6212a2 = C1830a.m6212a(this.f3712a.f3667b);
                    this.f3712a.f3682q = new File(fileM6212a2, String.valueOf(System.currentTimeMillis()));
                    C1830a.m6211a().m6214a(this.f3712a.f3683r, this.f3712a.f3678m.chatviewzipurl, this.f3712a.f3682q, 1);
                } catch (IOException e2) {
                    if (C1786r.f6455e) {
                        C1786r.m6056a(e2, SkinListView.f3666a);
                    }
                    if (this.f3712a.f3681p != null && this.f3712a.f3681p.exists()) {
                        this.f3712a.f3681p.delete();
                    }
                    this.f3712a.m3911f();
                    this.f3712a.m3913g();
                }
            } else if (c1836g.m6227a() == 1) {
                if (C1786r.f6452b) {
                    C1786r.m6061b("Chat view files download is completed.", SkinListView.f3666a);
                }
                try {
                    try {
                        C1003c.m3939a(this.f3712a.f3667b, this.f3712a.f3678m.f3708id, this.f3712a.f3681p, this.f3712a.f3682q);
                        if (this.f3712a.f3681p != null && this.f3712a.f3681p.exists()) {
                            this.f3712a.f3681p.delete();
                        }
                    } catch (IOException e3) {
                        if (C1786r.f6455e) {
                            C1786r.m6056a(e3, SkinListView.f3666a);
                        }
                        this.f3712a.m3913g();
                        if (this.f3712a.f3681p != null && this.f3712a.f3681p.exists()) {
                            this.f3712a.f3681p.delete();
                        }
                        if (this.f3712a.f3682q != null && this.f3712a.f3682q.exists()) {
                            file = this.f3712a.f3682q;
                        }
                    }
                    if (this.f3712a.f3682q != null && this.f3712a.f3682q.exists()) {
                        file = this.f3712a.f3682q;
                        file.delete();
                    }
                    this.f3712a.m3911f();
                } catch (Throwable th) {
                    if (this.f3712a.f3681p != null && this.f3712a.f3681p.exists()) {
                        this.f3712a.f3681p.delete();
                    }
                    if (this.f3712a.f3682q != null && this.f3712a.f3682q.exists()) {
                        this.f3712a.f3682q.delete();
                    }
                    throw th;
                }
            }
        }
        if (message.what == 3) {
            if (C1786r.f6452b) {
                C1786r.m6061b("Download is canceled.", SkinListView.f3666a);
            }
            this.f3712a.m3911f();
        }
        if (message.what == 4) {
            if (C1786r.f6452b) {
                C1786r.m6061b("Download is failed.", SkinListView.f3666a);
            }
            this.f3712a.m3911f();
            this.f3712a.m3913g();
        }
    }
}
