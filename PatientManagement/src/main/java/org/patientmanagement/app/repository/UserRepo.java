package org.patientmanagement.app.repository;

import org.patientmanagement.app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends  JpaRepository<UserModel, Integer> {
	public boolean existsByUserName(String userName);
	public boolean existsByUserNameAndPassword(String userName,String password);
}
