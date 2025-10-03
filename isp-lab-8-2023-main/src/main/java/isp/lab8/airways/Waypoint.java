package isp.lab8.airways;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
@ToString

public class Waypoint {
    private String name;
    private double latitude;
    private double longitude;
    private int altitude;
}
