package com.efigence.mercury.usecase.contract.common;


import java.util.List;

public class Error {

    public static Builder builder(){
        return new Builder();
    }

    protected Error(List<String> codes, List<String> arguments, Object rejectedValue, String rejectedField) {
        this.codes = codes;
        this.arguments = arguments;
        this.rejectedValue = rejectedValue;
        this.rejectedField = rejectedField;
    }

    private final List<String> codes;
    private final List<String> arguments;
    private final Object rejectedValue;
    private final String rejectedField;

    public List<String> getCodes() {
        return codes;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public String getRejectedField() {
        return rejectedField;
    }

    public static class Builder
    {
        private List<String> arguments;
        private List<String> codes;
        private Object rejectedValue;
        private String rejectedField;

        public Builder arguments(List<String> arguments){
            this.arguments = arguments;
            return this;
        }

        public Builder codes(List<String> codes){
            this.codes = codes;
            return this;
        }

        public Builder rejectedValue(Object rejectedValue){
            this.rejectedValue = rejectedValue;
            return this;
        }

        public Builder rejectedField(String rejectedField){
            this.rejectedField = rejectedField;
            return this;
        }

        public Error build(){
            return new Error(codes, arguments, rejectedValue, rejectedField);
        }
    }
}
