package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class HelloSpringExpression {
	
	ExpressionParser parser;
	
	@BeforeEach
	void unit() {
		parser = new SpelExpressionParser();
	}

	@Test
	void my_first_expression() {

		var expression = parser.parseExpression("10 + 5");
		
		var result = expression.getValue(Integer.class);
		assertEquals(15, result);
	}
	
	@Test
	void using_generic_method() {
		
		var expression = parser.parseExpression("{1,2,3,4,5}");
		
		var result = expression.getValue(List.class);
		
		assertEquals(5, result.size());
	}
}
