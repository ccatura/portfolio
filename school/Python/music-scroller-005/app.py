import mysql.connector
from flask          import Flask, render_template
from pages.home     import home_bp 
from pages.songs    import songs_bp 
from pages.song     import song_bp 
from pages.user     import user_bp 
from pages.sets     import sets_bp 
from pages.create   import create_bp 
from pages.search   import search_bp 

app = Flask(__name__)
app.register_blueprint(home_bp)
app.register_blueprint(songs_bp)
app.register_blueprint(song_bp)
app.register_blueprint(user_bp)
app.register_blueprint(sets_bp)
app.register_blueprint(create_bp)
app.register_blueprint(search_bp)

conn = mysql.connector.connect(
    host="sql647.main-hosting.eu",
    user="u682819236_scroll2",
    password="8h:pPw>m8Nx;",
    database="u682819236_music_scroll2"
)

@app.route('/song/<int:song_id>')
def show_song(song_id):
    cursor = conn.cursor(dictionary=True)
    cursor.execute("SELECT * FROM songs WHERE id = %s", (song_id,))
    song = cursor.fetchone()
    cursor.close()

    if song:
        return render_template('song.html', song=song)
    else:
        return "Song not found", 404



if __name__ == '__main__':
    app.run(debug=True)

