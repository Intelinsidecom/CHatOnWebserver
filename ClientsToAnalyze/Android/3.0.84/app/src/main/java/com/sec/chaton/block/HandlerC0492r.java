package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetBlockBuddyList;
import com.sec.chaton.p035io.entry.inner.BlockBuddy;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: BlockImpl.java */
/* renamed from: com.sec.chaton.block.r */
/* loaded from: classes.dex */
class HandlerC0492r extends Handler {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0487m f1619a;

    HandlerC0492r(MenuItemOnMenuItemClickListenerC0487m menuItemOnMenuItemClickListenerC0487m) {
        this.f1619a = menuItemOnMenuItemClickListenerC0487m;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 601:
                if (MenuItemOnMenuItemClickListenerC0487m.f1600b != null && MenuItemOnMenuItemClickListenerC0487m.f1600b.isShowing()) {
                    try {
                        MenuItemOnMenuItemClickListenerC0487m.f1600b.dismiss();
                    } catch (IllegalArgumentException e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                    }
                }
                this.f1619a.f1605g.setEmptyView(this.f1619a.f1609k);
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                    this.f1619a.f1606h.clear();
                    this.f1619a.f1608j.notifyDataSetChanged();
                    if (this.f1619a.f1612n != null) {
                        if (!GlobalApplication.m6456e()) {
                            this.f1619a.f1612n.setVisible(false);
                        } else {
                            this.f1619a.f1612n.setEnabled(false);
                            C3228cp.m11343a(this.f1619a.f1612n);
                        }
                    }
                    this.f1619a.f1609k.setVisibility(0);
                }
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    if (this.f1619a.f1611m != null) {
                        C3641ai.m13210a(this.f1619a.f1611m, R.string.popup_no_network_connection, 1).show();
                        this.f1619a.f1611m.finish();
                    }
                } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                    this.f1619a.f1606h.clear();
                    this.f1619a.f1608j.notifyDataSetChanged();
                    if (this.f1619a.f1612n != null) {
                        if (!GlobalApplication.m6456e()) {
                            this.f1619a.f1612n.setVisible(false);
                        } else {
                            this.f1619a.f1612n.setEnabled(false);
                            C3228cp.m11343a(this.f1619a.f1612n);
                        }
                    }
                    this.f1619a.f1609k.setVisibility(0);
                } else {
                    ArrayList arrayList = new ArrayList();
                    ArrayList<BlockBuddy> arrayList2 = ((GetBlockBuddyList) c0267d.m1354e()).buddy;
                    if (arrayList2 != null && arrayList2.size() != 0) {
                        this.f1619a.f1613o = new ArrayList();
                        for (int i = 0; i < arrayList2.size(); i++) {
                            C3250y.m11456e("NO : " + arrayList2.get(i).value + ", Name : " + arrayList2.get(i).name + ", ORGNUM : " + arrayList2.get(i).orgnum, getClass().getSimpleName());
                            if (!TextUtils.isEmpty(arrayList2.get(i).value)) {
                                this.f1619a.f1613o.add(arrayList2.get(i).value);
                            }
                            arrayList.add(new C0475ac(arrayList2.get(i).value, arrayList2.get(i).name, arrayList2.get(i).orgnum));
                        }
                        this.f1619a.f1606h.clear();
                        this.f1619a.f1606h.addAll(arrayList);
                        this.f1619a.f1608j.notifyDataSetChanged();
                    }
                }
                if (this.f1619a.f1611m != null) {
                    try {
                        if (!GlobalApplication.m6456e()) {
                            this.f1619a.f1611m.setTitle(this.f1619a.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1619a.f1606h.size()) + ")");
                        } else {
                            this.f1619a.f1614p.setText(this.f1619a.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1619a.f1606h.size()) + ")");
                        }
                    } catch (Exception e2) {
                    }
                }
                if (this.f1619a.f1606h.size() != 0 || this.f1619a.f1611m == null) {
                    if (this.f1619a.f1611m != null) {
                        this.f1619a.f1609k.setVisibility(8);
                        if (this.f1619a.f1612n != null) {
                            if (!GlobalApplication.m6456e()) {
                                this.f1619a.f1612n.setVisible(true);
                            } else {
                                this.f1619a.f1612n.setEnabled(true);
                                C3228cp.m11343a(this.f1619a.f1612n);
                            }
                        }
                    }
                } else {
                    if (this.f1619a.f1612n != null) {
                        if (!GlobalApplication.m6456e()) {
                            this.f1619a.f1612n.setVisible(false);
                        } else {
                            this.f1619a.f1612n.setEnabled(false);
                            C3228cp.m11343a(this.f1619a.f1612n);
                        }
                    }
                    this.f1619a.f1609k.setVisibility(0);
                }
                this.f1619a.m3152d();
                break;
            case 606:
                if (MenuItemOnMenuItemClickListenerC0487m.f1600b != null && MenuItemOnMenuItemClickListenerC0487m.f1600b.isShowing() && this.f1619a.f1611m != null && !this.f1619a.f1611m.isFinishing()) {
                    MenuItemOnMenuItemClickListenerC0487m.f1600b.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f1619a.f1607i.m5704a();
                    break;
                }
                break;
        }
    }
}
