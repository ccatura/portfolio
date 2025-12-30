from flask import Flask
from pages.main import main_bp #refers to the "main" directory, then the "main_bp" within the init file
from pages.info import info_bp 
from pages.song_list import song_list_bp 
from pages.set_lists import set_lists_bp 
from pages.song_create import song_create_bp 

app = Flask(__name__)
app.register_blueprint(main_bp) #registers the blueprint. we need this.
app.register_blueprint(info_bp)
app.register_blueprint(song_list_bp)
app.register_blueprint(set_lists_bp)
app.register_blueprint(song_create_bp)

if __name__ == '__main__': #runs the app
    app.run(debug=True)
