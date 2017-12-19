package com.hebe.gryn.logic.entity;

import java.util.ArrayList;

public class Layer extends ArrayList<Entity>{

	private static final long serialVersionUID = 3918805578515386539L;

	private boolean sorting;
	
	public Layer(boolean sorting) {
		this.sorting = sorting;
	}
	
	public boolean isSorting() {
		return sorting;
	}
	
	public void setSorting(boolean sorting) {
		this.sorting = sorting;
	}

}
