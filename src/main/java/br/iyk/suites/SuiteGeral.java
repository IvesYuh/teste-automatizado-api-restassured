package br.iyk.suites;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import br.iyk.core.BaseTest;
import br.iyk.core.BaseToken;

@Suite
@SelectClasses({ 

})

public class SuiteGeral extends BaseTest {
	@Test
	void setup() {
		BaseToken.retornaToken();
	}
}