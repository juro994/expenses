package sk.juraj.projects.expenses.dto;

import java.util.List;

public abstract class EntityListDTO<E> {
	
	private List<E> entityListHolder;
	
	public EntityListDTO() {
		
	}
	
	public EntityListDTO(List<E> entityListHolder) {
		this.entityListHolder = entityListHolder;
	}

	public List<E> getEntityListHolder() {
		return entityListHolder;
	}


}
