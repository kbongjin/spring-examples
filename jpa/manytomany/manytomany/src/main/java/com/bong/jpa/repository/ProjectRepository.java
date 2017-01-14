package com.bong.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bong.jpa.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
