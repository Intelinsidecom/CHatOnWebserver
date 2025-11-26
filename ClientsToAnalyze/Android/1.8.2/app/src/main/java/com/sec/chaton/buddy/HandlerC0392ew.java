package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetContentCategoryList;
import com.sec.chaton.p028io.entry.inner.ContentCategory;
import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ew */
/* loaded from: classes.dex */
class HandlerC0392ew extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1551a;

    HandlerC0392ew(SpecialBuddyActivity specialBuddyActivity) {
        this.f1551a = specialBuddyActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, RemoteException, OperationApplicationException {
        String string;
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 319) {
            this.f1551a.f1253k.dismiss();
            return;
        }
        if (message.what == 320) {
            this.f1551a.f1253k.dismiss();
            return;
        }
        if (message.what == 100) {
            if (!c0101b.m664a() || c0101b.m665b() != EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1551a.f1254l, this.f1551a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1551a.f1251i.m2354a());
            this.f1551a.f1252j.m2890a("true", arrayList);
            return;
        }
        if (message.what == 316) {
            this.f1551a.f1253k.dismiss();
            if (!c0101b.m664a() || c0101b.m665b() != EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1551a.f1254l, this.f1551a.getResources().getString(R.string.dev_network_error), 0).show();
                return;
            }
            GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0101b.m671d();
            C1786r.m6061b("categoryList.bFollowCount : " + getContentCategoryList.followcount + " categoryList.nLikeCount" + getContentCategoryList.likecount, getClass().getSimpleName());
            this.f1551a.f1257o = Integer.parseInt(getContentCategoryList.likecount);
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            if (this.f1551a.f1251i != null) {
                SpecialUser specialUser = new SpecialUser();
                specialUser.followcount = getContentCategoryList.followcount;
                arrayList2.add(C0657a.m2973a(this.f1551a.getContentResolver(), this.f1551a.m2271a(this.f1551a.f1251i, specialUser)));
                try {
                    this.f1551a.getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.f1551a.f1250e.startQuery(1, null, C0704s.f2647a, null, "buddy_no = ? ", new String[]{this.f1551a.f1255m}, null);
            StringBuilder sb = new StringBuilder();
            Iterator it = getContentCategoryList.contentcategory.iterator();
            while (it.hasNext()) {
                sb.append(((ContentCategory) it.next()).name);
                if (!TextUtils.isEmpty(getContentCategoryList.contentcategory.toString())) {
                    sb.append(", ");
                }
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                this.f1551a.f1267y.setText(R.string.calendar_description);
                this.f1551a.f1268z.setText(sb.toString());
                return;
            }
            return;
        }
        if (message.what == 321) {
            if (!c0101b.m664a() || c0101b.m665b() != EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1551a.f1254l, this.f1551a.getResources().getString(R.string.dev_network_error), 0).show();
                return;
            } else {
                this.f1551a.f1250e.startQuery(1, null, C0704s.f2647a, null, "buddy_no = ? ", new String[]{this.f1551a.f1255m}, null);
                C1786r.m6061b("Get Following buddy's info isConnectionSuccess()=" + c0101b.m664a() + ", result=" + c0101b.m665b() + ", fault=" + c0101b.m673f(), "BUDDY PROFILE");
                return;
            }
        }
        if (message.what == 303) {
            if (this.f1551a.f1253k != null && this.f1551a.f1253k.isShowing()) {
                this.f1551a.f1253k.dismiss();
            }
            if (c0101b.m664a()) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f1551a.f1259q = true;
                    C2153y.m7536a(this.f1551a.f1254l, "'" + this.f1551a.f1251i.m2355b() + "' " + this.f1551a.getResources().getString(R.string.buddy_suggestion_added_to_list), 0).show();
                    this.f1551a.m2247a(this.f1551a.f1259q);
                    this.f1551a.finish();
                    return;
                }
                if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                    new AlertDialogBuilderC2120a(this.f1551a.f1254l).setTitle(this.f1551a.getResources().getString(R.string.toast_error)).setMessage(String.format(this.f1551a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1551a.f1261s.getText())).setPositiveButton(this.f1551a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0393ex(this)).show();
                    return;
                }
                C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), null);
                if (c0101b.m673f() == 16003) {
                    string = this.f1551a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0101b.m673f() == 16004) {
                    string = this.f1551a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0101b.m673f() == 16005) {
                    string = this.f1551a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f1551a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                new AlertDialogBuilderC2120a(this.f1551a.f1254l).setTitle(this.f1551a.getResources().getString(R.string.toast_error)).setMessage(string).setPositiveButton(this.f1551a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0394ey(this)).show();
                return;
            }
            return;
        }
        if (message.what == 318) {
            if (!c0101b.m664a() || c0101b.m665b() != EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1551a.f1254l, this.f1551a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            }
            this.f1551a.f1259q = false;
            this.f1551a.m2247a(this.f1551a.f1259q);
            this.f1551a.finish();
            return;
        }
        if (message.what == 602) {
            this.f1551a.f1253k.dismiss();
            if (!c0101b.m664a() || c0101b.m665b() != EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1551a.f1254l, this.f1551a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            }
            C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1551a.f1248c, this.f1551a.m2270a(this.f1551a.f1251i), 2, false));
            this.f1551a.f1259q = false;
            this.f1551a.m2247a(this.f1551a.f1259q);
            this.f1551a.finish();
            return;
        }
        if (message.what == 603) {
            this.f1551a.f1253k.dismiss();
            if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("isNew", "Y");
                this.f1551a.f1250e.startUpdate(0, null, C0704s.f2647a, contentValues, "buddy_no='" + this.f1551a.f1255m + "'", null);
                this.f1551a.f1259q = true;
                this.f1551a.m2247a(this.f1551a.f1259q);
                this.f1551a.finish();
                return;
            }
            C2153y.m7536a(this.f1551a.f1254l, this.f1551a.getResources().getString(R.string.setting_buddy_unblocked, this.f1551a.f1255m), 0).show();
        }
    }
}
