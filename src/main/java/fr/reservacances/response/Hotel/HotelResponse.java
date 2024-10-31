package fr.reservacances.response.Hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HotelResponse {
        private String id;
        private String nom;
        private String villeId;
}
