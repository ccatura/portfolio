class Song:
  def __init__(self, title, artist, duration):
    self.title = title
    self.artist = artist
    self.duration = duration

  def play(self):
    return f"Playing '{self.title}' by {self.artist} ({self.duration} seconds)."

class Playlist:
  def __init__(self, name):
    self.name = name
    self.songs = []

  def add_song(self, song):
    self.songs.append(song)

  def remove_song(self, song):
    self.songs.remove(song)

  def play_all(self):
    playlist_status = f"Playing {self.name}:"
    for song in self.songs:
      playlist_status += "\n" + song.play()
    return playlist_status

def main():
  # Create individual song instances
  song1 = Song("The Love Song", "Charlie", 180)
  song2 = Song("The Other Song", "Charlie", 220)
  song3 = Song("Eat My Ass", "Not Charlie", 210)

  # Create a playlist and add songs to it
  my_playlist = Playlist("My Playlist")
  my_playlist.add_song(song1)
  my_playlist.add_song(song2)
  my_playlist.add_song(song3)



  # Play all songs in the playlist
  playlist_status = my_playlist.play_all()
  print(playlist_status)

  my_playlist.remove_song(song3)
  playlist_status = my_playlist.play_all()
  print(playlist_status)




#   print("Playlist type: ", type(my_playlist.songs))

if __name__ == "__main__":
  main()

