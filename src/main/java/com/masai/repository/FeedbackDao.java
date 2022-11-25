package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Feedback;
import com.masai.model.User;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	public List<Feedback> findByUser(User user);
}
