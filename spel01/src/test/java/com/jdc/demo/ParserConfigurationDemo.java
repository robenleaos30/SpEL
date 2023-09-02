	package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ParserConfigurationDemo {

	ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void test_without_configuration() {
		assertThrows(SpelEvaluationException.class, () -> {
			var root = new MyData();
			
			var expression = parser.parseExpression("list[0] = 'Hello SpEl'");
			
			var result = expression.getValue(root);
			System.out.println(result);
		});
	}
	
	@Test
	void test_with_configuration() {
		assertDoesNotThrow(() -> {
			
			var config = new SpelParserConfiguration(true, true);
			var parser = new SpelExpressionParser(config);
			var expression = parser.parseExpression("list[0] = 'Hello SpEl'");
			
			var root = new MyData();
			expression.getValue(root);
			
			assertEquals(1, root.getList().size());
			assertEquals("Hello SpEl", root.getList().get(0));
		});
	}
}
