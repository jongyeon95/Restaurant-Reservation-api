package kr.co.mentalK94.restaurantReservation.interfaces;

import kr.co.mentalK94.restaurantReservation.application.RegionService;
import kr.co.mentalK94.restaurantReservation.domain.Region;
import kr.co.mentalK94.restaurantReservation.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> list() {
        return regionService.getRegions();
    }

    @PostMapping("/regions")
    public ResponseEntity<?> create(
            @RequestBody Region resource
    ) throws URISyntaxException {

        Region region = regionService.addRegion(resource.getName());

        URI location = new URI("/regions/" + region.getId());
        return ResponseEntity.created(location).body("{}");
    }
}
