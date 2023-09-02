package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class ConversionDemo {

	ExpressionParser parser;
	
	@BeforeEach
	void init() { 
		parser = new SpelExpressionParser();
	}
	
	@Test
	void demo() {
		var expression = parser.parseExpression("'110'");
		
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		
		var result = expression.getValue(context, Integer.class);
		
		assertEquals(result, 110);
		System.out.println(result);
	}
}
