package kr.co.mentalK94.restaurantReservation.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Review save(Review review);

    List<Review> findAllByRestaurantId(long id);

    List<Review> findAll();
}
