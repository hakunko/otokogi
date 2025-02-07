package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface otokogidepo extends JpaRepository<Otokogi, Long>{

	  List<Otokogi> findByYearAndMonthAndName(int year, int month, String name); // `AndName` を追加
	  List<Otokogi> findByYear(int year);
}
