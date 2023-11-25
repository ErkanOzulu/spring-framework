package com.mycomp.repository;

import com.mycomp.entity.Account;
import com.mycomp.enums.UserRole;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);  //Behind the scene hibernate prepare the query keyword -Select * from Account where Country="" or State=""

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(Integer ageStart, Integer ageEnd);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAllByAddressStartingWith(String str);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAgeDesc();


    // ------------------- JPQL QUERIES ------------------- //

    //JPQL is based on entities, or we can say objects and uses generic SQL keywords even if you switch to  database from Postgresql to MySQL or other types of db it won't give any error, the native query is over the database when you change db types it would give errors because some keywords for exp like, Ilike, limit  are not using all types of db.They need to be updated

    //Write a JPQL query that returns all accounts
    @Query("Select a from Account a")
    //in JPQl we use entity name not db table name
    List<Account> fetchAllAccounts();

    //Write a JPQL query to list all admin accounts

    @Query("select a from Account a where a.role='ADMIN'")
    List<Account> fetchAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> fetchAllOrderByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

  /**
    @Query(value = "select * from account_details where age<?1",nativeQuery = true)
    List<Account>retrieveAllByAgeLessThan(Integer age);
    @Query(value = "select * from account_details where age<:inputAge",nativeQuery = true)
    List<Account>retrieveAllByAgeLessThan(@Param("inputAge") Integer age);
    all of them are same with below
   */
    @Query(value = "select * from account_details where age<age",nativeQuery = true)
    List<Account>retrieveAllByAgeLessThan(Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    //ILIKE provides case insensitivity
    @Query(value = "Select * from account_details where name ILIKE concat('%',?1,'%') or address ILIKE concat('%',?1,'%') or country ILIKE concat('%',?1,'%') or state ILIKE concat('%',?1,'%') or city ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Account>retrieveBySearchCriteria(String pattern);




}
