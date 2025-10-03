package isp.lab7.safehome;

import java.util.Objects;

public class AccessKey {
    private String pin;

    public AccessKey(String pin) {
        this.pin = pin;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccessKey)) return false;
        AccessKey that = (AccessKey) o;
        return this.pin.equals(that.pin);
    }

    @Override
    public int hashCode() {
        return pin.hashCode();
    }
}
