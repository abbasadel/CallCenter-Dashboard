package com.shuratech.gis.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author abbas
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AgentStatus {

    WaitForNextCall("Online", Color.SUCCESS),
    NotReadyForNextCall("Not Ready", Color.WARNING),
    AfterCallWork("After Call", Color.DEFAULT),
    Break(Color.DEFAULT),
    CallRinging(Color.SUCCESS),
    CallInternal(Color.INFO),
    CallOnHold(Color.DANGER),
    CallOutbound(Color.INFO),
    CallInbound(Color.INFO),
    LoggedOut(Color.DEFAULT);

    String label;
    Color color;

    public enum Color {

        DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER;
    };

    private AgentStatus(String label, Color color) {
        this.label = label;
        this.color = color;
    }

    private AgentStatus(Color color) {
        this.label = this.name();
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return label;
    }

}
