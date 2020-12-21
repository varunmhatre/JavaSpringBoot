package com.examples.example4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.examples.example4.model.Alien;

@RepositoryRestResource(collectionResourceRel = "aliens", path = "alien")
public interface AlienRepo extends JpaRepository<Alien, Integer>
{

}
