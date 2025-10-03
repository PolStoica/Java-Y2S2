package isp.lab8.airways;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Route  extends WaypointDistanceCalculator{

    private String name;
    private List<Waypoint> points = new ArrayList<>();
    public Route(String name) {
        this.name = name;
    }

    public void addWaypoint(Waypoint wp) {
        points.add(wp);
    }

    public void saveRouteToFolder() {
        String projectPath = System.getProperty("user.dir");
        String routeFolderPath = projectPath + "/routes/" + name;
        FilesAndFoldersUtil.createFolder(routeFolderPath);

        for (Waypoint wp : points) {
            String waypointData = wp.toString();
            String fileName = routeFolderPath + "/" + wp.getName() + ".txt";
            try {
                FileWriteUtil.writeUsingFileWriter(waypointData, fileName);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Route loadRouteFromFolder(String name) {
        String projectPath = System.getProperty("user.dir");
        String routeFolderPath = projectPath + "/routes/" + name;
        File folder = new File(routeFolderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Route folder not found: " + name);
            return null;
        }

        Route route = new Route(name);
        ObjectMapper objectMapper = new ObjectMapper();
        File[] waypointFiles = folder.listFiles((dir, fname) -> fname.endsWith(".json"));

        if (waypointFiles != null) {
            for (File wpFile : waypointFiles) {
                try {
                    Waypoint wp = objectMapper.readValue(wpFile, Waypoint.class);
                    route.addWaypoint(wp);
                } catch (IOException e) {
                    System.out.println("failed: " + wpFile.getName());
                }
            }
        }

        return route;
    }

    public static void deleteRoute(String name) {
        String routeFolderPath = System.getProperty("user.dir") + "/routes/" + name;
        File folder = new File(routeFolderPath);

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
            folder.delete();
            System.out.println("Route deleted: " + name);
        } else {
            System.out.println("Route not found: " + name);
        }
    }

    public static void listAllRoutes() {
        String routesFolderPath = System.getProperty("user.dir") + "/routes";
        File routesFolder = new File(routesFolderPath);

        if (routesFolder.exists() && routesFolder.isDirectory()) {
            File[] folders = routesFolder.listFiles(File::isDirectory);
            if (folders != null && folders.length > 0) {
                System.out.println("Available routes:");
                for (File folder : folders) {
                    System.out.println("- " + folder.getName());
                }
            } else {
                System.out.println("No routes found.");
            }
        } else {
            System.out.println("Routes folder not found.");
        }
    }

    public void displayRouteInfo() {
        System.out.println("Route: " + name);
        for (Waypoint wp : points) {
            System.out.println(
                    " -> " + wp.getName() + " (Lat: " + wp.getLatitude()
                            + ", Lon: " + wp.getLongitude() + ", Alt: " + wp.getAltitude() + ")"
            );

        }
        System.out.println("Total distance of the route: " + totalDistance() + " km");
    }

    public double totalDistance() {
        double total = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            total += calculateDistance(points.get(i).getLatitude(), points.get(i).getLongitude(), points.get(i + 1).getLatitude(), points.get(i + 1).getLongitude());
        }
        return total;
    }

}