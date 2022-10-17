package me.relend.parkour.configuration;

public enum Message {

	NO_PERMISSION("&cYou don't have permission to use this command!"),
	HELP_COMMAND("&cInvalid Usage: /parkour <options>");

	private final String value;

	Message(final String message) {
		this.value = message;
	}

	public String toString() {
		return value;
	}
}
