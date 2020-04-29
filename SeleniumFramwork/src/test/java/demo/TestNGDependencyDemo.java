package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	@Test(dependsOnGroups = {"sanity1*"})
	public void Test1() {
		System.out.println("I am inside Test1 ");
	}

	@Test(groups = {"sanity1"})
	public void Test2() {
		System.out.println("I am inside Test2 ");
	}
	
	@Test(groups = {"sanity2"})
	public void Test3() {
		System.out.println("I am inside Test3 ");
	}
}
