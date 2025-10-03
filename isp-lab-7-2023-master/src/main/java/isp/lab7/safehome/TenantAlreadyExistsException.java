package isp.lab7.safehome;

public class TenantAlreadyExistsException extends Exception {
    public TenantAlreadyExistsException(String name) {
        super("The tenant " + name + " already exists");
    }
}
