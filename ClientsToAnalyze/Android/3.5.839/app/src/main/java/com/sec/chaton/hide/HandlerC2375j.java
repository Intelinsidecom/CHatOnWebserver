package com.sec.chaton.hide;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetHideBuddyList;
import com.sec.chaton.p065io.entry.inner.HideBuddy;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: HideFragment.java */
/* renamed from: com.sec.chaton.hide.j */
/* loaded from: classes.dex */
class HandlerC2375j extends Handler {

    /* renamed from: a */
    final /* synthetic */ HideFragment f8451a;

    HandlerC2375j(HideFragment hideFragment) {
        this.f8451a = hideFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        C0778b c0778b = (C0778b) message.obj;
        if (this.f8451a.f8411p != null) {
            switch (message.what) {
                case 701:
                    if (HideFragment.f8397b != null && HideFragment.f8397b.isShowing()) {
                        try {
                            HideFragment.f8397b.dismiss();
                        } catch (IllegalArgumentException e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                        }
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                        this.f8451a.f8403h.clear();
                        this.f8451a.f8405j.notifyDataSetChanged();
                        if (this.f8451a.f8413r != null) {
                            this.f8451a.f8413r.setEnabled(false);
                            C4880cr.m18523a(this.f8451a.f8413r);
                        }
                    }
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        if (this.f8451a.f8411p != null) {
                            C5179v.m19810a(this.f8451a.f8411p, R.string.popup_no_network_connection, 1).show();
                            this.f8451a.f8411p.finish();
                        }
                    } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                        this.f8451a.f8403h.clear();
                        this.f8451a.f8405j.notifyDataSetChanged();
                        if (this.f8451a.f8413r != null) {
                            this.f8451a.f8413r.setEnabled(false);
                            C4880cr.m18523a(this.f8451a.f8413r);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        ArrayList<HideBuddy> arrayList2 = ((GetHideBuddyList) c0778b.m3110e()).buddy;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            this.f8451a.f8414s = new ArrayList();
                            for (int i = 0; i < arrayList2.size(); i++) {
                                C4904y.m18646e("NO : " + arrayList2.get(i).value + ", Name : " + arrayList2.get(i).name + ", ImgStatus : " + arrayList2.get(i).imgstatus, getClass().getSimpleName());
                                if (!TextUtils.isEmpty(arrayList2.get(i).value)) {
                                    this.f8451a.f8414s.add(arrayList2.get(i).value);
                                }
                                arrayList.add(new C1093u(arrayList2.get(i).value, arrayList2.get(i).name, arrayList2.get(i).imgstatus));
                            }
                            Collections.sort(arrayList, new C2376k(this));
                            this.f8451a.f8403h.clear();
                            this.f8451a.f8403h.addAll(arrayList);
                            this.f8451a.f8405j.notifyDataSetChanged();
                        }
                    }
                    if (this.f8451a.f8411p != null) {
                        try {
                            this.f8451a.f8411p.setTitle(this.f8451a.getResources().getString(R.string.settings_hided_contacts) + " (" + Integer.toString(this.f8451a.f8403h.size()) + ")");
                        } catch (Exception e2) {
                        }
                    }
                    if (this.f8451a.f8403h.size() != 0 || this.f8451a.f8411p == null) {
                        if (this.f8451a.f8411p != null && this.f8451a.f8413r != null) {
                            this.f8451a.f8413r.setEnabled(true);
                            C4880cr.m18523a(this.f8451a.f8413r);
                        }
                    } else {
                        if (this.f8451a.f8413r != null) {
                            this.f8451a.f8413r.setEnabled(false);
                            C4880cr.m18523a(this.f8451a.f8413r);
                        }
                        this.f8451a.m10327b();
                    }
                    this.f8451a.m10334a();
                    if (this.f8451a.f8412q != null) {
                        if ((C2190d.m9798a(this.f8451a.f8411p.getContentResolver()) - C2190d.m9825c(this.f8451a.f8411p.getContentResolver())) - C2190d.m9817b(this.f8451a.f8411p.getContentResolver()) <= 0) {
                            this.f8451a.f8412q.setEnabled(false);
                        } else {
                            this.f8451a.f8412q.setEnabled(true);
                        }
                        C4880cr.m18523a(this.f8451a.f8412q);
                        break;
                    }
                    break;
                case 703:
                    if (HideFragment.f8397b != null && HideFragment.f8397b.isShowing() && !this.f8451a.getActivity().isFinishing()) {
                        HideFragment.f8397b.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        C5179v.m19810a(this.f8451a.getActivity(), R.string.hidden_contacts_toast_popup, 0).show();
                        this.f8451a.f8404i.m9558a();
                        break;
                    } else {
                        C5179v.m19810a(this.f8451a.getActivity(), R.string.selected_contacts_failed_to_hide_contacts, 0).show();
                        break;
                    }
            }
        }
    }
}
