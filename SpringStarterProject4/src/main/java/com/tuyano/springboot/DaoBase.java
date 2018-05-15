package com.tuyano.springboot;

import java.io.Serializable;
import java.util.List;

public interface DaoBase<T extends BeanBase> extends Serializable {
	public List<T> getAll();
}
