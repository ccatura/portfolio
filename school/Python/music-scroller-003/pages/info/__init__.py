from flask import Blueprint, render_template

#this is wear we name the blueprint and tell flask where to find the templates
info_bp = Blueprint('info', __name__, template_folder='templates')

@info_bp.route('/info') #this is the route we will see this template on
def info():
    return render_template('info.html')