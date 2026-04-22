package com.tayeb.joueurs;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tayeb.joueurs.entities.Joueur;
import com.tayeb.joueurs.service.JoueurService;

import com.tayeb.joueurs.entities.Role;
import com.tayeb.joueurs.entities.User;
import com.tayeb.joueurs.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Joueurs2Application implements CommandLineRunner {
	@Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JoueurService joueurService;
    @Autowired
    UserService userService;
    


    public static void main(String[] args) {
        SpringApplication.run(Joueurs2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	/*System.out.println("Password Encoded BCRYPT :********************");
    	System.out.println(passwordEncoder.encode("123"));*/
        /*joueurService.saveJoueur(new Joueur("Cristiano Ronaldo", 200000.0, new Date()));
        joueurService.saveJoueur(new Joueur("Messi", 180000.0, new Date()));
        joueurService.saveJoueur(new Joueur("Neymar", 150000.0, new Date()));
        joueurService.saveJoueur(new Joueur("Mbappe", 220000.0, new Date()));
        joueurService.saveJoueur(new Joueur("Benzema", 130000.0, new Date()));
        joueurService.saveJoueur(new Joueur("Salah", 160000.0, new Date()));*/
    }
    /*@PostConstruct
    void init_users() {
        // Add roles
        userService.addRole(new Role(null, "ADMIN"));
        userService.addRole(new Role(null, "AGENT"));
        userService.addRole(new Role(null, "USER"));

        // Add users (password "123" will be BCrypt-encoded automatically)
        userService.saveUser(new User(null, "admin", "123", true, null));
        userService.saveUser(new User(null, "agent", "123", true, null));
        userService.saveUser(new User(null, "user1", "123", true, null));

        // Assign roles
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("agent", "AGENT");
        userService.addRoleToUser("agent", "USER");
        userService.addRoleToUser("user1", "USER");
    }*/
}
