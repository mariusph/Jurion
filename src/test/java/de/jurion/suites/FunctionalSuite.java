package de.jurion.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.jurion.test.CreateInitialAccountTest;
import de.jurion.test.CustomerAddAndRemoveFromCartTest;

@RunWith(Suite.class)
@SuiteClasses({
   
//	 CreateAccountTest.class,
//	 CreateAccountModelTest.class,
	CreateInitialAccountTest.class,
	 CustomerAddAndRemoveFromCartTest.class,
	 
})
public class FunctionalSuite {
     
}
