package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetBlockBuddyList;
import com.sec.chaton.p065io.entry.inner.BlockBuddy;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.i */
/* loaded from: classes.dex */
class HandlerC1081i extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f3461a;

    HandlerC1081i(BlockFragment blockFragment) {
        this.f3461a = blockFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        C0778b c0778b = (C0778b) message.obj;
        if (this.f3461a.f3421q != null) {
            switch (message.what) {
                case 601:
                    if (BlockFragment.f3406b != null && BlockFragment.f3406b.isShowing()) {
                        try {
                            BlockFragment.f3406b.dismiss();
                        } catch (IllegalArgumentException e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                        }
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                        this.f3461a.f3412h.clear();
                        this.f3461a.f3414j.notifyDataSetChanged();
                        if (this.f3461a.f3423s != null) {
                            this.f3461a.f3423s.setEnabled(false);
                            C4880cr.m18523a(this.f3461a.f3423s);
                        }
                    }
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        if (this.f3461a.f3421q != null) {
                            C5179v.m19810a(this.f3461a.f3421q, R.string.popup_no_network_connection, 1).show();
                            this.f3461a.f3421q.finish();
                        }
                    } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                        this.f3461a.f3412h.clear();
                        this.f3461a.f3414j.notifyDataSetChanged();
                        if (this.f3461a.f3423s != null) {
                            this.f3461a.f3423s.setEnabled(false);
                            C4880cr.m18523a(this.f3461a.f3423s);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        ArrayList<BlockBuddy> arrayList2 = ((GetBlockBuddyList) c0778b.m3110e()).buddy;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            this.f3461a.f3424t = new ArrayList();
                            for (int i = 0; i < arrayList2.size(); i++) {
                                C4904y.m18646e("NO : " + arrayList2.get(i).value + ", Name : " + arrayList2.get(i).name + ", ORGNUM : " + arrayList2.get(i).orgnum, getClass().getSimpleName());
                                if (!TextUtils.isEmpty(arrayList2.get(i).value)) {
                                    this.f3461a.f3424t.add(arrayList2.get(i).value);
                                }
                                arrayList.add(new C1093u(arrayList2.get(i).value, arrayList2.get(i).name, arrayList2.get(i).orgnum));
                            }
                            Collections.sort(arrayList, new C1082j(this));
                            this.f3461a.f3412h.clear();
                            this.f3461a.f3412h.addAll(arrayList);
                            this.f3461a.f3414j.notifyDataSetChanged();
                        }
                    }
                    if (this.f3461a.f3421q != null) {
                        try {
                            this.f3461a.f3421q.setTitle(this.f3461a.getResources().getString(R.string.settings_blocked_contacts) + " (" + Integer.toString(this.f3461a.f3412h.size()) + ")");
                        } catch (Exception e2) {
                        }
                    }
                    if (this.f3461a.f3412h.size() != 0 || this.f3461a.f3421q == null) {
                        if (this.f3461a.f3421q != null && this.f3461a.f3423s != null) {
                            this.f3461a.f3423s.setEnabled(true);
                            C4880cr.m18523a(this.f3461a.f3423s);
                        }
                    } else {
                        if (this.f3461a.f3423s != null) {
                            this.f3461a.f3423s.setEnabled(false);
                            C4880cr.m18523a(this.f3461a.f3423s);
                        }
                        this.f3461a.m6188b();
                    }
                    this.f3461a.m6195a();
                    if (this.f3461a.f3422r != null) {
                        if ((C2190d.m9798a(this.f3461a.f3421q.getContentResolver()) - C2190d.m9825c(this.f3461a.f3421q.getContentResolver())) - C2190d.m9817b(this.f3461a.f3421q.getContentResolver()) <= 0) {
                            this.f3461a.f3422r.setEnabled(false);
                        } else {
                            this.f3461a.f3422r.setEnabled(true);
                        }
                        C4880cr.m18523a(this.f3461a.f3422r);
                        break;
                    }
                    break;
                case 606:
                    if (BlockFragment.f3406b != null && BlockFragment.f3406b.isShowing() && !this.f3461a.getActivity().isFinishing()) {
                        BlockFragment.f3406b.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        C5179v.m19810a(this.f3461a.getActivity(), R.string.blocked_contacts_toast_popup, 0).show();
                        this.f3461a.f3413i.m9477a();
                        break;
                    } else {
                        C5179v.m19811a(this.f3461a.getActivity(), this.f3461a.getResources().getString(R.string.selected_contacts_failed_to_block_contacts), 0).show();
                        break;
                    }
            }
        }
    }
}
