from flask import Blueprint, render_template

#this is wear we name the blueprint and tell flask where to find the templates
song_bp = Blueprint('song', __name__, template_folder='templates')

@song_bp.route('/song') #this is the route we will see this template on
def song():
    return render_template('song.html', title="Song")