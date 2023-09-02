package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class UsingRootObject {

	private ExpressionParser parser;
	
	@BeforeEach
	void unit() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void using_root_object() {
		
		var student = new Student("Aung Aung", 23, List.of("Java","Spring","Angular","Flutter"));
		
		var expression = parser.parseExpression("name");
		
		var result = expression.getValue(student, String.class);
		
		assertEquals("Aung Aung", result);
				
		expression = parser.parseExpression("age");
		var age = expression.getValue(student, Integer.class);
		
		assertEquals(23, age);
		
		if(expression.isWritable(student)) {
			expression.setValue(student, 21);
		}
		
		expression = parser.parseExpression("'First interest expression is ' + interests[0]");
		var firstInterests = expression.getValue(student, String.class);
		
		assertEquals("First interest expression is Java", firstInterests);
	}
	
	@Test
	void using_record_root() {
		
		var adress = new Adress("Yadanarmyein Street", "No120/4f", "Kamayut");
		
		var expression = parser.parseExpression("street");
		var street = expression.getValue(adress, String.class);
		
		assertEquals(adress.street(), street);
		
		expression = parser.parseExpression("building");
		var building = expression.getValue(adress, String.class);
		
		assertEquals(adress.building(), building);
		
		expression = parser.parseExpression("township");
		var result = expression.getValue(adress, String.class);
		
		assertEquals(adress.township(), result);
	}
}
