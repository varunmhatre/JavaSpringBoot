package com.examples.example3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examples.example3.models.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>
{
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidLessThan(int aid);

	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);

	@Query("from Alien where aname=?1 AND tech=?2")
	List<Alien> findByNameAndTech(String name,String tech);
}
