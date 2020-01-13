package kr.co.mentalK94.restaurantReservation.interfaces;

import kr.co.mentalK94.restaurantReservation.application.RestaurantService;
import kr.co.mentalK94.restaurantReservation.domain.MenuItem;
import kr.co.mentalK94.restaurantReservation.domain.MenuItemRepository;
import kr.co.mentalK94.restaurantReservation.domain.Restaurant;
import kr.co.mentalK94.restaurantReservation.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
//        List<Restaurant> restaurantList = new ArrayList<>();
//
//        restaurantList.add(new Restaurant(1001L, "Bob zip", "Seoul"));
//        restaurantList.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
//        restaurantList.add(new Restaurant(2023L, "Cutlet Food", "Seoul"));

        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
//        List<Restaurant> restaurantList = new ArrayList<>();
//
//        restaurantList.add(new Restaurant(1001L, "Bob zip", "Seoul"));
//        restaurantList.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
//        restaurantList.add(new Restaurant(2023L, "Cutlet Food", "Seoul"));

        // �׷��� ���⼭ findAll�� ��� ã�� �� id������ �ش� ��ü ã�� ������ ���⼭ �ϴ� ���� ���� �ʴ�.
        // ���� findAll�� �ƴ� findById(id)�� ã�� �� �������־�� �Ѵ�.
//        List<Restaurant> restaurantList = restaurantRepository.findAll();

        // -----------------------------------------------------------------------------------
//        Restaurant restaurant = restaurantRepository.findById(id);
//
//        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantById(id);
//        restaurant.setMenuItems(menuItems);

        // �⺻ ���� + �޴� ����
        Restaurant restaurant = restaurantService.getRestaurantById(id);



        return restaurant;
    }
}
