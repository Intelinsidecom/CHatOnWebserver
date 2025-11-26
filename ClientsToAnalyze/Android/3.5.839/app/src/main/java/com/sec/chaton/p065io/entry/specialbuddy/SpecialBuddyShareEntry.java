package com.sec.chaton.p065io.entry.specialbuddy;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.C4904y;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyShareEntry extends Entry {
    public String content;
    public SpecialBuddyShareContentsEntry parsedContent;

    public String getRawContents() {
        return this.content;
    }

    public JSONObject getJsonContents() {
        try {
            return new JSONObject(this.content);
        } catch (JSONException e) {
            C4904y.m18635a(e, SpecialBuddyShareEntry.class.getSimpleName());
            return null;
        }
    }

    public SpecialBuddyShareContentsEntry getParsedContents() {
        if (this.parsedContent == null) {
            try {
                this.parsedContent = (SpecialBuddyShareContentsEntry) new C4901v(this.content).m18628b(SpecialBuddyShareContentsEntry.class);
            } catch (Exception e) {
                C4904y.m18635a(e, SpecialBuddyShareEntry.class.getSimpleName());
            }
        }
        return this.parsedContent;
    }
}
