package lgarcia.dev.nutrigest_api.controllers;

import lgarcia.dev.nutrigest_api.models.DTOs.Users.GET.AllUsersDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Users.GET.GetUserDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Users.POST.UserCreationRequest;
import lgarcia.dev.nutrigest_api.models.UserModel;
import lgarcia.dev.nutrigest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // GET Petitions
    @GetMapping
    public List<AllUsersDTO> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable Long id) {
        GetUserDTO userDTO = this.userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{id}/phones")
    public List<String> getPhonesByUserId(@PathVariable Long id) {
        return this.userService.getPhonesByUserId(id);
    }

    // POST Petitions
    @PostMapping
    public ResponseEntity<UserModel> storeUser(@RequestBody UserCreationRequest user) {
        UserModel newUser = userService.storeUser(user.getUser(), user.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/{id}/addPhone")
    public UserModel addPhone(@RequestBody UserModel user, @PathVariable Long id) {
        return this.userService.addPhone(user, id);
    }

    @PostMapping("/{id}/addAddress")
    public UserModel addAddress(@RequestBody UserModel user, @PathVariable Long id) {
        return this.userService.addAddress(user, id);
    }

    @PostMapping("/{id}/addMeasure")
    public UserModel addMeasure(@RequestBody UserModel user, @PathVariable Long id) {
        return this.userService.addMeasure(user, id);
    }

    // PUT and DELETE Petitions
    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable Long id) {
        return this.userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }


}
