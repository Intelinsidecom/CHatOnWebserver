package com.vlingo.sdk.internal.recognizer.results;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser;
import com.vlingo.sdk.internal.xml.XmlAttributes;

/* loaded from: classes.dex */
public class TaggedResultsParser extends VLResponseSectionParser {
    private static final Logger log = Logger.getLogger(TaggedResultsParser.class);
    private final int ATTRIBUTE_C;
    private final int ATTRIBUTE_CA;
    private final int ATTRIBUTE_CF;
    private final int ATTRIBUTE_GUTTID;
    private final int ATTRIBUTE_ID;
    private final int ATTRIBUTE_N;
    private final int ATTRIBUTE_NAME;
    private final int ATTRIBUTE_NS;
    private final int ATTRIBUTE_NSD;
    private final int ATTRIBUTE_R;
    private final int ATTRIBUTE_TYPE;
    private final int RESULT_ALT;
    private final int RESULT_CHOICE;
    private final int RESULT_PARSE_GRP;
    private final int RESULT_RECOGNITION;
    private final int RESULT_TAG;
    private final int RESULT_TAG_CHOICE;
    private final int RESULT_TAG_LIST;
    private final int RESULT_UTT_LIST;
    private final int RESULT_WORD;
    private final int RESULT_WORD_LIST;
    private int choiceCount;
    private RecNBest curParsedWord;
    private String guttid;
    private RecResults recResults;
    SRResponseParser srResultsParser;
    private TaggedResults tagResults;
    private int wordCount;

