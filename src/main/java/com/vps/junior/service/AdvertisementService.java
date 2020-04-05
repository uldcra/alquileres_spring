package com.vps.junior.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vps.junior.dao.IAdvertisementDao;
import com.vps.junior.entity.Advertisement;

@Service
public class AdvertisementService implements AdvertisementInterface{

	@Autowired
	IAdvertisementDao AdvertDao;
	
	@Override
	public List<Advertisement> findAll() {
		// TODO Auto-generated method stub
		return (List<Advertisement>) AdvertDao.findAll();
	}

	@Override
	public Advertisement addAdvertisement(Advertisement advertisement) {
		// TODO Auto-generated method stub
		return AdvertDao.save(advertisement);
	}

	@Override
	public void deleteAdvertisement(Long id) {
		// TODO Auto-generated method stub
		Advertisement adve = AdvertDao.findById(id).orElse(null);
		AdvertDao.delete(adve);
	}

	@Override
	public Advertisement findById(Long id) {
		// TODO Auto-generated method stub
		return AdvertDao.findById(id).orElse(null);
	}

	@Override
	public List<Advertisement> findByLocation(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertisement save(Advertisement Advertisement) {
		// TODO Auto-generated method stub
		return AdvertDao.save(Advertisement);
	}

	@Override
	public void delete(Long id) {
		Advertisement Advertisement = findById(id);
		AdvertDao.delete(Advertisement);
		
	}

}
