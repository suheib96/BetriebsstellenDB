package com.marzouka.BetriebsstellenDB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marzouka.BetriebsstellenDB.model.Betriebsstelle;

public interface BetriebsstelleRepository extends JpaRepository<Betriebsstelle, String>{

	List<Betriebsstelle> findByAbkuerzung(String abkuerzung);

}
