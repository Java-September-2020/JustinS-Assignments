package com.Lookify.justin.repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Lookify.justin.models.Song;



public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContaining(String artist);
}