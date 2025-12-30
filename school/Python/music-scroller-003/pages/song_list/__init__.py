from flask import Blueprint, render_template

#this is wear we name the blueprint and tell flask where to find the templates
song_list_bp = Blueprint('song_list', __name__, template_folder='templates')

@song_list_bp.route('/song_list') #this is the route we will see this template on
def info():
    return render_template('song_list.html')