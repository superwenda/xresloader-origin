// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: xresloader.proto

package org.xresloader;

public final class Xresloader {
  private Xresloader() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(org.xresloader.Xresloader.fileDescription);
    registry.add(org.xresloader.Xresloader.msgDescription);
    registry.add(org.xresloader.Xresloader.msgRequireMappingAll);
    registry.add(org.xresloader.Xresloader.msgSeparator);
    registry.add(org.xresloader.Xresloader.verifier);
    registry.add(org.xresloader.Xresloader.fieldDescription);
    registry.add(org.xresloader.Xresloader.fieldAlias);
    registry.add(org.xresloader.Xresloader.fieldRatio);
    registry.add(org.xresloader.Xresloader.fieldSeparator);
    registry.add(org.xresloader.Xresloader.fieldRequired);
    registry.add(org.xresloader.Xresloader.oneofDescription);
    registry.add(org.xresloader.Xresloader.oneofSeparator);
    registry.add(org.xresloader.Xresloader.enumDescription);
    registry.add(org.xresloader.Xresloader.enumvDescription);
    registry.add(org.xresloader.Xresloader.enumAlias);
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public static final int FILE_DESCRIPTION_FIELD_NUMBER = 1001;
  /**
   * <pre>
   * 描述信息（不同的输出可能有不同的功能）
   * </pre>
   *
   * <code>extend .google.protobuf.FileOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FileOptions,
      java.lang.String> fileDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int MSG_DESCRIPTION_FIELD_NUMBER = 1001;
  /**
   * <pre>
   * 描述信息（不同的输出可能有不同的功能）
   * </pre>
   *
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> msgDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int MSG_REQUIRE_MAPPING_ALL_FIELD_NUMBER = 1011;
  /**
   * <pre>
   * 开启所有字段映射检查
   * </pre>
   *
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.Boolean> msgRequireMappingAll = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Boolean.class,
        null);
  public static final int MSG_SEPARATOR_FIELD_NUMBER = 1012;
  /**
   * <pre>
   * Plain模式字段分隔符（默认为: ,;|）
   * </pre>
   *
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> msgSeparator = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int VERIFIER_FIELD_NUMBER = 1001;
  /**
   * <pre>
   * 附加验证器
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> verifier = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int FIELD_DESCRIPTION_FIELD_NUMBER = 1011;
  /**
   * <pre>
   * 描述信息（不同的输出可能有不同的功能）
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> fieldDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int FIELD_ALIAS_FIELD_NUMBER = 1012;
  /**
   * <pre>
   * 字段别名，可用于验证器名字
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> fieldAlias = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int FIELD_RATIO_FIELD_NUMBER = 1013;
  /**
   * <pre>
   * 字段放大倍数，可用于验证器名字
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.Integer> fieldRatio = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Integer.class,
        null);
  public static final int FIELD_SEPARATOR_FIELD_NUMBER = 1014;
  /**
   * <pre>
   * Plain模式字段分隔符（默认为: ,;|）
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> fieldSeparator = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int FIELD_REQUIRED_FIELD_NUMBER = 1015;
  /**
   * <pre>
   * 字段标记为必须，相当于 pb2 的required
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.Boolean> fieldRequired = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Boolean.class,
        null);
  public static final int ONEOF_DESCRIPTION_FIELD_NUMBER = 1001;
  /**
   * <pre>
   * 描述信息（不同的输出可能有不同的功能）
   * </pre>
   *
   * <code>extend .google.protobuf.OneofOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.OneofOptions,
      java.lang.String> oneofDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int ONEOF_SEPARATOR_FIELD_NUMBER = 1002;
  /**
   * <pre>
   * Plain模式字段分隔符（默认为: ,;|）
   * </pre>
   *
   * <code>extend .google.protobuf.OneofOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.OneofOptions,
      java.lang.String> oneofSeparator = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int ENUM_DESCRIPTION_FIELD_NUMBER = 1001;
  /**
   * <pre>
   * 描述信息（不同的输出可能有不同的功能）
   * </pre>
   *
   * <code>extend .google.protobuf.EnumOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.EnumOptions,
      java.lang.String> enumDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int ENUMV_DESCRIPTION_FIELD_NUMBER = 1001;
  /**
   * <pre>
   * 描述信息（不同的输出可能有不同的功能）
   * </pre>
   *
   * <code>extend .google.protobuf.EnumValueOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.EnumValueOptions,
      java.lang.String> enumvDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int ENUM_ALIAS_FIELD_NUMBER = 1002;
  /**
   * <pre>
   * 枚举别名，可用于验证器名字
   * </pre>
   *
   * <code>extend .google.protobuf.EnumValueOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.EnumValueOptions,
      java.lang.String> enumAlias = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020xresloader.proto\022\016org.xresloader\032 goog" +
      "le/protobuf/descriptor.proto:7\n\020file_des" +
      "cription\022\034.google.protobuf.FileOptions\030\351" +
      "\007 \001(\t:9\n\017msg_description\022\037.google.protob" +
      "uf.MessageOptions\030\351\007 \001(\t:A\n\027msg_require_" +
      "mapping_all\022\037.google.protobuf.MessageOpt" +
      "ions\030\363\007 \001(\010:7\n\rmsg_separator\022\037.google.pr" +
      "otobuf.MessageOptions\030\364\007 \001(\t:0\n\010verifier" +
      "\022\035.google.protobuf.FieldOptions\030\351\007 \001(\t:9" +
      "\n\021field_description\022\035.google.protobuf.Fi" +
      "eldOptions\030\363\007 \001(\t:3\n\013field_alias\022\035.googl" +
      "e.protobuf.FieldOptions\030\364\007 \001(\t:3\n\013field_" +
      "ratio\022\035.google.protobuf.FieldOptions\030\365\007 " +
      "\001(\005:7\n\017field_separator\022\035.google.protobuf" +
      ".FieldOptions\030\366\007 \001(\t:6\n\016field_required\022\035" +
      ".google.protobuf.FieldOptions\030\367\007 \001(\010:9\n\021" +
      "oneof_description\022\035.google.protobuf.Oneo" +
      "fOptions\030\351\007 \001(\t:7\n\017oneof_separator\022\035.goo" +
      "gle.protobuf.OneofOptions\030\352\007 \001(\t:7\n\020enum" +
      "_description\022\034.google.protobuf.EnumOptio" +
      "ns\030\351\007 \001(\t:=\n\021enumv_description\022!.google." +
      "protobuf.EnumValueOptions\030\351\007 \001(\t:6\n\nenum" +
      "_alias\022!.google.protobuf.EnumValueOption" +
      "s\030\352\007 \001(\tb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.DescriptorProtos.getDescriptor(),
        });
    fileDescription.internalInit(descriptor.getExtensions().get(0));
    msgDescription.internalInit(descriptor.getExtensions().get(1));
    msgRequireMappingAll.internalInit(descriptor.getExtensions().get(2));
    msgSeparator.internalInit(descriptor.getExtensions().get(3));
    verifier.internalInit(descriptor.getExtensions().get(4));
    fieldDescription.internalInit(descriptor.getExtensions().get(5));
    fieldAlias.internalInit(descriptor.getExtensions().get(6));
    fieldRatio.internalInit(descriptor.getExtensions().get(7));
    fieldSeparator.internalInit(descriptor.getExtensions().get(8));
    fieldRequired.internalInit(descriptor.getExtensions().get(9));
    oneofDescription.internalInit(descriptor.getExtensions().get(10));
    oneofSeparator.internalInit(descriptor.getExtensions().get(11));
    enumDescription.internalInit(descriptor.getExtensions().get(12));
    enumvDescription.internalInit(descriptor.getExtensions().get(13));
    enumAlias.internalInit(descriptor.getExtensions().get(14));
    com.google.protobuf.DescriptorProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
