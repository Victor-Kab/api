package io.studerd.api.module.parameter.entity.enums;

public enum ParameterType {
    SYSTEM("SYSTEM"),
    HEALTH("HEALTH"),
    OTHER("OTHER");
    private final String label;

    ParameterType(String label) {
        this.label = label;
    }

    public String label(){
        return this.label;
    }
}
