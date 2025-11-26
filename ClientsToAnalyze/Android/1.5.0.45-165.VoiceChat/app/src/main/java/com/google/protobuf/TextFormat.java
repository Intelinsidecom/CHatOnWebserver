package com.google.protobuf;

import com.coolots.sso.util.ChatONVAPII;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class TextFormat {

    /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
    private static /* synthetic */ int[] f55x792aeea3 = null;
    private static final int BUFFER_SIZE = 4096;
    private static final Printer DEFAULT_PRINTER;
    private static final Printer SINGLE_LINE_PRINTER;

    /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
    static /* synthetic */ int[] m4x792aeea3() {
        int[] iArr = f55x792aeea3;
        if (iArr == null) {
            iArr = new int[Descriptors.FieldDescriptor.Type.valuesCustom().length];
            try {
                iArr[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 10;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 15;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 16;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 17;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 18;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e18) {
            }
            f55x792aeea3 = iArr;
        }
        return iArr;
    }

    private TextFormat() {
    }

    static {
        Printer printer = null;
        DEFAULT_PRINTER = new Printer(false, printer);
        SINGLE_LINE_PRINTER = new Printer(true, printer);
    }

    public static void print(Message message, Appendable output) throws IOException {
        DEFAULT_PRINTER.print(message, new TextGenerator(output, null));
    }

    public static void print(UnknownFieldSet fields, Appendable output) throws IOException {
        DEFAULT_PRINTER.printUnknownFields(fields, new TextGenerator(output, null));
    }

    public static String shortDebugString(Message message) {
        try {
            StringBuilder sb = new StringBuilder();
            SINGLE_LINE_PRINTER.print(message, new TextGenerator(sb, null));
            return sb.toString().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String shortDebugString(UnknownFieldSet fields) {
        try {
            StringBuilder sb = new StringBuilder();
            SINGLE_LINE_PRINTER.printUnknownFields(fields, new TextGenerator(sb, null));
            return sb.toString().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToString(Message message) {
        try {
            StringBuilder text = new StringBuilder();
            print(message, text);
            return text.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToString(UnknownFieldSet fields) {
        try {
            StringBuilder text = new StringBuilder();
            print(fields, text);
            return text.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void printField(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
        DEFAULT_PRINTER.printField(field, value, new TextGenerator(output, null));
    }

    public static String printFieldToString(Descriptors.FieldDescriptor field, Object value) {
        try {
            StringBuilder text = new StringBuilder();
            printField(field, value, text);
            return text.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void printFieldValue(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
        DEFAULT_PRINTER.printFieldValue(field, value, new TextGenerator(output, null));
    }

    public static void printUnknownFieldValue(int tag, Object value, Appendable output) throws IOException {
        printUnknownFieldValue(tag, value, new TextGenerator(output, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printUnknownFieldValue(int tag, Object value, TextGenerator generator) throws IOException {
        switch (WireFormat.getTagWireType(tag)) {
            case 0:
                generator.print(unsignedToString(((Long) value).longValue()));
                return;
            case 1:
                generator.print(String.format(null, "0x%016x", (Long) value));
                return;
            case 2:
                generator.print("\"");
                generator.print(escapeBytes((ByteString) value));
                generator.print("\"");
                return;
            case 3:
                DEFAULT_PRINTER.printUnknownFields((UnknownFieldSet) value, generator);
                return;
            case 4:
            default:
                throw new IllegalArgumentException("Bad tag: " + tag);
            case 5:
                generator.print(String.format(null, "0x%08x", (Integer) value));
                return;
        }
    }

    private static final class Printer {

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
        private static /* synthetic */ int[] f56x792aeea3;
        final boolean singleLineMode;

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
        static /* synthetic */ int[] m5x792aeea3() {
            int[] iArr = f56x792aeea3;
            if (iArr == null) {
                iArr = new int[Descriptors.FieldDescriptor.Type.valuesCustom().length];
                try {
                    iArr[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 8;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 12;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 14;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 7;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 10;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 5;
                } catch (NoSuchFieldError e9) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 3;
                } catch (NoSuchFieldError e10) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
                } catch (NoSuchFieldError e11) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 15;
                } catch (NoSuchFieldError e12) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 16;
                } catch (NoSuchFieldError e13) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 17;
                } catch (NoSuchFieldError e14) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 18;
                } catch (NoSuchFieldError e15) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 9;
                } catch (NoSuchFieldError e16) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 13;
                } catch (NoSuchFieldError e17) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 4;
                } catch (NoSuchFieldError e18) {
                }
                f56x792aeea3 = iArr;
            }
            return iArr;
        }

        private Printer(boolean singleLineMode) {
            this.singleLineMode = singleLineMode;
        }

        /* synthetic */ Printer(boolean z, Printer printer) {
            this(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void print(Message message, TextGenerator generator) throws IOException {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> field : message.getAllFields().entrySet()) {
                printField(field.getKey(), field.getValue(), generator);
            }
            printUnknownFields(message.getUnknownFields(), generator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printField(Descriptors.FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            if (field.isRepeated()) {
                for (Object element : (List) value) {
                    printSingleField(field, element, generator);
                }
                return;
            }
            printSingleField(field, value, generator);
        }

        private void printSingleField(Descriptors.FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            if (field.isExtension()) {
                generator.print("[");
                if (field.getContainingType().getOptions().getMessageSetWireFormat() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && field.isOptional() && field.getExtensionScope() == field.getMessageType()) {
                    generator.print(field.getMessageType().getFullName());
                } else {
                    generator.print(field.getFullName());
                }
                generator.print("]");
            } else if (field.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
                generator.print(field.getMessageType().getName());
            } else {
                generator.print(field.getName());
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (this.singleLineMode) {
                    generator.print(" { ");
                } else {
                    generator.print(" {\n");
                    generator.indent();
                }
            } else {
                generator.print(": ");
            }
            printFieldValue(field, value, generator);
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (this.singleLineMode) {
                    generator.print("} ");
                    return;
                } else {
                    generator.outdent();
                    generator.print("}\n");
                    return;
                }
            }
            if (this.singleLineMode) {
                generator.print(" ");
            } else {
                generator.print("\n");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printFieldValue(Descriptors.FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            switch (m5x792aeea3()[field.getType().ordinal()]) {
                case 1:
                    generator.print(((Double) value).toString());
                    break;
                case 2:
                    generator.print(((Float) value).toString());
                    break;
                case 3:
                case 16:
                case 18:
                    generator.print(((Long) value).toString());
                    break;
                case 4:
                case 6:
                    generator.print(TextFormat.unsignedToString(((Long) value).longValue()));
                    break;
                case 5:
                case 15:
                case 17:
                    generator.print(((Integer) value).toString());
                    break;
                case 7:
                case 13:
                    generator.print(TextFormat.unsignedToString(((Integer) value).intValue()));
                    break;
                case 8:
                    generator.print(((Boolean) value).toString());
                    break;
                case 9:
                    generator.print("\"");
                    generator.print(TextFormat.escapeText((String) value));
                    generator.print("\"");
                    break;
                case 10:
                case 11:
                    print((Message) value, generator);
                    break;
                case 12:
                    generator.print("\"");
                    generator.print(TextFormat.escapeBytes((ByteString) value));
                    generator.print("\"");
                    break;
                case 14:
                    generator.print(((Descriptors.EnumValueDescriptor) value).getName());
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printUnknownFields(UnknownFieldSet unknownFields, TextGenerator generator) throws IOException {
            for (Map.Entry<Integer, UnknownFieldSet.Field> entry : unknownFields.asMap().entrySet()) {
                int number = entry.getKey().intValue();
                UnknownFieldSet.Field field = entry.getValue();
                printUnknownField(number, 0, field.getVarintList(), generator);
                printUnknownField(number, 5, field.getFixed32List(), generator);
                printUnknownField(number, 1, field.getFixed64List(), generator);
                printUnknownField(number, 2, field.getLengthDelimitedList(), generator);
                for (UnknownFieldSet value : field.getGroupList()) {
                    generator.print(entry.getKey().toString());
                    if (this.singleLineMode) {
                        generator.print(" { ");
                    } else {
                        generator.print(" {\n");
                        generator.indent();
                    }
                    printUnknownFields(value, generator);
                    if (this.singleLineMode) {
                        generator.print("} ");
                    } else {
                        generator.outdent();
                        generator.print("}\n");
                    }
                }
            }
        }

        private void printUnknownField(int number, int wireType, List<?> values, TextGenerator generator) throws IOException {
            for (Object value : values) {
                generator.print(String.valueOf(number));
                generator.print(": ");
                TextFormat.printUnknownFieldValue(wireType, value, generator);
                generator.print(this.singleLineMode ? " " : "\n");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unsignedToString(int value) {
        return value >= 0 ? Integer.toString(value) : Long.toString(value & 4294967295L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unsignedToString(long value) {
        if (value >= 0) {
            return Long.toString(value);
        }
        return BigInteger.valueOf(Long.MAX_VALUE & value).setBit(63).toString();
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        private TextGenerator(Appendable output) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = output;
        }

        /* synthetic */ TextGenerator(Appendable appendable, TextGenerator textGenerator) {
            this(appendable);
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.delete(length - 2, length);
        }

        public void print(CharSequence text) throws IOException {
            int size = text.length();
            int pos = 0;
            for (int i = 0; i < size; i++) {
                if (text.charAt(i) == '\n') {
                    write(text.subSequence(pos, size), (i - pos) + 1);
                    pos = i + 1;
                    this.atStartOfLine = true;
                }
            }
            write(text.subSequence(pos, size), size - pos);
        }

        private void write(CharSequence data, int size) throws IOException {
            if (size != 0) {
                if (this.atStartOfLine) {
                    this.atStartOfLine = false;
                    this.output.append(this.indent);
                }
                this.output.append(data);
            }
        }
    }

    private static final class Tokenizer {
        private int column;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);

        private Tokenizer(CharSequence text) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = text;
            this.matcher = WHITESPACE.matcher(text);
            skipWhitespace();
            nextToken();
        }

        /* synthetic */ Tokenizer(CharSequence charSequence, Tokenizer tokenizer) {
            this(charSequence);
        }

        public boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                this.matcher.region(this.pos + 1, this.matcher.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            }
        }

        public boolean tryConsume(String token) {
            if (!this.currentToken.equals(token)) {
                return false;
            }
            nextToken();
            return true;
        }

        public void consume(String token) throws ParseException {
            if (!tryConsume(token)) {
                throw parseException("Expected \"" + token + "\".");
            }
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char c = this.currentToken.charAt(0);
            return ('0' <= c && c <= '9') || c == '-' || c == '+';
        }

        public String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char c = this.currentToken.charAt(i);
                if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && (('0' > c || c > '9') && c != '_' && c != '.'))) {
                    throw parseException("Expected identifier.");
                }
            }
            String result = this.currentToken;
            nextToken();
            return result;
        }

        public int consumeInt32() throws ParseException {
            try {
                int result = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public int consumeUInt32() throws ParseException {
            try {
                int result = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeInt64() throws ParseException {
            try {
                long result = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeUInt64() throws ParseException {
            try {
                long result = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public double consumeDouble() throws ParseException, NumberFormatException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            }
            try {
                double result = Double.parseDouble(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw floatParseException(e);
            }
        }

        public float consumeFloat() throws ParseException, NumberFormatException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            }
            if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            }
            try {
                float result = Float.parseFloat(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw floatParseException(e);
            }
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            }
            if (this.currentToken.equals("false") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            }
            throw parseException("Expected \"true\" or \"false\".");
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public ByteString consumeByteString() throws ParseException {
            List<ByteString> list = new ArrayList<>();
            consumeByteString(list);
            while (true) {
                if (this.currentToken.startsWith("'") || this.currentToken.startsWith("\"")) {
                    consumeByteString(list);
                } else {
                    return ByteString.copyFrom(list);
                }
            }
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char quote = this.currentToken.length() > 0 ? this.currentToken.charAt(0) : (char) 0;
            if (quote != '\"' && quote != '\'') {
                throw parseException("Expected string.");
            }
            if (this.currentToken.length() < 2 || this.currentToken.charAt(this.currentToken.length() - 1) != quote) {
                throw parseException("String missing ending quote.");
            }
            try {
                String escaped = this.currentToken.substring(1, this.currentToken.length() - 1);
                ByteString result = TextFormat.unescapeBytes(escaped);
                nextToken();
                list.add(result);
            } catch (InvalidEscapeSequenceException e) {
                throw parseException(e.getMessage());
            }
        }

        public ParseException parseException(String description) {
            return new ParseException(String.valueOf(this.line + 1) + ChatONVAPII.USERID_DELEMETER + (this.column + 1) + ": " + description);
        }

        public ParseException parseExceptionPreviousToken(String description) {
            return new ParseException(String.valueOf(this.previousLine + 1) + ChatONVAPII.USERID_DELEMETER + (this.previousColumn + 1) + ": " + description);
        }

        private ParseException integerParseException(NumberFormatException e) {
            return parseException("Couldn't parse integer: " + e.getMessage());
        }

        private ParseException floatParseException(NumberFormatException e) {
            return parseException("Couldn't parse number: " + e.getMessage());
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;

        public ParseException(String message) {
            super(message);
        }
    }

    public static void merge(Readable input, Message.Builder builder) throws IOException {
        merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(CharSequence input, Message.Builder builder) throws ParseException {
        merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(Readable input, ExtensionRegistry extensionRegistry, Message.Builder builder) throws IOException {
        merge(toStringBuilder(input), extensionRegistry, builder);
    }

    private static StringBuilder toStringBuilder(Readable input) throws IOException {
        StringBuilder text = new StringBuilder();
        CharBuffer buffer = CharBuffer.allocate(4096);
        while (true) {
            int n = input.read(buffer);
            if (n != -1) {
                buffer.flip();
                text.append((CharSequence) buffer, 0, n);
            } else {
                return text;
            }
        }
    }

    public static void merge(CharSequence input, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        Tokenizer tokenizer = new Tokenizer(input, null);
        while (!tokenizer.atEnd()) {
            mergeField(tokenizer, extensionRegistry, builder);
        }
    }

    private static void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        Descriptors.FieldDescriptor field;
        String endToken;
        Message.Builder subBuilder;
        Descriptors.Descriptor type = builder.getDescriptorForType();
        ExtensionRegistry.ExtensionInfo extension = null;
        if (tokenizer.tryConsume("[")) {
            StringBuilder name = new StringBuilder(tokenizer.consumeIdentifier());
            while (tokenizer.tryConsume(".")) {
                name.append('.');
                name.append(tokenizer.consumeIdentifier());
            }
            extension = extensionRegistry.findExtensionByName(name.toString());
            if (extension == null) {
                throw tokenizer.parseExceptionPreviousToken("Extension \"" + ((Object) name) + "\" not found in the ExtensionRegistry.");
            }
            if (extension.descriptor.getContainingType() != type) {
                throw tokenizer.parseExceptionPreviousToken("Extension \"" + ((Object) name) + "\" does not extend message type \"" + type.getFullName() + "\".");
            }
            tokenizer.consume("]");
            field = extension.descriptor;
        } else {
            String name2 = tokenizer.consumeIdentifier();
            field = type.findFieldByName(name2);
            if (field == null) {
                String lowerName = name2.toLowerCase(Locale.US);
                field = type.findFieldByName(lowerName);
                if (field != null && field.getType() != Descriptors.FieldDescriptor.Type.GROUP) {
                    field = null;
                }
            }
            if (field != null && field.getType() == Descriptors.FieldDescriptor.Type.GROUP && !field.getMessageType().getName().equals(name2)) {
                field = null;
            }
            if (field == null) {
                throw tokenizer.parseExceptionPreviousToken("Message type \"" + type.getFullName() + "\" has no field named \"" + name2 + "\".");
            }
        }
        Object value = null;
        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            tokenizer.tryConsume(ChatONVAPII.USERID_DELEMETER);
            if (tokenizer.tryConsume("<")) {
                endToken = ">";
            } else {
                tokenizer.consume("{");
                endToken = "}";
            }
            if (extension == null) {
                subBuilder = builder.newBuilderForField(field);
            } else {
                subBuilder = extension.defaultInstance.newBuilderForType();
            }
            while (!tokenizer.tryConsume(endToken)) {
                if (tokenizer.atEnd()) {
                    throw tokenizer.parseException("Expected \"" + endToken + "\".");
                }
                mergeField(tokenizer, extensionRegistry, subBuilder);
            }
            value = subBuilder.build();
        } else {
            tokenizer.consume(ChatONVAPII.USERID_DELEMETER);
            switch (m4x792aeea3()[field.getType().ordinal()]) {
                case 1:
                    value = Double.valueOf(tokenizer.consumeDouble());
                    break;
                case 2:
                    value = Float.valueOf(tokenizer.consumeFloat());
                    break;
                case 3:
                case 16:
                case 18:
                    value = Long.valueOf(tokenizer.consumeInt64());
                    break;
                case 4:
                case 6:
                    value = Long.valueOf(tokenizer.consumeUInt64());
                    break;
                case 5:
                case 15:
                case 17:
                    value = Integer.valueOf(tokenizer.consumeInt32());
                    break;
                case 7:
                case 13:
                    value = Integer.valueOf(tokenizer.consumeUInt32());
                    break;
                case 8:
                    value = Boolean.valueOf(tokenizer.consumeBoolean());
                    break;
                case 9:
                    value = tokenizer.consumeString();
                    break;
                case 10:
                case 11:
                    throw new RuntimeException("Can't get here.");
                case 12:
                    value = tokenizer.consumeByteString();
                    break;
                case 14:
                    Descriptors.EnumDescriptor enumType = field.getEnumType();
                    if (tokenizer.lookingAtInteger()) {
                        int number = tokenizer.consumeInt32();
                        value = enumType.findValueByNumber(number);
                        if (value == null) {
                            throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + number + '.');
                        }
                    } else {
                        String id = tokenizer.consumeIdentifier();
                        value = enumType.findValueByName(id);
                        if (value == null) {
                            throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value named \"" + id + "\".");
                        }
                    }
                    break;
            }
        }
        if (field.isRepeated()) {
            builder.addRepeatedField(field, value);
        } else {
            builder.setField(field, value);
        }
    }

    static String escapeBytes(ByteString input) {
        StringBuilder builder = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte b = input.byteAt(i);
            switch (b) {
                case 7:
                    builder.append("\\a");
                    break;
                case 8:
                    builder.append("\\b");
                    break;
                case 9:
                    builder.append("\\t");
                    break;
                case 10:
                    builder.append("\\n");
                    break;
                case 11:
                    builder.append("\\v");
                    break;
                case 12:
                    builder.append("\\f");
                    break;
                case 13:
                    builder.append("\\r");
                    break;
                case 34:
                    builder.append("\\\"");
                    break;
                case 39:
                    builder.append("\\'");
                    break;
                case 92:
                    builder.append("\\\\");
                    break;
                default:
                    if (b >= 32) {
                        builder.append((char) b);
                        break;
                    } else {
                        builder.append('\\');
                        builder.append((char) (((b >>> 6) & 3) + 48));
                        builder.append((char) (((b >>> 3) & 7) + 48));
                        builder.append((char) ((b & 7) + 48));
                        break;
                    }
            }
        }
        return builder.toString();
    }

    static ByteString unescapeBytes(CharSequence charString) throws InvalidEscapeSequenceException {
        int pos;
        ByteString input = ByteString.copyFromUtf8(charString.toString());
        byte[] result = new byte[input.size()];
        int pos2 = 0;
        int i = 0;
        while (i < input.size()) {
            byte c = input.byteAt(i);
            if (c == 92) {
                if (i + 1 < input.size()) {
                    i++;
                    byte c2 = input.byteAt(i);
                    if (isOctal(c2)) {
                        int code = digitValue(c2);
                        if (i + 1 < input.size() && isOctal(input.byteAt(i + 1))) {
                            i++;
                            code = (code * 8) + digitValue(input.byteAt(i));
                        }
                        if (i + 1 < input.size() && isOctal(input.byteAt(i + 1))) {
                            i++;
                            code = (code * 8) + digitValue(input.byteAt(i));
                        }
                        pos = pos2 + 1;
                        result[pos2] = (byte) code;
                    } else {
                        switch (c2) {
                            case 34:
                                pos = pos2 + 1;
                                result[pos2] = ProtocolDefines.XMODE_VERSION_BCP;
                                break;
                            case 39:
                                pos = pos2 + 1;
                                result[pos2] = 39;
                                break;
                            case 92:
                                pos = pos2 + 1;
                                result[pos2] = 92;
                                break;
                            case 97:
                                pos = pos2 + 1;
                                result[pos2] = 7;
                                break;
                            case 98:
                                pos = pos2 + 1;
                                result[pos2] = 8;
                                break;
                            case 102:
                                pos = pos2 + 1;
                                result[pos2] = 12;
                                break;
                            case 110:
                                pos = pos2 + 1;
                                result[pos2] = 10;
                                break;
                            case 114:
                                pos = pos2 + 1;
                                result[pos2] = 13;
                                break;
                            case 116:
                                pos = pos2 + 1;
                                result[pos2] = 9;
                                break;
                            case 118:
                                pos = pos2 + 1;
                                result[pos2] = 11;
                                break;
                            case 120:
                                if (i + 1 < input.size() && isHex(input.byteAt(i + 1))) {
                                    i++;
                                    int code2 = digitValue(input.byteAt(i));
                                    if (i + 1 < input.size() && isHex(input.byteAt(i + 1))) {
                                        i++;
                                        code2 = (code2 * 16) + digitValue(input.byteAt(i));
                                    }
                                    pos = pos2 + 1;
                                    result[pos2] = (byte) code2;
                                    break;
                                } else {
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                                }
                            default:
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) c2) + '\'');
                        }
                    }
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                pos = pos2 + 1;
                result[pos2] = c;
            }
            pos2 = pos;
            i++;
        }
        return ByteString.copyFrom(result, 0, pos2);
    }

    static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String description) {
            super(description);
        }
    }

    static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    static String unescapeText(String input) throws InvalidEscapeSequenceException {
        return unescapeBytes(input).toStringUtf8();
    }

    private static boolean isOctal(byte c) {
        return 48 <= c && c <= 55;
    }

    private static boolean isHex(byte c) {
        return (48 <= c && c <= 57) || (97 <= c && c <= 102) || (65 <= c && c <= 70);
    }

    private static int digitValue(byte c) {
        if (48 <= c && c <= 57) {
            return c - 48;
        }
        if (97 <= c && c <= 122) {
            return (c - 97) + 10;
        }
        return (c - 65) + 10;
    }

    static int parseInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, true, false);
    }

    static int parseUInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, false, false);
    }

    static long parseInt64(String text) throws NumberFormatException {
        return parseInteger(text, true, true);
    }

    static long parseUInt64(String text) throws NumberFormatException {
        return parseInteger(text, false, true);
    }

    private static long parseInteger(String text, boolean isSigned, boolean isLong) throws NumberFormatException {
        int pos = 0;
        boolean negative = false;
        if (text.startsWith("-", 0)) {
            if (!isSigned) {
                throw new NumberFormatException("Number must be positive: " + text);
            }
            pos = 0 + 1;
            negative = true;
        }
        int radix = 10;
        if (text.startsWith("0x", pos)) {
            pos += 2;
            radix = 16;
        } else if (text.startsWith("0", pos)) {
            radix = 8;
        }
        String numberText = text.substring(pos);
        if (numberText.length() < 16) {
            long result = Long.parseLong(numberText, radix);
            if (negative) {
                result = -result;
            }
            if (!isLong) {
                if (isSigned) {
                    if (result > 2147483647L || result < -2147483648L) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
                    }
                    return result;
                }
                if (result >= 4294967296L || result < 0) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
                }
                return result;
            }
            return result;
        }
        BigInteger bigValue = new BigInteger(numberText, radix);
        if (negative) {
            bigValue = bigValue.negate();
        }
        if (!isLong) {
            if (isSigned) {
                if (bigValue.bitLength() > 31) {
                    throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
                }
            } else if (bigValue.bitLength() > 32) {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
            }
        } else if (isSigned) {
            if (bigValue.bitLength() > 63) {
                throw new NumberFormatException("Number out of range for 64-bit signed integer: " + text);
            }
        } else if (bigValue.bitLength() > 64) {
            throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + text);
        }
        return bigValue.longValue();
    }
}
