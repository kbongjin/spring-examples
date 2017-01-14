package com.bong.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bong.jpa.domain.ProjectMember;
import com.bong.jpa.domain.ProjectMemberId;

public interface ProjecMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

}
