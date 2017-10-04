package extremeContractionTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.*;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;

import customChecks.ExtremeContractionCheck;

@RunWith(PowerMockRunner.class)
public class VisitTokenUnitTest {
	
	private DetailAST astMock;
	private ExtremeContractionCheck ecc;

	@Before
	public void init() {
		astMock = PowerMock.createMock(DetailAST.class);
	}

}
