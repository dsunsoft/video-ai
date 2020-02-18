package com.dsunsoft.common.entity.ng;

import java.io.Serializable;

/**
 * ng select
 * 
 * @author ygm
 *
 */
public class NgSelect implements Serializable {
	private static final long serialVersionUID = -3958483836759978441L;

	private String text;
	private Object value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
