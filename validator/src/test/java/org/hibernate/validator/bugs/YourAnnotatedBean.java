package org.hibernate.validator.bugs;

/**
 * This bean exhibits the issue described in HV-1534. It has no
 * annotated constraints; all of the constraints to be applied
 * will be declared in the constraints xml resource file.
*/
public class YourAnnotatedBean {

	private Long id;

	private String name;

	protected YourAnnotatedBean() {
	}

	public YourAnnotatedBean(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
