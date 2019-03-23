package app.petclinic.services.springdatajpa;

import app.petclinic.models.PetType;
import app.petclinic.repositories.PetTypeRepository;
import app.petclinic.services.PetTypeSevice;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeJPAService implements PetTypeSevice
{
    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository)
    {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll()
    {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong)
    {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object)
    {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object)
    {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong)
    {
        petTypeRepository.deleteById(aLong);
    }
}