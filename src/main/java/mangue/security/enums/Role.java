package mangue.security.enums;

public enum Role {
    ADMIN("Admin"),
    USER("User");
    
    private final String roleName;
    
    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
    
}
