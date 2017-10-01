//Dillon Johnson

package ExtremeContractionTests;

import static org.junit.Assert.*;

import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import customChecks.ExtremeContractionCheck;

public class ExtremeContractionUnitTests {
	
	private int numberOfErrorsWith5CharMinimum = 6;

	@Test
	public void shouldReturnCorrectNumberOfErrorsGivenSampleFile() throws Exception {
		Checker checker = initCheckStyleChecker();
		List<File> files = initFilesToBeChecked();
		int numberOfErrors = checker.process(files);
		assertEquals(numberOfErrorsWith5CharMinimum, numberOfErrors);
	}

	private Checker initCheckStyleChecker() throws CheckstyleException {
		Checker checker = new Checker();
		checker.setModuleClassLoader(Thread.currentThread().getContextClassLoader());
		checker.configure(initConfiguration());
		return checker;
	}
	
	private DefaultConfiguration initConfiguration() {
		DefaultConfiguration checks = new DefaultConfiguration("422Checks");
		DefaultConfiguration treeWalker = new DefaultConfiguration("TreeWalker");
		DefaultConfiguration extremeContraction
			= new DefaultConfiguration(ExtremeContractionCheck.class.getCanonicalName());
		checks.addChild(treeWalker);
		treeWalker.addChild(extremeContraction);
		return checks;
	}
	
	private List<File> initFilesToBeChecked() throws Exception {
		String filename = "TestClassWithErrors.java";
		//URL fileURL = getClass().getResource(filename);
		//File testFile = new File(fileURL.getFile());
		URL path = ExtremeContractionUnitTests.class.getResource(filename);
		if (path == null) {
			System.out.println("rip");
		}
		System.out.println(path.toString());
		File testFile = new File(path.getFile());
		
		List<File> files = new ArrayList<File>();
		files.add(testFile);
		return files;
	}
}
