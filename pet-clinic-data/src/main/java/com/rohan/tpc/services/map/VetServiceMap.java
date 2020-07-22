package com.rohan.tpc.services.map;

import com.rohan.tpc.model.Speciality;
import com.rohan.tpc.model.Vet;
import com.rohan.tpc.services.SpecialityService;
import com.rohan.tpc.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {


    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                // We do this because, we need to make sure that this speciality exist in in-mem db
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);

                    // This is a defensive coding pattern
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
