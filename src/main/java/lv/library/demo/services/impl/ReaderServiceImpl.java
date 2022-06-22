package lv.library.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.repo.IReaderRepo;

@Service
public class ReaderServiceImpl {

	
	@Autowired
	private IReaderRepo readerepo;
}
