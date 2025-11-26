package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.EffectSound;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetSoundListEntry extends Entry {
    public Long count;

    @EntryParserInfo(name = "effectsound")
    public List<EffectSound> sounds = new ArrayList();
}
