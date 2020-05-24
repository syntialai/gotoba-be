package com.example.goToba.seeder;

import com.example.goToba.model.BistroTypes;
import com.example.goToba.service.redisService.BistroRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Component
public class BistroTypeSeeder {

    @Autowired
    BistroRedisService bistroRedisService;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedBistroTypes();
    }


    public void seedBistroTypes(){
        seed("All-day cafe");
        seed("All-you-can-eat restaurant");
        seed("Automat");
        seed("Automated restaurant");
        seed("Bakery");
        seed("Bar");
        seed("Bar mleczny");
        seed("Bistro");
        seed("Bouchon");
        seed("Brasserie");
        seed("Breastaurant");
        seed("Brewpub");
        seed("Bridge restaurant");
        seed("Cafe (British)");
        seed("Café gourmand");
        seed("Cafeteria");
        seed("Cakery");
        seed("Cantina");
        seed("Carvery");
        seed("Chifa");
        seed("Chiringuito");
        seed("Chuckwagon");
        seed("Churrascaria");
        seed("Coffeehouse");
        seed("Coney Island (restaurant)");
        seed("Concession stand");
        seed("Cosplay restaurant");
        seed("Diner");
        seed("Dining car");
        seed("Dining room");
        seed("Dinner theater");
        seed("Dinner train");
        seed("Drive-in");
        seed("Drive-through");
        seed("Farm Stall");
        seed("Fast food restaurant");
        seed("Fast casual restaurant");
        seed("Fish and chip shop");
        seed("Floating restaurant");
        seed("Food booth");
        seed("Food cart");
        seed("Food court");
        seed("Food truck");
        seed("Gastropub");
        seed("Ghost restaurant");
        seed("Greasy spoon");
        seed("Hawker centre ");
        seed("Health food");
        seed("Ice cream cart");
        seed("Ice cream van");
        seed("Juke joint");
        seed("Kopi tiam");
        seed("Milk bar");
        seed("Mobile catering");
        seed("Mystery dinner");
        seed("Pancake house");
        seed("Pie and mash");
        seed("Pizza delivery");
        seed("Pop-up restaurant");
        seed("Ramen shop");
        seed("Raw bar");
        seed("Revolving restaurant");
        seed("Sandwich bar");
        seed("Seafood restaurant");
        seed("Snack bar");
        seed("Soda shop");
        seed("Soup kitchen");
        seed("Steakhouse");
        seed("Strausse");
        seed("Supper club");
        seed("Take-out");
        seed("Tower restaurant");
        seed("Truck stop");
        seed("Underground restaurant");
    }
    public void seed(String name){
        BistroTypes bistroTypes= new BistroTypes(UUID.randomUUID().toString(),name);
        if(!bistroRedisService.hasKey(name)){
            bistroRedisService.add(bistroTypes);
        }
    }

}
