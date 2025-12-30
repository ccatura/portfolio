package lyricsTest;

public class Sanitize {

	public static String paragraph(String input) {
		if (input == null || input == "") {
            return "[NO TEXT ENTERED]";
        }

        String sanitized = input;

        sanitized = sanitized.trim(); // Remove leading/trailing whitespace
        sanitized = sanitized.replace("\\", "\\\\"); // Escape backslashes first
        sanitized = sanitized.replace("'", "''");   // Escape single quotes for SQL
        sanitized = sanitized.replace("\"", "\\\""); // Escape double quotes
        sanitized = sanitized.replace("[nl]", "\n"); // Turns the group of characters: [nl] into an actual newline character

        return sanitized;
	}
}
