package com;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.SearchTest;
import com.LoginTest;

@RunWith(Suite.class)
@SuiteClasses({LoginTest.class, SearchTest.class})
public class AllTests {
	}