package fr.reservacances.response.vol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class AvionInfoResponse {
    private String id;
    private String idcompagnie;
    private String nomcompagnie;
    private String idmodeleavion;
    private String nommodeleavion;
}
