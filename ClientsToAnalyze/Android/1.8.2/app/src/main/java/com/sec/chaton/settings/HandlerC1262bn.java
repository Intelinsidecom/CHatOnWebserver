package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetMemoBlindList;
import com.sec.chaton.p028io.entry.inner.MemoBlindEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddiesSaySettings.java */
/* renamed from: com.sec.chaton.settings.bn */
/* loaded from: classes.dex */
class HandlerC1262bn extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddiesSaySettings f4803a;

    HandlerC1262bn(BuddiesSaySettings buddiesSaySettings) {
        this.f4803a = buddiesSaySettings;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        switch (message.what) {
            case 905:
                if (!this.f4803a.f4583n || this.f4803a.f4582m == null || !this.f4803a.f4582m.isShowing()) {
                    if (this.f4803a.f4582m != null && this.f4803a.f4582m.isShowing()) {
                        this.f4803a.f4582m.dismiss();
                    }
                    C0101b c0101b = (C0101b) message.obj;
                    if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                        Toast.makeText(this.f4803a.f4578i, this.f4803a.getResources().getString(R.string.toast_network_unable), 0).show();
                        break;
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
                        this.f4803a.f4580k.clear();
                        this.f4803a.f4580k = arrayList;
                        this.f4803a.getIntent().putExtra("ACTIVITY_PURPOSE_ARG", arrayList);
                        this.f4803a.f4576d = new BuddyFragment(this.f4803a.f4577e);
                        this.f4803a.f4575c = this.f4803a.f4576d;
                        this.f4803a.f4576d.setArguments(BaseActivity.m1828b(this.f4803a.getIntent()));
                        FragmentTransaction fragmentTransactionBeginTransaction = this.f4803a.getSupportFragmentManager().beginTransaction();
                        fragmentTransactionBeginTransaction.add(R.id.buddy_controller, this.f4803a.f4576d);
                        if (!fragmentTransactionBeginTransaction.isEmpty()) {
                            fragmentTransactionBeginTransaction.commit();
                            break;
                        }
                    }
                } else {
                    this.f4803a.f4583n = false;
                    break;
                }
                break;
            case 906:
                if (this.f4803a.f4582m != null && this.f4803a.f4582m.isShowing()) {
                    this.f4803a.f4582m.dismiss();
                }
                C0101b c0101b2 = (C0101b) message.obj;
                if (!c0101b2.m664a() || c0101b2.m665b() == EnumC0803m.ERROR) {
                    Toast.makeText(this.f4803a.f4578i, this.f4803a.getResources().getString(R.string.toast_network_unable), 0).show();
                    break;
                } else {
                    Toast.makeText(this.f4803a.f4578i, this.f4803a.getResources().getString(R.string.toast_save_media), 0).show();
                    break;
                }
                break;
        }
    }
}
