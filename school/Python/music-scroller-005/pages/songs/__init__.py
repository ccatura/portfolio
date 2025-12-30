import mysql.connector
from flask import Blueprint, render_template
# from fake_db import data_items

#this is wear we name the blueprint and tell flask where to find the templates
songs_bp = Blueprint('songs', __name__, template_folder='templates')

def get_songs():
    conn = mysql.connector.connect(
        host="sql647.main-hosting.eu",      # e.g., 'localhost' or 'db.example.com'
        user="u682819236_scroll2",
        password="8h:pPw>m8Nx;",
        database="u682819236_music_scroll2"
    )
    cursor = conn.cursor(dictionary=True)  # dictionary=True gives you key access
    cursor.execute("SELECT `title`, `sub_title`, `id` FROM songs WHERE user_name LIKE 'arnold' ORDER BY title ASC")  # your table name
    rows = cursor.fetchall()
    conn.close()
    return rows

@songs_bp.route('/songs') #this is the route we will see this template on
def songs():
    songs = get_songs()
    song_quantity = len(songs)
    return render_template('songs.html', title="Songs", data=songs, song_quantity=song_quantity)