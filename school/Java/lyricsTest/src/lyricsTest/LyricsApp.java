package lyricsTest;

import java.util.*;

public class LyricsApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Enter song title
		System.out.print("Enter your song title: ");
		String songTitle = input.nextLine();
		
		//Enter lyrics
		System.out.print("Enter your lyrics (no 'new lines'): ");
		String lyrics = input.nextLine();
		
		// Create song object
		Song newSong1 = new Song(songTitle, lyrics);

		// Use all the methods to print out the different song infos
		System.out.print("\ngetSongInfo:\n" + newSong1.getSongInfo() + "\n\n");
		System.out.print("+++++++++++++++++\n");
		System.out.print("\ngetSongTitle:\n" + newSong1.getSongTitle() + "\n\n");
		System.out.print("+++++++++++++++++\n");
		System.out.print("\ngetSongLyrics:\n" + newSong1.getSongLyrics() + "\n\n");
		System.out.print("+++++++++++++++++\n");

	}

}