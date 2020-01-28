package kr.co.mentalK94.restaurantReservation.application;

import kr.co.mentalK94.restaurantReservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurantById(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }


    @Transactional
    public Restaurant updateRestaurant(long id, String name, String address) {
        // TODO : update Restaurant...
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        restaurant.setName(name);
        restaurant.setAddress(address);
        return restaurant;
    }
}
