package app.petclinic.bootstrap;

import app.petclinic.models.Owner;
import app.petclinic.models.Pet;
import app.petclinic.models.PetType;
import app.petclinic.models.Vet;
import app.petclinic.services.OwnerService;
import app.petclinic.services.PetTypeSevice;
import app.petclinic.services.VetService;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeSevice petTypeSevice;

    public DataInit(OwnerService ownerService, VetService vetService, PetTypeSevice petTypeSevice)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeSevice = petTypeSevice;
    }

    @Override
    public void run(String... args) throws Exception
    {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeSevice.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCat = petTypeSevice.save(cat);

        System.out.println("Loaded PetType's...");

        Owner owner1 = new Owner();
        owner1.setFname("Michael");
        owner1.setLname("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1223244322");
        // created a pet for owner1.
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFname("Fiona");
        owner2.setLname("Glennann");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1223244322");
        // creating a pet for owner2
        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCat);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Just Cat");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFname("Sam");
        vet1.setLname("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFname("Sam");
        vet2.setLname("ace");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
