package com.example.demo.exceptions;

public class APIException {
    private Code code;
    private String type;
    public static final String DEFAULT_CODE = "def001";

    public enum Code {
        ARTESANIA_NOT_FOUND("art001"),
        ARTESANIA_DUPLICATED("art002"),
        GENERAL_EXCEPTION("art999");
        private String code;
        private Code(String code){
            this.code = code;
        }
        public String getCode(){
            return this.code;
        }
        public static Code fromString(String code){
            for (Code myCode : Code.values()) {
                if(myCode.getCode().equalsIgnoreCase(code)){
                    return myCode;
                }
            }
            return null;
        }
    } 

    public APIException(String message) {
        super();
        this.code = Code.GENERAL_EXCEPTION;
        this.type = "tipo";
    }
    
    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "APIException [constante = " + DEFAULT_CODE + " code=" + code + ", type=" + type + "]";
    }
}
