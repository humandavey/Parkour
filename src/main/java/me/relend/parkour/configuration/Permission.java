package me.relend.parkour.configuration;

public enum Permission {

	PARKOUR_CMD("parkour.command"),
	PARKOUR_ADMIN_CMD("parkour.admin.command");

	private final String value;

	Permission(final String permission) {
		this.value = permission;
	}

	public String toString() {
		return value;
	}
}
