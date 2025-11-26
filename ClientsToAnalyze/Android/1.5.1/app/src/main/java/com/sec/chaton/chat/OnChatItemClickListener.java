package com.sec.chaton.chat;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.widget.ProfileImageView;

/* loaded from: classes.dex */
public interface OnChatItemClickListener {
    /* renamed from: a */
    void mo756a(View view);

    /* renamed from: a */
    void mo757a(View view, long j);

    /* renamed from: a */
    void mo758a(View view, long j, int i);

    /* renamed from: a */
    void mo759a(View view, long j, ChatONContract.MessageTable.MsgContentType msgContentType);

    /* renamed from: a */
    void mo760a(View view, Uri uri);

    /* renamed from: a */
    void mo761a(View view, ProfileImageView profileImageView, String str, String str2);

    /* renamed from: a */
    void mo762a(View view, String str, String str2);
}
