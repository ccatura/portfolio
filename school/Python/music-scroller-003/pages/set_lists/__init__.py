from flask import Blueprint, render_template

#this is wear we name the blueprint and tell flask where to find the templates
set_lists_bp = Blueprint('set_lists', __name__, template_folder='templates')

@set_lists_bp.route('/set_lists') #this is the route we will see this template on
def info():
    return render_template('set_lists.html')