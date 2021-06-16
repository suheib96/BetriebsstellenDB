package com.marzouka.BetriebsstellenDB.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marzouka.BetriebsstellenDB.model.Betriebsstelle;
import com.marzouka.BetriebsstellenDB.repository.BetriebsstelleRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.RequiredArgsConstructor;

@RestController // @Controller + //ResponseBody
@RequestMapping("/betriebsstellen")
@RequiredArgsConstructor
public class BetriebsstelleController {

//private final BetriebsstelleRepository betriebsstelleRepository;

	

	@GetMapping
	public List<Betriebsstelle> getAllBetriebsstellen() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get("Betriebsstellen.csv"));
		CSVReader csvReader = new CSVReader(reader);
		
		CsvToBean csvToBean = new CsvToBeanBuilder(reader)
				.withType(Betriebsstelle.class)
				.withSeparator(';')
				.build();
		List<Betriebsstelle> betriebsstellen = csvToBean.parse();
		
		

//		return  betriebsstelleRepository.findAll();
		return betriebsstellen;
	}
	@GetMapping("/{abk}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getOneBetriebsstelle(@PathVariable String abk ) throws IOException{
		Reader reader = Files.newBufferedReader(Paths.get("Betriebsstellen.csv"));
		CSVReader csvReader = new CSVReader(reader);

		CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(Betriebsstelle.class).withSeparator(';').build();
		List<Betriebsstelle> betriebsstellen = csvToBean.parse();
		for (int i = 0 ; i<betriebsstellen.size();i++) {
			if (betriebsstellen.get(i).getAbkuerzung().equals(abk.toUpperCase())) {
				return ResponseEntity.ok(betriebsstellen.get(i));
			}
		}
		return new ResponseEntity<String>("Es existiert keine Betriebsstelle mit dieser Abkürzung!",HttpStatus.NOT_FOUND);
//		if(betriebsstellen.indexOf(a) != -1) {
//		return betriebsstellen.get(betriebsstellen.indexOf(a));
//		}
//		 return betriebsstellen.get(1);
		
	}

}