package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBlockBuddyList;
import com.sec.chaton.p028io.entry.inner.BlockBuddy;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.l */
/* loaded from: classes.dex */
class HandlerC0252l extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f835a;

    HandlerC0252l(BlockFragment blockFragment) {
        this.f835a = blockFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 601:
                if (this.f835a.f806l && BlockFragment.f796b != null && BlockFragment.f796b.isShowing()) {
                    this.f835a.f806l = false;
                    break;
                } else {
                    if (BlockFragment.f796b != null && BlockFragment.f796b.isShowing()) {
                        BlockFragment.f796b.dismiss();
                    }
                    if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                        if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                            this.f835a.f803i.setVisibility(0);
                            this.f835a.f800f.clear();
                            this.f835a.f802h.notifyDataSetChanged();
                            this.f835a.f807m.setVisibility(8);
                            if (this.f835a.f808n != null) {
                                this.f835a.m1854a().findItem(R.id.actionbar_title_remove).setVisible(false).setEnabled(false);
                            }
                            this.f835a.f805k.setText(R.string.settings_blocked);
                            break;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = ((GetBlockBuddyList) c0101b.m671d()).buddy;
                            if (arrayList2 == null) {
                                this.f835a.f803i.setVisibility(0);
                                this.f835a.f807m.setVisibility(8);
                                break;
                            } else if (arrayList2.size() == 0) {
                                this.f835a.f803i.setVisibility(0);
                                this.f835a.f807m.setVisibility(8);
                                if (this.f835a.f808n != null) {
                                    this.f835a.m1854a().findItem(R.id.actionbar_title_remove).setVisible(false).setEnabled(false);
                                    break;
                                }
                            } else {
                                this.f835a.f803i.setVisibility(8);
                                this.f835a.f807m.setVisibility(0);
                                if (this.f835a.f808n != null) {
                                    this.f835a.m1854a().findItem(R.id.actionbar_title_remove).setVisible(true).setEnabled(true);
                                }
                                for (int i = 0; i < arrayList2.size(); i++) {
                                    C1786r.m6066e("NO : " + ((BlockBuddy) arrayList2.get(i)).value + ", Name : " + ((BlockBuddy) arrayList2.get(i)).name + ", ORGNUM : " + ((BlockBuddy) arrayList2.get(i)).orgnum, getClass().getSimpleName());
                                    arrayList.add(new C0253m(this.f835a, R.drawable.contacts_default_image, ((BlockBuddy) arrayList2.get(i)).value, ((BlockBuddy) arrayList2.get(i)).name, ((BlockBuddy) arrayList2.get(i)).orgnum));
                                }
                                this.f835a.f800f.clear();
                                this.f835a.f800f.addAll(arrayList);
                                this.f835a.f802h.notifyDataSetChanged();
                                break;
                            }
                        }
                    } else {
                        if (this.f835a.getActivity() != null) {
                            Toast.makeText(this.f835a.getActivity(), R.string.toast_setting_communication_failed, 1).show();
                        }
                        if (!GlobalApplication.m3265f()) {
                            this.f835a.getActivity().finish();
                            break;
                        }
                    }
                }
                break;
            case 603:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f835a.f801g.m2844a();
                    BlockFragment.f796b.show();
                    break;
                }
                break;
        }
    }
}
