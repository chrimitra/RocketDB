package com.f2.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f2.daos.UserDao;
import com.f2.models.User;
import com.f2.utils.Producer;

import redis.clients.jedis.JedisPooled;

@RestController
public class UserController {
	
	@Autowired
	JedisPooled jedisPooled;
	
	@Autowired
	UserDao userDao;
	
	Producer producer;
	
	// Funzione per mandare utente JSON alla cache o cache/db
	@GetMapping("/send")
	public void sendData() {
		
		// Creo l'oggetto utente
		Producer producer = new Producer();
		User nuovoUtente = producer.nuovoUser();
		
		 /* utente : { 
         * 				"id": "",
         * 				"ip": "",
         * 				"username": "" 
         * 			}						*/
				
		
		// JSON
		Map<String, String> utente = new HashMap<>();
        
		utente.put("ip", nuovoUtente.getIp());
        utente.put("username", nuovoUtente.getUsername());
        
        // Facciamo l'hash dell'oggetto
        Integer hashCode = utente.hashCode();
        
        utente.put("id", hashCode.toString());
        
        // Controllo se nella cache esiste
        if(jedisPooled.exists(hashCode.toString())) {
        	System.out.println("OK");
        // Se non esiste, salvamelo nel db e nella cache
        } else {
        	Long hashUtente = jedisPooled.hset(hashCode.toString(), utente);
        	nuovoUtente.setId(hashCode);
        	userDao.save(nuovoUtente);
        	
        }
        
       
	}
	
	// Funzione per controllare se nella cache esiste l'user
	@GetMapping("/check")
	public void checkData() {
		if(jedisPooled.exists("-597635382")) {
        	System.out.println("OK");
        }   
	}
	
	// Funzione per prendere tutte le key dalla cache
	@GetMapping("/all")
	public void allData() {
		 Set<String> allKeys = jedisPooled.keys("*");
		 System.out.println(allKeys);
		 
	}
	
	
}
