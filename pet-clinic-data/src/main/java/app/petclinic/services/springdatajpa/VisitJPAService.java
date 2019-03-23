package app.petclinic.services.springdatajpa;

import app.petclinic.models.Visit;
import app.petclinic.repositories.VisitRepository;
import app.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitJPAService implements VisitService
{
    private final VisitRepository visitRepository;

    public VisitJPAService(VisitRepository visitRepository)
    {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll()
    {
        Set<Visit> visits = new HashSet<>();

        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Long aLong)
    {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object)
    {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object)
    {
        visitRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong)
    {
        visitRepository.deleteById(aLong);

    }
}