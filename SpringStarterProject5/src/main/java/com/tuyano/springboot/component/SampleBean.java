package com.tuyano.springboot.component;

public class SampleBean {
	private int counter = 0;

	public int count() {
		return this.counter++;
	}
}
