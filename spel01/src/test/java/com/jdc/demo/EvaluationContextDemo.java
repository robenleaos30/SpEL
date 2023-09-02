package com.jdc.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class EvaluationContextDemo {
	
	ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void demo() {
		
		var adress = new Adress("Yadanarmyaing street, Kamayut 1 block", "No120/1F", "Kamayut");
		
		var expression = parser.parseExpression("building + ', ' + street + ', ' + township");
		
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(adress).build();
		
		var result = expression.getValue(context, String.class);
		
		System.out.println(result);
	}
}
