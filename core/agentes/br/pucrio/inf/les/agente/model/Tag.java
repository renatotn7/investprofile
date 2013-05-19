package br.pucrio.inf.les.agente.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Tag implements Serializable {
	private static final long serialVersionUID = 601L;

	private String tag = "";

	public Tag(String tag) {
		this.tag = tag;
	}

	public Tag(Enum canal) {
		this.tag = canal.toString();
	}

	public void concatenaCanal(String tag) {
		this.tag.concat(".");
		this.tag.concat(tag);
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Tag)) {
			return false;
		}
		Tag rhs = (Tag) object;
		return new EqualsBuilder().append(this.tag, rhs.tag).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-423999931, -845649863).append(this.tag)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.tag;
	}
}
