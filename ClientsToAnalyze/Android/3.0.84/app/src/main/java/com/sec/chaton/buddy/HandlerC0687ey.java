package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1364h;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p035io.entry.FlagImageURLEntry;
import com.sec.chaton.p035io.entry.inner.CoverStory;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ey */
/* loaded from: classes.dex */
class HandlerC0687ey extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2909a;

    HandlerC0687ey(BuddyProfileFragment buddyProfileFragment) {
        this.f2909a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        FlagImageURLEntry flagImageURLEntry;
        String string;
        if (this.f2909a.f2058aQ != null && this.f2909a.f2115r != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 100:
                    this.f2909a.m3685m();
                    C3250y.m11450b("****** IGNORE : " + this.f2909a.f2117t, BuddyProfileFragment.f2014a);
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        C3641ai.m13211a(this.f2909a.f2058aQ, this.f2909a.f2058aQ.getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f2909a.f2118u), 0).show();
                        this.f2909a.f2058aQ.finish();
                        return;
                    } else {
                        C3641ai.m13210a(this.f2909a.f2058aQ, R.string.toast_network_unable, 0).show();
                        return;
                    }
                case 303:
                    this.f2909a.m3685m();
                    if (!c0267d.m11704n()) {
                        this.f2909a.f2064aW.setText(this.f2909a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed));
                        return;
                    }
                    C3250y.m11450b("************** RESULT CODE : " + c0267d.m1351b(), "ADD BUDDY");
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        C3641ai.m13211a(this.f2909a.f2058aQ, this.f2909a.f2058aQ.getResources().getString(R.string.add_buddy_added, this.f2909a.f2118u), 0).show();
                        this.f2909a.f2058aQ.finish();
                        return;
                    }
                    C3250y.m11450b("*********** ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                    C3250y.m11450b("*********** ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                    if (c0267d.m1355f() == 16003) {
                        string = this.f2909a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
                    } else if (c0267d.m1355f() == 16004) {
                        string = this.f2909a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0267d.m1355f() == 16005) {
                        string = this.f2909a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = String.format(this.f2909a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f2909a.f2118u);
                    }
                    this.f2909a.f2064aW.setText(string);
                    return;
                case 324:
                    if (c0267d != null) {
                        try {
                            try {
                            } catch (OutOfMemoryError e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            C3250y.m11443a(e2, getClass().getSimpleName());
                        }
                        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS && (flagImageURLEntry = (FlagImageURLEntry) c0267d.m1354e()) != null && !TextUtils.isEmpty(flagImageURLEntry.fileurl)) {
                            this.f2909a.f2047aF.m11730a(this.f2909a.f2066aY, new CallableC0698fi(flagImageURLEntry.fileurl, this.f2909a.f2067aZ, this.f2909a.f2094ba + ".png"));
                            return;
                        }
                        return;
                    }
                    return;
                case 602:
                    this.f2909a.m3685m();
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        C3641ai.m13211a(this.f2909a.f2058aQ, this.f2909a.f2058aQ.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                        return;
                    }
                    if (this.f2909a.f2116s == null) {
                        this.f2909a.f2116s = new C0513c(this.f2909a.f2117t, this.f2909a.f2118u);
                    }
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2909a.f2104g, this.f2909a.f2116s, 2, false));
                    return;
                case 603:
                    this.f2909a.m3685m();
                    if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                        C3641ai.m13210a(this.f2909a.f2058aQ, R.string.toast_network_unable, 0).show();
                        return;
                    }
                    C3250y.m11450b("****** UNBLOCK : " + this.f2909a.f2117t, BuddyProfileFragment.f2014a);
                    C3641ai.m13211a(this.f2909a.f2058aQ, this.f2909a.f2058aQ.getResources().getString(R.string.setting_buddy_unblocked, this.f2909a.f2118u), 0).show();
                    this.f2909a.f2058aQ.finish();
                    return;
                case 901:
                    this.f2909a.m3685m();
                    if (this.f2909a.f2082ap != null) {
                        this.f2909a.f2082ap.setVisibility(8);
                    }
                    this.f2909a.m3714a(c0267d);
                    return;
                case 903:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f2909a.m3685m();
                        if (c0267d.m1355f() == 90016) {
                            AbstractC3271a.m11494a(this.f2909a.f2058aQ).mo11500a(this.f2909a.getResources().getString(R.string.poston_title)).mo11509b(this.f2909a.getResources().getString(R.string.trunk_content_deleted)).mo11510b(this.f2909a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0688ez(this)).mo11512b();
                            return;
                        } else {
                            C3641ai.m13211a(this.f2909a.f2058aQ, this.f2909a.getResources().getString(R.string.ams_msg_cannot_delete_file), 0).show();
                            return;
                        }
                    }
                    this.f2909a.f2044aC = true;
                    this.f2909a.m3685m();
                    this.f2909a.m3714a(c0267d);
                    C3641ai.m13210a(this.f2909a.f2058aQ, R.string.poston_deleted, 0).show();
                    return;
                case 3001:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY", BuddyProfileFragment.f2014a);
                    }
                    if (c0267d == null) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY (httpEntry == null)", BuddyProfileFragment.f2014a);
                            return;
                        }
                        return;
                    }
                    String str = CommonApplication.m11493l().getCacheDir() + "/";
                    String str2 = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        CoverStory coverStory = (CoverStory) c0267d.m1354e();
                        if (coverStory == null) {
                            C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY dialogCoverStory is null !!!", BuddyProfileFragment.f2014a);
                            return;
                        }
                        if (coverStory.metaid != null) {
                            if (coverStory.contentid != null) {
                                if (!BuddyDialog.m4123a(coverStory.contentid, this.f2909a.f2117t, str2, str, this.f2909a.f2086at)) {
                                    this.f2909a.f2088av.m5760a(coverStory.contentid, Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                    this.f2909a.f2089aw = coverStory.contentid;
                                    return;
                                }
                                return;
                            }
                            if (C3250y.f11734b) {
                                C3250y.m11450b(" Kmission coverstory directly access test", BuddyProfileFragment.f2014a);
                            }
                            this.f2909a.f2047aF.m11730a(this.f2909a.f2086at, new C1960a(coverStory.host + coverStory.metacontents, this.f2909a.f2117t, str + this.f2909a.f2117t + "/coverstory/", "buddy", CommonApplication.m11493l()));
                            return;
                        }
                        C3250y.m11450b("Buddy didn't set Coverstory ", BuddyProfileFragment.f2014a);
                        String strM6090a = C1365i.m6090a();
                        if (strM6090a != null) {
                            if (!BuddyDialog.m4123a(strM6090a, this.f2909a.f2117t, str2, str, this.f2909a.f2086at)) {
                                this.f2909a.f2088av.m5760a(strM6090a, Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                this.f2909a.f2089aw = strM6090a;
                            }
                            C3250y.m11450b(" Set RandomCoverStory randomId : " + strM6090a, BuddyProfileFragment.f2014a);
                            return;
                        }
                        C3250y.m11450b(" Random ERROR !!", BuddyProfileFragment.f2014a);
                        this.f2909a.f2088av.m5763b(Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                        return;
                    }
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY NO_CONTENT", BuddyProfileFragment.f2014a);
                            this.f2909a.f2088av.m5763b(Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                            return;
                        }
                        return;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY network ERROR", BuddyProfileFragment.f2014a);
                    }
                    String str3 = CommonApplication.m11493l().getCacheDir() + "/" + this.f2909a.f2117t + "/coverstory/";
                    File file = new File(str3 + "coverstory.jpg");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY mBuddyCoverStoryFile : " + str3 + "coverstory.jpg", BuddyProfileFragment.f2014a);
                    }
                    if (!file.exists()) {
                        boolean zM4122a = BuddyDialog.m4122a(this.f2909a.f2117t, str2, this.f2909a.f2090ax, this.f2909a.f2086at);
                        if (C3250y.f11734b) {
                            C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY result : " + zM4122a, BuddyProfileFragment.f2014a);
                        }
                        if (!zM4122a) {
                            this.f2909a.f2088av.m5763b(Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2909a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                            return;
                        }
                        return;
                    }
                    return;
                case 3005:
                    if (c0267d == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", BuddyProfileFragment.f2014a);
                        return;
                    }
                    if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f2909a.f2047aF.m11730a(this.f2909a.f2086at, new C1960a(((CoverStoryDownload) c0267d.m1354e()).fileurl, this.f2909a.f2117t, C1960a.f7636b, this.f2909a.f2058aQ.getApplicationContext(), this.f2909a.f2058aQ.getApplicationContext().getCacheDir() + "/" + this.f2909a.f2117t + "/coverstory/", "coverstory.jpg", this.f2909a.f2089aw));
                        if (this.f2909a.f2089aw != null) {
                            this.f2909a.f2089aw = null;
                            return;
                        }
                        return;
                    }
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        C3250y.m11450b("Deleted item on BuddyDialog mContentId : " + this.f2909a.f2089aw, BuddyProfileFragment.f2014a);
                        C1364h.m6088b(this.f2909a.f2089aw);
                        if (this.f2909a.f2089aw != null) {
                            this.f2909a.f2089aw = null;
                        }
                        this.f2909a.m3719a();
                        return;
                    }
                    return;
                case 3006:
                    if (c0267d == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", BuddyProfileFragment.f2014a);
                        return;
                    } else {
                        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
                            this.f2909a.f2047aF.m11730a(this.f2909a.f2086at, new C1960a(((CoverStoryDownload) c0267d.m1354e()).fileurl, this.f2909a.f2117t, C1960a.f7636b, this.f2909a.f2058aQ.getApplicationContext(), this.f2909a.f2058aQ.getApplicationContext().getCacheDir() + "/" + this.f2909a.f2117t + "/coverstory/", "coverstory.jpg", this.f2909a.f2089aw));
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
