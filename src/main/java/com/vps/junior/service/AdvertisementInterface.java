package com.vps.junior.service;



import java.util.List;



import com.vps.junior.entity.Advertisement;

public interface AdvertisementInterface  {

    public List<Advertisement> findAll();

    public Advertisement addAdvertisement (Advertisement advertisement);

    public void deleteAdvertisement (Long id);

    public Advertisement findById(Long id);

    public List<Advertisement> findByLocation(String string);

	public Advertisement save(Advertisement advertisement);

	public void delete(Long id);


}