package com.EventsBeltReviewer.justin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EventsBeltReviewer.justin.models.Events;

@Repository
public interface EventRepository extends CrudRepository<Events, Long> {
	List<Events> findAll();
}
