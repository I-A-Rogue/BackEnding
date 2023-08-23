package net.weg.wegproject.ConcreteClasses.address;

import lombok.AllArgsConstructor;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService implements ServiceInterface<Address> {
    private AddressRepository addressRepository;

    @Override
    public Address create(Address obj) {
        return addressRepository.save(obj);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address update(Address obj) {
        return addressRepository.save(obj);
    }

    @Override
    public Address delete(Long id) {
        Address address = addressRepository.findById(id).get();
        addressRepository.deleteById(id);
        return address;
    }
}
