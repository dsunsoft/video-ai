package com.dsunsoft.common.entity;

import java.io.Serializable;

/**
 * Commbox
 *
 * @author ygm
 */
public class Commbox implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String text;

    public Commbox() {
    }

    public Commbox(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
