// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LoginReq.proto

package com.xingjiahe.www.protobuf.request;

public final class LoginRequest {
  private LoginRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface LoginReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:LoginReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *登录类型
     * </pre>
     *
     * <code>int32 type = 1;</code>
     */
    int getType();

    /**
     * <pre>
     *名字
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    String getName();
    /**
     * <pre>
     *名字
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>string pass = 3;</code>
     */
    String getPass();
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>string pass = 3;</code>
     */
    com.google.protobuf.ByteString
        getPassBytes();
  }
  /**
   * Protobuf type {@code LoginReq}
   */
  public  static final class LoginReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:LoginReq)
      LoginReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use LoginReq.newBuilder() to construct.
    private LoginReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private LoginReq() {
      type_ = 0;
      name_ = "";
      pass_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private LoginReq(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              type_ = input.readInt32();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              pass_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return LoginRequest.internal_static_LoginReq_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return LoginRequest.internal_static_LoginReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              LoginReq.class, Builder.class);
    }

    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;
    /**
     * <pre>
     *登录类型
     * </pre>
     *
     * <code>int32 type = 1;</code>
     */
    public int getType() {
      return type_;
    }

    public static final int NAME_FIELD_NUMBER = 2;
    private volatile Object name_;
    /**
     * <pre>
     *名字
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    public String getName() {
      Object ref = name_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *名字
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PASS_FIELD_NUMBER = 3;
    private volatile Object pass_;
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>string pass = 3;</code>
     */
    public String getPass() {
      Object ref = pass_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        pass_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>string pass = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPassBytes() {
      Object ref = pass_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        pass_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (type_ != 0) {
        output.writeInt32(1, type_);
      }
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
      }
      if (!getPassBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, pass_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (type_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, type_);
      }
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
      }
      if (!getPassBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, pass_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof LoginReq)) {
        return super.equals(obj);
      }
      LoginReq other = (LoginReq) obj;

      boolean result = true;
      result = result && (getType()
          == other.getType());
      result = result && getName()
          .equals(other.getName());
      result = result && getPass()
          .equals(other.getPass());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + PASS_FIELD_NUMBER;
      hash = (53 * hash) + getPass().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static LoginReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static LoginReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static LoginReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static LoginReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static LoginReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static LoginReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static LoginReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static LoginReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static LoginReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static LoginReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static LoginReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static LoginReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(LoginReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code LoginReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:LoginReq)
        LoginReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return LoginRequest.internal_static_LoginReq_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return LoginRequest.internal_static_LoginReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                LoginReq.class, Builder.class);
      }

      // Construct using com.xingjiahe.www.protobuf.request.LoginRequest.LoginReq.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        type_ = 0;

        name_ = "";

        pass_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return LoginRequest.internal_static_LoginReq_descriptor;
      }

      public LoginReq getDefaultInstanceForType() {
        return LoginReq.getDefaultInstance();
      }

      public LoginReq build() {
        LoginReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public LoginReq buildPartial() {
        LoginReq result = new LoginReq(this);
        result.type_ = type_;
        result.name_ = name_;
        result.pass_ = pass_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof LoginReq) {
          return mergeFrom((LoginReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(LoginReq other) {
        if (other == LoginReq.getDefaultInstance()) return this;
        if (other.getType() != 0) {
          setType(other.getType());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getPass().isEmpty()) {
          pass_ = other.pass_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        LoginReq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (LoginReq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int type_ ;
      /**
       * <pre>
       *登录类型
       * </pre>
       *
       * <code>int32 type = 1;</code>
       */
      public int getType() {
        return type_;
      }
      /**
       * <pre>
       *登录类型
       * </pre>
       *
       * <code>int32 type = 1;</code>
       */
      public Builder setType(int value) {
        
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *登录类型
       * </pre>
       *
       * <code>int32 type = 1;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }

      private Object name_ = "";
      /**
       * <pre>
       *名字
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public String getName() {
        Object ref = name_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *名字
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *名字
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public Builder setName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *名字
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *名字
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private Object pass_ = "";
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>string pass = 3;</code>
       */
      public String getPass() {
        Object ref = pass_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          pass_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>string pass = 3;</code>
       */
      public com.google.protobuf.ByteString
          getPassBytes() {
        Object ref = pass_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          pass_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>string pass = 3;</code>
       */
      public Builder setPass(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        pass_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>string pass = 3;</code>
       */
      public Builder clearPass() {
        
        pass_ = getDefaultInstance().getPass();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>string pass = 3;</code>
       */
      public Builder setPassBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        pass_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:LoginReq)
    }

    // @@protoc_insertion_point(class_scope:LoginReq)
    private static final LoginReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new LoginReq();
    }

    public static LoginReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoginReq>
        PARSER = new com.google.protobuf.AbstractParser<LoginReq>() {
      public LoginReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new LoginReq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<LoginReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<LoginReq> getParserForType() {
      return PARSER;
    }

    public LoginReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016LoginReq.proto\"4\n\010LoginReq\022\014\n\004type\030\001 \001" +
      "(\005\022\014\n\004name\030\002 \001(\t\022\014\n\004pass\030\003 \001(\tB2\n\"com.xi" +
      "ngjiahe.www.protobuf.requestB\014LoginReque" +
      "stb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_LoginReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_LoginReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginReq_descriptor,
        new String[] { "Type", "Name", "Pass", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
