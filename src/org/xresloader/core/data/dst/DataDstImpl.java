package org.xresloader.core.data.dst;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.xresloader.core.data.dst.DataDstWriterNode.JAVA_TYPE;
import org.xresloader.core.data.err.ConvException;
import org.xresloader.core.data.src.DataSrcImpl;
import org.xresloader.core.data.vfy.DataVerifyImpl;
import org.xresloader.core.engine.ExcelEngine;
import org.xresloader.core.engine.IdentifyDescriptor;
import org.xresloader.core.ProgramOptions;

/**
 * Created by owentou on 2014/10/10.
 */
public abstract class DataDstImpl {
    private String systemEndl = null;
    private String lastErrorMessage = "";

    public String getSystemEndl() {
        if (null != systemEndl) {
            return systemEndl;
        }

        systemEndl = System.getProperty("line.separator", "\n");
        if (null == systemEndl || systemEndl.isEmpty()) {
            systemEndl = "\r\n";
        }
        return systemEndl;
    }

    /**
     * 初始化
     * 
     * @return
     */
    public boolean init() {
        return false;
    }

    /**
     * @return 协议处理器名字
     */
    public String name() {
        return this.getClass().getTypeName();
    }

    /**
     * 编译并返回协议映射关系
     * 
     * @return 协议映射关系
     */
    public DataDstWriterNode compile() throws ConvException {
        return null;
    }

    /**
     * 生成数据
     * 
     * @param src 生成输出结构的描述器
     * @return
     */
    public byte[] build(DataDstImpl src) throws ConvException {
        return new byte[0];
    }

    /**
     * 生成常量数据
     * 
     * @return 常量数据,不支持的时候返回空
     */
    public HashMap<String, Object> buildConst() {
        return null;
    }

    /**
     * 生成选项数据
     * 
     * @return 选项数据,不支持的时候返回空
     */
    public HashMap<String, Object> buildOptions(ProgramOptions.ProtoDumpType dumpType) {
        return null;
    }

    /**
     * 转储常量数据
     * 
     * @return 常量数据,不支持的时候返回空
     */
    public byte[] dumpConst(HashMap<String, Object> data) throws ConvException, IOException {
        return null;
    }

    public String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

    public void setLastErrorMessage(String format, Object... args) {
        this.lastErrorMessage = String.format(format, args);
    }

    public void logErrorMessage(String format, Object... args) {
        this.setLastErrorMessage(format, args);
        ProgramOptions.getLoger().error("%s", this.lastErrorMessage);
    }

    static public String[] splitPlainGroups(String input, String sep) {
        if (sep == null || sep.isEmpty()) {
            sep = ",;|";
        }

        if (input == null || input.isEmpty()) {
            return null;
        }

        char sepC = 0;
        for (int i = 0; sepC == 0 && i < input.length(); ++i) {
            if (sep.indexOf(input.charAt(i)) < 0) {
                continue;
            }

            sepC = input.charAt(i);
        }

        return input.split("\\" + sepC);
    }

    static public Boolean parsePlainDataBoolean(String input, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (input == null) {
            return false;
        }

        String item = ExcelEngine.tryMacro(input.trim());
        return DataSrcImpl.getBooleanFromString(item);
    }

    static public Boolean[] parsePlainDataBoolean(String[] groups, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (groups == null) {
            return null;
        }

        Boolean[] ret = new Boolean[groups.length];
        for (int i = 0; i < groups.length; ++i) {
            ret[i] = parsePlainDataBoolean(groups[i], ident, field);
        }

        return ret;
    }

    static public String parsePlainDataString(String input, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (input == null) {
            return null;
        }

        if (DataSrcImpl.getOurInstance().isInitialized() && ProgramOptions.getInstance().enableStringMacro) {
            return ExcelEngine.tryMacro(input.trim());
        } else {
            return input.trim();
        }
    }

    static public String[] parsePlainDataString(String[] groups, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (groups == null) {
            return null;
        }

        String[] ret = new String[groups.length];
        for (int i = 0; i < groups.length; ++i) {
            String item = groups[i];
            ret[i] = parsePlainDataString(item, ident, field);
        }

        return ret;
    }

    static public Long parsePlainDataLong(String input, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (input == null) {
            return null;
        }

        String item = ExcelEngine.tryMacro(input.trim());
        Long ret;
        if (ident != null) {
            ret = DataVerifyImpl.getAndVerify(ident.getVerifier(), ident.name, item);
            if (ident.getRatio() != 1) {
                ret *= ident.getRatio();
            }
        } else if (field != null) {
            ret = DataVerifyImpl.getAndVerify(field.getVerifier(), field.getName(), item);
            if (field.mutableExtension().ratio != 1) {
                ret *= field.mutableExtension().ratio;
            }
        } else {
            ret = Long.valueOf(0);
        }

        return ret;
    }

