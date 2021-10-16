package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

     List<User> findByName(String name);

     List<User> findByNameAndAge(String name, String age);

     List<User> findByNameOrAge(String name, String age);

     List<User> findByNameIn(Collection<String> names);

     List<User> findByNameNot(String name);

    // Using named parameters
    @Query("SELECT u FROM User u WHERE (:name is null or u.name LIKE %:name% ) and (:status is null or u.status = :status)")
     List<User> findByNameAndStatus(@Param("name") String name, @Param("status") String status);

    @Query(value = "select u from user u where u.name like %?1", nativeQuery = true)
    List<User> findByNameEndsWith(String firstname);

}
