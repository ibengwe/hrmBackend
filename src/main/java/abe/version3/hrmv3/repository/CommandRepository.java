package abe.version3.hrmv3.repository;

import abe.version3.hrmv3.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command,Integer> {
}
