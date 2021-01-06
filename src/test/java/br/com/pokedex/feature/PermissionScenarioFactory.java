package br.com.pokedex.feature;

import br.com.pokedex.domain.Permission;

public class PermissionScenarioFactory {
    
    public static final Permission PERMISSION=loadPermission();
    public static final Permission PERMISSION_NEW=loadNewPermission();
    public static final Permission PERMISSION_BUILDER=loadPermissionBuilder();
    public static final Permission PERMISSION_SET=loadPermissionSet();
    public static final Permission PERMISSION_GET=loadPermissionGet();

    private static Permission loadPermission() {
        return new Permission("fsdafsadf","ADMIN");
    }

    private static Permission loadPermissionGet() {
        Permission permission=new Permission();
        permission.getPermissionId();
        permission.getDescription();
        return permission;
    }

    private static Permission loadPermissionSet() {
        Permission permission=new Permission();
        permission.setPermissionId("jfiasdjfijsdf");
        permission.setDescription("description");
        return permission;
    }

    private static Permission loadPermissionBuilder() {
        return Permission.builder()
        .permissionId("fksadiofjidsf")
        .description("ADMIN")
        .build();
    }

    private static Permission loadNewPermission() {
        return new Permission("fsdafsadf","MANAGER");
    }
}
