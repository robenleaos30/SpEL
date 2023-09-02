package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import com.jdc.root.Adress;
import com.jdc.root.Student;

public class UsingRootObject {

	ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void student_test() {
		var student = new Student("Aung Aung", 23, List.of("Java", "Spring", "Angular", "Python", "JavaScript", "MySQL"));
	
		var expression = parser.parseExpression("name");
		
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		
		var result = expression.getValue(context, student, String.class);
		
		assertEquals("Aung Aung", result);
	}
	
	@Test
	void record_adress_test() {
		var adress = new Adress("Yadanarmyaing Street", "No120/1F", "Kamayut");
		
		var expression = parser.parseExpression("building + ', ' + street + ', ' + township");
		
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		
		var result = expression.getValue(context, adress, String.class);
		
		System.out.println(result);
	}
}
