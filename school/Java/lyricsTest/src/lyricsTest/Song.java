package lyricsTest;

public class Song {
	String title;
	String lyrics;

	public Song(String songTitle, String lyrics) {
		this.title = songTitle;
		this.lyrics = lyrics;
	}
	
	public String getSongInfo() {
		String songInfo = "TITLE: " + Sanitize.paragraph(this.title) + "\n\nLYRICS:\n" + Sanitize.paragraph(this.lyrics);
		return songInfo;
	}
	
	public String getSongTitle() {
		return Sanitize.paragraph(this.title);
	}
	
	public String getSongLyrics() {
		return Sanitize.paragraph(this.lyrics);
	}
}
