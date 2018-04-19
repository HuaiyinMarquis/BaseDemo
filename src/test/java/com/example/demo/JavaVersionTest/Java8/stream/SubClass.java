package com.example.demo.JavaVersionTest.Java8.stream;

public class SubClass extends MyClass implements MyFun, MyInterface{ //类优先原则

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

}
