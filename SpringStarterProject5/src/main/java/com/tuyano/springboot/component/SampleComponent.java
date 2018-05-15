package com.tuyano.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class SampleComponent {
	private int counter;

	@Autowired
	public SampleComponent(ApplicationArguments arg) {
		this.counter = 0;
	}

	public int count() {
		return this.counter++;
	}
}
