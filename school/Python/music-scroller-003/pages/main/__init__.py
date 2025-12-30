from flask import Blueprint, render_template #we need these for blueprints and templates

#this is wear we name the blueprint and tell flask where to find the templates
main_bp = Blueprint('main', __name__, template_folder='templates')

@main_bp.route('/') #this is the route we will see this template on
def home():
    return render_template('home.html')
