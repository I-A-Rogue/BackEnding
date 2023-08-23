package net.weg.wegproject.ConcreteClasses.address;

import lombok.AllArgsConstructor;
import net.weg.wegproject.interfaces.ControllerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController implements ControllerInterface<Address, Long> {
    @Override
    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Long objDTO) {
        return null;
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
    public ResponseEntity<Address> update(@RequestBody Long objDTO,@PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> delete(@PathVariable Long id) {
        return null;
    }
}
