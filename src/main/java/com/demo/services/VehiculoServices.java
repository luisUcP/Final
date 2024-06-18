package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Vehiculo;
import com.demo.repository.VehiculoRepository;

@Service

public class VehiculoServices {
    @Autowired

    private VehiculoRepository VehiculoRepository;

    public void create (Vehiculo Vehiculo){
        VehiculoRepository.save(Vehiculo);

    }

    public List<Vehiculo> read(){
        return VehiculoRepository.findAll();

    }
    
    public void update(Vehiculo Vehiculo){
        if(VehiculoRepository.existsById(Vehiculo.getId())){
            VehiculoRepository.save(Vehiculo);
        

        }
      
    }
    public void delete(Long id){
		if (VehiculoRepository.existsById(id)) {
			VehiculoRepository.deleteById(id);

		}
	}
    
}