package de.jurion.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.jurion.test.CreateAccountTest;
import de.jurion.test.CustomerAddAndRemoveFromCartTest;

@RunWith(Suite.class)
@SuiteClasses({
   
	 CreateAccountTest.class,
//	 CreateAccountModelTest.class,
	 CustomerAddAndRemoveFromCartTest.class,
	 
})
public class FunctionalSuite {
     
}
