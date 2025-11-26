package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.GetBlockBuddyList;
import com.sec.chaton.p035io.entry.inner.BlockBuddy;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.j */
/* loaded from: classes.dex */
class HandlerC0484j extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1596a;

    HandlerC0484j(BlockFragment blockFragment) {
        this.f1596a = blockFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        if (this.f1596a.f1553n != null) {
            switch (message.what) {
                case 601:
                    if (BlockFragment.f1541b != null && BlockFragment.f1541b.isShowing()) {
                        try {
                            BlockFragment.f1541b.dismiss();
                        } catch (IllegalArgumentException e) {
                            C3250y.m11443a(e, getClass().getSimpleName());
                        }
                    }
                    this.f1596a.f1547h.setEmptyView(this.f1596a.f1551l);
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        this.f1596a.f1548i.clear();
                        this.f1596a.f1550k.notifyDataSetChanged();
                        if (this.f1596a.f1555p != null) {
                            this.f1596a.f1555p.setEnabled(false);
                            C3228cp.m11343a(this.f1596a.f1555p);
                        }
                        this.f1596a.f1551l.setVisibility(0);
                    }
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        if (this.f1596a.f1553n != null) {
                            C3641ai.m13210a(this.f1596a.f1553n, R.string.popup_no_network_connection, 1).show();
                            this.f1596a.f1553n.finish();
                        }
                    } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        this.f1596a.f1548i.clear();
                        this.f1596a.f1550k.notifyDataSetChanged();
                        if (this.f1596a.f1555p != null) {
                            this.f1596a.f1555p.setEnabled(false);
                            C3228cp.m11343a(this.f1596a.f1555p);
                        }
                        this.f1596a.f1551l.setVisibility(0);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        ArrayList<BlockBuddy> arrayList2 = ((GetBlockBuddyList) c0267d.m1354e()).buddy;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            this.f1596a.f1556q = new ArrayList();
                            for (int i = 0; i < arrayList2.size(); i++) {
                                C3250y.m11456e("NO : " + arrayList2.get(i).value + ", Name : " + arrayList2.get(i).name + ", ORGNUM : " + arrayList2.get(i).orgnum, getClass().getSimpleName());
                                if (!TextUtils.isEmpty(arrayList2.get(i).value)) {
                                    this.f1596a.f1556q.add(arrayList2.get(i).value);
                                }
                                arrayList.add(new C0475ac(arrayList2.get(i).value, arrayList2.get(i).name, arrayList2.get(i).orgnum));
                            }
                            Collections.sort(arrayList, new C0485k(this));
                            this.f1596a.f1548i.clear();
                            this.f1596a.f1548i.addAll(arrayList);
                            this.f1596a.f1550k.notifyDataSetChanged();
                        }
                    }
                    if (this.f1596a.f1553n != null) {
                        try {
                            this.f1596a.f1553n.setTitle(this.f1596a.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1596a.f1548i.size()) + ")");
                        } catch (Exception e2) {
                        }
                    }
                    if (this.f1596a.f1548i.size() != 0 || this.f1596a.f1553n == null) {
                        if (this.f1596a.f1553n != null) {
                            this.f1596a.f1551l.setVisibility(8);
                            if (this.f1596a.f1555p != null) {
                                this.f1596a.f1555p.setEnabled(true);
                                C3228cp.m11343a(this.f1596a.f1555p);
                            }
                        }
                    } else {
                        if (this.f1596a.f1555p != null) {
                            this.f1596a.f1555p.setEnabled(false);
                            C3228cp.m11343a(this.f1596a.f1555p);
                        }
                        this.f1596a.f1551l.setVisibility(0);
                    }
                    this.f1596a.m3107a();
                    if (this.f1596a.f1554o != null) {
                        if (C1360d.m6034b(this.f1596a.f1553n.getContentResolver()) - C1360d.m6041c(this.f1596a.f1553n.getContentResolver()) <= 0) {
                            this.f1596a.f1554o.setEnabled(false);
                        } else {
                            this.f1596a.f1554o.setEnabled(true);
                        }
                        C3228cp.m11343a(this.f1596a.f1554o);
                        break;
                    }
                    break;
                case 606:
                    if (BlockFragment.f1541b != null && BlockFragment.f1541b.isShowing() && !this.f1596a.getActivity().isFinishing()) {
                        BlockFragment.f1541b.dismiss();
                    }
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f1596a.f1549j.m5704a();
                        break;
                    }
                    break;
            }
        }
    }
}
