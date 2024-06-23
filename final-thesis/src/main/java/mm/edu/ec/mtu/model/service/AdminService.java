package mm.edu.ec.mtu.model.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ec.mtu.model.entity.Admin;
import mm.edu.ec.mtu.model.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo repo;
	
	public Optional<Admin> findByUsername(String email){
		return repo.findById(email);
	}
}
