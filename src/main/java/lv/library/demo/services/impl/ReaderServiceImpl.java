package lv.library.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.model.Reader;
import lv.library.demo.repo.IReaderRepo;

@Service
public class ReaderServiceImpl {

	
	@Autowired
	private IReaderRepo readerepo;
	
	public void insertReader(String name, String Surname) {
		Reader temp = new Reader(name, Surname);
		Reader readerfromDB = readerepo.save(temp);
	}
}
