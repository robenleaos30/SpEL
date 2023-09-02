package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class HelloExpression {

	ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void demo() {
		var expression = parser.parseExpression("10 + 5");
		
		var result = expression.getValue(Integer.class);
		
		assertEquals(15, result);
	}
	
	@Test
	void test() {
		var expression = parser.parseExpression("{1,2,3,4,5}");
		
		var result = expression.getValue(List.class);
		
		assertEquals(5, result.size());
	}
	
	@Test
	void conversion() {
		var expression = parser.parseExpression("'110'");
		
		var result = expression.getValue(Integer.class);
		
		assertEquals(110, result);
		
		System.out.println(result);
	}
}
