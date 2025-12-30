from flask import Blueprint, render_template
from fake_db import data_items

#this is wear we name the blueprint and tell flask where to find the templates
songs_bp = Blueprint('songs', __name__, template_folder='templates')

@songs_bp.route('/songs') #this is the route we will see this template on
def songs():
    return render_template('songs.html', title="Songs", data=data_items)