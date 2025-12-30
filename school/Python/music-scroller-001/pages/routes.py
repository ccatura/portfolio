from flask import Blueprint, render_template

pages_bp = Blueprint("pages", __name__)

@pages_bp.route("/")
def index():
    return render_template("index.html")

@pages_bp.route("/login")
def login():
    return render_template("login.html")

@pages_bp.route("/scroller")
def scroller():
    return render_template("scroller.html")

@pages_bp.route("/song_create")
def song_create():
    return render_template("song_create.html")

@pages_bp.route("/song_list")
def song_list():
    return render_template("song_list.html")
