package com.github.MikeMwita.empAPI.repo;

import com.github.MikeMwita.empAPI.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepo  extends PagingAndSortingRepository<User,Long> {
List<User>findAll();



}
