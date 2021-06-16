package com.marzouka.BetriebsstellenDB.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Betriebsstelle {

	
	
	
	@CsvBindByPosition(position = 0)
	private String abkuerzung;
	@CsvBindByPosition(position = 1)
	private String name;
	@CsvBindByPosition(position = 2)
	private String kurzname;
	@CsvBindByPosition(position = 3)
	private String typ;
	@CsvBindByPosition(position = 4)
	private String betrZust;
	@CsvBindByPosition(position = 5)
	private String primaryLocationCode;
	@CsvBindByPosition(position = 6)
	private String UIC;
	@CsvBindByPosition(position = 7)
	private String RB;
	@CsvBindByPosition(position = 8)
	private String gültigVon;
	@CsvBindByPosition(position = 9)
	private String gültigBis;
	@CsvBindByPosition(position = 10)
	private String NetzKey;
	@CsvBindByPosition(position = 11)
	private String FplRel;
	@CsvBindByPosition(position =12)
	private String FplGr;
	
	
	
}
