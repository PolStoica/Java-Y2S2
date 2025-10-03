package isp.lab8.airways;

public class Exercise {
    public static void main(String[] args) {
        Waypoint wp  = new Waypoint("LRCL"  , 46.7852, 23.6862, 415   );
        Waypoint wp2 = new Waypoint("TASOD" , 47.0548, 23.9212, 10460 );
        Waypoint wp3 = new Waypoint("SOPAV" , 46.9804, 24.7365, 10900 );
        Waypoint wp4 = new Waypoint("BIRGU" , 45.9467, 26.0217, 10200 );
        Waypoint wp5 = new Waypoint("LROP"  , 44.5711, 26.0858, 106   );

        Route route = new Route("LRCL-LROP");
        route.addWaypoint(wp);
        route.addWaypoint(wp2);
        route.addWaypoint(wp3);
        route.addWaypoint(wp4);
        route.addWaypoint(wp5);

        try{
        route.displayRouteInfo();
        route.saveRouteToFolder();
        route.listAllRoutes();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try {
            route.deleteRoute(route.getName());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}