package net.newture.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TeachingBase entity. @author MyEclipse Persistence Tools
 */

public class TeachingBase implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer baseId;
	private String baseName;
	private Set<Class> classeses = new HashSet<Class>();

	// Constructors

	/** default constructor */
	public TeachingBase() {
	}

	// Property accessors

	public Integer getBaseId() {
		return this.baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}

	public String getBaseName() {
		return this.baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public Set<Class> getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set<Class> classeses) {
		this.classeses = classeses;
	}

}