import os
from flask                      import Flask
from flask_sqlalchemy           import SQLAlchemy
from flask_migrate              import Migrate

app = Flask(__name__)

basedir = os.path.abspath(os.path.dirname(__file__)) # Folder path of this file
app.config['SQLALCHEMY_DATABASE_URI'] = "postgresql://postgres:IppySaysRelax!@localhost/music-scroller"
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

# 3. Initialize SQLAlchemy and Migrate with the app
db = SQLAlchemy(app)
migrate = Migrate(app, db)

# 4. Import models after initializing db to avoid circular imports
from models.user                import User
from models.song                import Song
from models.set                 import Set

from pages.create               import create_bp
from pages.home                 import home_bp
from pages.search               import search_bp
from pages.sets                 import sets_bp
from pages.song                 import song_bp
from pages.song_create          import song_create_bp
from pages.song_create_commit   import song_create_commit_bp
from pages.songs                import songs_bp
from pages.user                 import user_bp
from pages.user_create          import user_create_bp
from pages.user_create_commit   import user_create_commit_bp

app.register_blueprint(create_bp)
app.register_blueprint(home_bp)
app.register_blueprint(search_bp)
app.register_blueprint(sets_bp)
app.register_blueprint(song_bp)
app.register_blueprint(song_create_bp)
app.register_blueprint(song_create_commit_bp)
app.register_blueprint(songs_bp)
app.register_blueprint(user_bp)
app.register_blueprint(user_create_bp)
app.register_blueprint(user_create_commit_bp)

#Globals
app.config['temp_user_id'] = 19

if __name__ == '__main__':
    app.run(debug=True)
