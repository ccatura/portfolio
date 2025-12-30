from flask import Blueprint, render_template

#this is wear we name the blueprint and tell flask where to find the templates
song_create_bp = Blueprint('song_create', __name__, template_folder='templates')

@song_create_bp.route('/song_create') #this is the route we will see this template on
def info():
    return render_template('song_create.html')