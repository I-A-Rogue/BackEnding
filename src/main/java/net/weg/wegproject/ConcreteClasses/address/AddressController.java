package net.weg.wegproject.ConcreteClasses.address;

import lombok.AllArgsConstructor;
import net.weg.wegproject.interfaces.ControllerInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController implements ControllerInterface<Address, AddressDTO> {

    private final AddressService addressService;

    @Override
    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressDTO objDTO) {
        try{
            Address obj = new Address();
            BeanUtils.copyProperties(objDTO, obj);
            return ResponseEntity.ok(addressService.create(obj));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Address> findOne(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@RequestBody AddressDTO objDTO,@PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> delete(@PathVariable Long id) {
        return null;
    }
}
