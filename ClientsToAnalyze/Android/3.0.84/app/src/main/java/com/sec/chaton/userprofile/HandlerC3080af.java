package com.sec.chaton.userprofile;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.af */
/* loaded from: classes.dex */
class HandlerC3080af extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f11292a;

    HandlerC3080af(MyInfoFragment myInfoFragment) {
        this.f11292a = myInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        boolean z;
        if (this.f11292a.getActivity() != null) {
            switch (message.what) {
                case 411:
                    C0267d c0267d = (C0267d) message.obj;
                    if (c0267d != null) {
                        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                            C3250y.m11456e("ProfileControl.METHOD_GET_PROFILE_ALL Success", getClass().getSimpleName());
                            String strM10979a = C3159aa.m10962a().m10979a("birthday_server", "");
                            if (!strM10979a.equals("")) {
                                MyInfoFragment.m10677a(strM10979a);
                            }
                            this.f11292a.m10674a();
                            this.f11292a.m10686e();
                            break;
                        } else {
                            AbstractC3271a.m11494a(this.f11292a.getActivity()).mo11495a(R.string.ams_attention_title).mo11506b(R.string.buddy_profile_saveprofile_toast_failed).mo11511b(true).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3082ah(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3081ag(this)).mo11512b();
                            break;
                        }
                    }
                    break;
                case HttpResponseCode.TOO_LONG /* 413 */:
                    LayoutInflater layoutInflater = (LayoutInflater) this.f11292a.getActivity().getSystemService("layout_inflater");
                    ImageView imageView = (ImageView) this.f11292a.f11092p.findViewById(R.id.info_phone_number_divider);
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (c0267d2 != null && c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                        this.f11292a.f11089m.removeAllViews();
                        BuddyMappingInfo buddyMappingInfo = (BuddyMappingInfo) c0267d2.m1354e();
                        if (buddyMappingInfo == null || !buddyMappingInfo.mapping.booleanValue()) {
                            z = false;
                        } else {
                            z = false;
                            for (int i = 0; i < buddyMappingInfo.MappingInfo.size(); i++) {
                                String str = buddyMappingInfo.MappingInfo.get(i).phoneNumber;
                                if (str != null && !str.equals(this.f11292a.f11085i)) {
                                    View viewInflate = layoutInflater.inflate(R.layout.phonenumber_adapter_item, (ViewGroup) null);
                                    ((TextView) viewInflate.findViewById(R.id.mypage_phonenumber)).setText("+" + str);
                                    this.f11292a.f11089m.addView(viewInflate);
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            imageView.setVisibility(8);
                            break;
                        } else {
                            imageView.setVisibility(0);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
