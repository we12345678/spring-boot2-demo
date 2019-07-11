package com.norteksoft.demo.repossitory;
import com.norteksoft.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UsersRepository extends JpaRepository<Users, Long> {

}
