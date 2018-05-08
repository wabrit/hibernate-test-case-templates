package org.hibernate.validator.bugs;

/**
 * This bean exhibits the issue described in HV-1534. It has no
 * annotated constraints; all of the constraints to be applied
 * will be declared in the constraints xml resource file.
*/
public class YourAnnotatedSubBean1 extends YourAnnotatedBean {

	protected YourAnnotatedSubBean1() {
	}

	public YourAnnotatedSubBean1(Long id, String name) {
		super(id, name);
	}

}
