package org.hibernate.validator.bugs;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.testutil.TestForIssue;
import org.junit.BeforeClass;
import org.junit.Test;

public class YourTestCase {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@TestForIssue(jiraKey = "HV-1534") // Please fill in the JIRA key of your issue
	public void testYourBug() {
		// YourAnnotatedSubBean1 has no annotated or XML-espressed constraints
		final Set<ConstraintViolation<YourAnnotatedBean>> constraintViolations1 = validator.validate( new YourAnnotatedSubBean1( 1L, null ) );
		assertEquals( 0, constraintViolations1.size() );

		// YourAnnotatedSubBean2 has an XML-espressed constraint, on a property of its parent class
		// This test will fail if the test is run with pom.xml (Which specifies a hibernate validator version of 6.0.8.Final)
		// This test will pass if the test is run with pom-HV-4.3.2.xml (Which specifies a hibernate validator version of 4.3.2.Final)
		final Set<ConstraintViolation<YourAnnotatedBean>> constraintViolations2 = validator.validate( new YourAnnotatedSubBean2( 1L, null ) );
		assertEquals( 1, constraintViolations2.size() );
		assertEquals(
				"Name must be specified for YourAnnotatedSubBean2",
				constraintViolations2.iterator().next().getMessage() );
	}

}
