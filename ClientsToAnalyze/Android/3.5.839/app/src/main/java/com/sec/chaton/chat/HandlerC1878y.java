package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.common.tooltip.C5013c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.y */
/* loaded from: classes.dex */
class HandlerC1878y extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f7096a;

    HandlerC1878y(ChatFragment chatFragment) {
        this.f7096a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View viewFindViewById;
        super.handleMessage(message);
        if (this.f7096a.getActivity() != null) {
            if (C4878cp.m18516a().m18518b(EnumC4879cq.CHAT_ALBUM)) {
                if (this.f7096a.f5547ap != null && this.f7096a.f5547ap.findItem(R.id.chat_menu_trunk) != null && this.f7096a.f5547ap.findItem(R.id.chat_menu_trunk).isEnabled() && (viewFindViewById = this.f7096a.getActivity().getWindow().getDecorView().findViewById(R.id.chat_menu_trunk)) != null) {
                    new C5013c().m19050a(viewFindViewById).m19049a(R.string.tooltip_album).m19048a().m19042a(this.f7096a.getActivity());
                    C4878cp.m18516a().m18517a(EnumC4879cq.CHAT_ALBUM);
                    return;
                }
                return;
            }
            if (C4822an.m18205O() && C4878cp.m18516a().m18518b(EnumC4879cq.CHAT_ATTACH)) {
                View viewInflate = LayoutInflater.from(this.f7096a.f5624cN).inflate(R.layout.large_file_bubble_tip_layout, (ViewGroup) null);
                ((TextView) viewInflate.findViewById(R.id.tooltip_attach_textview)).setText(this.f7096a.getString(R.string.tooltip_attach, 1));
                new C5013c().m19050a(this.f7096a.f5515aH).m19051b(viewInflate).m19048a().m19042a(this.f7096a.getActivity());
                C4878cp.m18516a().m18517a(EnumC4879cq.CHAT_ATTACH);
                return;
            }
            if (C4878cp.m18516a().m18518b(EnumC4879cq.CHAT_LARGE_FONT)) {
                View viewInflate2 = LayoutInflater.from(this.f7096a.f5624cN).inflate(R.layout.layout_tooltip_image_text, (ViewGroup) null);
                ImageView imageView = (ImageView) viewInflate2.findViewById(R.id.toolTipCustomImageView);
                ((TextView) viewInflate2.findViewById(R.id.toolTipCustomTextView)).setText(R.string.tooltip_chats_large_font);
                imageView.setImageResource(R.drawable.user_guide_chat_bg);
                new C5013c().m19050a(this.f7096a.f5564bF).m19051b(viewInflate2).m19048a().m19042a(this.f7096a.getActivity());
                C4878cp.m18516a().m18517a(EnumC4879cq.CHAT_LARGE_FONT);
                return;
            }
            if (C4878cp.m18516a().m18518b(EnumC4879cq.CHAT_VOICE) && this.f7096a.f5662cz.getVisibility() == 0) {
                new C5013c().m19050a(this.f7096a.f5662cz).m19049a(R.string.tooltip_voice_chat).m19048a().m19042a(this.f7096a.getActivity());
                C4878cp.m18516a().m18517a(EnumC4879cq.CHAT_VOICE);
            }
        }
    }
}
