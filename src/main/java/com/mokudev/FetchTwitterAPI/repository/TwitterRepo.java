package com.mokudev.FetchTwitterAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mokudev.FetchTwitterAPI.model.TwitterModel;

@Repository
public interface TwitterRepo extends JpaRepository<TwitterModel, String>{

}
