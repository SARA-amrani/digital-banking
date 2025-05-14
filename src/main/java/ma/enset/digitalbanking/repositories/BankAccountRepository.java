package ma.enset.digitalbanking.repositories;

import ma.enset.digitalbanking.entities.BankAccount;
import ma.enset.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
