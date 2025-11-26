package com.vlingo.sdk.internal.recognizer.results;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class TaggedResults {
    private static final boolean SHOW_DEBUG = true;
    private String guttid;
    private RecResults uttResults = null;
    private Vector<Object> groups = null;
    private ParseGroup curParseGroup = null;
    private Tag curTag = null;

    public Vector<String> getNBestForWord(String word) {
        return this.uttResults.getNBestForWord(word);
    }

    public int getNBestForWordIfBetterMatch(List<String> result, String word, String[] previousWords, int numPreviousWords, String[] nextWords, int numNextWords, int bestNumMatchingWordsSoFar) {
        return this.uttResults.getNBestForWordIfBetterMatch(result, word, previousWords, numPreviousWords, nextWords, numNextWords, bestNumMatchingWordsSoFar);
    }

    public synchronized ParseGroup getParseGroup() {
        return (this.groups == null || this.groups.isEmpty()) ? null : (ParseGroup) this.groups.elementAt(0);
    }

    public synchronized String getParseType() {
        return getParseGroup() != null ? getParseGroup().getParseType() : "";
    }

    public TaggedResults(String guttId) {
        this.guttid = guttId;
    }

    public RecResults getUttResults() {
        return this.uttResults;
    }

    public Vector<Object> getParseGroups() {
        return this.groups;
    }

    public int getNumParseGroups() {
        if (this.groups != null) {
            return this.groups.size();
        }
        return 0;
    }

    public boolean isParseGroupsEmpty() {
        return this.groups == null || this.groups.size() == 0;
    }

    public boolean isEmpty() {
        return this.uttResults == null || this.uttResults.size() == 0;
    }

    public String getGUttID() {
        return this.guttid;
    }

    void onUttResults(RecResults uttResults) {
        this.uttResults = uttResults;
    }

    void onTagList(int num) {
        this.groups = new Vector<>(num);
    }

    void onParseGroup(float conf, String parseType, int num) {
        this.curParseGroup = new ParseGroup(conf, parseType, num, null);
        this.groups.addElement(this.curParseGroup);
    }

    void onTag(String name) {
        this.curTag = new Tag(name, null);
        this.curParseGroup.tags.addElement(this.curTag);
    }

    void onTagResults(RecResults tagResults) {
        this.curTag.tagResults = tagResults;
    }

    private static final void collapseWords(StringBuffer sb, String[] words) {
        if (words.length > 0) {
            sb.append(words[0].trim());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(words[i].trim());
            }
        }
    }

    public String serialize() {
        System.out.println("serialize");
        if (this.uttResults == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("<Alternates guttid=\"" + this.uttResults.guttid + "\">");
        System.out.println("1");
        serializeWordList(sb, this.uttResults);
        System.out.println("2");
        serializeUttList(sb, this.uttResults);
        System.out.println("3");
        serializeParseGroups(sb, this.groups);
        System.out.println(SimpleUserInfo.STATE_MOVETO_CONFERENCE);
        sb.append("</Alternates>");
        return sb.toString();
    }

    private static void serializeUttList(StringBuffer sb, RecResults results) {
        RecNBest[][] ul = results.uttList;
        float[] conf = results.uttListConf;
        sb.append("<UL n=\"" + ul.length + "\">");
        for (int i = 0; i < ul.length; i++) {
            sb.append("<c ");
            if (conf != null && i < conf.length) {
                sb.append("c=\"" + conf[i] + "\" ");
            }
            sb.append("n=\"" + ul[i].length + "\">");
            for (int j = 0; j < ul[i].length; j++) {
                int id = ul[i][j].f3256id;
                if (id != -1) {
                    sb.append("<w id=\"" + id + "\"");
                } else {
                    sb.append("<w");
                }
                if (ul[i][j].noSpace) {
                    sb.append(" ns=\"t\"");
                }
                if (ul[i][j].noSpaceNumber) {
                    sb.append(" nsd=\"t\"");
                }
                sb.append(">");
                sb.append(ul[i][j].iSelectedWord);
                sb.append("</w>");
            }
            sb.append("</c>");
        }
        sb.append("</UL>");
    }

    private static void serializeWordList(StringBuffer sb, RecResults results) {
        RecNBest[] wl = results.wordList;
        sb.append("<WL n=\"" + wl.length + "\">");
        for (int i = 0; i < wl.length; i++) {
            RecNBest w = wl[i];
            RecChoice[] wcl = w.iChoices;
            sb.append("<w id=\"" + i + "\" n=\"" + wcl.length + "\">");
            for (RecChoice wc : wcl) {
                sb.append("<c r=\"" + wc.numAlign + "\"");
                if (wc.noSpace) {
                    sb.append(" ns=\"t\"");
                }
                if (wc.noSpaceNumber) {
                    sb.append(" nsd=\"t\"");
                }
                sb.append(">");
                collapseWords(sb, wc.words);
                sb.append("</c>");
            }
            sb.append("</w>");
        }
        sb.append("</WL>");
    }

    private static final void serializeParseGroups(StringBuffer sb, Vector<Object> groups) {
        if (groups != null && !groups.isEmpty()) {
            int size = groups.size();
            sb.append("<T n=\"" + size + "\">");
            for (int i = 0; i < size; i++) {
                ParseGroup pg = (ParseGroup) groups.elementAt(i);
                sb.append("<pg t=\"" + pg.parseType + "\" c=\"" + pg.confidence + "\" n=\"" + pg.tags.size() + "\">");
                int tSize = pg.tags.size();
                for (int j = 0; j < tSize; j++) {
                    Tag tag = (Tag) pg.tags.elementAt(j);
                    RecNBest[][] ul = tag.tagResults.uttList;
                    String[] cannonical = tag.tagResults.uttListCannonical;
                    sb.append("<tag n=\"" + ul.length + "\" ");
                    sb.append("nm=\"" + tag.name + "\">");
                    for (int k = 0; k < ul.length; k++) {
                        sb.append("<tl ");
                        if (cannonical != null && cannonical.length > k && cannonical[k] != null) {
                            sb.append("cf=\"" + cannonical[k] + "\" ");
                        }
                        sb.append("n=\"" + ul[k].length + "\">");
                        for (int l = 0; l < ul[k].length; l++) {
                            int id = ul[k][l].f3256id;
                            if (id != -1) {
                                sb.append("<w id=\"" + id + "\"");
                            } else {
                                sb.append("<w");
                            }
                            if (ul[k][l].noSpace) {
                                sb.append(" ns=\"t\"");
                            }
                            if (ul[k][l].noSpaceNumber) {
                                sb.append(" nsd=\"t\"");
                            }
                            sb.append(">");
                            sb.append(ul[k][l].iSelectedWord);
                            sb.append("</w>");
                        }
                        sb.append("</tl>");
                    }
                    sb.append("</tag>");
                }
                sb.append("</pg>");
            }
            sb.append("</T>");
        }
    }

    public String toString() {
        String rs = String.valueOf(String.valueOf("   TaggedResults: " + this.guttid) + "\n      UttResults: " + this.uttResults) + "\n         UttPhrase:";
        if (this.uttResults != null) {
            String[] uttPhrase = this.uttResults.getPhraseLevel();
            if (uttPhrase != null) {
                for (String str : uttPhrase) {
                    rs = String.valueOf(rs) + "\n            " + str;
                }
            }
        } else {
            rs = String.valueOf(rs) + " null";
        }
        if (this.groups != null) {
            String rs2 = String.valueOf(rs) + "\n      ParseGroups " + this.groups.size();
            int size = this.groups.size();
            for (int i = 0; i < size; i++) {
                ParseGroup pg = (ParseGroup) this.groups.elementAt(i);
                rs2 = String.valueOf(rs2) + pg.toString();
            }
            return rs2;
        }
        return String.valueOf(rs) + " null";
    }

    public static class ParseGroup {
        private final float confidence;
        private final String parseType;
        private final Vector<Object> tags;

        private ParseGroup(float confidence, String parseType, int num) {
            this.confidence = confidence;
            this.parseType = parseType;
            this.tags = new Vector<>(num);
        }

        /* synthetic */ ParseGroup(float f, String str, int i, ParseGroup parseGroup) {
            this(f, str, i);
        }

        public String toString() {
            String rs = "\n         ParseGroup: " + this.confidence + " " + this.parseType;
            if (this.tags != null) {
                int size = this.tags.size();
                String rs2 = String.valueOf(rs) + "\n            Tags: " + size;
                for (int i = 0; i < size; i++) {
                    Tag tag = (Tag) this.tags.elementAt(i);
                    rs2 = String.valueOf(rs2) + tag.toString();
                }
                return rs2;
            }
            return String.valueOf(rs) + " null";
        }

        public float getConfidence() {
            return this.confidence;
        }

        public String getParseType() {
            return this.parseType;
        }

        public Vector<Object> getTags() {
            return this.tags;
        }

        public int getNumTags() {
            if (this.tags != null) {
                return this.tags.size();
            }
            return 0;
        }

        public boolean isTagsEmpty() {
            return this.tags == null || this.tags.size() == 0;
        }

        public Tag lookupTagByName(String name) {
            if (this.tags != null && this.tags.size() > 0) {
                int size = this.tags.size();
                for (int i = 0; i < size; i++) {
                    Tag tag = (Tag) this.tags.elementAt(i);
                    if (tag.getName().equalsIgnoreCase(name)) {
                        return tag;
                    }
                }
            }
            return null;
        }
    }

    public static class Tag {
        private String name;
        private RecResults tagResults;

        private Tag(String name) {
            this.tagResults = null;
            this.name = name;
        }

        /* synthetic */ Tag(String str, Tag tag) {
            this(str);
        }

        public String toString() {
            String rs = String.valueOf(String.valueOf("\n            Tag " + this.name) + "\n               UttLevel: " + this.tagResults) + "               PhraseLevel: ";
            String[] phrase = this.tagResults.getPhraseLevel();
            if (phrase != null) {
                for (String str : phrase) {
                    rs = String.valueOf(rs) + "               " + str;
                }
            }
            return rs;
        }

        public RecResults getRecResults() {
            return this.tagResults;
        }

        public String getName() {
            return this.name;
        }
    }
}
