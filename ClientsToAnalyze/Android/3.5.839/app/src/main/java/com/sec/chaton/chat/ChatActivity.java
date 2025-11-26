package com.sec.chaton.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.specialbuddy.InterfaceC4535ae;
import com.sec.chaton.specialbuddy.SpecialBuddyChatFragment;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatActivity extends BaseActivity implements InterfaceC1668dv, InterfaceC4535ae {

    /* renamed from: q */
    private static final String f5451q = ChatActivity.class.getSimpleName();

    /* renamed from: n */
    private boolean f5452n;

    /* renamed from: o */
    private ChatFragment f5453o;

    /* renamed from: p */
    private SpecialBuddyChatFragment f5454p;

    /* renamed from: t */
    private InterfaceC1061c f5457t;

    /* renamed from: r */
    private EnumC2301u f5455r = EnumC2301u.NORMAL;

    /* renamed from: s */
    private boolean f5456s = false;

    /* renamed from: u */
    private EnumC4549n f5458u = EnumC4549n.LIVEINVALID;

    @Override // com.sec.chaton.chat.InterfaceC1668dv
    /* renamed from: f */
    public void mo7821f() {
        finish();
    }

    @Override // com.sec.chaton.chat.InterfaceC1668dv
    /* renamed from: a */
    public void mo7820a(Bundle bundle) {
        this.f5454p = new SpecialBuddyChatFragment();
        this.f5457t = this.f5454p;
        this.f5454p.setArguments(bundle);
        m50e().mo183a().mo102b(this.f5453o).mo97a(this.f5453o).mo96a(R.id.fragment_controller, this.f5454p, f5451q).mo104c(this.f5454p).mo99b();
        this.f5456s = false;
    }

    @Override // com.sec.chaton.chat.InterfaceC1668dv
    /* renamed from: g */
    public void mo7822g() {
        mo7820a(m6158a(getIntent()));
    }

    @Override // com.sec.chaton.specialbuddy.InterfaceC4535ae
    /* renamed from: h */
    public void mo7823h() {
        this.f5453o = new ChatFragment();
        this.f5453o.setArguments(m6158a(getIntent()));
        this.f5457t = this.f5453o;
        m50e().mo183a().mo102b(this.f5454p).mo97a(this.f5454p).mo96a(R.id.fragment_controller, this.f5453o, f5451q).mo104c(this.f5453o).mo99b();
        this.f5456s = true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Fragment fragment;
        super.onCreate(bundle);
        setContentView(R.layout.base_singlepane);
        Intent intent = getIntent();
        if (intent != null) {
            if (m50e().mo187c() == null || m50e().mo187c().size() <= 0) {
                boolean zM7819b = m7819b(intent);
                if (intent.hasExtra("roomType")) {
                    this.f5455r = EnumC2301u.m10211a(intent.getIntExtra("roomType", EnumC2301u.NORMAL.m10212a()));
                } else if (intent.hasExtra("liveUserType") || zM7819b) {
                    this.f5455r = EnumC2301u.LIVE;
                } else {
                    this.f5455r = EnumC2301u.NORMAL;
                }
                this.f5458u = EnumC4549n.m17245a(intent.getIntExtra("liveServiceType", EnumC4549n.LIVECONTENTS.m17247a()));
                this.f5456s = true;
                if (this.f5455r == EnumC2301u.LIVE) {
                    if (intent.hasExtra("msgContentType")) {
                        if (intent.getIntExtra("msgContentType", EnumC2214ab.LIVECONTENTS.m10076a()) == EnumC2214ab.LIVECONTENTS.m10076a()) {
                            this.f5456s = false;
                        } else {
                            this.f5456s = true;
                        }
                    } else if (this.f5458u == EnumC4549n.LIVECONTENTS) {
                        this.f5456s = false;
                    } else if (this.f5458u == EnumC4549n.LIVEINVALID) {
                        this.f5458u = EnumC4549n.LIVECHAT;
                        String strM7095a = EnumC1109f.NONE.m7095a();
                        if (intent.hasExtra("liveUserType")) {
                            strM7095a = intent.getStringExtra("liveUserType");
                        } else if (intent.hasExtra("receivers")) {
                            String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                            if (stringArrayExtra.length > 0) {
                                try {
                                    strM7095a = C2186al.m9761a(getContentResolver(), stringArrayExtra[0]);
                                } catch (Exception e) {
                                    if (C4904y.f17872b) {
                                        C4904y.m18635a(e, f5451q);
                                    }
                                }
                            }
                        }
                        switch (C1619c.f6143a[EnumC1109f.m7094a(strM7095a).ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                                this.f5456s = false;
                                this.f5458u = EnumC4549n.LIVECONTENTS;
                                break;
                            case 4:
                            default:
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("can find user type. strUserType: " + strM7095a + ", liveServiceType: " + this.f5458u, f5451q);
                                }
                                this.f5456s = false;
                                this.f5458u = EnumC4549n.LIVECONTENTS;
                                break;
                            case 5:
                            case 6:
                                break;
                        }
                    }
                }
                if (this.f5456s) {
                    if (this.f5453o == null) {
                        this.f5453o = new ChatFragment();
                    }
                    this.f5457t = this.f5453o;
                    fragment = this.f5453o;
                } else {
                    if (this.f5454p == null) {
                        this.f5454p = new SpecialBuddyChatFragment();
                    }
                    this.f5457t = this.f5454p;
                    fragment = this.f5454p;
                }
                fragment.setArguments(m6158a(intent));
                m50e().mo183a().mo96a(R.id.fragment_controller, fragment, f5451q).mo99b();
            }
        }
    }

    /* renamed from: b */
    private boolean m7819b(Intent intent) {
        if (intent == null) {
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra("specialbuddy", false);
        boolean booleanExtra2 = intent.getBooleanExtra("eventpage", false);
        boolean booleanExtra3 = intent.getBooleanExtra("liveprofile", false);
        if (booleanExtra) {
            C4904y.m18639b("checkSpecialBuddy(), spbd_intent, specialbuddy flag : true", f5451q);
            return true;
        }
        if (booleanExtra2) {
            C4904y.m18639b("checkSpecialBuddy(), spbd_intent, eventPage flag : true", f5451q);
            return true;
        }
        if (booleanExtra3) {
            C4904y.m18639b("checkSpecialBuddy(), spbd_intent, liveBuddyProfile flag : true", f5451q);
            return true;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
        return stringArrayExtra != null && stringArrayExtra.length > 0 && stringArrayExtra[0].startsWith("0999");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[Catch: IllegalStateException -> 0x002d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x002d, blocks: (B:6:0x000d, B:8:0x0013, B:10:0x0017, B:12:0x001b, B:14:0x0022, B:16:0x0026, B:20:0x003a), top: B:23:0x000d }] */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBackPressed() {
        /*
            r2 = this;
            r0 = 0
            com.sec.chaton.base.c r1 = r2.f5457t
            if (r1 == 0) goto Lb
            com.sec.chaton.base.c r0 = r2.f5457t
            boolean r0 = r0.onBackKeyPressed()
        Lb:
            if (r0 != 0) goto L21
            com.sec.chaton.e.u r0 = r2.f5455r     // Catch: java.lang.IllegalStateException -> L2d
            com.sec.chaton.e.u r1 = com.sec.chaton.p057e.EnumC2301u.LIVE     // Catch: java.lang.IllegalStateException -> L2d
            if (r0 != r1) goto L3a
            boolean r0 = r2.f5456s     // Catch: java.lang.IllegalStateException -> L2d
            if (r0 == 0) goto L22
            com.sec.chaton.specialbuddy.SpecialBuddyChatFragment r0 = r2.f5454p     // Catch: java.lang.IllegalStateException -> L2d
            if (r0 == 0) goto L3a
            r2.mo7822g()     // Catch: java.lang.IllegalStateException -> L2d
            r0 = 0
            r2.f5453o = r0     // Catch: java.lang.IllegalStateException -> L2d
        L21:
            return
        L22:
            com.sec.chaton.chat.ChatFragment r0 = r2.f5453o     // Catch: java.lang.IllegalStateException -> L2d
            if (r0 == 0) goto L3a
            r2.mo7823h()     // Catch: java.lang.IllegalStateException -> L2d
            r0 = 0
            r2.f5454p = r0     // Catch: java.lang.IllegalStateException -> L2d
            goto L21
        L2d:
            r0 = move-exception
            java.lang.Class r1 = r2.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C4904y.m18635a(r0, r1)
            goto L21
        L3a:
            super.onBackPressed()     // Catch: java.lang.IllegalStateException -> L2d
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatActivity.onBackPressed():void");
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f5455r == EnumC2301u.LIVE) {
                onBackPressed();
            } else {
                finish();
            }
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C4904y.m18641c("[LIFE] onNewIntent, Task ID: " + getTaskId(), getClass().getSimpleName());
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        C4904y.m18641c("[LIFE] onStart, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStart();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        C4904y.m18641c("[LIFE] onStop, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStop();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        C4904y.m18641c("[LIFE] onResume, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        super.onSupportCreateOptionsMenu(menu);
        if (this.f5456s) {
            getMenuInflater().inflate(R.menu.activity_chat_menu, menu);
            return true;
        }
        getMenuInflater().inflate(R.menu.activity_contentschat_menu, menu);
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        C4904y.m18641c("[LIFE] onPause, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onPause();
    }

    /* renamed from: i */
    public ArrayList<String> m7824i() {
        if (this.f5453o == null) {
            return null;
        }
        return this.f5453o.m8278w();
    }

    /* renamed from: j */
    public void m7825j() {
        if (this.f5453o != null) {
            this.f5453o.m8274s();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C4904y.f17872b) {
            C4904y.m18639b("onActivityResult", f5451q);
        }
        this.f5452n = true;
    }
}
