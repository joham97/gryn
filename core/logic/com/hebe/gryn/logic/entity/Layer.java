package com.hebe.gryn.logic.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Layer extends ArrayList<Entity> {

	private static final long serialVersionUID = 3918805578515386539L;

	private boolean sorting;

	public Layer(boolean sorting) {
		this.sorting = sorting;
	}

	public boolean isSorting() {
		return this.sorting;
	}

	public void setSorting(boolean sorting) {
		this.sorting = sorting;
	}

	public void sort() {
		if (this.sorting) {
			sort(new Comparator<Entity>() {
				@Override
				public int compare(Entity o1, Entity o2) {
					return o1.compareTo(o2);
				}
			});
		}
	}

	@Override
	public boolean add(Entity e) {
		boolean result = super.add(e);
		sort();
		return result;
	}

	@Override
	public void add(int index, Entity element) {
		super.add(index, element);
		sort();
	}

	@Override
	public boolean addAll(Collection<? extends Entity> c) {
		boolean result = super.addAll(c);
		sort();
		return result;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Entity> c) {
		boolean result = super.addAll(index, c);
		sort();
		return result;
	}

}
