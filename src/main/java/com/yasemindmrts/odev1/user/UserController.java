package com.yasemindmrts.odev1.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    static List<User> users = new ArrayList();

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        User user = new User(1L,"Yasemin", "Demirtas", "ysmdmr@gmail","54363252", new Date(), true);
        User user2 = new User(2L,"Yaz", "Demirtas", "ysmd23mr@gmail","54363252", new Date(), true);

        users.add(user);
        users.add(user2);

        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        users.add(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/")
    public ResponseEntity<User> findById(@RequestParam Long id) {
        for(User user: users) {
            if (user.getId() == id)  {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/users/update")
    public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam Long id){
        for(User usr: users) {
            if (usr.getId() == id) {

                usr.setName(user.getName());
                usr.setSurname(user.getSurname());
                usr.setBornDate(user.getBornDate());
                usr.setActive(user.isActive());
                usr.setEMail(user.getEMail());
                usr.setPhoneNumber(user.getPhoneNumber());

                return ResponseEntity.ok(usr);
            }
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/users/inactive")
    public ResponseEntity<User> makeInactive(@RequestParam Long id){

        for(User user: users) {

            if (user.getId() == id)  {
                user.setActive(false);
                return ResponseEntity.ok(user);
            }

        }
        return ResponseEntity.ok(null);
    }
}
