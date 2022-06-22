package lv.library.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.repo.ILibraryRepo;

@Service
public class LibraryDepartmentServiceImpl {

	@Autowired
	private ILibraryRepo libraryrepo;
}
