package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.view.ContextMenu;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4822an;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fv */
/* loaded from: classes.dex */
class ViewOnCreateContextMenuListenerC4248fv implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15603a;

    ViewOnCreateContextMenuListenerC4248fv(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15603a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.f15603a.m16099q()) {
            Cursor cursor = this.f15603a.f15050p.getCursor();
            String string = cursor.getString(0);
            long j = cursor.getLong(1);
            this.f15603a.m15942a(contextMenu, view, contextMenuInfo);
            C4108aq c4108aqM16323a = this.f15603a.f15050p.m16323a(string, j, cursor);
            if (c4108aqM16323a != null) {
                if (C3847e.m14649a(this.f15603a.f14933E)) {
                    String strM16040c = this.f15603a.m16040c(this.f15603a.f14933E);
                    this.f15603a.f14932D = "Type: Text message";
                    this.f15603a.f14932D += "\nFrom: " + strM16040c.substring(0, strM16040c.length() - 1) + "\nReceived: " + c4108aqM16323a.f15274i.toString();
                }
                if (Build.VERSION.SDK_INT > 15) {
                    Cursor cursorQuery = this.f15603a.getContentResolver().query(Uri.parse(Telephony.Sms.CONTENT_URI + "/cmas"), null, "sms_id = " + c4108aqM16323a.m16307j(), null, null);
                    if (cursorQuery != null) {
                        if (cursorQuery.getCount() > 0) {
                            this.f15603a.m15937a(cursorQuery);
                        }
                        this.f15603a.m16025b(cursorQuery);
                    }
                }
                contextMenu.setHeaderTitle(R.string.search);
                MenuItemOnMenuItemClickListenerC4260gg menuItemOnMenuItemClickListenerC4260gg = new MenuItemOnMenuItemClickListenerC4260gg(this.f15603a, c4108aqM16323a);
                if (!this.f15603a.m15977aD()) {
                    if (c4108aqM16323a.m16312o() || (c4108aqM16323a.m16311n() && c4108aqM16323a.f15285t == 0)) {
                        contextMenu.add(0, 24, 0, R.string.chat_view_menu_copy).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                    }
                    if (c4108aqM16323a.f15273h) {
                        contextMenu.add(0, 29, 0, R.string.menu_unlock).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                    } else {
                        contextMenu.add(0, 28, 0, R.string.menu_lock).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                    }
                    if (c4108aqM16323a.m16311n()) {
                        if (c4108aqM16323a.m16299b() == EnumC2214ab.TEXT) {
                            contextMenu.setHeaderTitle(R.string.media_text);
                        } else if (c4108aqM16323a.m16299b() == EnumC2214ab.VIDEO) {
                            contextMenu.setHeaderTitle(R.string.media_video);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else if (c4108aqM16323a.m16299b() == EnumC2214ab.IMAGE) {
                            contextMenu.setHeaderTitle(R.string.media_photo);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else if (c4108aqM16323a.m16299b() == EnumC2214ab.CALENDAR) {
                            contextMenu.setHeaderTitle(R.string.media_calendar);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                            if (this.f15603a.m16033b(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 30, 0, this.f15603a.m16060e(c4108aqM16323a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else if (c4108aqM16323a.m16299b() == EnumC2214ab.AUDIO) {
                            contextMenu.setHeaderTitle(R.string.media_voice);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                            if (this.f15603a.m16033b(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 30, 0, this.f15603a.m16060e(c4108aqM16323a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else if (c4108aqM16323a.m16299b() == EnumC2214ab.CONTACT) {
                            contextMenu.setHeaderTitle(R.string.media_contact);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                            if (this.f15603a.m16033b(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 30, 0, this.f15603a.m16060e(c4108aqM16323a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else if (c4108aqM16323a.m16299b() == EnumC2214ab.GEO) {
                            contextMenu.setHeaderTitle(R.string.layout_calendar_location);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                            if (this.f15603a.m16033b(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 30, 0, this.f15603a.m16060e(c4108aqM16323a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else if (c4108aqM16323a.m16299b() != EnumC2214ab.ANICON) {
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                            if (this.f15603a.m16033b(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 30, 0, this.f15603a.m16060e(c4108aqM16323a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        } else {
                            contextMenu.setHeaderTitle(R.string.media_anicon);
                            if (this.f15603a.m15969a(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                            if (this.f15603a.m16033b(c4108aqM16323a.f15268c)) {
                                contextMenu.add(0, 30, 0, this.f15603a.m16060e(c4108aqM16323a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                            }
                        }
                    }
                    if (c4108aqM16323a.m16313p()) {
                        contextMenu.add(0, 21, 0, C4822an.m18218a() ? R.string.menu_forward_via_message : R.string.menu_forward).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                    }
                    if (c4108aqM16323a.m16313p() && C4822an.m18218a()) {
                        if (c4108aqM16323a.f15287v != null) {
                            if (c4108aqM16323a.f15287v.size() == 1) {
                                if (c4108aqM16323a.f15287v.m14921j()) {
                                    if (!c4108aqM16323a.f15287v.f13925a.get(0).m14869i()) {
                                        contextMenu.add(0, 35, 0, R.string.menu_forward_via_chat).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                                    }
                                } else if (c4108aqM16323a.f15287v.f13925a.size() == 1 && c4108aqM16323a.f15287v.f13925a.get(0).m14879s()) {
                                    contextMenu.add(0, 35, 0, R.string.menu_forward_via_chat).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                                }
                            }
                        } else {
                            contextMenu.add(0, 35, 0, R.string.menu_forward_via_chat).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                        }
                    }
                    if (c4108aqM16323a.m16313p()) {
                        contextMenu.add(0, 36, 0, R.string.share).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                    }
                }
                contextMenu.add(0, 18, 0, R.string.delete_message).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                if (this.f15603a.m15977aD()) {
                    contextMenu.add(0, 17, 0, R.string.view_cmas_message_details).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4260gg);
                    return;
                }
                return;
            }
            C3890m.m14999e("Mms/compose", "Cannot load message item for type = " + string + ", msgId = " + j);
        }
    }
}
