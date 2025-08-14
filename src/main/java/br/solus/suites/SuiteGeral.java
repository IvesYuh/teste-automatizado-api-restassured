package br.solus.suites;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import br.solus.core.BaseToken;
import br.solus.core.BaseTest;

@Suite
@SelectClasses({ 

})

public class SuiteGeral extends BaseTest {
	@Test
	void setup() {
		BaseToken.retornaToken();
	}
}