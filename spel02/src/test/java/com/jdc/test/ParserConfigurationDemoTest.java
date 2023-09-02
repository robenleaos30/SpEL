package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.jdc.root.MyData;

public class ParserConfigurationDemoTest {

	ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser(new SpelParserConfiguration(true, true));
	}
	
	@Test
	void method_without_configuration() {
		assertDoesNotThrow(() -> {
			var root = new MyData();
									
			var expression = parser.parseExpression("list[0] = 'Hello SpEL'");
			
			var result = expression.getValue(root);
			System.out.println(result);
		});
	}
}
