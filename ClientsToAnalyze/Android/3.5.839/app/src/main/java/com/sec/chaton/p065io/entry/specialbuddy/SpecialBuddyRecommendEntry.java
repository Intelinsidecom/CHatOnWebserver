package com.sec.chaton.p065io.entry.specialbuddy;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.C4904y;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyRecommendEntry extends Entry {
    public String content;
    public SpecialBuddyRecommendBuddyEntry parsedContent;

    public String getRawContents() {
        return this.content;
    }

    public JSONObject getJsonContents() {
        try {
            return new JSONObject(this.content);
        } catch (JSONException e) {
            C4904y.m18635a(e, SpecialBuddyRecommendEntry.class.getSimpleName());
            return null;
        }
    }

    public SpecialBuddyRecommendBuddyEntry getParsedContents() {
        if (this.parsedContent == null) {
            try {
                this.parsedContent = (SpecialBuddyRecommendBuddyEntry) new C4901v(this.content).m18628b(SpecialBuddyRecommendBuddyEntry.class);
            } catch (Exception e) {
                C4904y.m18635a(e, SpecialBuddyRecommendEntry.class.getSimpleName());
            }
        }
        return this.parsedContent;
    }
}