    static public Long[] parsePlainDataLong(String[] groups, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (groups == null) {
            return null;
        }

        Long[] ret = new Long[groups.length];
        for (int i = 0; i < groups.length; ++i) {
            ret[i] = parsePlainDataLong(groups[i], ident, field);
        }

        return ret;
    }

    static public Double parsePlainDataDouble(String input, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (input == null) {
            return 0.0;
        }

        try {
            String item = ExcelEngine.tryMacro(input.trim());
            Double ret = Double.valueOf(item);
            if (ident != null) {
                if (ident.getRatio() != 1) {
                    ret *= ident.getRatio();
                }
            } else if (field != null) {
                if (field.mutableExtension().ratio != 1) {
                    ret *= field.mutableExtension().ratio;
                }
            }

            return ret;
        } catch (java.lang.NumberFormatException e) {
            throw new ConvException(String.format("Try to convert %s to double failed.", input));
        }
    }

    static private final Pattern DATE_CHECK_RULE = Pattern.compile("\\d+-\\d+-\\d+");
    static private final Pattern TIME_SSS_CHECK_RULE = Pattern.compile("\\d+:\\d+:\\d+\\.\\d+");
    static private final Pattern TIME_CHECK_RULE = Pattern.compile("\\d+:\\d+:\\d+");
    static private final Pattern ZONE_CHECK_RULE = Pattern.compile(":\\d+(\\.\\d*)?(Z|[+-])");
    static private final Pattern DIGITAL_CHECK_RULE = Pattern.compile("[+-]?\\d+(\\.\\d*)?");
    static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter DATE_TIME_SSS_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd HH:mm:ss")
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true).toFormatter()
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter DATE_TIME_ZONE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[XXXXX][XXX]")
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter DATE_TIME_ZONE_SSS_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd HH:mm:ss")
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
            .optionalStart()
            .appendOffset("+HH:MM:ss", "Z")
            .optionalEnd()
            .optionalStart()
            .appendOffset("+HH:MM", "Z")
            .optionalEnd()
            .toFormatter()
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter TIME_SSS_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("HH:mm:ss")
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true).toFormatter()
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter TIME_ZONE_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss[XXX][XXXXX]")
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static DateTimeFormatter TIME_ZONE_SSS_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("HH:mm:ss")
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
            .optionalStart()
            .appendOffset("+HH:MM:ss", "Z")
            .optionalEnd()
            .optionalStart()
            .appendOffset("+HH:MM", "Z")
            .optionalEnd()
            .toFormatter()
            .withZone(ZoneId.systemDefault())
            .withResolverStyle(ResolverStyle.SMART);
    static ZoneOffset SYSTEM_ZONE_OFFSET = OffsetDateTime.now().getOffset();
    static ZoneOffset UTC_ZONE_OFFSET = ZoneOffset.UTC;

    static public Instant parsePlainDataDatetime(String input) throws ConvException {
        if (input == null) {
            return null;
        }

        String item = ExcelEngine.tryMacro(input.trim()).trim();
        if (DIGITAL_CHECK_RULE.matcher(item).matches()) {
            try {
                int dot = item.indexOf('.');
                if (dot >= 0) {
                    long sec = Long.parseLong(item.substring(0, dot));
                    Double nanos = Double.parseDouble(item.substring(dot)) * 1000000000;
                    return Instant.ofEpochSecond(sec).plusNanos(nanos.longValue());
                } else {
                    long sec = Long.parseLong(item);
                    return Instant.ofEpochSecond(sec);
                }
            } catch (NumberFormatException | DateTimeException e) {
                throw new ConvException(String.format(
                        "Can convert %s to datetime(%s).",
                        input, e.getMessage()));
            }
        }

        boolean hasDate = DATE_CHECK_RULE.matcher(item).find();
        boolean hasTime = TIME_CHECK_RULE.matcher(item).find();
        boolean hasTimeSSS = TIME_SSS_CHECK_RULE.matcher(item).find();
        boolean hasZone = ZONE_CHECK_RULE.matcher(item).find();
        try {
            if (hasDate) {
                if (hasTimeSSS && hasZone) {
                    return ZonedDateTime.parse(item, DATE_TIME_ZONE_SSS_FORMATTER).toInstant();
                } else if (hasTime && hasZone) {
                    return ZonedDateTime.parse(item, DATE_TIME_ZONE_FORMATTER).toInstant();
                } else if (hasTimeSSS) {
                    return LocalDateTime.parse(item, DATE_TIME_SSS_FORMATTER).toInstant(SYSTEM_ZONE_OFFSET);
                } else if (hasTime) {
                    return LocalDateTime.parse(item, DATE_TIME_FORMATTER).toInstant(SYSTEM_ZONE_OFFSET);
                } else {
                    // return OffsetDateTime.parse(item, DATE_FORMATTER).toInstant();
                    return LocalDate.parse(item,
                            DATE_FORMATTER).atStartOfDay().toInstant(SYSTEM_ZONE_OFFSET);
                }
            } else {
                var colon = item.indexOf(':');
                String zeroPrefix = item.charAt(0) == '-' ? "-00:" : "00:";
                if (hasTimeSSS && hasZone) {
                    return OffsetTime.parse(zeroPrefix + item.substring(colon + 1), TIME_ZONE_SSS_FORMATTER)
                            .atDate(LocalDate.ofEpochDay(0))
                            .plusHours(Long.parseLong(item.substring(0, colon)))
                            .toInstant();
                } else if (hasTime && hasZone) {
                    return OffsetTime.parse(zeroPrefix + item.substring(colon + 1), TIME_ZONE_FORMATTER)
                            .atDate(LocalDate.ofEpochDay(0))
                            .plusHours(Long.parseLong(item.substring(0, colon)))
                            .toInstant();
                } else if (hasTimeSSS) {
                    return LocalTime.parse(zeroPrefix + item.substring(colon + 1), TIME_SSS_FORMATTER)
                            .atDate(LocalDate.ofEpochDay(0))
                            .plusHours(Long.parseLong(item.substring(0, colon)))
                            .toInstant(UTC_ZONE_OFFSET);
                } else {
                    return LocalTime.parse(zeroPrefix + item.substring(colon + 1), TIME_FORMATTER)
                            .atDate(LocalDate.ofEpochDay(0))
                            .plusHours(Long.parseLong(item.substring(0, colon)))
                            .toInstant(UTC_ZONE_OFFSET);
                }
            }
        } catch (DateTimeException e) {
            throw new ConvException(String.format(
                    "Can convert %s to datetime(%s).",
                    input, e.getMessage()));
        }
    }

    static public Instant parsePlainDataDuration(String input) throws ConvException {
        if (input == null) {
            return null;
        }

        String item = ExcelEngine.tryMacro(input.trim()).trim();
        if (DIGITAL_CHECK_RULE.matcher(item).matches()) {
            try {
                int dot = item.indexOf('.');
                if (dot >= 0) {
                    Long sec = Long.parseLong(item.substring(0, dot));
                    Double nanos = Double.parseDouble(item.substring(dot)) * 1000000000;
                    return Instant.ofEpochSecond(sec).plusNanos(nanos.longValue());
                } else {
                    Long sec = Long.parseLong(item);
                    return Instant.ofEpochSecond(sec);
                }
            } catch (NumberFormatException e) {
                throw new ConvException(String.format(
                        "Can convert %s to duration(%s).",
                        input, e.getMessage()));
            }
        }

        boolean hasTime = TIME_CHECK_RULE.matcher(item).find();
        boolean hasTimeSSS = TIME_SSS_CHECK_RULE.matcher(item).find();
        boolean hasZone = ZONE_CHECK_RULE.matcher(item).find();

        try {
            int colon = item.indexOf(':');
            String zeroPrefix = item.charAt(0) == '-' ? "-00:" : "00:";
            if (hasTimeSSS && hasZone) {
                return OffsetTime.parse(zeroPrefix + item.substring(colon + 1), TIME_ZONE_SSS_FORMATTER)
                        .atDate(LocalDate.ofEpochDay(0))
                        .plusHours(Long.parseLong(item.substring(0, colon)))
                        .toInstant();
            } else if (hasTime && hasZone) {
                return OffsetTime.parse(zeroPrefix + item.substring(colon + 1), TIME_ZONE_FORMATTER)
                        .atDate(LocalDate.ofEpochDay(0))
                        .plusHours(Long.parseLong(item.substring(0, colon)))
                        .toInstant();
            } else if (hasTimeSSS) {
                return LocalTime.parse(zeroPrefix + item.substring(colon + 1), TIME_SSS_FORMATTER)
                        .atDate(LocalDate.ofEpochDay(0))
                        .plusHours(Long.parseLong(item.substring(0, colon)))
                        .toInstant(UTC_ZONE_OFFSET);
            } else {
                return LocalTime.parse(zeroPrefix + item.substring(colon + 1), TIME_FORMATTER)
                        .atDate(LocalDate.ofEpochDay(0))
                        .plusHours(Long.parseLong(item.substring(0, colon)))
                        .toInstant(UTC_ZONE_OFFSET);
            }
        } catch (DateTimeParseException e) {
            throw new ConvException(String.format(
                    "Can convert %s to duration(%s).",
                    input, e.getMessage()));
        }
    }

    static public Double[] parsePlainDataDouble(String[] groups, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstFieldDescriptor field) throws ConvException {
        if (groups == null) {
            return null;
        }

        Double[] ret = new Double[groups.length];
        for (int i = 0; i < groups.length; ++i) {
            String item = ExcelEngine.tryMacro(groups[i].trim());
            ret[i] = parsePlainDataDouble(item, ident, field);
        }

        return ret;
    }

    static public Object[] parsePlainDataOneof(String input, IdentifyDescriptor ident,
            DataDstWriterNode.DataDstOneofDescriptor oneof) throws ConvException {
        if (input == null) {
            return null;
        }

        String[] groups = splitPlainGroups(input, getPlainOneofSeparator(oneof));
        if (groups == null || groups.length < 1) {
            return null;
        }

        String item = ExcelEngine.tryMacro(groups[0].trim());
        Long select;
        if (ident != null) {
            select = DataVerifyImpl.getAndVerify(ident.getVerifier(), ident.name, item);
        } else {
            try {
                select = Long.valueOf(DataVerifyImpl.getAndVerify(oneof.getVerifier(), "[PLAIN TEXT]", item.trim()));
            } catch (java.lang.NumberFormatException e) {
                throw new ConvException(String.format("Try to convert %s to oneof case failed.", input));
            }
        }

        DataDstWriterNode.DataDstFieldDescriptor field = oneof.getFieldById(select.intValue());
        if (field == null) {
            return null;
        }

        Object[] ret = new Object[groups.length];
        ret[0] = field;
        for (int i = 1; i < groups.length; ++i) {
            ret[i] = groups[i];
        }

        if (ret.length > 2) {
            DataSrcImpl current_source = DataSrcImpl.getOurInstance();
            String[] ignored = new String[ret.length - 2];
            for (int i = 2; i < ret.length; ++i) {
                ignored[i - 2] = groups[i];
            }
            if (current_source != null) {
                ProgramOptions.getLoger().warn(
                        "Convert %s from \"%s\", we need only %d fields but provided %d, \"%s\" may be ignored.%s  > File: %s, Table: %s, Row: %d, Column: %d",
                        oneof.getFullName(), input, 2, ret.length, String.join("\",\"", ignored),
                        ProgramOptions.getEndl(), current_source.getCurrentFileName(),
                        current_source.getCurrentTableName(), current_source.getCurrentRowNum() + 1,
                        current_source.getLastColomnNum() + 1);
            } else {
                ProgramOptions.getLoger().warn(
                        "Convert %s from \"%s\", we need only %d fields but provided %d, \"%s\" may be ignored.",
                        oneof.getFullName(), input, 2, ret.length, String.join("\",\"", ignored));
            }
        }

        return ret;
    }

    static public String getPlainFieldSeparator(DataDstWriterNode.DataDstFieldDescriptor field) {
        if (field == null) {
            return null;
        }

        if (field.isList()) {
            return field.mutableExtension().plainSeparator;
        }

        String ret = field.mutableExtension().plainSeparator;
        if (field.getType() != JAVA_TYPE.MESSAGE) {
            return ret;
        }

        if (ret == null) {
            ret = field.getTypeDescriptor().mutableExtension().plainSeparator;
        } else if (field.getTypeDescriptor().mutableExtension().plainSeparator != null) {
            ret = ret + field.getTypeDescriptor().mutableExtension().plainSeparator;
        }

        return ret;
    }

    static public String getPlainMessageSeparator(DataDstWriterNode.DataDstFieldDescriptor field) {
        if (field == null) {
            return null;
        }

        if (field.isList()) {
            if (field.getType() == JAVA_TYPE.MESSAGE) {
                return field.getTypeDescriptor().mutableExtension().plainSeparator;
            }
        }

        String ret = field.mutableExtension().plainSeparator;
        if (field.getType() != JAVA_TYPE.MESSAGE) {
            return ret;
        }

        if (ret == null) {
            ret = field.getTypeDescriptor().mutableExtension().plainSeparator;
        } else if (field.getTypeDescriptor().mutableExtension().plainSeparator != null) {
            ret = ret + field.getTypeDescriptor().mutableExtension().plainSeparator;
        }

        return ret;
    }

    static public String getPlainOneofSeparator(DataDstWriterNode.DataDstOneofDescriptor oneof) {
        if (oneof == null) {
            return null;
        }

        return oneof.mutableExtension().plainSeparator;
    }
}