    public TaggedResultsParser(SRResponseParser parser) {
        super(parser.parser);
        this.recResults = null;
        this.choiceCount = 0;
        this.wordCount = 0;
        this.guttid = null;
        this.tagResults = null;
        this.srResultsParser = parser;
        this.RESULT_RECOGNITION = parser.registerElement("Recognition");
        this.RESULT_ALT = parser.registerElement("Alternates");
        this.RESULT_UTT_LIST = parser.registerElement("UL");
        this.RESULT_WORD_LIST = parser.registerElement("WL");
        this.RESULT_TAG_LIST = parser.registerElement("T");
        this.RESULT_WORD = parser.registerElement("w");
        this.RESULT_CHOICE = parser.registerElement("c");
        this.RESULT_PARSE_GRP = parser.registerElement("pg");
        this.RESULT_TAG = parser.registerElement("tag");
        this.RESULT_TAG_CHOICE = parser.registerElement("tl");
        this.ATTRIBUTE_GUTTID = parser.registerAttribute("guttid");
        this.ATTRIBUTE_N = parser.registerAttribute("n");
        this.ATTRIBUTE_R = parser.registerAttribute("r");
        this.ATTRIBUTE_ID = parser.registerAttribute("id");
        this.ATTRIBUTE_NS = parser.registerAttribute("ns");
        this.ATTRIBUTE_NSD = parser.registerAttribute("nsd");
        this.ATTRIBUTE_C = parser.registerAttribute("c");
        this.ATTRIBUTE_CF = parser.registerAttribute("cf");
        this.ATTRIBUTE_TYPE = parser.registerAttribute("t");
        this.ATTRIBUTE_NAME = parser.registerAttribute("nm");
        this.ATTRIBUTE_CA = parser.registerAttribute("ca");
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser
    public boolean handlesElement(int elementType) {
        return this.RESULT_RECOGNITION == elementType;
    }

    private void newRecResults() {
        this.curParsedWord = null;
        this.choiceCount = 0;
        this.wordCount = 0;
        if (this.recResults != null) {
            RecNBest[] wordList = this.recResults.wordList;
            this.recResults = new RecResults(10, this.guttid);
            this.recResults.wordList = wordList;
        }
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginElement(int elementType, XmlAttributes attributes, char[] cData, int elementEndPosition) throws NumberFormatException {
        if (elementType == this.RESULT_RECOGNITION) {
            this.recResults = null;
            this.choiceCount = 0;
            this.wordCount = 0;
            this.curParsedWord = null;
            this.guttid = attributes.lookup(this.ATTRIBUTE_GUTTID);
            this.srResultsParser.getResponse().setGUttId(this.guttid);
            return;
        }
        if (elementType == this.RESULT_ALT) {
            this.recResults = null;
            this.tagResults = new TaggedResults(this.guttid);
            return;
        }
        if (elementType == this.RESULT_WORD_LIST) {
            if (attributes != null) {
                if (this.recResults == null) {
                    this.recResults = new RecResults(10, this.guttid);
                }
                int numNBests = parseInt(attributes.lookup(this.ATTRIBUTE_N), 0);
                if (numNBests > 0) {
                    RecNBest[] wordList = new RecNBest[numNBests];
                    this.recResults.wordList = wordList;
                    for (int i = 0; i < numNBests; i++) {
                        wordList[i] = null;
                    }
                    return;
                }
                return;
            }
            log.error("PAR1", "warning: no attributes for word list");
            return;
        }
        if (elementType == this.RESULT_UTT_LIST) {
            if (this.recResults == null) {
                this.recResults = new RecResults(10, this.guttid);
            }
            int numSentences = parseInt(attributes.lookup(this.ATTRIBUTE_N), 0);
            if (numSentences > 0) {
                RecNBest[][] uttList = new RecNBest[numSentences][];
                float[] uttListConf = new float[numSentences];
                this.recResults.uttList = uttList;
                this.recResults.uttListConf = uttListConf;
                for (int i2 = 0; i2 < numSentences; i2++) {
                    uttList[i2] = null;
                }
            }
            this.recResults.choiceIndex = 0;
            this.curParsedWord = null;
            this.choiceCount = 0;
            return;
        }
        if (elementType == this.RESULT_TAG_LIST) {
            int numTagList = parseInt(attributes.lookup(this.ATTRIBUTE_N), 0);
            this.tagResults.onTagList(numTagList);
            return;
        }
        if (elementType == this.RESULT_PARSE_GRP) {
            float confidence = parseFloat(attributes.lookup(this.ATTRIBUTE_C), -1.0f);
            String parseType = attributes.lookup(this.ATTRIBUTE_TYPE);
            int numParseGroups = parseInt(attributes.lookup(this.ATTRIBUTE_N), 0);
            this.tagResults.onParseGroup(confidence, parseType, numParseGroups);
            return;
        }
        if (elementType == this.RESULT_TAG) {
            newRecResults();
            String name = attributes.lookup(this.ATTRIBUTE_NAME);
            String cannonical = attributes.lookup(this.ATTRIBUTE_CF);
            int numTagSentences = parseInt(attributes.lookup(this.ATTRIBUTE_N), 0);
            if (numTagSentences > 0) {
                RecNBest[][] uttList2 = new RecNBest[numTagSentences][];
                float[] uttListConf2 = new float[numTagSentences];
                String[] uttListCannonical = new String[numTagSentences];
                this.recResults.uttList = uttList2;
                this.recResults.uttListConf = uttListConf2;
                this.recResults.uttListCannonical = uttListCannonical;
                for (int i3 = 0; i3 < numTagSentences; i3++) {
                    uttList2[i3] = null;
                }
                if (cannonical != null) {
                    this.recResults.uttListCannonical[0] = cannonical;
                }
            }
            this.tagResults.onTag(name);
            return;
        }
        if (elementType == this.RESULT_WORD) {
            this.curParsedWord = null;
            if (this.recResults != null) {
                if (this.recResults.uttList != null) {
                    handleWordInUL(attributes, cData);
                    return;
                } else {
                    handleWordInWL(attributes, cData);
                    return;
                }
            }
            return;
        }
        if ((elementType == this.RESULT_TAG_CHOICE || elementType == this.RESULT_CHOICE) && this.recResults != null) {
            if (this.recResults.uttList != null) {
                handleChoiceInUL(attributes, cData);
            } else if (this.curParsedWord != null) {
                handleChoiceInWL(attributes, cData);
            }
        }
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endElement(int elementType, int elementStartPosition) {
        if (this.RESULT_ALT == elementType) {
            this.srResultsParser.getResponse().setTaggedResults(this.tagResults);
            this.responseParser.onSectionComplete();
            return;
        }
        if (this.RESULT_UTT_LIST == elementType) {
            this.tagResults.onUttResults(this.recResults);
            return;
        }
        if (this.RESULT_TAG == elementType) {
            this.tagResults.onTagResults(this.recResults);
        } else if ((this.RESULT_CHOICE == elementType || this.RESULT_TAG_CHOICE == elementType) && this.recResults.uttList != null) {
            this.choiceCount++;
        }
    }

    private void handleWordInWL(XmlAttributes attributes, char[] cData) throws NumberFormatException {
        if (attributes != null) {
            int n = 0;
            int id = -1;
            for (int i = 0; i < attributes.getLength(); i++) {
                int attributeType = attributes.getType(i);
                if (this.ATTRIBUTE_N == attributeType) {
                    n = Integer.parseInt(attributes.getValue(i));
                } else if (this.ATTRIBUTE_ID == attributeType) {
                    id = Integer.parseInt(attributes.getValue(i));
                }
            }
            this.curParsedWord = new RecNBest(n);
            if (id >= 0 && id <= this.recResults.wordList.length) {
                this.curParsedWord.f3256id = id;
                RecNBest[] wordList = this.recResults.wordList;
                wordList[id] = this.curParsedWord;
                return;
            }
            log.error("PAR2", "warning: word id " + id + " out of range");
            return;
        }
        log.error("PAR3", "warning: no attributes for word " + this.recResults.wordList.length + " in word list");
    }

    private void handleWordInUL(XmlAttributes attributes, char[] cData) throws NumberFormatException {
        String wordString = cData != null ? new String(cData) : "(null)";
        int id = -1;
        boolean ns = false;
        boolean nsd = false;
        boolean ct = false;
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                int attributeType = attributes.getType(i);
                if (this.ATTRIBUTE_CA == attributeType) {
                    String s = attributes.getValue(i);
                    ct = s != null && s.equals("t");
                } else if (this.ATTRIBUTE_ID == attributeType) {
                    id = Integer.parseInt(attributes.getValue(i));
                } else if (this.ATTRIBUTE_NS == attributeType) {
                    String s2 = attributes.getValue(i);
                    ns = s2 != null && s2.equals("t");
                } else if (this.ATTRIBUTE_NSD == attributeType) {
                    String s3 = attributes.getValue(i);
                    nsd = s3 != null && s3.equals("t");
                }
            }
        }
        RecNBest newWord = new RecNBest(wordString);
        newWord.noSpace = ns;
        newWord.noSpaceNumber = nsd;
        newWord.capitalized = ct;
        if (id >= 0 && id <= this.recResults.wordList.length) {
            newWord.f3256id = id;
            RecNBest wordListWord = this.recResults.wordList[id];
            if (wordListWord != null) {
                newWord.iChoices = wordListWord.iChoices;
                newWord.f3255iN = wordListWord.f3255iN;
                newWord.adjustChoiceIndex();
            } else {
                log.error("PAR4", "warning: word at index " + id + " not found");
            }
        }
        if (this.choiceCount == 0) {
            this.recResults.addNBest(this.wordCount, newWord.copy());
        }
        RecNBest[][] uttList = this.recResults.uttList;
        if (this.wordCount < uttList[this.choiceCount].length) {
            RecNBest[] recNBestArr = uttList[this.choiceCount];
            int i2 = this.wordCount;
            this.wordCount = i2 + 1;
            recNBestArr[i2] = newWord;
        }
    }

    private void handleChoiceInWL(XmlAttributes attributes, char[] cData) throws NumberFormatException {
        String choiceString = cData != null ? new String(cData) : "(null)";
        int numAlign = 1;
        boolean ns = false;
        boolean nsd = false;
        boolean ct = false;
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                int attributeType = attributes.getType(i);
                if (this.ATTRIBUTE_CA == attributeType) {
                    String s = attributes.getValue(i);
                    ct = s != null && s.equals("t");
                } else if (this.ATTRIBUTE_R == attributeType) {
                    numAlign = Integer.parseInt(attributes.getValue(i));
                } else if (this.ATTRIBUTE_NS == attributeType) {
                    String s2 = attributes.getValue(i);
                    ns = s2 != null && s2.equals("t");
                } else if (this.ATTRIBUTE_NSD == attributeType) {
                    String s3 = attributes.getValue(i);
                    nsd = s3 != null && s3.equals("t");
                }
            }
        }
        RecChoice newChoice = this.curParsedWord.addResultsFromString(choiceString, numAlign);
        if (newChoice != null) {
            newChoice.noSpace = ns;
            newChoice.noSpaceNumber = nsd;
            newChoice.capitalized = ct;
        }
    }

    private void handleChoiceInUL(XmlAttributes attributes, char[] cData) throws NumberFormatException {
        if (attributes != null) {
            float confidence = parseFloat(attributes.lookup(this.ATTRIBUTE_C), -1.0f);
            String cannonical = attributes.lookup(this.ATTRIBUTE_CF);
            int numWords = parseInt(attributes.lookup(this.ATTRIBUTE_N), 0);
            if (numWords > 0) {
                RecNBest[][] uttList = this.recResults.uttList;
                uttList[this.choiceCount] = new RecNBest[numWords];
                float[] uttListConf = this.recResults.uttListConf;
                uttListConf[this.choiceCount] = confidence;
                String[] uttListCannonical = this.recResults.uttListCannonical;
                if (uttListCannonical != null && cannonical != null && uttListCannonical[this.choiceCount] == null) {
                    uttListCannonical[this.choiceCount] = cannonical;
                }
            }
            this.wordCount = 0;
            return;
        }
        log.error("PAR5", "warning: no attributes for choice in utt list");
    }

    private static float parseFloat(String string, float defaultValue) throws NumberFormatException {
        if (string == null) {
            return defaultValue;
        }
        float result = Float.parseFloat(string);
        return result;
    }

    private static int parseInt(String string, int defaultValue) throws NumberFormatException {
        if (string == null) {
            return defaultValue;
        }
        int result = Integer.parseInt(string);
        return result;
    }
}
