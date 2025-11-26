package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetMemoBlindList;
import com.sec.chaton.p028io.entry.inner.MemoBlindEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dn */
/* loaded from: classes.dex */
class HandlerC1316dn extends Handler {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4891a;

    HandlerC1316dn(SettingFragment settingFragment) {
        this.f4891a = settingFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        switch (message.what) {
            case 905:
                C0101b c0101b = (C0101b) message.obj;
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    if (this.f4891a.f4738p != null) {
                        this.f4891a.f4738p.dismiss();
                    }
                    Toast.makeText(SettingFragment.f4730l, this.f4891a.getResources().getString(R.string.toast_network_unable), 0).show();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((GetMemoBlindList) c0101b.m671d()).blind.iterator();
                    while (it.hasNext()) {
                        MemoBlindEntry memoBlindEntry = (MemoBlindEntry) it.next();
                        try {
                            Long.parseLong(memoBlindEntry.value);
                            arrayList.add(memoBlindEntry.value);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    this.f4891a.f4739q.clear();
                    this.f4891a.f4739q = arrayList;
                    Intent intent = new Intent(SettingFragment.f4730l, (Class<?>) BuddyActivity2.class);
                    intent.putExtra("BUDDY_SORT_STYLE", 11);
                    intent.putExtra("ACTIVITY_PURPOSE", 9);
                    intent.putExtra("ACTIVITY_PURPOSE_ARG", arrayList);
                    ((BaseActivity) this.f4891a.getActivity()).mo1830a(intent);
                }
                if (GlobalApplication.m3265f() && this.f4891a.f4738p != null) {
                    this.f4891a.f4738p.dismiss();
                    break;
                }
                break;
            case 906:
                C0101b c0101b2 = (C0101b) message.obj;
                if (!c0101b2.m664a() || c0101b2.m665b() == EnumC0803m.ERROR) {
                    if (this.f4891a.f4738p != null) {
                        this.f4891a.f4738p.dismiss();
                    }
                    Toast.makeText(SettingFragment.f4730l, this.f4891a.getResources().getString(R.string.toast_network_unable), 0).show();
                    break;
                } else {
                    Toast.makeText(SettingFragment.f4730l, this.f4891a.getResources().getString(R.string.toast_save_media), 0).show();
                    break;
                }
                break;
        }
    }
}
