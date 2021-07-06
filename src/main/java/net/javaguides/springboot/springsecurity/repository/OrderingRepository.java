package net.javaguides.springboot.springsecurity.repository;

import net.javaguides.springboot.springsecurity.model.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {
    List<Ordering> findAll();
}
